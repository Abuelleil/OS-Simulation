package com.company;


public class Board {
    Cell[][] board;


    public Board()

    {
        board=new Cell[10][10];
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                board[i][j]=new Cell();
            }
        }

    }
    public Cell getCell(int i ,int j) {
        return board[i][j];
    }


}
