package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import de.schkola.launcher.swing.LauncherButton;
import de.schkola.launcher.swing.LauncherLabel;
import de.schkola.launcher.swing.LauncherPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JDialog;

public class ShutdownDialog extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final LauncherButton no = new LauncherButton(" Nein ");
    private final LauncherButton yes = new LauncherButton(" Ja ");
    private final LauncherLabel label = new LauncherLabel();
    private String performThis;

    public ShutdownDialog(String perform) {
        super(Launcher.getInstance());
        performThis = perform;
        switch (perform) {
            case "shutdown":
                super.setTitle(" Herrunterfahren? ");
                super.setSize(390, 100);
                label.setText("M\u00F6chtst du den Computer wirklich herrunterfahren?");
                break;
            case "logoff":
                super.setTitle(" Ausloggen? ");
                super.setSize(280, 100);
                label.setText("M\u00F6chtst du dich wirklich abmelden?");
                break;
            case "restart":
                super.setTitle(" Neustarten? ");
                super.setSize(380, 100);
                label.setText("M\u00F6chtest du den Computer wirklich neustarten?");
                break;
        }
        panel.add(label);
        panel.add(yes, BorderLayout.SOUTH);
        panel.add(no, BorderLayout.SOUTH);
        super.setLocation(350, 250);
        super.getContentPane().add(panel);
        super.setIconImage(Launcher.getLogo());
        super.setVisible(true);
        super.setResizable(false);
        yes.addActionListener((ActionEvent w) -> {
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
        });
        no.addActionListener((ActionEvent w) -> dispose());
    }
}
