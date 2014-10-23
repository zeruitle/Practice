import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList<Integer>();
        int change = 0;
        while(scan.hasNext()){
            String tmp[] = scan.next().split(",");
            if(scan.hasNext()){
                coins.add(Integer.parseInt(tmp[0]));
            } else {
                change = Integer.parseInt(tmp[0]);
            }
        }
        System.out.println(coinchange(quickSort(coins,0,coins.size()-1),change));
    }
    
    public static ArrayList<Integer> quickSort(ArrayList<Integer> coins, int low, int high) {
        int i = low, j = high;
        int pivot = coins.get(low+(high-low)/2);
        while (i <= j){
            while(coins.get(i) < pivot){
                i++;
            }
            while(coins.get(j) > pivot) {
                j--;
            }
            if(i <= j){
                int swap = coins.get(i);
                coins.set(i,coins.get(j));
                coins.set(j,swap);
                i++;
                j--;
            }
        }
        if(low < j)
            quickSort(coins,low,j);
        if(i < high)
            quickSort(coins,i, high);
        return coins;
    }
    
    public static int coinchange(ArrayList<Integer> coins, int change) {
        if(change - coins.get(0) != 0){
            return 1+coinchange(coins,change-coins.get(0));
        } else {
            return 1;
        }
    }
}