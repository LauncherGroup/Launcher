package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import de.schkola.launcher.swing.LauncherLabel;
import de.schkola.launcher.swing.LauncherPanel;
import javax.swing.JDialog;

public class Info extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final String text = "<html><body><center>Dieses Programm wurde Programmiert von Niklas Merkelt<br><br>Version: " + Launcher.getVersion() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Letztes Update: " + Launcher.getDateLaftModified() + "</center><br></body></html>";
    private final LauncherLabel info_text = new LauncherLabel(text);

    public Info() {
        super(Launcher.getInstance());
        setTitle("\u00DCber...");
        panel.add(info_text);
        getContentPane().add(panel);
        setSize(450, 100);
        setLocation(300, 150);
        setIconImage(Launcher.getLogo());
        setResizable(false);
        setVisible(true);
    }
}
