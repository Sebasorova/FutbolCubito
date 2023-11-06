package com.github.shynixn.blockball.core.logic.business.commandmenu

import com.github.shynixn.blockball.api.business.enumeration.ChatClickAction
import com.github.shynixn.blockball.api.business.enumeration.MenuClickableItem
import com.github.shynixn.blockball.api.business.enumeration.MenuCommand
import com.github.shynixn.blockball.api.business.enumeration.MenuPageKey
import com.github.shynixn.blockball.api.persistence.entity.ChatBuilder
import com.github.shynixn.blockball.core.logic.persistence.entity.ChatBuilderEntity

/**
 * Created by Shynixn 2018.
 * <p>
 * Version 1.2
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2018 by Shynixn
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
class EffectsSettingsPage : Page(EffectsSettingsPage.ID, MainSettingsPage.ID) {

    companion object {
        /** Id of the page. */
        const val ID = 7
    }

    /**
     * Returns the key of the command when this page should be executed.
     *
     * @return key
     */
    override fun getCommandKey(): MenuPageKey {
        return MenuPageKey.EFFECTS
    }

    /**
     * Builds the page content.
     *
     * @param cache cache
     * @return content
     */
    override fun buildPage(cache: Array<Any?>): ChatBuilder {
        return ChatBuilderEntity()
            .component("- Scoreboard:").builder()
            .component(MenuClickableItem.PAGE.text).setColor(MenuClickableItem.PAGE.color)
            .setClickAction(ChatClickAction.RUN_COMMAND, MenuCommand.SCOREBOARD_OPEN.command)
            .setHoverText("Configure the scoreboard of players.")
            .builder().nextLine()
            .component("- Bossbar:").builder()
            .component(MenuClickableItem.PAGE.text).setColor(MenuClickableItem.PAGE.color)
            .setClickAction(ChatClickAction.RUN_COMMAND, MenuCommand.BOSSBAR_OPEN.command)
            .setHoverText("Configure the bossbar for players.")
            .builder().nextLine()
            .component("- Holograms:").builder()
            .component(MenuClickableItem.PAGE.text).setColor(MenuClickableItem.PAGE.color)
            .setClickAction(ChatClickAction.RUN_COMMAND, MenuCommand.HOLOGRAM_OPEN.command)
            .setHoverText("Configure the holograms for players.")
            .builder().nextLine()
    }
}