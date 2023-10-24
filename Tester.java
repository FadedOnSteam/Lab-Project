import java.util.Scanner;
import java.io.*;
public class Tester{
    public static void main(String[] args)throws IOException{
        File file = new File("test.txt");
        Scanner scnr = new Scanner(file);

        int size = findSize(scnr);
        scnr.close();
        String [] a = new String [size];
        arrayGenerate(a, file);
        
        String [] b = copy(a);
        String [] c = copy(a);
        String [] d = copy(a);
        String [] e = copy(a);

        print(a);
        Sorting.bubbleSort(a);
        print(a);

        Sorting.selectionSort(b);
        print(b);

        Sorting.insertionSort(c);
        print(c);

        Sorting.quickSort(d);
        print(d);

        Sorting.mergeSort(e);
        print(e);
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
}