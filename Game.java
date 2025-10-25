import java.util.Scanner;
import java.lang.Math;
//FIX THE GUESSING try the method again. DONT FORGET TO MAKE "scanner.nextLine()" LOWERCASE

public class Game{
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);    
        String answer = wordPick();
        System.out.println("Welcome to Halloween Themed Hangman!");
        System.out.println("--|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("___");
        System.out.println("");
        System.out.println(spellOut(answer));
        char[] key = toCheck(answer);
        int points = 0;
        int lose = 6;
        String results = "";
        while (points < lose)
        {
            System.out.println("Please type your guess!");
            String newGuess = scanner.nextLine();
            boolean replace = guess(answer, newGuess);
            if(replace = true)
            {
                char[] set = new char [answer.length()-1];
                for(int i = 0; i<answer.length();i++)
                {
                    if(newGuess.equals(answer.substring(i,i+1)))
                    {
                        current+=newGuess;
                        
                    }
                    else
                    {
                        current+= "- ";

                    }
                }
                System.out.println(current);
            }
            if (results.equals(answer))
            {
                System.out.println("You found the word!");
                System.out.println(results);
                break;
            }
        }
    
    }
    public static String wordPick()
    {
        int x = (int) (Math.random()*(5-1+1)) +1;
        if (x == 1)
        {
            return "Halloween";
        }
        else if (x==2)
        {
            return"Skeleton";
        }
        else if (x==3)
        {
            return "Pumpkin";
        }
        else if (x==4)
        {
            return "Candy";
        }
        else
        {
            return "Spooky";
        }
    }
    public static char[] toCheck(String a)
    {
        char[] b = a.toCharArray();
        return b;
    }
    public static String spellOut(String word)
    {
        String x = "";
        for (int i = 0; i <= word.length()-1; i++)
        {
            x += "- ";
        }
        return x;
    }
    public static boolean guess(String check, String g)
    {
        boolean correct = false;
            if (g.length()>1)
            {
                System.out.println("please enter a guess that is 1 letter");
            }
            else if (check.indexOf(g)== -1)
            {
                System.out.println("That's incorrect!");
            }
            else
            {
                for(int i = 0; i<check.length();i++)
                {
                    if(g.equals(check.substring(i,i+1)))
                    {
                        correct = true;
                    }
                }

            }
            return correct;
        }   
}