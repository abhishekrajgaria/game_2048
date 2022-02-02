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
        this.board[cell.getX()][cell.getY()] = number;
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

    public void transpose(){
        int[][] temp = new int[getSize()][];
        for(int i=0;i<getSize();i++){
            temp[i] = new int[getSize()];
            for(int j=0;j<getSize();j++){
                temp[i][j] = this.board[i][j];
            }
        }
        for(int i=0;i<getSize();i++){
            for(int j=0;j<getSize();j++){
                this.board[i][j] = temp[j][i];
            }
        }
    }

    public void reverse(){
        for(int x=0;x<=((getSize()/2)-1);x++){
            for(int y=0;y<getSize();y++){
                this.board[x][y] += this.board[getSize()-x-1][y];
                this.board[getSize()-x-1][y] = this.board[x][y] - this.board[getSize()-x-1][y];
                this.board[x][y] = this.board[x][y] - this.board[getSize()-x-1][y];
            }
        }
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
                    System.out.print(getCell(cell)+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Score: " + this.score);
        System.out.println("******************************");
    }
}