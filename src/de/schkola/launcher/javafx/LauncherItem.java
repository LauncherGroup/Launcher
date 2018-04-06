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

import de.schkola.launcher.Launcher;
import de.schkola.launcher.Run;
import de.schkola.launcher.Run.RunMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class LauncherItem extends MenuItem {

    private final List<String> commands = new ArrayList<>();
    private final RunMode mode;
    
    /**
     * Add an new LauncherItem
     *
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     * @param runmode See 'RunMode.java'
     * @param command The commands that should executed
     */
    public LauncherItem(String name, Menu parent, RunMode runmode, String... command) {
        super.setText(name);
        commands.addAll(Arrays.asList(command));
        mode = runmode;
        parent.getItems().add(this);
        super.setOnAction((w) -> {
            for (int i = 0; i < commands.size(); i++) {
                if (Run.run(mode, commands.get(i))) {
                    if (getMinimized()) {
                        Launcher.getInstance().minimize();
                    }
                    return;
                } else if (i == commands.size() - 1 && runmode.getErrorType() != null) {
                    new Alert(AlertType.ERROR, runmode.getErrorType().getMsg()).show();
                    return;
                }
            }
        });
    }

    public LauncherItem(String name, Menu parent, EventHandler<ActionEvent> al) {
        super.setText(name);
        mode = RunMode.ACTION;
        parent.getItems().add(this);
        super.setOnAction(al);
    }

    /**
     * Add an new command to the LauncherItem
     *
     * @param command
     */
    public void addCommand(String command) {
        commands.add(command);
    }

    /**
     * Return the RunMode of the LauncherItem
     *
     * @return See 'RunMode.java'
     */
    public RunMode getRunMode() {
        return mode;
    }

    /**
     * Return the parent item of the LauncherItem
     *
     * @return
     */
    public Menu getParentItem() {
        return this.getParentMenu();
    }

    /**
     * Return an 'List' of all commands of the LauncherItem
     *
     * @return
     */
    public List<String> getCommands() {
        return commands;
    }

    /**
     * Returns the command with the given index number
     *
     * @param index Index number of the command
     * @return Command
     */
    public String getCommand(int index) {
        return commands.get(index);
    }

    /**
     * Returns whether the Launcher should minimized after executing the command
     *
     * @return TRUE = Should minimized | FALSE = Shouldn't minimized
     */
    public boolean getMinimized() {
        return mode.shouldMinimize();
    }
}
