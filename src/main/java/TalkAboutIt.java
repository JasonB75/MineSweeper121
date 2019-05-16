import java.util.Scanner;
public class TalkAboutIt
{
    public static  MineSweeper round;
    public static int counter = 0;
    public static boolean stopGame = false;
    static int row ;
    static int column ;

    public static void main(String[] args)
    {
        //MineSweeper turn = new MineSweeper();
        //System.out.println (turn.gameStart());
        gameStart();
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

        while (!stopGame)
        {
            System.out.println(nextRound(statement));
            statement = in.nextLine();
        }
    }

    public static void  gameStart()
    {
        stopGame = false;
        counter = 0;
        System.out.println( "Howdy Pardner, younna play some vidya gamez? (y/n)");
    }


    public static String nextRound(String statement)
    {
        if (counter == 0)
        {
            if(statement.trim().equals("y") || statement.trim().equals("Y"))
            {
                counter = counter + 1;
                return "Select difficulty (E/M/H)";
            }
            else if (statement.trim().equals("n") || statement.trim().equals("N"))
            {
                return "Then Perish";
            }
        }
        else if (counter == 1)
        {
            if(statement.trim().equals("e") || statement.trim().equals("E"))
            {
                counter = counter + 1;
                 row = 5;
                 column = 5;
                round = new MineSweeper(row, column, 4);
                round.start(row,column);
                round.printBoard();
                //round.printBoard();
                return "Easy mode selected, let the games begin! Enter your next cordinates (Letter, Number)";

            }
            else if(statement.trim().equals("m") || statement.trim().equals("M"))
            {
                counter = counter + 1;
                int row = 10;
                int column = 10;
                round = new MineSweeper(row, column, 8);
                round.start(row,column);
                round.printBoard();
                //round.printBoard();
                return "Medium mode selected, let the games begin! Enter your next cordinates (Letter, Number)";

            }
            else if(statement.trim().equals("h") || statement.trim().equals("H"))
            {
                counter = counter + 1;
                int row = 15;
                int column = 15;
                round = new MineSweeper(row, column, 16);
                round.start(row,column);
                round.printBoard();
                //round.printBoard();
                return "Hard mode selected, let the games begin! Enter your next cordinates (Letter, Number)";
            }
            else
            {
                return "What?";
            }
        }
        else if(counter >= 2)
        {
            if (statement.trim().contains("a")
                    || (statement.trim().contains("b"))
                    || (statement.trim().contains("c"))
                    || (statement.trim().contains("d"))
                    || (statement.trim().contains("e"))
                    || (statement.trim().contains("f"))
                    || (statement.trim().contains("g"))
                    || (statement.trim().contains("h"))
                    || (statement.trim().contains("i"))
                    || (statement.trim().contains("j"))
                    || (statement.trim().contains("k"))
                    || (statement.trim().contains("l"))
                    || (statement.trim().contains("m"))
                    || (statement.trim().contains("n"))
                    || (statement.trim().contains("o")))
            {
                if (statement.trim().contains("1")
                        || (statement.trim().contains("2"))
                        || (statement.trim().contains("3"))
                        || (statement.trim().contains("4"))
                        || (statement.trim().contains("5"))
                        || (statement.trim().contains("6"))
                        || (statement.trim().contains("7"))
                        || (statement.trim().contains("8"))
                        || (statement.trim().contains("9"))
                        || (statement.trim().contains("10"))
                        || (statement.trim().contains("11"))
                        || (statement.trim().contains("l2"))
                        || (statement.trim().contains("13"))
                        || (statement.trim().contains("14"))
                        || (statement.trim().contains("15")))
                {
                    if (statement.trim().contains(","))
                    {
                        String  bois = " abcdefghijklmnop";
                        counter = counter + 1;
                        String[] values = statement.split(",");
                        int result = Integer.parseInt(values[1]);
                        int yeet = bois.indexOf(values[0]);
                        round.enterCord(yeet, result, row, column);
                        //round.printBoard();

                        //round.printGame();
                        return "Round " + (counter - 1) + "! Enter your next cordinates (Letter,Number)";
                    }
                }
                else
                {
                    return "Please enter your cordinates correctly";
                }
            }
        }
        return "Please enter your cordinates correctly";
    }
}