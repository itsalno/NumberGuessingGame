package GUI.Controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.util.Duration;

public class MainScreen implements Initializable {
    private static final Duration MESSAGE_DELAY =Duration.seconds(1) ;
    @FXML
    private Label hintslbl;
    @FXML
    private TextField numberfield;
    @FXML
    private Label questlabel;
    @FXML
    private Label levellabel;
    private int rnumber;
    private int currentLevel=1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hintslbl.setText("");
        levellabel.setText(String.valueOf(currentLevel));
        rnumber = createRandom();
    }

    public void guessnumber(ActionEvent actionEvent) throws IOException {
        try {
            int guessedNumber = Integer.parseInt(numberfield.getText());

            if (guessedNumber == rnumber) {
                questlabel.setText("Correct!");
                numberfield.clear();
                hintslbl.setText("");
                nextLevel();
                questlabel.setText("Guess the number between 0-100");
            } else if (guessedNumber < rnumber) {
                questlabel.setText("Incorrect. Try again!");
                hintslbl.setText(">"+ guessedNumber+" and "+"<"+(rnumber+1));
            } else {
                questlabel.setText("Incorrect. Try again!");
                hintslbl.setText("<"+ guessedNumber +" and "+">"+(rnumber+-1));
            }
        } catch (NumberFormatException e) {
            questlabel.setText("Please enter a valid number.");
        }

    }

    public int createRandom(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    public void nextLevel(){
        int currentLevel = Integer.parseInt(levellabel.getText());
        int nextLevel = currentLevel + 1;
        levellabel.setText(String.valueOf(nextLevel));

        rnumber = createRandom();
    }

}
