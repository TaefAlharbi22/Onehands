package oneHand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Window5Controller {

    @FXML
    private TextField dateID;

    @FXML
    private TextField desID;

    @FXML
    private TextField nameID;

    @FXML
    private TextField placeID;

    @FXML
    private TextField timeID;

    static String username;

    @FXML
    void enterAction(ActionEvent event) {

        if (nameID.getText().isEmpty()){

            JOptionPane.showMessageDialog(null,"Please enter at least the name");

        }else {

            try {
                FileWriter file = new FileWriter("reports.txt",true);

                file.write(username+"\n");
                file.write(nameID.getText()+"\n");
                file.close();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Window6.fxml"));
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);

                } catch (Exception io) {
                    System.out.println("FXML Loading Error");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
