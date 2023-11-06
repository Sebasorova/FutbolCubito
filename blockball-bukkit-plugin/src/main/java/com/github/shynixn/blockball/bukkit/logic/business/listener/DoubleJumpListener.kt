package com.github.shynixn.blockball.bukkit.logic.business.listener

import com.github.shynixn.blockball.api.business.service.GameService
import com.github.shynixn.blockball.api.business.service.ParticleService
import com.github.shynixn.blockball.api.business.service.SoundService
import com.google.inject.Inject
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerToggleFlightEvent

/**
 * Created by Shynixn 2019.
 * <p>
 * Version 1.2
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2019 by Shynixn
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
class DoubleJumpListener @Inject constructor(private val gameService: GameService, private val soundService: SoundService, private val particleService: ParticleService) : Listener {
    /**
     * Gets called when a player moves. Allows the executing player to start flying
     * for double jump calculation if the action is enabled and the player is in a game.
     */
    @EventHandler
    fun onPlayerMoveEvent(event: PlayerMoveEvent) {
        if (!event.player.isOnGround) {
            return
        }

        val game = gameService.getGameFromPlayer(event.player)

        if (game.isPresent && game.get().arena.meta.doubleJumpMeta.enabled) {
            event.player.allowFlight = true
        }
    }

    /**
     * Gets called when a player doule presses the space key to start flying. Performs a double
     * jump action if the player is in a game and double jump is available.
     */
    @EventHandler
    fun onPlayerToggleFlightEvent(event: PlayerToggleFlightEvent) {
        if (event.player.gameMode == GameMode.CREATIVE || event.player.gameMode == GameMode.SPECTATOR) {
            return
        }

        val game = gameService.getGameFromPlayer(event.player)

        if (!game.isPresent || !game.get().arena.meta.doubleJumpMeta.enabled) {
            return
        }

        val player = event.player
        val meta = game.get().arena.meta.doubleJumpMeta

        player.allowFlight = false
        player.isFlying = false
        event.isCancelled = true

        if (game.get().doubleJumpCoolDownPlayers.containsKey(player)) {
            return
        }

        game.get().doubleJumpCoolDownPlayers[player] = meta.cooldown
        player.velocity = player.location.direction
                .multiply(meta.horizontalStrength)
                .setY(meta.verticalStrength)

        soundService.playSound(player.location, meta.soundEffect, player.world.players)
        particleService.playParticle(player.location, meta.particleEffect, player.world.players)
    }
}