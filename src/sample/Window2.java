package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Window2 implements Initializable {
 @FXML Label show;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void results(String buffer){
        show.setText(buffer);
    }
}
