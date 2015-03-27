package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info {

    private final JButton close = new JButton(" Schlie\u00DFen ");
    private final JFrame info = new JFrame("\u00DCber...");
    private final JPanel panel = new JPanel();
    private final String text = "<html><body><center>Dieses Programm wurde Programmiert von Niklas Merkelt<br><br>Version: " + Launcher.getVersion() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Letztes Update: " + Launcher.getDateLaftModified() + "</center><br></body></html>";
    private final JLabel info_text = new JLabel(text);

    public Info() {
        panel.setBackground(new Color(255, 165, 0));
        panel.setForeground(new Color(0, 128, 128));
        panel.setFont(Launcher.FONT_SMALL);
        info_text.setBackground(new Color(255, 165, 0));
        info_text.setForeground(new Color(0, 128, 128));
        info_text.setFont(Launcher.FONT_SMALL);
        panel.add(info_text);
        close.setForeground(new Color(0, 128, 128));
        close.setBackground(new Color(204, 204, 255));
        close.setFont(Launcher.FONT_BIG);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                info.dispose();
            }
        });
        panel.add(close, BorderLayout.SOUTH);
        info.getContentPane().add(panel);
        info.setSize(400, 140);
        info.setLocation(300, 150);
        info.setIconImage(Launcher.getLogo());
        info.setResizable(false);
        info.setVisible(true);
    }
}
