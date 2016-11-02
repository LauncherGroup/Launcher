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
