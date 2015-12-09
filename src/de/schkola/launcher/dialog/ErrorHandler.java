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
                setTitle(" Keine Verbindung zum Server ");
                setSize(350, 100);
                label.setText("<html><body><center><br>Das Ger\u00E4t hat keine Verbindung zum Server!</center></body></html>");
                break;
            case NOT_AVAILABLE:
                setTitle(" Programm nicht verf\u00FCgbar ");
                setSize(450, 100);
                label.setText("<html><body><center><br>Dieses Programm ist auf diesem Ger\u00E4t leider nicht verf\u00FCgbar!</center></body></html>");
                break;
        }
        panel.add(label);
        setLocation(350, 250);
        getContentPane().add(panel);
        setIconImage(Launcher.getLogo());
        setResizable(false);
        setVisible(true);
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
