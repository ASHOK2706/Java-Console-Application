import java.util.Random;
import java.util.Scanner;

class TicTacToeBoard 
{
    static char[][] board;
    public TicTacToeBoard()
    {
        board=new char[3][3];
        initializeBoard();
        displayBoard();
    }
    public void initializeBoard() 
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }
    public void displayBoard()
    {
        System.out.println("      0    1    2  ");
        System.out.println();
        System.out.println("    -------------");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(i+"   ");
            System.out.print("| ");

            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.print("\n    -------------");
            System.out.println();
        }
    }
    public static void placeMark(int row,int col, char mark)
    {
        if(0<=row && row<3 && 0<=col && col<3)
        {
            board[row][col]=mark;
        }
        else {
            System.out.println("Invalid Input ");
        }
    }
    public boolean WinCheck()
    {
        for(int i=0;i<3;i++)
        {
            if((board[0][i]!=' ') && (board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
            {
                return true;
            }
            else if((board[i][0]!=' ') &&(board[i][0]==board[i][1]) && (board[i][1]==board[i][2]))
            {
                return true;
            }
            else if( (board[0][0]!=' ' && ((board[0][0]==board[1][1]) && (board[1][1]==board[2][2]))) || (board[0][2]!=' ' && ((board[0][2]==board[1][1]) && (board[1][1]==board[2][0]))) )
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkDraw()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                    return false;
            }
        }
        return true;
    }
}
abstract class Player
{
    String name;
    char mark;
    abstract void makeMove();
    public boolean isValidMove(int row,int col)
    {
        if(0<=row && row<3 && 0<=col && col<3)
        {
            if(TicTacToeBoard.board[row][col]==' ')
            {
                return true;
            }
        }
        return false;
    }

}
class HumanPlayer extends Player 
{

    public HumanPlayer(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    public void makeMove()
    {
        Scanner in=new Scanner(System.in);
        int row,col;
        do{
        System.out.println("Enter the Roe and Column :");
        row=in.nextInt();
        col=in.nextInt();
        }while(!isValidMove(row, col));
        TicTacToeBoard.placeMark(row, col, mark);
    }
    
}
class AIPlayer extends Player
{
    public AIPlayer(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    public void makeMove()
    {
        int row,col;
        do{
            Random rand=new Random();
            row=rand.nextInt(3);
            col=rand.nextInt(3);
        }while(!isValidMove(row, col));
        TicTacToeBoard.placeMark(row, col, mark);
    }
   
}
public class TicTacToeGame
{
    public static void Playing(Player player1,Player player2)
    {
        TicTacToeBoard board=new TicTacToeBoard();
        Player current_Player;
        current_Player=player1;
        while(true)
        {
            System.out.println(current_Player.name +" turn ");
            current_Player.makeMove();
            board.displayBoard();
            if(board.WinCheck())
            {
                System.out.println(current_Player.name + " has won the Game");
                break;
            }
            else if(board.checkDraw())
            {
                System.out.println("Game is Draw");
                break;
            }
            else{
                if(current_Player==player1)
                {
                    current_Player=player2;
                }
                else
                {
                    current_Player=player1;
                }
            }
        }

    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);

            HumanPlayer player1=new HumanPlayer("Player 1",'X');
            HumanPlayer player2=new HumanPlayer("Player 2", 'O');
            AIPlayer Computer=new AIPlayer("Computer", 'O');
            System.out.println("###    Tic Tac Toe    ###");
            System.out.println("\n1. Tow Player Game "+
                               "\n2. Play with Computer"+
                               "\n3. Exit");
            System.out.println();
            System.out.print("Enter your Choice : ");
            int choice = in.nextInt();
            System.out.println();
            switch(choice)
            {
                case 1:
                    Playing(player1, player2);
                    break;
                case 2:
                    Playing(player1, Computer);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid Option");
                    break;
            }


        
    }
}