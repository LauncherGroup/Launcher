package de.schkola.launcher;

import de.schkola.launcher.dialog.ErrorHandler;
import de.schkola.launcher.dialog.ShutdownDialog;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Run {

    /**
     * Runs Commands on the Computer
     *
     * @param mode See 'RunMode'
     * @param command The command witch sould executed
     * @param last Is this command the last?
     * @return TRUE = Executed | FALSE = NOT EXECUTED (ERROR)
     */
    public static boolean run(RunMode mode, String command, boolean last) {
        Runtime runtime = Runtime.getRuntime();
        switch (mode) {
            case COMMAND:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
                    if (last) {
                        new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                    }
                    return false;
                }
            case WEB:
                try {
                    runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Opera\\launcher.exe --user-data-dir=P:\\Opera -newtab " + command);
                    return true;
                } catch (IOException ex) {
                    try {
                        runtime.exec(System.getenv("PROGRAMFILES") + "\\Opera\\launcher.exe --user-data-dir=P:\\Opera -newtab " + command);
                        return true;
                    } catch (IOException ex1) {
                        try {
                            runtime.exec(System.getenv("PROGRAMFILES") + "\\Internet Explorer\\iexplore.exe " + command);
                            return true;
                        } catch (IOException ex2) {
                            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                                if (System.getProperty("os.name").equals("Linux")) {
                                    command = command.replace("file://", "smb://");
                                }
                                try {
                                    desktop.browse(new URI(command));
                                    return true;
                                } catch (URISyntaxException | IOException e) {
                                    new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                                    return false;
                                }
                            }
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
            case KIX:
                try {
                    runtime.exec("KIX32.EXE " + command);
                    return true;
                } catch (IOException ex) {
                    new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                    return false;
                }
            case SERVER:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
                    if (last) {
                        new ErrorHandler(ErrorHandler.ErrorType.NO_CONNECTION);
                    }
                    return false;
                }
            case SHUTDOWN:
                new ShutdownDialog(command);
                break;
            case MSOFFICE:
                try {
                    runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Microsoft Office\\Office\\" + command);
                } catch (IOException ex1) {
                    try {
                        runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Microsoft Office\\Office14\\" + command);
                    } catch (IOException ex2) {
                        try {
                            runtime.exec(System.getenv("PROGRAMFILES") + "\\Microsoft Office\\Office\\" + command);
                        } catch (IOException ex3) {
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
                return true;
            case OPENOFFICE:
                try {
                    runtime.exec(System.getenv("PROGRAMFILES") + "\\OpenOffice 4\\program\\s" + command + ".exe");
                } catch (IOException ex1) {
                    try {
                        runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\OpenOffice 4\\program\\s" + command + ".exe");
                    } catch (IOException ex2) {
                        try {
                            runtime.exec("libreoffice --" + command);
                        } catch (IOException ex3) {
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
                return true;
        }
        return false;
    }

    public enum RunMode {

        /**
         * Opens an webpage
         */
        WEB,
        /**
         * Runs the given command
         */
        COMMAND,
        /**
         * Runs an KiXtart Script
         */
        KIX,
        /**
         * Runs an application from an server
         */
        SERVER,
        /**
         * Runs an shutdown command in Windows
         */
        SHUTDOWN,
        /**
         * Opens an 'Microsoft Office' application
         */
        MSOFFICE,
        /**
         * Open an 'OpenOffice' application
         */
        OPENOFFICE,
        /**
         * Uses an ActionListener
         */
        ACTION;
    }

    public enum OfficeProg {
        TEXT("writer", "WINWORD.EXE"),
        CALC("calc", "EXCEL.EXE"),
        PRESENTATION("impress", "POWERPNT.EXE"),
        DATABASE("base", "MSACCESS.EXE"),
        MATH("math", null),
        DRAW("draw", null);
        String ooname;
        String msname;

        OfficeProg(String ooname, String msname) {
            this.ooname = ooname;
            this.msname = msname;
        }

        public String getOOname() {
            return ooname;
        }

        public String getMSname() {
            return msname;
        }
    }
}
