package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JComponent;
import javax.swing.JMenu;

public class LauncherMenu extends JMenu {

    /**
     * Add an new LauncherMenu
     * @param name Displayed name of the Menu
     * @param parent Parent element | wehre the menu should added
     */
    public LauncherMenu(String name, JComponent parent) {
        super.setText(name);
        super.setForeground(Launcher.FOREGROUND);
        super.setFont(Launcher.FONT_BIG);
        parent.add(this);
    }
}
