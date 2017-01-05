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

import de.schkola.launcher.dialog.ErrorHandler.ErrorType;
import de.schkola.launcher.dialog.ShutdownDialog;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Run {

    /**
     * Runs Commands on the Computer
     *
     * @param mode See 'RunMode'
     * @param command The command witch sould executed
     * @return TRUE = Executed | FALSE = NOT EXECUTED (ERROR)
     */
    public static boolean run(RunMode mode, String command) {
        Runtime runtime = Runtime.getRuntime();
        switch (mode) {
            case COMMAND:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            case WEB:
                try {
                    if (new File("P:\\Opera").exists()) {
                        runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Opera\\launcher.exe --user-data-dir=P:\\Opera -newtab " + command);
                    } else {
                        runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Opera\\launcher.exe -newtab " + command);
                    }
                    return true;
                } catch (IOException ex) {
                    try {
                        if (new File("P:\\Opera").exists()) {
                            runtime.exec(System.getenv("PROGRAMFILES") + "\\Opera\\launcher.exe --user-data-dir=P:\\Opera -newtab " + command);
                        } else {
                            runtime.exec(System.getenv("PROGRAMFILES") + "\\Opera\\launcher.exe -newtab " + command);
                        }
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
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                }
            case KIX:
                try {
                    runtime.exec("KIX32.EXE " + command);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            case SERVER:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
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
        WEB(ErrorType.NOT_AVAILABLE),
        /**
         * Runs the given command
         */
        COMMAND(ErrorType.NOT_AVAILABLE),
        /**
         * Runs an KiXtart Script
         */
        KIX(ErrorType.NOT_AVAILABLE),
        /**
         * Runs an application from an server
         */
        SERVER(ErrorType.NO_CONNECTION),
        /**
         * Runs an shutdown command in Windows
         */
        SHUTDOWN(null),
        /**
         * Opens an 'Microsoft Office' application
         */
        MSOFFICE(ErrorType.NOT_AVAILABLE),
        /**
         * Open an 'OpenOffice' application
         */
        OPENOFFICE(ErrorType.NOT_AVAILABLE),
        /**
         * Uses an ActionListener
         */
        ACTION(null);

        private final ErrorType errorType;

        RunMode(ErrorType et) {
            this.errorType = et;
        }

        public ErrorType getErrorType() {
            return errorType;
        }
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
