package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import de.schkola.launcher.swing.LauncherLabel;
import de.schkola.launcher.swing.LauncherPanel;
import javax.swing.JDialog;

public class ErrorHandler extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final LauncherLabel label = new LauncherLabel();

    /**
     * ErrorHandler for ErrorType
     *
     * @param type See ErrorType
     */
    public ErrorHandler(ErrorType type) {
        super(Launcher.getInstance());
        switch (type) {
            case NO_CONNECTION:
                super.setTitle(" Keine Verbindung zum Server ");
                super.setSize(350, 100);
                label.setText("<html><body><center><br>Das Ger\u00E4t hat keine Verbindung zum Server!</center></body></html>");
                break;
            case NOT_AVAILABLE:
                super.setTitle(" Programm nicht verf\u00FCgbar ");
                super.setSize(450, 100);
                label.setText("<html><body><center><br>Dieses Programm ist auf diesem Ger\u00E4t leider nicht verf\u00FCgbar!</center></body></html>");
                break;
        }
        panel.add(label);
        super.setLocation(350, 250);
        super.getContentPane().add(panel);
        super.setIconImage(Launcher.getLogo());
        super.setResizable(false);
        super.setVisible(true);
    }

    public enum ErrorType {

        /**
         * ErrorType for no connection to the given host
         */
        NO_CONNECTION,
        /**
         * ErrorType for 'Program not avilable on the computer'
         */
        NOT_AVAILABLE
    }
}
