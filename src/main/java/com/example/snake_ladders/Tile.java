package com.example.snake_ladders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    Tile(int size){
        setWidth(size);
        setHeight(size);
        setStroke(Color.BLACK);
        setFill(Color.AZURE);
    }
}
