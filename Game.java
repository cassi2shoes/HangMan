import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
//FIX THE GUESSING try the method again. DONT FORGET TO MAKE "scanner.nextLine()" LOWERCASE

public class Game{
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);    
        String answer = wordPick();
        System.out.println("Welcome to Halloween Themed Hangman!");
        System.out.println(ascii(0));
        System.out.println("");
        System.out.println(spellOut(answer));
        char[] key = toCheck(answer);
        char[] play = buildWord(answer);
        int points = 0;
        int lose = 6;
        String incorrectGuesses ="These are the letters you have guessed incorrectly: ";
        while (points < lose)
        {
            System.out.println("Please enter a guess!");
            String user = scanner.nextLine();
            String lowerUser = user.toLowerCase();
            String compariasonString = String.valueOf(play);
            int trueOrFalse = answer.indexOf(lowerUser);
            boolean a = trueOrFalse == -1;
            if (user.length() > 1)
            {
                System.out.println("please make your guess one(1) character long.");
            }
            else if (a == true)
            {
                System.out.println("that guess is incorrect");
                points++;
                incorrectGuesses+=" " + lowerUser;
                System.out.println("you have " + (lose-points) + " incorrect guesses left before you lose");
                System.out.println(incorrectGuesses);
                System.out.println(ascii(points));
                System.out.println(play);
            }
            else if (location(compariasonString,lowerUser) != -1)
            {
                System.out.println("You've already guessed this letter correctly");
            }
            else
            {
                char realGuess = lowerUser.charAt(0);
                int place = location(answer,lowerUser);
                play[place] = realGuess;
                System.out.println(incorrectGuesses);
                System.out.println(ascii(points));
                System.out.println(play);
                if(Arrays.equals(play,key))
                {
                    points+=50;
                }
            }
        }
        if(points>49)
        {
            System.out.println("You Win!");
        }
        else
        {
            System.out.println("you lost :(");
            System.out.println("--|");
            System.out.println("| o");
            System.out.println("|/|\\");
            System.out.println("|/ \\");
            System.out.println("____");
        }
    
    }
    public static String wordPick()
    {
        int x = (int) (Math.random()*(5-1+1)) +1;
        if (x == 1)
        {
            return "scary";
        }
        else if (x==2)
        {
            return"costume";
        }
        else if (x==3)
        {
            return "ghost";
        }
        else if (x==4)
        {
            return "candy";
        }
        else
        {
            return "monster";
        }
    }
    public static char[] toCheck(String a)
    {
        char[] b = a.toCharArray();
        return b;
    }
    public static char[] buildWord(String a)
    {
        int x = a.length();
        char[] b = new char[x];
        for (int i = 0; i<a.length(); i++)
        {
            b[i]='-';
        }
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
    public static int location(String a , String letter)
    {
        return a.indexOf(letter);
    }
    public static String ascii(int point)
    {
        String[] asciiStorage = {"--|\n|  \n|   \n|   \n____","--|\n| o \n|   \n|   \n____","--|\n| o\n| | \n|  \n___","--|\n| o\n|/| \n|  \n___","--|\n| o\n|/|\\ \n|  \n___","--|\n| o\n|/|\\ \n|/ \n___","--|\n| o\n|/|\\ \n|/ \\ \n___"};
        return asciiStorage[point];
    }
}