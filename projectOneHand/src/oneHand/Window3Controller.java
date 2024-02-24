package oneHand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Window3Controller {

    @FXML
    private CheckBox checkID;

    @FXML
    private TextField emailID;

    @FXML
    private TextField nameID;

    @FXML
    private TextField passID;

    @FXML
    private TextField phoneID;

    @FXML
    private TextField verifyID;

    @FXML
    void enterAction(ActionEvent event) {

        if (nameID.getText().length()>4 && passID.getText().length() >= 8 && passID.getText().equals(verifyID.getText()) && checkID.isSelected()){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Window4.fxml"));
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);

            } catch (Exception io) {
                System.out.println("FXML Loading Error");
            }

            try {
                FileWriter file = new FileWriter("signs.txt",true);

                file.write(nameID.getText()+"\n");
                file.write(passID.getText()+"\n");
                file.close();



            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            JOptionPane.showMessageDialog(null,"please password must be 8 character or more,\n and username must more than 4\nand approved to policies");
        }

    }

}
