package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerDialog {

    private final JFrame dialog = new JFrame();
    private final JPanel panel = new JPanel();
    private final JButton no = new JButton(" Nein ");
    private final JButton yes = new JButton(" Ja ");
    private final JLabel label = new JLabel();
    private String performThis;

    public AnswerDialog(String perform) {
        performThis = perform;
        switch (perform) {
            case "shutdown":
                dialog.setTitle(" Herrunterfahren? ");
                dialog.setSize(390, 100);
                label.setText("M\u00F6chtst du den Computer wirklich herrunterfahren?");
                break;
            case "logoff":
                dialog.setTitle(" Ausloggen? ");
                dialog.setSize(280, 100);
                label.setText("M\u00F6chtst du dich wirklich abmelden?");
                break;
            case "restart":
                dialog.setTitle(" Neustarten? ");
                dialog.setSize(380, 100);
                label.setText("M\u00F6chtest du den Computer wirklich neustarten?");
                break;
        }
        label.setForeground(Launcher.FOREGROUND);
        label.setFont(Launcher.FONT_BIG);
        panel.setBackground(Launcher.BACKGROUND);
        panel.add(label);
        yes.setForeground(Launcher.FOREGROUND);
        yes.setBackground(Launcher.BACKGROUND);
        yes.setFont(Launcher.FONT_BIG);
        panel.add(yes, BorderLayout.SOUTH);
        no.setForeground(Launcher.FOREGROUND);
        no.setBackground(Launcher.BACKGROUND);
        no.setFont(Launcher.FONT_BIG);
        panel.add(no, BorderLayout.SOUTH);
        dialog.setLocation(350, 250);
        dialog.getContentPane().add(panel);
        dialog.setIconImage(Launcher.getLogo());
        dialog.setVisible(true);
        dialog.setResizable(false);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    switch (performThis) {
                        case "shutdown":
                            runtime.exec("shutdown -s -t 0");
                            break;
                        case "logoff":
                            runtime.exec("shutdown -l");
                            break;
                        case "restart":
                            runtime.exec("shutdown -r");
                            break;
                    }
                } catch (IOException ex) {
                    return;
                }
                System.exit(0);
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                dialog.dispose();
            }
        });
    }
}
