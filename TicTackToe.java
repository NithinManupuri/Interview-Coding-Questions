package Ibm;

import java.util.Scanner;

public class TicTackToe {
    public static void main(String[] args){
            char[][] board=new char[3][3];
        for(int r=0;r< board.length;r++) {
            for (int col = 0; col < board.length; col++) {
                board[r][col] = ' ';
            }
        }
        ticTacToe(board);
    }
    public static void ticTacToe(char[][] board){
        Scanner sc=new Scanner(System.in);
        char player='X';
         boolean gameOver=false;
        while(!gameOver){
            printBoard(board);
            System.out.println("player "+player+" enter:");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if(gameOver){
                    System.out.print("player "+player+" has won the game!");
                }else{
                    player=(player=='X')?'O':'X';
                }
            }else{
                System.out.print("Invalid insert");
            }
        }
    }
    public static boolean haveWon(char[][] board,char player){
        for(int r=0;r<board.length;r++){
            if(board[r][0]==player && board[r][1]==player && board[r][2] == player){
                 return true;
            }
        }
        for(int c=0;c<board.length;c++){
            if(board[0][c]==player && board[1][c]==player && board[2][c] == player){
                return true;
            }
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2] == player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0] == player){
            return true;
        }

      return false;
    }
    public static void printBoard(char[][] board){
        for(int r=0;r< board.length;r++){
            for(int col=0;col<board.length;col++){

                System.out.print(board[r][col]+" |");
            }
            System.out.println();
        }

    }

}
