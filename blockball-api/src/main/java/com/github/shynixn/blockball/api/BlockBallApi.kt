@file:Suppress("unused")

package com.github.shynixn.blockball.api

import com.github.shynixn.blockball.api.business.proxy.PluginProxy

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
object BlockBallApi {
    private var plugin: PluginProxy? = null

    /**
     * Initializes the [blockBallPlugin] proxy.
     */
    private fun initializeBlockBall(blockBallPlugin: PluginProxy) {
        this.plugin = blockBallPlugin
    }

    /**
     * Gets a business logic from the BlockBall plugin.
     * All types in the service package can be accessed.
     * Throws a [IllegalArgumentException] if the service could not be found.
     */
    fun <S> resolve(service: Class<S>): S {
        return plugin!!.resolve(service)
    }

    /**
     * Creates a new entity from the given [entity] clazz.
     * Throws a [IllegalArgumentException] if the entity could not be found.
     */
    fun <E> create(entity: Class<E>): E {
        return plugin!!.create(entity)
    }
}
