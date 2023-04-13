package com.example.snake_ladders;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {

    public ArrayList<Pair<Integer,Integer>> posCord ;

    public ArrayList<Integer> map;

    public Board(){
        posCord = new ArrayList<>();
        populateBoard();
        map = new ArrayList<>();
        populateMap();

    }



    public void populateBoard(){
        posCord.add(new Pair<>(0,0));

        for (int i = 0; i < SnakeLadder.height ; i++) {
            for (int j = 0; j < SnakeLadder.width ; j++) {
//              xcord
                int xCord = 0;
                if( i % 2 == 0){
                    xCord = j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }else{
                    xCord = SnakeLadder.height*SnakeLadder.tileSize - j*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                }
//              ycord
                int yCord = SnakeLadder.height*SnakeLadder.tileSize - i*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                posCord.add(new Pair<>(xCord,yCord));
            }

        }
    }

    int getXcord(int pos){
        if(pos >=1 && pos <=100){
            return posCord.get(pos).getKey();
        }
        return  -1;
    }
    int getYcord(int pos){
        if(pos >=1 && pos <=100){
            return posCord.get(pos).getValue();
        }
        return  -1;
    }

    private void populateMap(){

        for (int i = 0; i < 101; i++) {
            map.add(i);
        }

        map.set(8,26);
        map.set(40,82);
        map.set(50,91);
        map.set(48,9);
        map.set(46,5);
        map.set(44,22);
        map.set(52,11);
        map.set(55,7);
        map.set(43,77);
        map.set(59,17);
        map.set(62,96);
        map.set(64,36);
        map.set(66,87);
        map.set(69,51);
        map.set(73,1);
        map.set(80,100);
        map.set(83,19);
        map.set(92,51);
        map.set(95,24);
        map.set(98,28);

    }

    public int getnewPosition(int pos){
        if(pos >= 0 && pos<=100){
            return map.get(pos);
        }
        return -1;
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//
//
//        for(int i = 0 ; i < board.posCord.size();i++){
//            System.out.println(i+" $ "+" x : "+board.posCord.get(i).getKey()+" "
//                    +" y : "+board.posCord.get(i).getValue()+" ");
//        }
//
//    }


}
