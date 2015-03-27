package de.schkola.launcher.dialog;

import de.schkola.launcher.Launcher;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help {

    private final JButton close = new JButton(" Schlie\u00DFen ");
    private final JFrame help = new JFrame("Hilfe");
    private final JPanel panel = new JPanel();
    private final String text = "<html>\r\n<body>\r\nWillkommen in der Hilfe von dem Programm zur leichten Bedienung der Schkola Oberland!<br>\r\nDieses Programm wurde speziell f\u00FCr die Schkola geschrieben und erm\u00F6glicht eine leichtere <br>Bedienung des Computers. Oben in der Men\u00FCbar k\u00F6nnst du die verschiedenen <br>Programme, Nachschlagewerke, Spiele und Co. \u00F6ffnen.<br><br>\r\nKlicke einfach auf eine der oben gezeigten Auswahlm\u00F6glichkeiten und suchen dir<br> das ben\u00F6tigte Fach aus, das klicke es dann an. Im folgenden Men\u00FC k\u00F6nnst<br> du dann das Programm ausw\u00E4hlen.<br><br>\r\nWenn irgendwelche Fehler auftreten oder du eine Frage zu diesem Programm hast<br> melde dich bitte per Lernsax bei Niklas Merkelt (mn1g@schkola.lernsax.de) <br><br>\r\nWir w\u00FCnschen dir Viel Spa\u00DF und Erfolg mit unserem Programm.<br><br>\r\nLG PU-Gruppe Launcher<br>\r\n\r\n</body>\r\n</html>";
    private final JLabel hilfe_text = new JLabel(text);

    public Help() {
        panel.setBackground(new Color(255, 165, 0));
        panel.setForeground(new Color(0, 128, 128));
        hilfe_text.setBackground(new Color(255, 165, 0));
        hilfe_text.setForeground(new Color(0, 128, 128));
        hilfe_text.setFont(Launcher.FONT_SMALL);
        panel.add(hilfe_text);
        close.setForeground(new Color(0, 128, 128));
        close.setBackground(new Color(204, 204, 255));
        close.setFont(Launcher.FONT_BIG);
        panel.add(close, BorderLayout.SOUTH);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                help.dispose();
            }
        });
        help.getContentPane().add(panel);
        help.setSize(580, 340);
        help.setLocation(300, 150);
        help.setIconImage(Launcher.getLogo());
        help.setResizable(false);
        help.setVisible(true);
    }
}
