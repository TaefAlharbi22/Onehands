package oneHand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Window2Controller {

    @FXML
    private PasswordField passID;

    @FXML
    private TextField userNameID;

    @FXML
    void enterAction(ActionEvent event) {

        Boolean isNotAccount = true;

        try {
            File file = new File("signs.txt");
            Scanner fileRead = new Scanner(file);

            while (fileRead.hasNextLine()) {

                String name = fileRead.nextLine();
                String pass = fileRead.nextLine();

                if (name.equals(userNameID.getText()) && pass.equals(passID.getText())){

                    isNotAccount = false;

                    Window5Controller.username = userNameID.getText();
                    Window6Controller.username = userNameID.getText();

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Window4.fxml"));
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);

                    } catch (Exception io) {
                        System.out.println("FXML Loading Error");
                    }

                }

            }

            if (isNotAccount){
                JOptionPane.showMessageDialog(null,"wrong!, you do not have account");
            }

        } catch (FileNotFoundException e) {
            e.toString();
        }

    }

}
