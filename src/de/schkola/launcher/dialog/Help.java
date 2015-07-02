package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help {

    private final JFrame help = new JFrame("Hilfe");
    private final JPanel panel = new JPanel();
    private final String text = "<html>\r\n<body><center>\r\nWillkommen in der Hilfe von dem Programm zur leichten Bedienung der Schkola Oberland!<br>\r\nDieses Programm wurde speziell f\u00FCr die Schkola geschrieben und erm\u00F6glicht eine leichtere <br>Bedienung des Computers. Oben in der Men\u00FCbar kannst du die verschiedenen <br>Programme, Nachschlagewerke, Spiele und Co. \u00F6ffnen.<br><br>\r\nKlicke einfach auf eine der oben gezeigten Auswahlm\u00F6glichkeiten und suchen dir<br> das ben\u00F6tigte Fach aus, das klicke es dann an. Im folgenden Men\u00FC kannst<br> du dann das Programm starten.<br><br>\r\nWenn irgendwelche Fehler auftreten oder du eine Frage zu diesem Programm hast<br> melde dich bitte per Lernsax bei Niklas Merkelt (mn1g@schkola.lernsax.de) <br><br>\r\nWir w\u00FCnschen dir Viel Spa\u00DF und Erfolg mit unserem Programm.<br><br>\r\nLG PU-Gruppe Launcher<br><br>\r\n\r\n</center></body>\r\n</html>";
    private final JLabel hilfe_text = new JLabel(text);

    public Help() {
        panel.setBackground(Launcher.BACKGROUND);
        hilfe_text.setForeground(Launcher.FOREGROUND);
        hilfe_text.setFont(Launcher.FONT_SMALL);
        panel.add(hilfe_text);
        help.getContentPane().add(panel);
        help.setSize(600, 290);
        help.setLocation(300, 150);
        help.setIconImage(Launcher.getLogo());
        help.setResizable(false);
        help.setVisible(true);
    }
}
