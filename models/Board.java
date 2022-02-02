package models;

import java.util.ArrayList;
import java.util.List;

public class Board{
    private int[][] board;
    private int score;

    public Board(int size){
        this.board = new int[size][];
        this.score = 0;

        for(int i=0;i<size;i++){
            this.board[i] = new int[size];
            for(int j=0;j<size;j++){
                board[i][j] = 0;
            }
        }
    }

    public int getSize(){
        return board.length;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getCell(Cell cell){
        return board[cell.getX()][cell.getY()];
    }

    public void setCell(Cell cell, int number){
        board[cell.getX()][cell.getY()] = number;
    }

    public boolean isEmpty(Cell cell){
        return getCell(cell)==0;
    }

    public List<Cell> emptyCells(){
        List<Cell> result = new ArrayList<>();
        for(int i=0;i<getSize();i++){
            for(int j=0;j<getSize();j++){
                Cell cell = new Cell(i,j);
                if(isEmpty(cell)){
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void printBoard(){
        System.out.println("******************************");
        for(int i=0;i<getSize();i++){
            for(int j=0;j<getSize();j++){
                Cell cell = new Cell(i,j);
                if(isEmpty(cell)){
                    System.out.print("_ ");
                }
                else{
                    System.out.print(getCell(cell));
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Score: " + this.score);
        System.out.println("******************************");
    }
}