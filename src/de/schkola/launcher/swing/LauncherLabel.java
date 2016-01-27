package de.schkola.launcher.swing;

import de.schkola.launcher.Launcher;
import javax.swing.JLabel;

public class LauncherLabel extends JLabel {

    public LauncherLabel() {
        this("");
    }
    
    public LauncherLabel(String text) {
        super.setText(text);
        super.setForeground(Launcher.FOREGROUND);
        super.setFont(Launcher.FONT_BIG);
    }
}
