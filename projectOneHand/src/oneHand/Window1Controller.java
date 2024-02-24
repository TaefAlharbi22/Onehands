package oneHand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window1Controller {

    @FXML
    void logInAction(ActionEvent event) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Window2.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception io) {
            System.out.println("FXML Loading Error");
        }


    }

    @FXML
    void logUpAction(ActionEvent event) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Window3.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception io) {
            System.out.println("FXML Loading Error");
        }


    }

}
