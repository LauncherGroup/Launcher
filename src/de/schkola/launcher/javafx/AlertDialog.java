package de.schkola.launcher.javafx;

import de.schkola.launcher.Launcher;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class AlertDialog extends Alert {

    public AlertDialog(AlertType alertType) {
        this(alertType, "");
        
    }

    public AlertDialog(AlertType alertType, String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
        getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        Stage s = (Stage) getDialogPane().getScene().getWindow();
        s.getIcons().add(Launcher.getLogo());
    }
}
