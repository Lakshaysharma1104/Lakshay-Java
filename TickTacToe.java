package Games;

import java.util.Scanner;

public class TickTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
         char player ='X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("player "+player + " enter :");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                //place the element if the move is valid
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("player "+player + "has won");
                }else{
                    //if player is x then switch to O
                    if(player == 'X'){
                        player ='O';
                    }else{
                        player = 'X';
                    }
                }

            }else{
                System.out.println("Invalid move , try again");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        //check for row
        for (int row = 0; row < board.length; row++) {
            if(board[row][0]== player && board[row][1]== player && board[row][2]== player){
                return true;
            }
        }
        //check for col
        for (int col = 0; col < board.length; col++) {
            if(board[0][col]== player && board[1][col]== player && board[2][col]== player){
                return true;
            }
        }
        //for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }if(board[2][0] == player && board[1][1] == player && board[0][2] == player ){
            return true;
        }
      return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" | "+board[row][col]);
            }
                System.out.println();
        }
    }
}
