package driver;

import java.util.Scanner;

import models.Board;
import service.GameService;

public class Game {
    
    

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the size of board: ");
        int size = sc.nextInt();
        play(size);
        sc.close();
    }

    public static void play(int size) {
        GameService service = new GameService();
        Board board = service.initializeBoard(size);
        board.printBoard();
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        String curInput = "";
        while(flag==1 && curInput!="e"){
            System.out.println("Enter the Move: ");
            curInput =  sc.nextLine();
            flag = service.move(board, curInput);
        }
        sc.close();

    }
}
