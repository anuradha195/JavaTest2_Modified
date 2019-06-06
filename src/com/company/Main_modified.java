package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main_modified extends Application {
    private Stage window;
    Scanner sc = new Scanner(System.in);
    int  count=0;
    double rand= Math.random();
    int random = (int) (rand*100);
    //int numberguessed = 0;
	
    public static void main(String[] args) {
        launch(args);
	// write your code here
        // write code here
    }

	
    @Override
    public void start(Stage primaryStage) throws Exception {

	
        window=primaryStage;

        // Set Title of the Stage...
		primaryStage.setTitle("Lets Play a Game");

		//create Menubar for the application
		MenuBar menuBar = new MenuBar();
        // --- Menu Game
        //create menu item for MenuBar




        
		Menu menuGame = new Menu("Games");
        
		MenuItem Numbergame=new MenuItem("Number Guessing game");

        Menu menuOtherOptions = new Menu("Other Options");
        
		menuBar.getMenus().addAll(menuGame,menuOtherOptions);

        menuGame.getItems().addAll(Numbergame);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar);
        Scene firstscene = new Scene(vbox, 640, 420);


        VBox vbox1 = new VBox();
        TextField numberOfLives = new TextField();
        Label setNumOfLivesLabel =new Label("Submit how many Lives would you like to have");
        numberOfLives.setPromptText("How many Lives would you like to have?");
        TextField guessNumberTextField = new TextField();
        Label guessNumberLabel =new Label("Guess a number Here: ");
        Button submitGuessButton = new Button("Check if you guessed right?");
        guessNumberTextField.setPromptText("Guess a number ");
        vbox1.getChildren().addAll(setNumOfLivesLabel,numberOfLives,guessNumberLabel,guessNumberTextField,submitGuessButton);
        Scene gameScene = new Scene(vbox1,640,480);

        Numbergame.setOnAction(event -> {
            window.setScene(gameScene);
        });

        submitGuessButton.setOnAction(event -> {
                int numberguessed;
                int userInputGuess = Integer.parseInt(numberOfLives.getText());
                //System.out.println("random number is :" +random);
                numberguessed = Integer.parseInt(guessNumberTextField.getText());
                count++;
                //System.out.println("Count is : " + count);
                if (numberguessed > random) {
                    System.out.println("Your guess was too high, try again ");
                    if (count == userInputGuess) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                } else if (numberguessed < random) {
                    System.out.println("You guess too low, try again ");
                    if (count == userInputGuess) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                }
                if (numberguessed == random) {
                    System.out.println("Congratulations!!!! You guessed the correct number ");
                    window.close();
                }
            });



            /*do {
                numberguessed=0;
                //TextField numberdisplay = new TextField();
                numberdisplay.setPromptText("Guess a number ");
                numberguessed = Integer.parseInt(numberdisplay.getText());
                //count++;
                if (numberguessed > random) {
                    System.out.println("You guess too high, try again ");
                    System.out.println("Count is :"+count);
                    if ( count == 3){
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                } else if (numberguessed < random) {
                    System.out.println("You guess too low, try again ");
                    System.out.println("Count is :"+count);
                    if ( count == 3) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }

                }

            } while (  !(numberguessed == random)  );
            if ( numberguessed == random);
                System.out.println("Congratulations!!!! You guessed the correct number ");
                window.close();*/

        window.setScene(firstscene);
        primaryStage.show();
    }

}
