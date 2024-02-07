package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class MainScreen implements Initializable {
    @FXML
    private TextField numberfield;
    @FXML
    private Label questlabel;
    @FXML
    private Label levellabel;
    private int rnumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rnumber = createRandom();
    }

    public void guessnumber(ActionEvent actionEvent) throws IOException {
        try {
            int guessedNumber = Integer.parseInt(numberfield.getText());

            if (guessedNumber == rnumber) {
                questlabel.setText("Correct!");
            } else {
                questlabel.setText("Incorrect. Try again!");
            }
        } catch (NumberFormatException e) {
            questlabel.setText("Please enter a valid number.");
        }
    }

    public int createRandom(){
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        System.out.println(randomNumber);
        return randomNumber;
    }

    public void checkWinner(){


    }

}
