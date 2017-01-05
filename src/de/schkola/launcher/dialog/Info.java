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

public class Info extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final String text = "<html><body><center>Dieses Programm wurde Programmiert von Niklas Merkelt<br><br>Version: " + Launcher.getVersion() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Letztes Update: " + Launcher.getDateLaftModified() + "</center><br></body></html>";
    private final LauncherLabel info_text = new LauncherLabel(text);

    public Info() {
        super(Launcher.getInstance());
        super.setTitle("\u00DCber...");
        panel.add(info_text);
        super.getContentPane().add(panel);
        super.setSize(450, 100);
        super.setLocation(300, 150);
        super.setIconImage(Launcher.getLogo());
        super.setResizable(false);
        super.setVisible(true);
    }
}
