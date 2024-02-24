package oneHand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Window6Controller implements Initializable {

    @FXML
    private ChoiceBox<String> listID;

    static String username;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> reports = new ArrayList<>();

        try {
            File file = new File("reports.txt");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {

                String name = fileReader.nextLine();
                String report = fileReader.nextLine();

                if (name.equals(username)){
                    reports.add(report);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (reports.isEmpty()){
            listID.getItems().addAll("No Reports");
        }
        else {
            listID.getItems().addAll(reports);
        }


    }

    @FXML
    void backAction(ActionEvent event) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Window4.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception io) {
            System.out.println("FXML Loading Error");
        }

    }

    @FXML
    void signOutAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Window1.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception io) {
            System.out.println("FXML Loading Error");
        }

    }
}
