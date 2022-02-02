package service;

import java.util.List;
import java.util.Random;

import models.Board;
import models.Cell;

public class GameService{

    public void addTile(Board board){
        Random rnd = new Random();
        List<Cell> emptyCells = board.emptyCells();
        Cell cell = emptyCells.get(rnd.nextInt(emptyCells.size()));
        board.setCell(cell, 2);
    }

    public Board initializeBoard(int size){
        Board board = new Board(size);
        addTile(board);
        addTile(board);
        return board;
    }

    public Board resetBoard(Board board){
        int size = board.getSize();
        return new Board(size);
    }

    //aim to convert row to col
    public void transpose(Board board){

    }

    //aim to get mirror image of board
    public void reverse(Board board){

    }

    public void moveUp(Board board){

    }

    public void move(Board board, char dir){
        if(dir=='L' || dir=='R'){
            transpose(board);
        }
        if(dir=='D' || dir=='R'){
            reverse(board);
        }
        moveUp(board);
        if(dir=='D' || dir=='R'){
            reverse(board);
        }
        if(dir=='L' || dir=='R'){
            transpose(board);
        }
        board.printBoard();
    }


}