import java.util.Scanner;
import java.io.*;
public class Tester{
    public static void main(String[] args)throws IOException{
        File file = new File("dictionary.txt");
        File fileout = new File("resultsreverse.txt");
        PrintWriter output = new PrintWriter(fileout);
        long preTime;
        long postTime;
        Scanner scnr = new Scanner(file);

        int size = findSize(scnr);
        scnr.close();
        String [] a = new String [size];
        arrayGenerate(a, file);

        String [] b = copy(a);
        String [] c = copy(a);  
        String [] d = copy(a);  
        String [] e = copy(a);  
        String [] f = copy(a);  
        String [] a1 = copy(a);
        String [] b1 = copy(a);
        String [] c1 = copy(a);
        String [] d1 = copy(a);
        String [] e1 = copy(a);
        String [] f1 = copy(a);

        preTime = System.nanoTime();
        Sorting.bubbleSort(a);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "bubble sort");

        preTime = System.nanoTime();
        Sorting.selectionSort(b);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "selection sort");

        preTime = System.nanoTime();
        Sorting.insertionSort(c);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "insertion sort");

        preTime = System.nanoTime();
        Sorting.quickSort(d);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "quick sort");

        preTime = System.nanoTime();
        Sorting.mergeSort(e);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "merge sort");

        preTime = System.nanoTime();
        Sorting.cocktailSort(f);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "cocktail sort");

        preTime = System.nanoTime();
        seqSearch(a, "yellow-earth");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for yellow-earth" );

        preTime = System.nanoTime();
        biSearch(a, "yellow-earth");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for yellow-earth");

        preTime = System.nanoTime();
        seqSearch(a, "AMARyYO");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for AMARyYo" );

        preTime = System.nanoTime();
        biSearch(a, "AMARyYO");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for AMARyYO");

        preTime = System.nanoTime();
        seqSearch(a, "amarillo");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for amarillo" );

        preTime = System.nanoTime();
        biSearch(a, "amarillo");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for amarillo");

        preTime = System.nanoTime();
        seqSearch(a, "yellow");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for yellow" );

        preTime = System.nanoTime();
        biSearch(a, "yellow");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for yellow");

        preTime = System.nanoTime();
        Sorting.bubbleSort(a1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse bubble sort");

        preTime = System.nanoTime();
        Sorting.selectionSort(b1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse selection sort");

        preTime = System.nanoTime();
        Sorting.insertionSort(c1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse insertion sort");

        preTime = System.nanoTime();
        Sorting.quickSort(d1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse quick sort");

        preTime = System.nanoTime();
        Sorting.mergeSort(e1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse merge sort");

        preTime = System.nanoTime();
        Sorting.cocktailSort(f1);
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "reverse cocktail sort");
        
        preTime = System.nanoTime();
        seqSearch(a1, "yellow-earth");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for yellow-earth in a descending order array");

        preTime = System.nanoTime();
        biSearch(a1, "yellow-earth");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for yellow-earth in a descending order array");

        preTime = System.nanoTime();
        seqSearch(a1, "AMARyYO");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for AMARyYo in a descending order array");

        preTime = System.nanoTime();
        biSearch(a1, "AMARyYO");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for AMARyYO in a descending order array");

        preTime = System.nanoTime();
        seqSearch(a1, "amarillo");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for amarillo in a descending order array");

        preTime = System.nanoTime();
        biSearch(a1, "amarillo");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for amarillo in a descending order array");

        preTime = System.nanoTime();
        seqSearch(a1, "yellow");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "sequential search for yellow in a descending order array");

        preTime = System.nanoTime();
        biSearch(a1, "yellow");
        postTime = System.nanoTime();
        addResult(output, preTime, postTime, "binary search for yellow in a descending order array");

        output.close();
    }
    //iterates through the dictionary once to find the amount of elements needed.
    public static int findSize(Scanner scnr){
        int count = 0;
        while(scnr.hasNext()){
            scnr.nextLine();
            count++;
        }
        return count;
    }
    //fills the array with elements from the dictionary.
    public static void arrayGenerate(String [] a, File file)throws IOException{
        Scanner scnr = new Scanner(file);
        for (int i = 0; i < a.length; i++) {
            a[i] = scnr.nextLine();
        }
        scnr.close();
    }
    //prints out an array.
    public static void print(String [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //Used to copy the original array by value.
    public static String [] copy(String [] a){
        String [] b = new String [a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
    public static boolean seqSearch(String [] a, String target){
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(target)){
                return true;
            }
        }
        return false;
    }
    public static boolean biSearch(String [] a, String target){
        return biSearch(a, target, 0, a.length-1);
    }
    private static boolean biSearch(String [] a, String target, int low, int high){
        int midpoint = (low + high) / 2;
        if(low > high){
            return false;
        }
        else if(a[midpoint].equals(target)){
            return true;
        }
        else if(a[midpoint].compareTo(target) < 0){
            return biSearch(a, target, ++midpoint, high);
        }
        else{
            return biSearch(a, target, low, --midpoint);
        }
    }
    public static void addResult(PrintWriter output, long pretime, long posttime, String sortType){
        output.println(sortType + (" took: " + (posttime - pretime) + " nanoseconds to sort/search."));
    }
}