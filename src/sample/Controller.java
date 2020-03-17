package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Activities.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import org.w3c.dom.Text;
import javafx.scene.paint.Color;
import java.lang.reflect.Array;
import java.util.Arrays;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Controller {
    Swimming swim=new Swimming();
    Running run=new Running();
    StrengthTraining gym=new StrengthTraining();
    KickBoxing box=new KickBoxing();
    @FXML
    TextField runInput;
    @FXML
    TextField gymInput;
    @FXML
    TextField boxInput;
    @FXML
    TextField swimInput;
    @FXML
    TextField caloriesResult;
    @FXML
    TextField heartbeatResult;
    @FXML
    Button results;
    @FXML
    Label verify;
    @FXML
    Button clear;
    @FXML
    Button sort;
    @FXML
    Label label1;
    public void swimbutton(ActionEvent event){
        if(Integer.signum(Integer.parseInt(swimInput.getText()))==-1) {
            verify.setText("Invalid input");
            verify.setTextFill(Color.web("red"));
        }
        else {verify.setTextFill(Color.web("black"));
            int input = Integer.parseInt(swimInput.getText()); //To get time from input and convert it to integer(input from the user is a string initially)
            swim.calculate(input);
            swimInput.setText("");
            swimInput.setPromptText("");
            verify.setText("Swimming added successfully");
        }
    }
    public void gymbutton(ActionEvent event){
        if(Integer.signum(Integer.parseInt(gymInput.getText()))==-1)
        {
            verify.setText("Invalid input");
            verify.setTextFill(Color.web("red"));
        }
        else {verify.setTextFill(Color.web("black"));
            int input = Integer.parseInt(gymInput.getText());
            gym.calculate(input);
            gymInput.setText("");
            gymInput.setPromptText("");
            verify.setText("Gym added successfully");
        }
    }
    public void boxbutton(ActionEvent event){
        if(Integer.signum(Integer.parseInt(boxInput.getText()))==-1)
        {
            verify.setText("Invalid input");
            verify.setTextFill(Color.web("red"));
        }
        else {verify.setTextFill(Color.web("black"));
            int input = Integer.parseInt(boxInput.getText());
            box.calculate(input);
            boxInput.setText("");
            boxInput.setPromptText("");
            verify.setText("Kick Boxing added successfully");
        }
    }
    public void runbutton(ActionEvent event){
        if(Integer.signum(Integer.parseInt(runInput.getText()))==-1)
        {
            verify.setText("Invalid input");
            verify.setTextFill(Color.web("red"));
        }
        else {            verify.setTextFill(Color.web("black"));
            int input = Integer.parseInt(runInput.getText());
            run.calculate(input);
            runInput.setText("");
            runInput.setPromptText("");
            verify.setText("Running added successfully");
        }
    }
    private static DecimalFormat df = new DecimalFormat("0.000");
    public void setResults(ActionEvent event){
        heartbeatResult.setText(df.format(Activities.totalHeartRate));
        caloriesResult.setText(Integer.toString(Activities.totalCalories));
    }
    public void setClear(ActionEvent event)
    {Activities.totalCalories=0;
    Activities.totalHeartRate=80.0;
        swim.HeartRate=0;swim.Calories=0;
        gym.HeartRate=0;gym.Calories=0;
        run.HeartRate=0;run.Calories=0;
        box.HeartRate=0;box.Calories=0;
        heartbeatResult.setText("");
        caloriesResult.setText("");
        runInput.setPromptText("");boxInput.setPromptText("");gymInput.setPromptText("");swimInput.setPromptText("");
        verify.setText("");
        label1.setText("");
    }
    public void setSort(ActionEvent event){int csort[]=new int [4];String buffer="";
        csort[0]=swim.Calories;csort[1]=run.Calories;csort[2]=gym.Calories;csort[3]=box.Calories;
        int flag1=0,flag2=0,flag3=0,flag4=0;
        Arrays.sort(csort);
        int i=1,j=3;
        for(j=3;j>=0;j--) {
            if (csort[j] == gym.Calories && csort[j]!=0) {
                if (flag3 != 1) {
                    buffer += i + "-Gym: " + gym.Calories + " calories " + df.format(gym.HeartRate) + " beat/min\n";
                    i++;
                    flag3 = 1;
                }
            }
                if (csort[j] == box.Calories && csort[j]!=0) {
                    if(flag4!=1) {
                        buffer += i + "-Kick Boxing: " + box.Calories + " calories " + df.format(box.HeartRate) + " beat/min\n";
                        i++;
                        flag4=1;
                    }
                }

        if (csort[j] == run.Calories && csort[j]!=0) {
            if(flag2!=1) {
                buffer += i + "-Running: " + run.Calories + " calories " + df.format(run.HeartRate) + " beat/min\n";
                i++;
                flag2=1;
            }
            }
            if (csort[j] == swim.Calories && csort[j]!=0) {
                if (flag1 != 1) {
                    buffer += i + "-Swimming: " + swim.Calories + " calories " + df.format(swim.HeartRate) + " beat/min\n";
                    flag1 = 1;
                    i++;
                }
            }
        }
        label1.setTextFill(Color.web("green"));
        label1.setText(buffer);
    }

    }


