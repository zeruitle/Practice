import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GemStone {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = 0, count = 0;
        if(scan.hasNext())
            testcase = scan.nextInt();
        String[] rocks = new String[testcase];
        while(scan.hasNext()) {
            rocks[count] = removeDuplicateChar(scan.next());
            count++;
        }
        quickSort(rocks,0,rocks.length-1);
        String shortest = rocks[0];
        checkloop:
        for(int i = 1; i < testcase; i++ ){
            for(int j = 0; j < shortest.length(); j++){
                CharSequence cs = shortest.charAt(j)+"";
                if(!rocks[i].contains(cs)){
                    StringBuilder sb = new StringBuilder(shortest);
                    sb.deleteCharAt(j);
                    shortest = sb.toString();
                }
                if(shortest.length() == 0) {
                    break checkloop;
                }     
            }
        }
        System.out.println(shortest.length());
    }
    
    private static void quickSort(String[] rocks, int low, int high){
        int i = low, j = high;
        int pivot = rocks[low+(high-low)/2].length();
        while (i <= j){
            while (rocks[i].length() < pivot) {
                i++;
            }
            while (rocks[j].length() > pivot) {
                j--;
            }
            if (i <= j) {
                String tmp = rocks[i];
                rocks[i] = rocks[j];
                rocks[j] = tmp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(rocks,low,j);
        if (i < high)
            quickSort(rocks,i,high);
    }
    
    private static String removeDuplicateChar(String input) {
        String result = "";
        char[] tmp = input.toCharArray();
        int i = 0;
        while(i < tmp.length){
            boolean repeat = false;
            for(int j = 0; j < i; j++){
                if(tmp[i] == tmp[j])
                    repeat = true;
            }
            if(repeat == false)
                result = result + tmp[i];
            i++;
        }
        return result;
    }
}