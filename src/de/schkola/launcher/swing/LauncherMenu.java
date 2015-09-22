package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LauncherMenu extends JMenu {

    /**
     * Add an new LauncherMenu
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     */
    public LauncherMenu(String name, JMenuItem parent) {
        setText(name);
        setForeground(Launcher.FOREGROUND);
        setFont(Launcher.FONT_BIG);
        parent.add(this);
    }

    /**
     * Add an new LauncherMenu
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     */
    public LauncherMenu(String name, JMenuBar parent) {
        setText(name);
        setForeground(Launcher.FOREGROUND);
        setFont(Launcher.FONT_BIG);
        parent.add(this);
    }
}
