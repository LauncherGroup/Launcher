package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info {

    private final JFrame info = new JFrame("\u00DCber...");
    private final JPanel panel = new JPanel();
    private final String text = "<html><body><center>Dieses Programm wurde Programmiert von Niklas Merkelt<br><br>Version: " + Launcher.getVersion() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Letztes Update: " + Launcher.getDateLaftModified() + "</center><br></body></html>";
    private final JLabel info_text = new JLabel(text);

    public Info() {
        panel.setBackground(Launcher.BACKGROUND);
        info_text.setForeground(Launcher.FOREGROUND);
        info_text.setFont(Launcher.FONT_BIG);
        panel.add(info_text);
        info.getContentPane().add(panel);
        info.setSize(450, 100);
        info.setLocation(300, 150);
        info.setIconImage(Launcher.getLogo());
        info.setResizable(false);
        info.setVisible(true);
    }
}
