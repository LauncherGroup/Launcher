package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JLabel;

public class LauncherLabel extends JLabel {

    public LauncherLabel() {
        this("");
    }
    
    public LauncherLabel(String text) {
        setText(text);
        setForeground(Launcher.FOREGROUND);
        setFont(Launcher.FONT_BIG);
    }
}
