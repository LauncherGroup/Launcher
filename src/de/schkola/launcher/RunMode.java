package de.schkola.launcher;

public enum RunMode {

    /**
     * Opens an webpage with 'Internet Explorer'
     */
    IEXPLORE,

    /**
     * Opens an webpage with 'Opera'
     */
    OPERA,

    /**
     * Runs the given command
     */
    PROGRAM,

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
     * RunMode for computer commands like 'explorer.exe ...'
     */
    COMPUTER,

    /**
     * Opens an 'Microsoft Office' application
     */
    MSOFFICE,

    /**
     * Open an 'OpenOffice' application
     */
    OPENOFFICE,

    /**
     * Opens an defined Frame in Java -> see 'LauncherListener.java'
     */
    FRAME;
    
}
