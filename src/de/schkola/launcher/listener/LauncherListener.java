package de.schkola.launcher.listener;

import de.schkola.launcher.dialog.Info;
import de.schkola.launcher.dialog.Help;
import de.schkola.launcher.Launcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class LauncherListener implements ActionListener {

    private final Launcher l;

    public LauncherListener(Launcher launcher) {
        this.l = launcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == l.close) {
            System.exit(0);
        } else if (e.getSource() == l.m5ueber) {
            new Info();
        } else if (e.getSource() == l.m5hilfe) {
            new Help();
        } else if (e.getSource() == l.m5mini) {
            l.launcher.setExtendedState(JFrame.ICONIFIED);
        }
    }
}
