package de.schkola.launcher;

import de.schkola.launcher.dialog.AnswerDialog;
import java.io.IOException;

public class Run {

    /**
     * Runs Commands on the Computer
     *
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
                    runtime.exec(System.getenv("PROGRAMFILES") + "\\Internet Explorer\\iexplore.exe " + command);
                    return true;
                } catch (IOException ex) {
                    new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                    return false;
                }
            case OPERA:
                try {
                    runtime.exec(System.getenv("PROGRAMFILES") + "\\Opera\\launcher.exe -newtab " + command);
                } catch (IOException ex1) {
                    try {
                        runtime.exec(System.getenv("PROGRAMFILES") + " (x86)\\Opera\\launcher.exe -newtab " + command);
                    } catch (IOException ex2) {
                        new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                        return false;
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
                    Runtime.getRuntime().exec(System.getenv("PROGRAMFILES") + "\\OpenOffice 4\\program\\" + command);
                } catch (IOException ex1) {
                    try {
                        Runtime.getRuntime().exec(System.getenv("PROGRAMFILES") + " (x86)\\OpenOffice 4\\program\\" + command);
                    } catch (IOException ex2) {
                        new ErrorHandler(ErrorHandler.ErrorType.NOT_AVAILABLE);
                        return false;
                    }
                }
                return true;
        }
        return false;
    }
}
