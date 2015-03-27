package de.schkola.launcher;

import de.schkola.launcher.dialog.AnswerDialog;
import java.io.IOException;

public class Run {

    /**
     * Runs Commands on the Computer
     * @param mode See 'RunMode'
     * @param command The command witch sould executed
     * @param last Is this command the last?
     * @return TRUE = Executed | FALSE = NOT EXECUTED (ERROR)
     */
    public static Boolean run(RunMode mode, String command, Boolean last) {
        Runtime runtime = Runtime.getRuntime();
        switch (mode) {
            case PROGRAM:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
                    if (last) {
                        new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                    }
                    return false;
                }
            case IEXPLORE:
                try {
                    runtime.exec("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe \"" + command + "\"");
                } catch (IOException ex1) {
                    try {
                        runtime.exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"" + command + "\"");
                    } catch (IOException ex2) {
                        try {
                            runtime.exec("C:\\Programme\\Internet Explorer\\iexplore.exe \"" + command + "\"");
                        } catch (IOException ex3) {
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
                return true;
            case OPERA:
                try {
                    runtime.exec("C:\\Programme\\Opera\\launcher.exe -newtab " + command);
                } catch (IOException ex1) {
                    try {
                        runtime.exec("C:\\Program Files (x86)\\Opera\\launcher.exe -newtab " + command);
                    } catch (IOException ex2) {
                        try {
                            runtime.exec("C:\\Program Files (x86)\\Opera\\opera.exe -newtab " + command);
                        } catch (IOException ex3) {
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
                return true;
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
                new AnswerDialog(command);
                break;
            case COMPUTER:
                try {
                    runtime.exec(command);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            case MSOFFICE:
                try {
                    runtime.exec("C:\\Program Files (x86)\\Microsoft Office\\Office\\" + command);
                } catch (IOException ex1) {
                    try {
                        runtime.exec("C:\\Program Files (x86)\\Microsoft Office\\Office14\\" + command);
                    } catch (IOException ex2) {
                        try {
                            runtime.exec("C:\\Programme\\Microsoft Office\\Office\\" + command);
                        } catch (IOException ex3) {
                            new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                            return false;
                        }
                    }
                }
                return true;
            case OPENOFFICE:
                try {
                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\program\\" + command);
                } catch (IOException ex1) {
                    try {
                        Runtime.getRuntime().exec("D:\\Programme\\OpenOffice.org 3\\program\\" + command);
                    } catch (IOException ex2) {
                        try {
                            Runtime.getRuntime().exec("C:\\Programme\\OpenOffice 4\\program\\" + command);
                        } catch (IOException ex3) {
                            try {
                                Runtime.getRuntime().exec("C:\\Programme\\program\\" + command);
                            } catch (IOException ex4) {
                                try {
                                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\OpenOffice 4\\program\\" + command);
                                } catch (IOException ex5) {
                                    try {
                                        Runtime.getRuntime().exec("C:\\Programme\\OpenOffice.org 3\\program\\" + command);
                                    } catch (IOException ex6) {
                                        new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
        }
        return false;
    }
}
