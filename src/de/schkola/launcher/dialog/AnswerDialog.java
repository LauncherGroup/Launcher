package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import de.schkola.launcher.swing.LauncherButton;
import de.schkola.launcher.swing.LauncherLabel;
import de.schkola.launcher.swing.LauncherPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JDialog;

public class AnswerDialog extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final LauncherButton no = new LauncherButton(" Nein ");
    private final LauncherButton yes = new LauncherButton(" Ja ");
    private final LauncherLabel label = new LauncherLabel();
    private String performThis;

    public AnswerDialog(String perform) {
        super(Launcher.getInstance());
        performThis = perform;
        switch (perform) {
            case "shutdown":
                setTitle(" Herrunterfahren? ");
                setSize(390, 100);
                label.setText("M\u00F6chtst du den Computer wirklich herrunterfahren?");
                break;
            case "logoff":
                setTitle(" Ausloggen? ");
                setSize(280, 100);
                label.setText("M\u00F6chtst du dich wirklich abmelden?");
                break;
            case "restart":
                setTitle(" Neustarten? ");
                setSize(380, 100);
                label.setText("M\u00F6chtest du den Computer wirklich neustarten?");
                break;
        }
        panel.add(label);
        panel.add(yes, BorderLayout.SOUTH);
        panel.add(no, BorderLayout.SOUTH);
        setLocation(350, 250);
        getContentPane().add(panel);
        setIconImage(Launcher.getLogo());
        setVisible(true);
        setResizable(false);
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
