package com.github.shynixn.blockball.core.logic.business.service

import com.github.shynixn.blockball.api.BlockBallApi
import com.github.shynixn.blockball.api.business.service.ConfigurationService
import com.github.shynixn.blockball.api.business.service.LoggingService
import java.util.logging.Level
import java.util.logging.Logger

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
class LoggingUtilServiceImpl(private val logger: Logger) : LoggingService {
    private var configService: ConfigurationService? = null

    /**
     * Logs an debug text only if debug is enabled.
     */
    override fun debug(text: String, e: Throwable?) {
        if (configService == null) {
            configService = BlockBallApi.resolve(ConfigurationService::class.java)
        }

        if (configService!!.containsValue("debug") && configService!!.findValue("debug")) {
            if (e == null) {
                logger.log(Level.INFO, text)
            } else {
                logger.log(Level.INFO, text, e)
            }
        }
    }

    /**
     * Logs an info text.
     */
    override fun info(text: String, e: Throwable?) {
        if (e == null) {
            logger.log(Level.INFO, text)
        } else {
            logger.log(Level.INFO, text, e)
        }
    }

    /**
     * Logs an warning text.
     */
    override fun warn(text: String, e: Throwable?) {
        if (e == null) {
            logger.log(Level.WARNING, text)
        } else {
            logger.log(Level.WARNING, text, e)
        }
    }

    /**
     * Logs an error text.
     */
    override fun error(text: String, e: Throwable?) {
        if (e == null) {
            logger.log(Level.WARNING, text)
        } else {
            logger.log(Level.WARNING, text, e)
        }
    }
}