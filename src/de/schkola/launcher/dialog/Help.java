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

public class Help extends JDialog {

    private final LauncherPanel panel = new LauncherPanel();
    private final String text = "<html>\r\n<body><center>\r\nWillkommen in der Hilfe von dem Programm zur leichten Bedienung der Schkola Oberland!<br>\r\nDieses Programm wurde speziell f\u00FCr die Schkola geschrieben und erm\u00F6glicht eine leichtere <br>Bedienung des Computers. Oben in der Men\u00FCbar kannst du die verschiedenen <br>Programme, Nachschlagewerke, Spiele und Co. \u00F6ffnen.<br><br>\r\nKlicke einfach auf eine der oben gezeigten Auswahlm\u00F6glichkeiten und suchen dir<br> das ben\u00F6tigte Fach aus, das klicke es dann an. Im folgenden Men\u00FC kannst<br> du dann das Programm starten.<br><br>\r\nWenn irgendwelche Fehler auftreten oder du eine Frage zu diesem Programm hast<br> melde dich bitte per Lernsax bei Niklas Merkelt (mn1g@schkola.lernsax.de) <br><br>\r\nWir w\u00FCnschen dir Viel Spa\u00DF und Erfolg mit unserem Programm.<br><br>\r\nLG PU-Gruppe Launcher<br><br>\r\n\r\n</center></body>\r\n</html>";
    private final LauncherLabel hilfe_text = new LauncherLabel(text);

    public Help() {
        super(Launcher.getInstance());
        super.setTitle("Hilfe");
        panel.add(hilfe_text);
        super.getContentPane().add(panel);
        super.setSize(650, 290);
        super.setLocation(300, 150);
        super.setIconImage(Launcher.getLogo());
        super.setResizable(false);
        super.setVisible(true);
    }
}
