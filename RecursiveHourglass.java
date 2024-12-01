///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment4
// Files:              Assignment4 starter code: RecursiveHourglass.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class includes a method that prints an hour glass using recusion and a 
 * helper class called getline
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class RecursiveHourglass {

    public static int recursionCallCount = 0; // WARNING: DO NOT MODIFY THIS
    // LINE FOR STAFF TO TEST RECURSIVE CALLS

    // Feel free to add more constants

    /**
     * returns a String of n characters (c) with numSpaces spaces in the front
     * and back of the line, along with a newline character at the end.
     *
     * @param (char c) (the character to be printed)
     * @param (int n) (the number of time to print the character)
     * @param (int numSpaces) (the number of spaces to print before and after)
     * @return (a string of n characters and numSpace spaces and start a new line)
     */
    private static String getline(char c, int n, int numSpaces) {
        String line = ""; 
        for (int i = 0; i < numSpaces; i++) {
            line += ' '; 
        }
        for (int i = 0; i < n; i++) {
            line += c; 
        }
        for (int i = 0; i < numSpaces; i++) {
            line += ' '; 
        }
        line += '\n'; 
        return line; 
    }

    /**
     * use recursion to print an hour glass
     *
     * @param (char c) (the character to print the hourglass)
     * @param (int height) (the height of the hourglass)
     * @param (int numSpaces) (the number of spaces to print before 
     *                          and after the first and last line)
     * @return (a string in the shape of an hourglass)
     */
    public static String recursiveHourglass (char c, int height, 
                                             int numSpaces) 
    {
        recursionCallCount++; // WARNING: DO NOT MODIFY THIS LINE, FOR STAFF
        // TO TEST RECURSIVE CALLS

        if(height<0)
        {
            return("Invalid height");
        }
        if(height==0)
        {
            return(getline(c, height, numSpaces));
        }
        else if(height==1)
        {
            return(getline(c, height, numSpaces));
        }
        else if(height==2)
        {
            return(getline(c, height, numSpaces) 
                    + getline(c, height, numSpaces));
        }
        else
        {
            return(getline(c, height, numSpaces) 
                    + recursiveHourglass(c, height-2, numSpaces+1)
                    + getline(c, height, numSpaces));
        }
    }

    /**
     * Tests for all methods above
     *
     * 
     * @return (whether the methods above pass all the tests or not)
     */
    public static boolean unitTests() {
        // Test Case 1: 
        String heightThreeHourglass = "***\n * \n***\n"; 
        if (!recursiveHourglass('*', 3, 0).equals(heightThreeHourglass)) {
            return false; 
        }

        // Test Case 2: 
        String heightThreeHourglass2 = " ***** \n  ***  \n   *   \n  ***  \n ***** \n"; 
        if (!recursiveHourglass('*', 5, 1).equals(heightThreeHourglass2)) {
            return false; 
        }

        // Test Case 3: 
        String heightThreeHourglass3 = "******\n **** \n  **  \n  **  \n **** \n******\n"; 
        if (!recursiveHourglass('*', 6, 0).equals(heightThreeHourglass3)) {
            return false; 
        }

        return true; 
    }

    /**
     * The main method
     *
     * 
     * @return (void)
     */
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}

