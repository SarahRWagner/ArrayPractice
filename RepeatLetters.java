//checks to see if a string is made of all unique letters
import java.util.Arrays;
public class RepeatLetters
{
    public static void main(String[] args)
    {



        String sampleF = "badfac"; // has char that repeats
        String sampleT = "qercta"; // has all unique chars

        uniqueLetter(sampleT); // runs sample string through method, this will be true.
        uniqueLetter(sampleF); // runs sample string through method, this will be false.

        uniqueLetter((sortString(sampleF)));
        uniqueLetter((sortString(sampleT)));



    } // end of main method

    public static boolean uniqueLetter(String string)
    {
        for(int index = 0; index < string.length(); index++) // keeps track of the letters you're going through
        {
            for(int i = 1 + index; i < string.length(); i++) // checks the first letter to the next letter
            {
                if(string.charAt(index) == string.charAt(i)) // if the first letter matches the second letter
                {
                    return false; //this is false if the letters are equal
                }
            }
        }
        return true; // all characters are unique
    } // end of uniqueLetter method

    public static String sortString(String string) // I wanted to use the Array.sorts, and found this method on GeeksforGeeks.
    // It sorts the String into it's chars and then the chars into alphabetically order
    // Makes the method above go quicker because it will find the same chars quicker.
    {
        // convert input string to char array
        char[] tempArray = string.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    } // end of sortString method

} // end of program