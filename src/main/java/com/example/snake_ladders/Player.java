package com.example.snake_ladders;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Player {

    private static Board gameBoard = new Board();
    private Circle coin;

    private String Name;

    private int currPos;

    public Player(int tileSize, String name, Color color){
        coin = new Circle(tileSize/2.5);
        currPos = 0;
        Name = name;
        coin.setFill(color);
        movePlayer(1);

    }


    public Circle getCoin() {
        return coin;
    }

    public String getName() {
        return Name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public boolean isWinner(){
        if(currPos == 100){
            return true;
        }else{
            return false;
        }
    }

    public  void  movePlayer(int pos){
        if(pos+currPos <=100){
            currPos +=pos;
            TranslateTransition firstMove = animateTranslate(pos),secondMove = null;

            int newPos = gameBoard.getnewPosition(currPos);
            if(newPos != currPos && newPos != -1){
                currPos = newPos;
               secondMove = animateTranslate(6);
            }

            if(secondMove ==null){
                firstMove.play();
            }else{
                SequentialTransition seq = new SequentialTransition(firstMove,new PauseTransition(Duration.millis(500)),
                        secondMove);
                seq.play();
            }
        }
    }

    public void restart(){
        currPos = 1;
        movePlayer(0);
    }

    private TranslateTransition animateTranslate(int pos){
        TranslateTransition animate = new TranslateTransition(Duration.millis(4*200),coin);
        animate.setToX(gameBoard.getXcord(currPos));
        animate.setToY(gameBoard.getYcord(currPos));
        animate.setAutoReverse(false);
        return  animate;
    }


}
