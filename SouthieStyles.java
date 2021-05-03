/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package southiestyles;
import java.util.*;
import java.io.*;
/**
 *
 * @author levin.o646
 */
public class SouthieStyles {

    /**
     * @param args the command line arguments
     */
    // Using the main function to create a file in "input.txt" to execute the phrases
    public static void main(String[] args) throws FileNotFoundException {
        readingFile("input.txt", "output.txt");
        //input is used for the beginning of the phrases with questionares.
        //output is displayed for the entire Jaws Script of the story using file commands.
    }
    
    public static void readingFile(String location, String destination)
        throws FileNotFoundException {
        
        // sf will be used to define source file
        // df will be used to define destination file
        // While we also use pw for print writer, we would also use destination file.
        // Not only we would also use Scanning file, we would use it for source file.
        File sf = new File(location);
        File df = new File(destination);
        PrintWriter pw = new PrintWriter(df);
        Scanner sc = new Scanner(sf);
        //We will be using Delimiter to define the pattern of the scanner.
        sc.useDelimiter(" ");
        while(sc.hasNext()) {
            String word = sc.next();
            
            // While the string has no new lines, the line separator would concatenate newline string
            // If word contains the get property of line separator, then use
            // string split, print writer print and print line for convertion of southie
            if(word.contains(System.getProperty("line.separator"))) {
                // String split method defines separates or splits a string into
                // substrings depending on the delimit or regular expression.
                String[] split = word.split(System.getProperty("line.separator"));
                pw.println(convertToSouthie(split[0]));
                pw.print(convertToSouthie(split[1]) + " ");
            } else { 
                // Otherwise, just print from the print writer the word of the
                // Jaws Script phrases instead of the splits.
                pw.print(convertToSouthie(word) + " ");
            }
        }
        // close shuts the print writer stream and lets the resurces that was
        // used in the stream go.
        pw.close();
    }
    
    public static String convertToSouthie(String word) {
        StringBuilder sb = new StringBuilder(word);
        // String builder is used to make the strings in words combined to that
        // the statements of the Jaws Script would be displayed
        if(word.length() > 1 && word.endsWith("a")) {
            sb.insert(word.length(), "r");
        } else if(word.contains("very")) {
            sb.replace(sb.indexOf("very"), sb.indexOf("very") + 4, "wick");
            sb.insert(sb.indexOf("wick") + 4, "ed");
        } else {
            for(int i = 0; i < word.length() - 1; i++) {
                // If the char at words of i(integer) would become either any
                // letter of the vowels or r if integer adds 1, then there is 2
                // if-statements that could be in use.
                if((word.charAt(i) == 'a' || word.charAt(i) == 'e' ||
                    word.charAt(i) == 'i' || word.charAt(i) == 'o' ||
                        word.charAt(i) == 'u') && word.charAt(i + 1) == 'r') {
                    
                    // If integer takes away 1 however, then it becomes greater than or equal to 0
                    // as the substring of both integers adding and taking away 1
                    //ignores any double e cases or char at integers of i.
                    if(i - 1 >= 0) {
                        if(i - 1 >= 0 && (word.substring(i - 1, i + 1).equalsIgnoreCase("ee") ||
                            word.charAt(i) == 'i')) {
                            
                            // StringBuilder sets the char at integer adding 1
                            // for y and adding 2 for ah
                            sb.setCharAt(i + 1, 'y');
                            sb.insert(i + 2, "ah");
                        } 
                        // Otherwise if it takes back 1 that becomes more or equal to 0
                        // and the word substring of integer both adds and subtracts 1
                        // that ignores the case for double o, then string builder sets
                        // char at integer adding 1 for w and 2 for ah
                    } else if(i - 1 >= 0 && (word.substring(i - 1, i + 1).equalsIgnoreCase("oo"))) {
                        sb.setCharAt(i + 1, 'w');
                        sb.insert(i + 2, "ah");
                        //Otherwise, integer adding 1 becomes h.
                    } else {
                        sb.setCharAt(i + 1, 'h');
                    }
                }
            }
        } // Call function of string builder.
        return sb.toString();
    }
}
