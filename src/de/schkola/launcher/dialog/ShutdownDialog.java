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
