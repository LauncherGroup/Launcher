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
package de.schkola.launcher;

import de.schkola.launcher.Run.OfficeProg;
import de.schkola.launcher.Run.RunMode;
import de.schkola.launcher.dialog.Help;
import de.schkola.launcher.dialog.Info;
import de.schkola.launcher.swing.LauncherItem;
import de.schkola.launcher.swing.LauncherMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Launcher extends JFrame {

    private final JMenuBar menubar = new JMenuBar();
    private static final String VERSION = "1.8.1";
    private static final String DATE_LAST_MODIFIED = "Donnerstag, 05.01.2017";
    public static final Color FOREGROUND = new Color(29, 62, 143); //#1D3E8F
    public static final Color BACKGROUND = new Color(0, 177, 181); //#00B1B5
    public static Font FONT_BIG = new Font("SanukPro", Font.PLAIN, 15);
    public static Font FONT_SMALL = new Font("SanukPro", Font.PLAIN, 14);
    private static Launcher instance = null;
    //Menupunkte - Toolbar
    private final LauncherMenu lernspiele = new LauncherMenu(" Lernspiele ", menubar);
    private final LauncherMenu nachschlagewerk = new LauncherMenu(" Nachschlagewerke ", menubar);
    private final LauncherMenu lernprog = new LauncherMenu(" Lernprogramme ", menubar);
    private final LauncherMenu prog = new LauncherMenu(" Werkzeuge ", menubar);
    private final LauncherMenu web = new LauncherMenu(" Webseiten ", menubar);
    private final LauncherMenu computer = new LauncherMenu(" Computer ", menubar);
    private final LauncherMenu about = new LauncherMenu(" Programm ", menubar);
    //Menuitems
    //1
    private final LauncherMenu m1geo = new LauncherMenu(" Geografie ", lernspiele);
    private final LauncherMenu m1info = new LauncherMenu(" Infomartik ", lernspiele);
    private final LauncherMenu m1ma = new LauncherMenu(" Mathematik ", lernspiele);
    private final LauncherMenu m1ma_mathematikus = new LauncherMenu(" Mathematikus ", m1ma);
    //2-1
    private final LauncherMenu m2astro = new LauncherMenu(" Astronomie ", nachschlagewerk);
    private final LauncherMenu m2bio = new LauncherMenu(" Biologie ", nachschlagewerk);
    private final LauncherMenu m2deutsch = new LauncherMenu(" Deutsch ", nachschlagewerk);
    private final LauncherMenu m2ge = new LauncherMenu(" Geschichte ", nachschlagewerk);
    private final LauncherMenu m2ku = new LauncherMenu(" Kunst ", nachschlagewerk);
    private final LauncherMenu m2musik = new LauncherMenu(" Musik ", nachschlagewerk);
    private final LauncherMenu m2physik = new LauncherMenu(" Physik ", nachschlagewerk);
    //2-2
    private final LauncherMenu m2info = new LauncherMenu(" Informatik ", lernprog);
    private final LauncherMenu m2ma = new LauncherMenu(" Mathematik ", lernprog);
    private final LauncherMenu m2ma_mathebits = new LauncherMenu(" Mathe Bits ", m2ma);
    //3
    private final LauncherMenu m3office = new LauncherMenu(" OpenOffice ", prog);
    private final LauncherMenu m3micro = new LauncherMenu(" Microsoft Office ", prog);
    private final LauncherMenu m3image = new LauncherMenu(" Bildprogramme ", prog);
    private static Image logo = null;

    public Launcher(boolean minimized) {
        setupLogo();
        setupMenuBar();
        super.setIconImage(logo);
        super.setJMenuBar(menubar);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //1
        new LauncherItem(" Geograficus ", m1geo, RunMode.COMMAND, true, "C:\\Program Files (x86)\\BrainGame\\Geograficus\\Geograficus.exe");
        new LauncherItem(" Informaticus ", m1info, RunMode.COMMAND, true, "C:\\Program Files (x86)\\BrainGame\\Informaticus\\Informaticus.exe");
        new LauncherItem(" Mathica ", m1ma, RunMode.COMMAND, true, "C:\\Program Files (x86)\\BrainGame\\Mathica\\Mathica.exe");
        new LauncherItem(" Mathematikus 1 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus1$\\Matikus1Net.exe");
        new LauncherItem(" Mathematikus 2 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus2$\\Mat2Net.exe");
        new LauncherItem(" Mathematikus 3 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus3$\\Matikus3Net.exe");
        new LauncherItem(" Mathematikus 4 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus4$\\Matikus4Net.exe");
        //2
        new LauncherItem(" Lexikon ", m2astro, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Astronomie/LEXIKON%20Grundwissen%20Astro/INDEX.HTM");
        new LauncherItem(" DUDEN ", m2bio, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Biologie/DUDEN-Biologie%20Sek%20I/pdf/inhalt.pdf");
        new LauncherItem(" Lexikon ", m2deutsch, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Sprachen/Deutsch/Duden%20Basiswissen%20Deutsch/lexikon/index.htm");
        new LauncherItem(" Lexikon ", m2ge, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Geschichte/BW_Geschichte/LEXIKON/INDEX.HTM");
        new LauncherItem(" DUDEN ", m2ku, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Kunst/Duden%20Kunst%20Gym%20II/pdf/inhalt.pdf");
        new LauncherItem(" Lexikon ", m2musik, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Musik/Duden_Musik/LEXIKON/INDEX.HTM");
        new LauncherItem(" DUDEN Sek. I ", m2physik, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Sek%20I%20Gesamtband/pdf/inhalt.pdf");
        new LauncherItem(" DUDEN Sek. II ", m2physik, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Gym%20II/pdf/inhalt.pdf");
        new LauncherItem(" Lexikon ", m2physik, RunMode.WEB, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Basiswissen_Physik/LEXIKON/INDEX.HTM");
        new LauncherItem(" Formelsammelung ", nachschlagewerk, RunMode.WEB, true, "\\\\SVR03-EB\\esa\\infos\\Fachbereiche\\Naturwissenschaften\\Formelsamllung_bis_10\\fs_htm\\start.htm");
        new LauncherItem(" L\u00F6wenzahn Lexikon ", nachschlagewerk, RunMode.KIX, true, "D:\\Launcher\\loewenzahn.kix");
        //2
        new LauncherItem(" Robot Karol ", m2info, RunMode.COMMAND, true, "C:\\Program Files (x86)\\RobotKarol\\karol.exe");
        new LauncherItem(" Microsoft Logo ", m2info, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Softronics\\Microsoft Windows Logo\\Logo32.exe");
        new LauncherItem(" TIPP 10 ", m2info, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Tipp10\\tipp10.exe");
        new LauncherItem(" 3 Satz, Prozente und Zinsen ", m2ma_mathebits, RunMode.COMMAND, true, "D:\\Launcher\\Prozente_7.bat");
        new LauncherItem(" Terme und Gleichungen ", m2ma_mathebits, RunMode.COMMAND, true, "D:\\Launcher\\Terme_7.bat");
        //3
        new LauncherItem(" Dateimanager ", prog, RunMode.COMMAND, true, "C:\\Program Files (x86)\\totalcmd\\TOTALCMD.exe", "C:\\totalcmd\\TOTALCMD.exe");
        new LauncherItem(" Webbrowser (Internet) ", prog, RunMode.WEB, true, "");
        new LauncherItem(" WebWeaver Desktop ", prog, RunMode.COMMAND, true, "C:\\Program Files (x86)\\DigiOnline GmbH\\WebWeaver Desktop\\WebWeaver.exe", "mono /opt/WebWeaverDesktop/WebWeaver.exe");
        new LauncherItem(" ActivInspire ", prog, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Activ Software\\Inspire\\Inspire.exe", "inspire", "\\\\SVR03-EB\\esa\\infos\\ActivBoard\\Netzinstall\\program%20files\\Activ%20Software\\Inspire\\Inspire.exe");
        new LauncherItem(" Blender ", prog, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Blender Foundation\\Blender\\blender.exe");
        new LauncherItem(" Python IDLE ", prog, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Python 3.5\\pythonw.exe \"C:\\Program Files (x86)\\Python 3.5\\Lib\\idlelib\\idle.pyw\"");
        new LauncherItem(" Geogebra ", prog, RunMode.SERVER, true, "\\\\SVR03-EB\\esa\\infos\\Fachbereiche\\Mathematik\\GeoGebra%205.0.137.0\\GeoGebra.exe");
        new LauncherItem(" Writer (Textverarbeitung) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.TEXT.getOOname());
        new LauncherItem(" Calc (Tabellenkalkulation) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.CALC.getOOname());
        new LauncherItem(" Impress (Pr\u00E4sentation) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.PRESENTATION.getOOname());
        new LauncherItem(" Draw (Zeichnen) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.DRAW.getOOname());
        new LauncherItem(" Base (Datenbank) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.DATABASE.getOOname());
        new LauncherItem(" Math (Formel) ", m3office, RunMode.OPENOFFICE, true, OfficeProg.MATH.getOOname());
        new LauncherItem(" Word (Textverarbeitung) ", m3micro, RunMode.MSOFFICE, true, OfficeProg.TEXT.getMSname());
        new LauncherItem(" Excel (Tabellenkalkulation) ", m3micro, RunMode.MSOFFICE, true, OfficeProg.CALC.getMSname());
        new LauncherItem(" Power Point (Pr\u00E4sentation) ", m3micro, RunMode.MSOFFICE, true, OfficeProg.PRESENTATION.getMSname());
        new LauncherItem(" Access (Datenbank) ", m3micro, RunMode.MSOFFICE, true, OfficeProg.DATABASE.getMSname());
        new LauncherItem(" GIMP ", m3image, RunMode.COMMAND, true, "C:\\Program Files\\GIMP 2\\bin\\gimp-2.8.exe", "C:\\Program Files\\GIMP 2\\bin\\gimp-2.6.exe", "gimp-2.8");
        new LauncherItem(" IrfanView ", m3image, RunMode.COMMAND, true, "C:\\Program Files (x86)\\IrfanView\\i_view32.exe");
        new LauncherItem(" InkScape ", m3image, RunMode.COMMAND, true, "C:\\Program Files (x86)\\Inkscape\\inkscape.exe", "inkscape");
        //4
        new LauncherItem(" Schkola.de ", web, RunMode.WEB, true, "http://schkola.de");
        new LauncherItem(" Lernsax.de ", web, RunMode.WEB, true, "https://www.lernsax.de/wws/9.php#/wws/100001.php");
        new LauncherItem(" MeSax Schulserver ", web, RunMode.WEB, true, "http://mesax/");
        new LauncherItem(" Erlaubt Liste ", web, RunMode.SERVER, true, "\\\\SVR03-EB\\esa\\infos\\IT\\Launcher\\erlaubt.bat");
        new LauncherItem(" Whitelist Lernsax ", web, RunMode.WEB, true, "https://www.lernsax.de/link.php?wiki%7Cinfo%40schkola.lernsax.de%7CIndex%7C/");
        //5
        new LauncherItem(" Herunterfahren ", computer, RunMode.SHUTDOWN, true, "shutdown");
        new LauncherItem(" Abmelden ", computer, RunMode.SHUTDOWN, true, "logoff");
        new LauncherItem(" Neu Starten ", computer, RunMode.SHUTDOWN, true, "restart");
        new LauncherItem(" Homeverzeichniss ", computer, RunMode.COMMAND, true, "explorer.exe P:");
        new LauncherItem(" Arbeitsplatz ", computer, RunMode.COMMAND, true, "explorer.exe /e", "nemo");
        //6
        new LauncherItem(" \u00DCber ", about, false, (ae) -> new Info());
        new LauncherItem(" Hilfe ", about, false, (ae) -> new Help());
        new LauncherItem(" Minimieren ", about, true, (ae) -> minimize());
        new LauncherItem(" Beenden ", about, false, (ae) -> System.exit(0));
        startupLauncher(minimized);
    }

    private void setupMenuBar() {
        menubar.setFont(FONT_BIG);
        menubar.setForeground(FOREGROUND);
        menubar.setBackground(BACKGROUND);
    }

    private Image setupLogo() {
        logo = Toolkit.getDefaultToolkit().getImage(Launcher.class.getResource("/de/schkola/launcher/res/icon.png"));
        return logo;
    }

    private void startupLauncher(boolean minimized) {
        setTitle("Schkola Launcher | " + VERSION);
        setSize(775, 20);
        setLocation(0, 0);
        setResizable(false);
        setUndecorated(true);
        setAlwaysOnTop(true);
        if (minimized) {
            setExtendedState(JFrame.ICONIFIED);
        }
        setVisible(true);
    }

    /**
     * Main!
     *
     * @param args Commandline arguments
     */
    public static void main(String[] args) {
        try {
            instance = new Launcher(args[0].equals("minimized"));
        } catch (Exception e) {
            instance = new Launcher(false);
        }
    }

    /**
     * Return the current Instance of the Launcher
     *
     * @return
     */
    public static Launcher getInstance() {
        return instance == null ? new Launcher(false) : instance;
    }

    /**
     * Return the Launcher logo
     *
     * @return
     */
    public static Image getLogo() {
        return logo == null ? getInstance().setupLogo() : logo;
    }

    /**
     * Returns the current Launcher version
     *
     * @return
     */
    public static String getVersion() {
        return VERSION;
    }

    /**
     * Returns the Date when the Launcher was last modified
     *
     * @return
     */
    public static String getDateLaftModified() {
        return DATE_LAST_MODIFIED;
    }

    /**
     * Minimize the Launcher to the Taskbar
     */
    public void minimize() {
        setExtendedState(ICONIFIED);
    }
}
