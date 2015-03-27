package de.schkola.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorHandler {
    
    private final JFrame error = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    private final JButton close = new JButton(" Schlie\u00DFen ");
    
    /**
     * ErrorHandler for ErrorType
     * @param type See ErrorType
     */
    public ErrorHandler(ErrorType type) {
        switch (type) {
            case NO_CONNECTION:
                error.setTitle(" Keine Verbindung zum Server ");
                error.setSize(350, 100);
                label.setText("<html><body><center>\r\nDas Ger\u00E4t hat keine Verbindung zum Server.\r\n<br></center></body></html>");
                break;
            case NOT_AVAILABLE:
                error.setTitle(" Programm nicht verf\u00FCgbar ");
                error.setSize(450, 100);
                label.setText("Dieses Programm ist auf diesem Ger\u00E4t leider nicht verf\u00FCgbar!");
                break;
        }
        close.setForeground(new Color(0, 128, 128));
        close.setBackground(new Color(204, 204, 255));
        close.setFont(Launcher.FONT_BIG);
        panel.setForeground(new Color(0, 128, 128));
        panel.setBackground(new Color(255, 165, 0));
        panel.setFont(Launcher.FONT_SMALL);
        panel.add(label);
        panel.add(close, BorderLayout.SOUTH);
        error.setLocation(350, 250);
        error.getContentPane().add(panel);
        error.setIconImage(Launcher.getLogo());
        error.setResizable(true);
        error.setVisible(true);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                error.dispose();
            }
        });
    }
    
    public enum ErrorType{

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
