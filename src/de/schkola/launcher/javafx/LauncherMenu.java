/*
 * The MIT License
 *
 * Copyright 2016 Niklas Merkelt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.schkola.launcher.javafx;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class LauncherMenu extends Menu {

    /**
     * Add an new LauncherMenu
     *
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     */
    public LauncherMenu(String name, Menu parent) {
        super.setText(name);
        parent.getItems().add(this);
    }
    
    /**
     * Add an new LauncherMenu
     *
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     */
    public LauncherMenu(String name, MenuBar parent) {
        super.setText(name);
        parent.getMenus().add(this);
    }
}
