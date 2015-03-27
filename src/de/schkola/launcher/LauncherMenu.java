package de.schkola.launcher;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LauncherMenu extends JMenu {

    /**
     * Add an new LauncherMenu
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     * @param instance The instance of Launcher -> normaly 'this'
     */
    public LauncherMenu(String name, JMenuItem parent, Launcher instance) {
        this.setText(name);
        this.setForeground(Launcher.FOREGROUND);
        this.setFont(Launcher.FONT_BIG);
        this.addActionListener(instance.AL);
        parent.add(this);
    }

    /**
     * Add an new LauncherMenu
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     * @param instance The instance of Launcher -> normaly 'this'
     */
    public LauncherMenu(String name, JMenuBar parent, Launcher instance) {
        this.setText(name);
        this.setForeground(Launcher.FOREGROUND);
        this.setFont(Launcher.FONT_BIG);
        this.addActionListener(instance.AL);
        parent.add(this);
    }
}
