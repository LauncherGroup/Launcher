/*
 * The MIT License
 *
 * Copyright 2016 Niklas Merkelt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
