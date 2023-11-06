package com.github.shynixn.blockball.core.logic.persistence.entity

import com.github.shynixn.blockball.api.business.annotation.YamlSerialize
import com.github.shynixn.blockball.api.persistence.entity.ArenaProtectionMeta
import com.github.shynixn.blockball.api.persistence.entity.Position

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
class ArenaProtectionMetaEntity : ArenaProtectionMeta {
    /** Velocity being applied when an entity enters the arena which is not an player or armorstand. */
    @YamlSerialize(value = "entity-protection", orderNumber = 2, implementation = PositionEntity::class)
    override var entityProtection: Position = PositionEntity(5.0, 2.0, 5.0)
    /** Should a velocity be applied to entities which are not an player or armorstand. */
    @YamlSerialize(value = "entity-protection-enabled", orderNumber = 1)
    override var entityProtectionEnabled: Boolean = true
    /** Velocity being applied when a player rejoins the server into a field of an arena. */
    @YamlSerialize(value = "rejoin-protection", orderNumber = 4, implementation = PositionEntity::class)
    override var rejoinProtection: Position = PositionEntity(0.0, 2.0, 0.0)
    /** Should a velocity be applied to players which rejoin on the field of the arena. */
    @YamlSerialize(value = "rejoin-protection-enabled", orderNumber = 3)
    override var rejoinProtectionEnabled: Boolean = true
}