package de.schkola.launcher;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorHandler {

    private final JFrame error = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();

    /**
     * ErrorHandler for ErrorType
     *
     * @param type See ErrorType
     */
    public ErrorHandler(ErrorType type) {
        switch (type) {
            case NO_CONNECTION:
                error.setTitle(" Keine Verbindung zum Server ");
                error.setSize(350, 100);
                label.setText("<html><body><center><br>Das Ger\u00E4t hat keine Verbindung zum Server!</center></body></html>");
                break;
            case NOT_AVAILABLE:
                error.setTitle(" Programm nicht verf\u00FCgbar ");
                error.setSize(450, 100);
                label.setText("<html><body><center><br>Dieses Programm ist auf diesem Ger\u00E4t leider nicht verf\u00FCgbar!</center></body></html>");
                break;
        }
        label.setForeground(Launcher.FOREGROUND);
        label.setFont(Launcher.FONT_BIG);
        panel.setBackground(Launcher.BACKGROUND);
        panel.add(label);
        error.setLocation(350, 250);
        error.getContentPane().add(panel);
        error.setIconImage(Launcher.getLogo());
        error.setResizable(false);
        error.setVisible(true);
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
