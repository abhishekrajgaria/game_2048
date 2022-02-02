package service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import models.Board;
import models.Cell;

public class GameService {

    public void addTile(Board board) {
        Random rnd = new Random();
        List<Cell> emptyCells = board.emptyCells();
        Cell cell = emptyCells.get(rnd.nextInt(emptyCells.size()));
        board.setCell(cell, 2);
    }

    public Board initializeBoard(int size) {
        Board board = new Board(size);
        addTile(board);
        addTile(board);
        return board;
    }

    public Board resetBoard(Board board) {
        int size = board.getSize();
        return new Board(size);
    }

    public void moveUp(Board board) {
        int newScore = 0;
        for(int y=0;y<board.getSize();y++){
            LinkedList<Integer> curCol = new LinkedList<>();
            for(int x=0;x<board.getSize();x++){
                Cell cell = new Cell(x,y);
                if(!board.isEmpty(cell)){
                    curCol.add(board.getCell(cell));
                }
            }
            LinkedList<Integer> newCol = new LinkedList<>();
            while(curCol.size()>=2){
                int first = curCol.pop();
                int second = curCol.peek();
                if(second==first){
                    newCol.add(first*2);
                    newScore+=first*2;
                    curCol.pop();
                }
                else{
                    newCol.add(first);
                }
            }
            newCol.addAll(curCol);
            for(int x=0;x<board.getSize();x++){
                Cell cell = new Cell(x,y);
                if(newCol.isEmpty()){
                    board.setCell(cell,0);
                }
                else{
                    board.setCell(cell, newCol.pop());
                }
            }
        }
        board.setScore(board.getScore()+newScore);
    }

    public void move(Board board, char dir) {
        if (dir == 'L' || dir == 'R') {
            board.transpose();
        }
        if (dir == 'D' || dir == 'R') {
            board.reverse();
        }
        moveUp(board);
        if (dir == 'D' || dir == 'R') {
            board.reverse();
        }
        if (dir == 'L' || dir == 'R') {
            board.transpose();
        }
        board.printBoard();
    }

}