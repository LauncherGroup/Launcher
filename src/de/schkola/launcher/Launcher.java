package de.schkola.launcher;

import de.schkola.launcher.Run.RunMode;
import de.schkola.launcher.dialog.Help;
import de.schkola.launcher.dialog.Info;
import de.schkola.launcher.swing.LauncherMenu;
import de.schkola.launcher.swing.LauncherItem;
import de.schkola.launcher.listener.WindowListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Launcher extends JFrame {

    private final JMenuBar menubar = new JMenuBar();
    private static final String VERSION = "1.6.4";
    private static final String DATE_LAST_MODIFIED = "Mittwoch, 27.01.2016";
    public static final Color FOREGROUND = new Color(29, 62, 143); //#00B1B5
    public static final Color BACKGROUND = new Color(0, 177, 181); //#1D3E8F
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
    private final LauncherItem m1geo_geograficus = new LauncherItem(" Geograficus ", m1geo, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\BrainGame\\Geograficus\\Geograficus.exe");
    private final LauncherMenu m1info = new LauncherMenu(" Infomartik ", lernspiele);
    private final LauncherItem m1info_informaticus = new LauncherItem(" Informaticus ", m1info, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\BrainGame\\Informaticus\\Informaticus.exe");
    private final LauncherMenu m1ma = new LauncherMenu(" Mathematik ", lernspiele);
    private final LauncherItem m1ma_mathica = new LauncherItem(" Mathica ", m1ma, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\BrainGame\\Mathica\\Mathica.exe");
    private final LauncherMenu m1ma_mathematikus = new LauncherMenu(" Mathematikus ", m1ma);
    private final LauncherItem m1ma_ma_1 = new LauncherItem(" Mathematikus 1 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus1$\\Matikus1Net.exe");
    private final LauncherItem m1ma_ma_2 = new LauncherItem(" Mathematikus 2 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus2$\\Mat2Net.exe");
    private final LauncherItem m1ma_ma_3 = new LauncherItem(" Mathematikus 3 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus3$\\Matikus3Net.exe");
    private final LauncherItem m1ma_ma_4 = new LauncherItem(" Mathematikus 4 ", m1ma_mathematikus, RunMode.SERVER, true, "\\\\svr03-eb\\Matikus4$\\Matikus4Net.exe");
    //2-1
    private final LauncherMenu m2astro = new LauncherMenu(" Astronomie ", nachschlagewerk);
    private final LauncherItem m2astro_lexikon = new LauncherItem(" Lexikon ", m2astro, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Astronomie/LEXIKON%20Grundwissen%20Astro/INDEX.HTM");
    private final LauncherMenu m2bio = new LauncherMenu(" Biologie ", nachschlagewerk);
    private final LauncherItem m2bio_duden = new LauncherItem(" DUDEN ", m2bio, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Biologie/DUDEN-Biologie%20Sek%20I/pdf/inhalt.pdf");
    private final LauncherMenu m2deutsch = new LauncherMenu(" Deutsch ", nachschlagewerk);
    private final LauncherItem m2deutsch_lexikon = new LauncherItem(" Lexikon ", m2deutsch, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Sprachen/Deutsch/Duden%20Basiswissen%20Deutsch/lexikon/index.htm");
    private final LauncherMenu m2ge = new LauncherMenu(" Geschichte ", nachschlagewerk);
    private final LauncherItem m2ge_lexikon = new LauncherItem(" Lexikon ", m2ge, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Geschichte/BW_Geschichte/LEXIKON/INDEX.HTM");
    private final LauncherMenu m2ku = new LauncherMenu(" Kunst ", nachschlagewerk);
    private final LauncherItem m2ku_duden = new LauncherItem(" DUDEN ", m2ku, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Kunst/Duden%20Kunst%20Gym%20II/pdf/inhalt.pdf");
    private final LauncherMenu m2musik = new LauncherMenu(" Musik ", nachschlagewerk);
    private final LauncherItem m2musik_lexikon = new LauncherItem(" Lexikon ", m2musik, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Musik/Duden_Musik/LEXIKON/INDEX.HTM");
    private final LauncherMenu m2physik = new LauncherMenu(" Physik ", nachschlagewerk);
    private final LauncherItem m2physik_duden_1 = new LauncherItem(" DUDEN Sek. I ", m2physik, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Sek%20I%20Gesamtband/pdf/inhalt.pdf");
    private final LauncherItem m2physik_duden_2 = new LauncherItem(" DUDEN Sek. II ", m2physik, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Gym%20II/pdf/inhalt.pdf");
    private final LauncherItem m2physik_lexikon = new LauncherItem(" Lexikon ", m2physik, RunMode.OPERA, true, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Basiswissen_Physik/LEXIKON/INDEX.HTM");
    private final LauncherItem m2formelsammelung = new LauncherItem(" Formelsammelung ", nachschlagewerk, RunMode.OPERA, true, "\\\\SVR03-EB\\esa\\infos\\Fachbereiche\\Naturwissenschaften\\Formelsamllung_bis_10\\fs_htm\\start.htm");
    private final LauncherItem m2LoewenzahnLexi = new LauncherItem(" L\u00F6wenzahn Lexikon ", nachschlagewerk, RunMode.KIX, true, "D:\\Launcher\\loewenzahn.kix");
    //2-2
    private final LauncherMenu m2info = new LauncherMenu(" Informatik ", lernprog);
    private final LauncherItem m2info_robot = new LauncherItem(" Robot Karol ", m2info, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\RobotKarol\\karol.exe");
    private final LauncherItem m2info_mslogo = new LauncherItem(" Microsoft Logo ", m2info, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\Softronics\\Microsoft Windows Logo\\Logo32.exe");
    private final LauncherItem m2info_tipp10 = new LauncherItem(" TIPP 10 ", m2info, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\Tipp10\\tipp10.exe");
    private final LauncherMenu m2ma = new LauncherMenu(" Mathematik ", lernprog);
    private final LauncherMenu m2ma_mathebits = new LauncherMenu(" Mathe Bits ", m2ma);
    private final LauncherItem m2ma_3_satz = new LauncherItem(" 3 Satz, Prozente und Zinsen ", m2ma_mathebits, RunMode.PROGRAM, true, "D:\\Launcher\\Prozente_7.bat");
    private final LauncherItem m2ma_terme = new LauncherItem(" Terme und Gleichungen ", m2ma_mathebits, RunMode.PROGRAM, true, "D:\\Launcher\\Terme_7.bat");
    //3
    private final LauncherItem m3datei = new LauncherItem(" Dateimanager ", prog, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\totalcmd\\TOTALCMD.exe");
    private final LauncherMenu m3inet = new LauncherMenu(" Internet Browser ", prog);
    private final LauncherItem m3inet_opera = new LauncherItem(" Opera ", m3inet, RunMode.OPERA, true, "");
    private final LauncherItem m3inet_iexplorer = new LauncherItem(" Internet Explorer ", m3inet, RunMode.IEXPLORE, true, "");
    private final LauncherItem m3webweaver = new LauncherItem(" WebWeaver Desktop ", prog, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\DigiOnline GmbH\\WebWeaver Desktop\\WebWeaver.exe");
    //private final LauncherItem m3mathe = new LauncherItem(" GEONExT ", prog, RunMode.PROGRAM, true, "");
    private final LauncherMenu m3office = new LauncherMenu(" OpenOffice ", prog);
    private final LauncherItem m3office_writer = new LauncherItem(" Writer (Textverarbeitung) ", m3office, RunMode.OPENOFFICE, true, "swriter.exe");
    private final LauncherItem m3office_calc = new LauncherItem(" Calc (Tabellenkalkulation) ", m3office, RunMode.OPENOFFICE, true, "scalc.exe");
    private final LauncherItem m3office_impress = new LauncherItem(" Impress (Pr\u00E4sentation) ", m3office, RunMode.OPENOFFICE, true, "simpress.exe");
    private final LauncherItem m3office_draw = new LauncherItem(" Draw (Zeichnen) ", m3office, RunMode.OPENOFFICE, true, "sdraw.exe");
    private final LauncherItem m3office_base = new LauncherItem(" Base (Datenbank) ", m3office, RunMode.OPENOFFICE, true, "sbase.exe");
    private final LauncherItem m3office_math = new LauncherItem(" Math (Formel) ", m3office, RunMode.OPENOFFICE, true, "smath.exe");
    private final LauncherMenu m3micro = new LauncherMenu(" Microsoft Office ", prog);
    private final LauncherItem m3micro_word = new LauncherItem(" Word (Textverarbeitung) ", m3micro, RunMode.MSOFFICE, true, "WINWORD.EXE");
    private final LauncherItem m3micro_excel = new LauncherItem(" Excel (Tabellenkalkulation) ", m3micro, RunMode.MSOFFICE, true, "EXCEL.EXE");
    private final LauncherItem m3micro_powerpoint = new LauncherItem(" Power Point (Pr\u00E4sentation) ", m3micro, RunMode.MSOFFICE, true, "POWERPNT.EXE");
    private final LauncherItem m3micro_access = new LauncherItem(" Access (Datenbank) ", m3micro, RunMode.MSOFFICE, true, "MSACCESS.EXE");
    private final LauncherMenu m3image = new LauncherMenu(" Bildprogramme ", prog);
    private final LauncherItem m3image_gimp = new LauncherItem(" GIMP ", m3image, RunMode.PROGRAM, true, "C:\\Program Files\\GIMP 2\\bin\\gimp-2.8.exe");
    private final LauncherItem m3image_irfanview = new LauncherItem(" IrfanView ", m3image, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\IrfanView\\i_view32.exe");
    private final LauncherItem m3image_inkscape = new LauncherItem(" InkScape ", m3image, RunMode.PROGRAM, true, "C:\\Program Files (x86)\\Inkscape\\inkscape.exe");
    //4
    private final LauncherItem m4schkola = new LauncherItem(" Schkola.de ", web, RunMode.OPERA, true, "http://schkola.de");
    private final LauncherItem m4lernsax = new LauncherItem(" Lernsax.de ", web, RunMode.OPERA, true, "https://www.lernsax.de/wws/9.php#/wws/100001.php");
    private final LauncherItem m4mesax = new LauncherItem(" MeSax Schulserver ", web, RunMode.OPERA, true, "http://mesax/");
    private final LauncherItem m4erlaubt = new LauncherItem(" Erlaubt Liste ", web, RunMode.SERVER, true, "\\\\SVR03-EB\\esa\\infos\\IT\\Launcher\\erlaubt.bat");
    private final LauncherItem m4erlaubt_lernsax = new LauncherItem(" Whitelist Lernsax ", web, RunMode.OPERA, true, "https://www.lernsax.de/link.php?wiki%7Cinfo%40schkola.lernsax.de%7CIndex%7C/");
    //5
    private final LauncherItem m6shutdown = new LauncherItem(" Herunterfahren ", computer, RunMode.SHUTDOWN, true, "shutdown");
    private final LauncherItem m6logoff = new LauncherItem(" Abmelden ", computer, RunMode.SHUTDOWN, true, "logoff");
    private final LauncherItem m6restart = new LauncherItem(" Neu Starten ", computer, RunMode.SHUTDOWN, true, "restart");
    private final LauncherItem m6home = new LauncherItem(" Homeverzeichniss ", computer, RunMode.COMPUTER, true, "explorer.exe P:");
    private final LauncherItem m6computer = new LauncherItem(" Arbeitsplatz ", computer, RunMode.COMPUTER, true, "explorer.exe /e,");
    //6
    private final LauncherItem m5ueber = new LauncherItem(" \u00DCber ", about, false, (ActionEvent ae) -> new Info());
    private final LauncherItem m5hilfe = new LauncherItem(" Hilfe ", about, false, (ActionEvent ae) -> new Help());
    private final LauncherItem m5mini = new LauncherItem(" Minimieren ", about, true, (ActionEvent ae) -> Launcher.minimize());
    private final LauncherItem close = new LauncherItem(" Beenden ", about, false, (ActionEvent ae) -> System.exit(0));
    private static Image logo = null;

    public Launcher(boolean minimized) {
        setupVisual();
        setupMenuBar();
        m2info_robot.addCommand("C:\\Programme\\faecher\\informatik\\RobotKarol\\karol.exe");
        m2info_mslogo.addCommand("C:\\Programme\\Softronics\\Microsoft Windows Logo\\Logo32.exe");
        m2info_tipp10.addCommand("C:\\Programme\\Tipp10\\tipp10.exe");
        m3datei.addCommand("C:\\totalcmd\\TOTALCMD.exe");
        m3webweaver.addCommand("C:\\Programme\\DigiOnline GmbH\\WebWeaver Desktop\\WebWeaver.exe");
        m3webweaver.addCommand("D:\\Programme\\DigiOnline GmbH\\WebWeaver Desktop\\WebWeaver.exe");
        m3image_gimp.addCommand("C:\\Program Files\\GIMP 2\\bin\\gimp-2.6.exe");
        super.setIconImage(logo);
        super.addWindowListener(new WindowListener());
        super.setJMenuBar(menubar);
        startupLauncher(minimized);
    }

    private void setupMenuBar() {
        menubar.setFont(FONT_BIG);
        menubar.setForeground(FOREGROUND);
        menubar.setBackground(BACKGROUND);
    }

    private void setupVisual() {
        logo = Toolkit.getDefaultToolkit().getImage(Launcher.class.getResource("/de/schkola/launcher/res/icon.png"));
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
        boolean minimized = false;
        try {
            minimized = args[0].equals("minimized");
        } catch (Exception e) {
        }
        instance = new Launcher(minimized);

    }

    /**
     * Return the current Instance of the Launcher
     *
     * @return
     */
    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher(false);
        }
        return instance;
    }

    /**
     * Return the Launcher logo
     *
     * @return
     */
    public static Image getLogo() {
        return logo;
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
    public static void minimize() {
        instance.setExtendedState(ICONIFIED);
    }
}
