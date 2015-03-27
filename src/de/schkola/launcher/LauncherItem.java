package de.schkola.launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.util.ArrayList;
import java.util.List;

public class LauncherItem extends JMenuItem {

    private final List<String> commands = new ArrayList();
    private final RunMode mode;
    private final JMenuItem parentItem;
    private final boolean shouldMinimized;

    /**
     * Add an new LauncherItem
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     * @param runmode See 'RunMode.java'
     * @param command The first command that should executed
     * @param minimized Should the Launcher minimized after executing
     * @param instance The instance of Launcher -> normaly 'this'
     */
    public LauncherItem(String name, JMenuItem parent, RunMode runmode, String command, boolean minimized, Launcher instance) {
        this.setText(name);
        this.setForeground(Launcher.FOREGROUND);
        this.setFont(Launcher.FONT_BIG);
        if (runmode.equals(RunMode.FRAME)) {
            this.addActionListener(instance.AL);
        } else {
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent w) {
                    boolean run;
                    for (int i = 0; i < commands.size(); i++) {
                        if (i == commands.size() - 1) {
                            run = Run.run(mode, commands.get(i), true);
                        } else {
                            run = Run.run(mode, commands.get(i), false);
                        }
                        if ((run || commands.size() == 1) && shouldMinimized) {
                            Launcher.getInstance().setExtendedState(JFrame.ICONIFIED);
                            return;
                        }
                    }

                }
            });
        }
        commands.add(command);
        mode = runmode;
        parentItem = parent;
        shouldMinimized = minimized;
        parent.add(this);
    }

    /**
     * Add an new command to the LauncherItem
     * @param command
     */
    public void addCommand(String command) {
        commands.add(command);
    }

    /**
     * Return the RunMode of the LauncherItem
     * @return See 'RunMode.java'
     */
    public RunMode getRunMode() {
        return mode;
    }

    /**
     * Return the parent item of the LauncherItem
     * @return
     */
    public JMenuItem getParentItem() {
        return parentItem;
    }

    /**
     * Return an 'List' of all commands of the LauncherItem
     * @return
     */
    public List<String> getCommands() {
        return commands;
    }

    /**
     * Returns the command with the given index number
     * @param index Index number of the command
     * @return Command
     */
    public String getCommand(int index) {
        return commands.get(index);
    }

    /**
     * Returns whether the Launcher should minimized after executing the command
     * @return TRUE = Should minimized | FALSE = Shouldn't minimized
     */
    public boolean getMinimized() {
        return shouldMinimized;
    }
}
