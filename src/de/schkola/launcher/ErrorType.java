package de.schkola.launcher;

public enum ErrorType {

    /**
     * ErrorType for no connection to the given host
     */
    NO_CONNECTION("Das Ger\u00E4t hat keine Verbindung zum Server!"),
    /**
     * ErrorType for 'Program not avilable on the computer'
     */
    NOT_AVAILABLE("Dieses Programm ist auf diesem Ger\u00E4t leider nicht verf\u00FCgbar!");

    String msg;

    ErrorType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
