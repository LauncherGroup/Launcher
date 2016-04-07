package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JButton;

public class LauncherButton extends JButton {
    
    public LauncherButton(String title) {
        super.setText(title);
        super.setForeground(Launcher.FOREGROUND);
        super.setBackground(Launcher.BACKGROUND);
        super.setFont(Launcher.FONT_BIG);
    }
}
