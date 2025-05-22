import java.util.*;

public class tictactoe 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String playagain;

        do 
        {
            char[][] board = 
            {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
            };

            char currentplayer = 'x';
            boolean gameended = false;

            while (!gameended) 
            {
                printBoard(board);
                System.out.println("player " + currentplayer + ", enter your move (row and column: 1 1 for top left): ");
                int row = sc.nextInt() - 1;
                int col = sc.nextInt() - 1;

                if (row < 0 || row > 2 || col < 0 || col > 2) 
                {
                    System.out.println("this position is out of bounds. try again.");
                } 
                
                else if (board[row][col] != ' ') 
                {
                    System.out.println("this position is already taken. try again.");
                } 
                
                else 
                {
                    board[row][col] = currentplayer;

                    if (checkWin(board, currentplayer)) 
                    {
                        printBoard(board);
                        System.out.println("player " + currentplayer + " wins!");
                        gameended = true;
                    } 
                    
                    else if (isBoardFull(board)) 
                    {
                        printBoard(board);
                        System.out.println("it's a tie!");
                        gameended = true;
                    } 
                    
                    else 
                    {
                        currentplayer = (currentplayer == 'x') ? 'o' : 'x';
                    }
                }
            }

            System.out.print("Do you want to play again? (yes or no): ");
            sc.nextLine();                                               // consume leftover newline
            playagain = sc.nextLine().toLowerCase();

        } while (playagain.equals("yes"));

        System.out.println("Thank you for playing.");
    }

    public static void printBoard(char[][] board) 
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean checkWin(char[][] board, char player) 
    {
                                                               // check rows
        for (int i = 0; i < 3; i++) 
        {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) 
            {
                return true;
            }
        }

                                                                 // check columns
        for (int j = 0; j < 3; j++) 
        {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) 
            {
                return true;
            }
        }

                                                                  // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) 
        {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) 
        {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[i][j] == ' ') 
                {
                    return false;
                }
            }
        }
        return true;
    }
}

