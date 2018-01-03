package de.schkola.launcher;

public enum ShutdownAction {
    SHUTDOWN("M\u00F6chtst du den Computer wirklich herrunterfahren?", "shutdown -s -t 0"),
    LOGOFF("M\u00F6chtst du dich wirklich abmelden?", "shutdown -l"),
    RESTART("M\u00F6chtest du den Computer wirklich neustarten?", "shutdown -r");
    
    String msg;
    String cmd;
    ShutdownAction(String msg, String cmd) {
        this.msg = msg;
        this.cmd = cmd;
    }

    public String getMsg() {
        return msg;
    }

    public String getCmd() {
        return cmd;
    }
}
