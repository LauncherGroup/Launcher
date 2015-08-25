package de.schkola.launcher;

import de.schkola.launcher.listener.WindowListener;
import de.schkola.launcher.listener.LauncherListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Launcher extends JFrame {

    private final JMenuBar menubar = new JMenuBar();
    private static final String VERSION = "1.6.1";
    private static final String DATE_LAST_MODIFIED = "Dienstag, 25.08.2015";
    public static final Color FOREGROUND = new Color(29, 62, 143); //#00B1B5
    public static final Color BACKGROUND = new Color(0, 177, 181); //#1D3E8F
    public static Font FONT_BIG = new Font("SanukPro", Font.PLAIN, 15);
    public static Font FONT_SMALL = new Font("SanukPro", Font.PLAIN, 14);
    private static Launcher instance = null;
    public final LauncherListener AL = new LauncherListener(this);
    //Menupunkte - Toolbar
    public final LauncherMenu fach = new LauncherMenu(" Lernspiele ", menubar, this);
    public final LauncherMenu nachschlagewerk = new LauncherMenu(" Nachschlagewerke ", menubar, this);
    public final LauncherMenu lern = new LauncherMenu(" Lernprogramme ", menubar, this);
    public final LauncherMenu prog = new LauncherMenu(" Werkzeuge ", menubar, this);
    public final LauncherMenu web = new LauncherMenu(" Webseiten ", menubar, this);
    public final LauncherMenu computer = new LauncherMenu(" Computer ", menubar, this);
    public final LauncherMenu mueber = new LauncherMenu(" Programm ", menubar, this);
    //Menuitems
    //1
    private final LauncherMenu m1geo = new LauncherMenu(" Geografie ", fach, this);
    public LauncherItem m1geo_geograficus = new LauncherItem(" Geograficus ", m1geo, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\BrainGame\\Geograficus\\Geograficus.exe");
    private final LauncherMenu m1info = new LauncherMenu(" Infomartik ", fach, this);
    public LauncherItem m1info_informaticus = new LauncherItem(" Informaticus ", m1info, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\BrainGame\\Informaticus\\Informaticus.exe");
    private final LauncherMenu m1ma = new LauncherMenu(" Mathematik ", fach, this);
    public LauncherItem m1ma_mathica = new LauncherItem(" Mathica ", m1ma, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\BrainGame\\Mathica\\Mathica.exe");
    private final LauncherMenu m1ma_mathematikus = new LauncherMenu(" Mathematikus ", m1ma, this);
    public LauncherItem m1ma_ma_1 = new LauncherItem(" Mathematikus 1 ", m1ma_mathematikus, RunMode.SERVER, true, this, "\\\\svr03-eb\\Matikus1$\\Matikus1Net.exe");
    public LauncherItem m1ma_ma_2 = new LauncherItem(" Mathematikus 2 ", m1ma_mathematikus, RunMode.SERVER, true, this, "\\\\svr03-eb\\Matikus2$\\Mat2Net.exe");
    public LauncherItem m1ma_ma_3 = new LauncherItem(" Mathematikus 3 ", m1ma_mathematikus, RunMode.SERVER, true, this, "\\\\svr03-eb\\Matikus3$\\Matikus3Net.exe");
    public LauncherItem m1ma_ma_4 = new LauncherItem(" Mathematikus 4 ", m1ma_mathematikus, RunMode.SERVER, true, this, "\\\\svr03-eb\\Matikus4$\\Matikus4Net.exe");
    //2-1
    private final LauncherMenu m2astro = new LauncherMenu(" Astronomie ", nachschlagewerk, this);
    public LauncherItem m2astro_lexikon = new LauncherItem(" Lexikon ", m2astro, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Astronomie/LEXIKON%20Grundwissen%20Astro/INDEX.HTM");
    private final LauncherMenu m2bio = new LauncherMenu(" Biologie ", nachschlagewerk, this);
    public LauncherItem m2bio_duden = new LauncherItem(" DUDEN ", m2bio, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Biologie/DUDEN-Biologie%20Sek%20I/pdf/inhalt.pdf");
    private final LauncherMenu m2deutsch = new LauncherMenu(" Deutsch ", nachschlagewerk, this);
    public LauncherItem m2deutsch_lexikon = new LauncherItem(" Lexikon ", m2deutsch, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Sprachen/Deutsch/Duden%20Basiswissen%20Deutsch/lexikon/index.htm");
    private final LauncherMenu m2ge = new LauncherMenu(" Geschichte ", nachschlagewerk, this);
    public LauncherItem m2ge_lexikon = new LauncherItem(" Lexikon ", m2ge, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Geschichte/BW_Geschichte/LEXIKON/INDEX.HTM");
    private final LauncherMenu m2ku = new LauncherMenu(" Kunst ", nachschlagewerk, this);
    public LauncherItem m2ku_duden = new LauncherItem(" DUDEN ", m2ku, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Kunst/Duden%20Kunst%20Gym%20II/pdf/inhalt.pdf");
    private final LauncherMenu m2musik = new LauncherMenu(" Musik ", nachschlagewerk, this);
    public LauncherItem m2musik_lexikon = new LauncherItem(" Lexikon ", m2musik, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Musik/Duden_Musik/LEXIKON/INDEX.HTM");
    private final LauncherMenu m2physik = new LauncherMenu(" Physik ", nachschlagewerk, this);
    public LauncherItem m2physik_duden_1 = new LauncherItem(" DUDEN Sek. I ", m2physik, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Sek%20I%20Gesamtband/pdf/inhalt.pdf");
    public LauncherItem m2physik_duden_2 = new LauncherItem(" DUDEN Sek. II ", m2physik, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Duden%20Physik%20Gym%20II/pdf/inhalt.pdf");
    public LauncherItem m2physik_lexikon = new LauncherItem(" Lexikon ", m2physik, RunMode.OPERA, true, this, "file://svr03-eb/esa/infos/Fachbereiche/Physik/Basiswissen_Physik/LEXIKON/INDEX.HTM");
    public LauncherItem m2formelsammelung = new LauncherItem(" Formelsammelung ", nachschlagewerk, RunMode.IEXPLORE, true, this, "\\\\SVR03-EB\\esa\\infos\\Fachbereiche\\Naturwissenschaften\\Formelsamllung_bis_10\\fs_htm\\start.htm");
    public LauncherItem m2LoewenzahnLexi = new LauncherItem(" L\u00F6wenzahn Lexikon ", nachschlagewerk, RunMode.KIX, true, this, "D:\\Launcher\\loewenzahn.kix");
    //2-2
    private final LauncherMenu m2info = new LauncherMenu(" Informatik ", lern, this);
    public LauncherItem m2info_robot = new LauncherItem(" Robot Karol ", m2info, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\RobotKarol\\karol.exe");
    public LauncherItem m2info_mslogo = new LauncherItem(" Microsoft Logo ", m2info, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\Softronics\\Microsoft Windows Logo\\Logo32.exe");
    public LauncherItem m2info_tipp10 = new LauncherItem(" TIPP 10 ", m2info, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\Tipp10\\tipp10.exe");
    private final LauncherMenu m2ma = new LauncherMenu(" Mathematik ", lern, this);
    private final LauncherMenu m2ma_mathebits = new LauncherMenu(" Mathe Bits ", m2ma, this);
    public LauncherItem m2ma_3_satz = new LauncherItem(" 3 Satz, Prozente und Zinsen ", m2ma_mathebits, RunMode.PROGRAM, true, this, "D:\\Launcher\\Prozente_7.bat");
    public LauncherItem m2ma_terme = new LauncherItem(" Terme und Gleichungen ", m2ma_mathebits, RunMode.PROGRAM, true, this, "D:\\Launcher\\Terme_7.bat");
    //3
    public LauncherItem m3datei = new LauncherItem(" Dateimanager ", prog, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\totalcmd\\TOTALCMD.exe");
    private final LauncherMenu m3inet = new LauncherMenu(" Internet Browser ", prog, this);
    public LauncherItem m3inet_opera = new LauncherItem(" Opera ", m3inet, RunMode.OPERA, true, this, "");
    public LauncherItem m3inet_iexplorer = new LauncherItem(" Internet Explorer ", m3inet, RunMode.IEXPLORE, true, this, "");
    public LauncherItem m3webweaver = new LauncherItem(" WebWeaver Desktop ", prog, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\DigiOnline GmbH\\WebWeaver Desktop\\WebWeaver.exe");
    //public LauncherItem m3mathe = new LauncherItem(" GEONExT ", prog, RunMode.PROGRAM, "", true, this);
    private final LauncherMenu m3office = new LauncherMenu(" OpenOffice ", prog, this);
    public LauncherItem m3office_writer = new LauncherItem(" Writer (Textverarbeitung) ", m3office, RunMode.OPENOFFICE, true, this, "swriter.exe");
    public LauncherItem m3office_calc = new LauncherItem(" Calc (Tabellenkalkulation) ", m3office, RunMode.OPENOFFICE, true, this, "scalc.exe");
    public LauncherItem m3office_impress = new LauncherItem(" Impress (Pr\u00E4sentation) ", m3office, RunMode.OPENOFFICE, true, this, "simpress.exe");
    public LauncherItem m3office_draw = new LauncherItem(" Draw (Zeichnen) ", m3office, RunMode.OPENOFFICE, true, this, "sdraw.exe");
    public LauncherItem m3office_base = new LauncherItem(" Base (Datenbank) ", m3office, RunMode.OPENOFFICE, true, this, "sbase.exe");
    public LauncherItem m3office_math = new LauncherItem(" Math (Formel) ", m3office, RunMode.OPENOFFICE, true, this, "smath.exe");
    private final LauncherMenu m3micro = new LauncherMenu(" Microsoft Office ", prog, this);
    public LauncherItem m3micro_word = new LauncherItem(" Word (Textverarbeitung) ", m3micro, RunMode.MSOFFICE, true, this, "WINWORD.EXE");
    public LauncherItem m3micro_excel = new LauncherItem(" Excel (Tabellenkalkulation) ", m3micro, RunMode.MSOFFICE, true, this, "EXCEL.EXE");
    public LauncherItem m3micro_powerpoint = new LauncherItem(" Power Point (Pr\u00E4sentation) ", m3micro, RunMode.MSOFFICE, true, this, "POWERPNT.EXE");
    public LauncherItem m3micro_access = new LauncherItem(" Access (Datenbank) ", m3micro, RunMode.MSOFFICE, true, this, "MSACCESS.EXE");
    private final LauncherMenu m3image = new LauncherMenu(" Bildprogramme ", prog, this);
    public LauncherItem m3image_gimp = new LauncherItem(" GIMP ", m3image, RunMode.PROGRAM, true, this, "C:\\Program Files\\GIMP 2\\bin\\gimp-2.8.exe");
    public LauncherItem m3image_irfanview = new LauncherItem(" IrfanView ", m3image, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\IrfanView\\i_view32.exe");
    public LauncherItem m3image_inkscape = new LauncherItem(" InkScape ", m3image, RunMode.PROGRAM, true, this, "C:\\Program Files (x86)\\Inkscape\\inkscape.exe");
    //4
    public LauncherItem m4schkola = new LauncherItem(" Schkola.de ", web, RunMode.OPERA, true, this, "http://schkola.de");
    public LauncherItem m4lernsax = new LauncherItem(" Lernsax.de ", web, RunMode.OPERA, true, this, "https://www.lernsax.de/wws/9.php#/wws/100001.php");
    public LauncherItem m4mesax = new LauncherItem(" MeSax Schulserver ", web, RunMode.OPERA, true, this, "http://mesax/");
    public LauncherItem m4erlaubt = new LauncherItem(" Erlaubt Liste ", web, RunMode.SERVER, true, this, "\\\\SVR03-EB\\esa\\infos\\IT\\Launcher\\erlaubt.bat");
    public LauncherItem m4erlaubt_lernsax = new LauncherItem(" Whitelist Lernsax ", web, RunMode.OPERA, true, this, "https://www.lernsax.de/link.php?wiki%7Cinfo%40schkola.lernsax.de%7CIndex%7C/");
    //5
    public LauncherItem m6shutdown = new LauncherItem(" Herunterfahren ", computer, RunMode.SHUTDOWN, true, this, "shutdown");
    public LauncherItem m6logoff = new LauncherItem(" Abmelden ", computer, RunMode.SHUTDOWN, true, this, "logoff");
    public LauncherItem m6restart = new LauncherItem(" Neu Starten ", computer, RunMode.SHUTDOWN, true, this, "restart");
    public LauncherItem m6home = new LauncherItem(" Homeverzeichniss ", computer, RunMode.COMPUTER, true, this, "explorer.exe P:");
    public LauncherItem m6computer = new LauncherItem(" Arbeitsplatz ", computer, RunMode.COMPUTER, true, this, "explorer.exe /e,");
    //6
    public LauncherItem m5ueber = new LauncherItem(" \u00DCber ", mueber, RunMode.FRAME, true, this, "");
    public LauncherItem m5hilfe = new LauncherItem(" Hilfe ", mueber, RunMode.FRAME, true, this, "");
    public LauncherItem m5mini = new LauncherItem(" Minimieren ", mueber, RunMode.FRAME, true, this, "");
    public LauncherItem close = new LauncherItem(" Beenden ", mueber, RunMode.FRAME, true, this, "");
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
        setIconImage(logo);
        addWindowListener(new WindowListener());
        setJMenuBar(this.menubar);
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
