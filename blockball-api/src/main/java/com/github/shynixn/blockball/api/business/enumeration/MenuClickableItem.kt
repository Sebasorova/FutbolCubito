package com.github.shynixn.blockball.api.business.enumeration

/**
 * Enum for different clickable components in the chat ui.
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
enum class MenuClickableItem(
        /*** Returns the displayed text of the component.*/
        val text: String,
        /*** Returns the displayed color of the component.*/
        val color: ChatColor) {
    /**
     * Clickable Edit.
     */
    EDIT(" [edit..]", ChatColor.GREEN),
    /**
     * Clickable copy armor.
     */
    COPY_ARMOR(" [copy armor..]", ChatColor.GOLD),
    /**
     *  Clickable copy inventory.
     */
    COPY_INVENTORY(" [copy inventory..]", ChatColor.GOLD),
    /**
     * Clickable page.
     */
    PAGE(" [page..]", ChatColor.YELLOW),
    /**
     * Clickable preview.
     */
    PREVIEW(" [preview..]", ChatColor.GRAY),
    /**
     *  Clickable add.
     */
    ADD(" [add..]", ChatColor.BLUE),
    /**
     * Clickable delete.
     */
    DELETE(" [delete..]", ChatColor.DARK_RED),
    /**
     * Clickable select.
     */
    SELECT(" [select..]", ChatColor.AQUA),
    /**
     * Clickable selection.
     */
    SELECTION(" [selection..]", ChatColor.GOLD),
    /**
     * Clickable location.
     */
    LOCATION(" [location..]", ChatColor.BLUE),
    /**
     * Clickable invalid.
     */
    INVALID(" [page..]", ChatColor.BLACK),
    /**
     * Clickable toggle.
     */
    TOGGLE(" [toggle..]", ChatColor.LIGHT_PURPLE);
}