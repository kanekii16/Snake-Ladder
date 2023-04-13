package com.example.snake_ladders;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int width = 10 ,height = 10,tileSize = 50;
    public static final int buttonLine = tileSize * height + 43,infoLine = tileSize * height + 10;

    private Player volt,kaneki;

    private boolean gameStart = false , voltTurn = false ,kanekiTurn = false;

    private Dice dice = new Dice();
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);



        for (int i = 0; i < height; i++) {
            for(int j = 0 ; j < width ; j++){
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }

        }

        Image img = new Image("C:\\Users\\iamsa\\IdeaProjects\\Snake_Ladders\\src\\main\\board.jpg");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

//        Creating buttons

        Button playerOne = new Button("Player One");
        Button playerTwo = new Button("Player Two");
        Button start = new Button("Start");

        playerOne.setTranslateY(buttonLine);
        playerOne.setTranslateX(25);

        playerTwo.setTranslateY(buttonLine);
        playerTwo.setTranslateX(400);

        start.setTranslateX(230);
        start.setTranslateY(buttonLine);

        Label playerOneLabel = new Label("Player 1 Turn");

        Label playerTwoLabel = new Label("Player 2 Turn");


        Label diceLabel = new Label("Dice");

        playerOneLabel.setTranslateX(25);
        playerOneLabel.setTranslateY(infoLine);

        playerTwoLabel.setTranslateX(400);
        playerTwoLabel.setTranslateY(infoLine);


        diceLabel.setTranslateX(230);
        diceLabel.setTranslateY(infoLine);


        volt = new Player(tileSize,"Volt",Color.BLACK);
        kaneki = new Player(tileSize-5,"Kaneki",Color.SIENNA);


//        Palyer Movement;


        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                gameStart = true;
                start.setDisable(true);
                diceLabel.setText("Game Begins");
                playerOneLabel.setText("Your Turn ! " + volt.getName());
                kanekiTurn = false;
                playerTwoLabel.setText("");
                voltTurn = true;
                volt.restart();
                kaneki.restart();
                playerOne.setDisable(false);
                playerTwo.setDisable(true);



            }
        });

            playerOne.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(gameStart){
                        if(voltTurn){
                            int diceVal = dice.getRolledVal();
                            diceLabel.setText("The value is : "+diceVal);
                            volt.movePlayer(diceVal);
                            if(volt.isWinner()){
                                diceLabel.setText("The Winner is : "+volt.getName());

                                playerOne.setDisable(true);
                                playerTwo.setDisable(true);

                                playerOneLabel.setText("");
                                playerTwoLabel.setText("");

                                start.setDisable(false);

                            }else{
                                voltTurn = false;
                                kanekiTurn = true;
                                playerOne.setDisable(true);
                                playerTwo.setDisable(false);
                                playerOneLabel.setText("");
                                playerTwoLabel.setText("Your Turn Kaneki !");
                            }

                        }

                    }

                }
            });

            playerTwo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    if(gameStart){
                        if(kanekiTurn){
                            int diceVal = dice.getRolledVal();
                            diceLabel.setText("The value is : "+diceVal);
                            kaneki.movePlayer(diceVal);
                            if(kaneki.isWinner()){

                                diceLabel.setText("The Winner is : "+kaneki.getName());

                                playerOne.setDisable(true);
                                playerTwo.setDisable(true);

                                playerOneLabel.setText("");
                                playerTwoLabel.setText("");

                                start.setDisable(false);
                            }else{
                                kanekiTurn = false;
                                voltTurn = true;
                                playerTwo.setDisable(true);
                                playerOne.setDisable(false);
                                playerTwoLabel.setText("");
                                playerOneLabel.setText("Your Turn Volt !");
                            }

                        }

                    }

                }
            });









        root.getChildren().addAll(board,playerOne,playerTwo,start,
                playerOneLabel,playerTwoLabel,diceLabel,volt.getCoin(),kaneki.getCoin()
        );





        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}