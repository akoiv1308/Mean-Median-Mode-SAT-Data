import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{

    Scanner scanner = new Scanner(new File("satData.txt"));

    int [] SAT = new int [71];
    int i = 0;

    while(scanner.hasNextInt()){
      SAT[i++] = scanner.nextInt();
    }
    // Output of the program //
    System.out.println("Average: " + getAverage(SAT));
    System.out.println("Mode: " + getMode(SAT));
    System.out.println("Median: " + getMedian(SAT));
  }
  
  /**
   * this method will determine the mean (average) of the data set.
   * @param scores for the SAT exam
   * @return the average score from the array
   */

   // Average is the sum of all values divided by the length of the array //
   static int getAverage(int[] scores){
     int sum = 0;
     // adding every value to the variable sum
     for(int i = 0; i<=scores.length-1; i++) {
       sum+=scores[i];
     }
     // returning the average //
     return sum/scores.length;
   }

   /**
   * this method will determine the mode (most frequent value) of the data set.
   * @param scores for the SAT exam
   * @return the mode score from the array
   */

   static int getMode(int[] scores){
     int max = 0;
     int maxValue = 0;
     int count = 0;
     for(int i = 0; i<scores.length-1; i++) {
       count = 0;
       for(int j = 0; j<scores.length-1; j++) {
         // if the same, increase count variable by one //
         if(scores[j] == scores[i]) {
           count++;
         }
       }
       // if the number occurred more than the current "max" number, then make max that number //
       if(count>max) {
         max = count;
         maxValue = scores[i];
       }
     }
     return maxValue;
   }
   // I made some research and found out that bubble sort can be used to find the median in the array. This sorting method goes through each value and compares adjacent values and swaps them if they are in the wrong order. //
   
  /* https://en.wikipedia.org/wiki/Bubble_sort */ 

   static int getMedian(int[] scores) {
     for (int i = 0; i<scores.length; i++) {
      for (int j = i + 1; j<scores.length; j++) {
        int switchNum = 0;
        // switching numbers //
        if (scores[i] > scores[j]) {
          switchNum = scores[i];
          scores[i] = scores[j];
          scores[j] = switchNum;
        }
      }
     }
     // if the array length if even, then return the result of dividing the length by 2 //
    if (scores.length % 2 != 0) {
      return scores[scores.length / 2]; 
    }
    // otherwise, the array length is odd //
   return (scores[scores.length - 1 / 2] + scores[scores.length / 2]) / 2; 
  }
}