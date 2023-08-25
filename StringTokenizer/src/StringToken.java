/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieup
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringToken{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Step 1: Input String
        String string = InputString("Enter the string: ");
        //Step 2: Count of number of  word
        Map<String, Integer> countWords = countWords(string);
        //Step 3: Display Count of number of word
        Map<Character, Integer> countLetters = countLetters(string);
        //Step 4: Display count of words
        DisplayWordCount(countWords);
        //Step 5: Display the number of letter
        DisplayLetterCount(countLetters);
    }
      private static String InputString(String str){
          Scanner sc = new Scanner(System.in);
          //Loop use to check valid 
          while(true){
              System.out.println(str);
              String string = sc.nextLine();
              if(string.isEmpty()){
                  System.out.print("Plz enter your string!");
                  continue;
              }
         if (!string.matches("^[A-Za-z0-9\\s]+$")) {
            System.out.println("Please enter a string with only letters, numbers, and spaces!");
            continue;
        }
              return string;
          }
      }
      

    private static Map<String, Integer> countWords(String string) {
        Map<String, Integer> countWords = new HashMap<>();
        StringTokenizer token = new StringTokenizer(string);
        //check the string has any more tokens 
        while(token.hasMoreTokens()){
            String words = token.nextToken();
            //check 
            if(!countWords.containsKey(words)){
                countWords.put(words, 1);
            }
            else{
                countWords.put(words,((int)countWords.get(words))+1);
            }
        }
        return countWords;
    }

    private static Map<Character, Integer> countLetters(String string) {
       Map<Character, Integer> countLetters = new HashMap<>();
       //Loop use to access each character in array charater
       for(char ch : string.toCharArray()){
           //Check character is space or not 
           if(Character.isSpaceChar(ch)) continue;
           //Check if 
           if(!countLetters.containsKey(ch)){
               countLetters.put(ch, 1);
           }
           else{
               countLetters.put(ch, ((int) countLetters.get(ch)) + 1);
           }
       }
        return countLetters;
    }

    private static void DisplayWordCount(Map<String, Integer> countWords) {
         System.out.println(countWords);
    }
    private static void DisplayLetterCount(Map<Character, Integer> countLetters) {
        System.out.println(countLetters);
    }

}
