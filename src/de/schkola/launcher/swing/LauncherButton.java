package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JButton;

public class LauncherButton extends JButton {

    public LauncherButton() {
        this("");
    }
    
    public LauncherButton(String title) {
        setText(title);
        setForeground(Launcher.FOREGROUND);
        setBackground(Launcher.BACKGROUND);
        setFont(Launcher.FONT_BIG);
    }
}
