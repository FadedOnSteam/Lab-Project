public class Sorting {
    public static void bubbleSort(String [] a){
        String temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if(a[j].compareTo(a[j+1]) > 0){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(String [] a){
        int indexSmallest;
        String temp;

        for (int i = 0; i < a.length; i++) {
            indexSmallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[indexSmallest]) < 0){
                    indexSmallest = j;
                }
            }
            temp = a[i];
            a[i] = a[indexSmallest];
            a[indexSmallest] = temp;
        }
    }
    public static void insertionSort(String [] a){
        String temp;
        int j;
        for (int i = 0; i < a.length; i++) {
            j = i;
            while(j > 0 && a[j].compareTo(a[j-1]) < 0){
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                --j;
            }
        }
    }
    public static int partition(String [] a, int i, int k) {
        int midpoint;
        int low;
        int high;
        String pivot;
        String temp;
        boolean done;

        midpoint = i + (k - i) / 2;
        pivot = a[midpoint];

        done = false;
        low = i;
        high = k;

        while(!done){
            while(a[low].compareTo(pivot) < 0){
                ++low;
            }
            while(a[high].compareTo(pivot) > 0){
                --high;
            }
            if(low >= high){
                done = true;
            }
            else {
                temp = a[low];
                a[low] = a[high];
                a[high] = temp;

                ++low;
                --high;
            }
        }
        return high;
    }
    private static void quickSort(String [] a, int i, int k) {
        int j;
        if(i >= k){
            return;
        }

        j = partition(a, i, k);

        quickSort(a, i, j);
        quickSort(a, j + 1, k);
   }
    public static void quickSort(String [] a){
        quickSort(a, 0, a.length-1);
   }
    public static void merge(String [] a, int i, int j, int k){
        int mergedSize = k - i + 1;
        String mergedString [] = new String [mergedSize];
        int mergePos;
        int leftPos;
        int rightPos;

        mergePos = 0;
        leftPos = i;
        rightPos = j + 1;

        while(leftPos <= j && rightPos <= k){
            if(a[leftPos].compareTo(a[rightPos]) < 0){
                mergedString[mergePos] = a[leftPos];
                ++leftPos;
            }
            else{
                mergedString[mergePos] = a[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        while(leftPos <= j){
            mergedString[mergePos] = a[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while(rightPos <= k){
            mergedString[mergePos] = a[rightPos];
            ++rightPos;
            ++mergePos;
        }

        for(mergePos = 0; mergePos < mergedSize; ++mergePos){
            a[i + mergePos] = mergedString[mergePos];
        }
    }
    private static void mergeSort(String [] a, int i, int k){
        int j;

        if(i < k){
            j = (i + k) / 2;

            mergeSort(a, i, j);
            mergeSort(a, j + 1, k);

            merge(a, i, j, k);
        }
    }
    public static void mergeSort(String [] a){
        mergeSort(a, 0, a.length-1);
    }
    public static void cocktailSort(String [] a){
        String swap;
        int n = a.length;
        boolean swapped = true;
        int start = 0;
        int end = n - 1;

        while(swapped){
            swapped = false;
            for (int i = 0; i < end; i++) {
                if(a[i].compareTo(a[i + 1]) > 0){
                    swap = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = swap;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
            swapped = false;
            end = end -1;
            for (int i = end - 1; i >= start; i--) {
                if(a[i].compareTo(a[i + 1]) > 0){
                    swap = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = swap;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
    public static void bubbleSortReverse(String [] a){
        String temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if(a[j].compareTo(a[j+1]) < 0){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSortReverse(String [] a){
        int indexLargest;
        String temp;

        for (int i = 0; i < a.length; i++) {
            indexLargest = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[indexLargest]) > 0){
                    indexLargest = j;
                }
            }
            temp = a[i];
            a[i] = a[indexLargest];
            a[indexLargest] = temp;
        }
    }
    public static void insertionSortReverse(String [] a){
        String temp;
        int j;
        for (int i = 0; i < a.length; i++) {
            j = i;
            while(j > 0 && a[j].compareTo(a[j-1]) > 0){
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                --j;
            }
        }
    }
    public static void cocktailSortReverse(String [] a){
        String swap;
        int n = a.length;
        boolean swapped = true;
        int start = 0;
        int end = n - 1;

        while(swapped){
            swapped = false;
            for (int i = 0; i < end; i++) {
                if(a[i].compareTo(a[i + 1]) < 0){
                    swap = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = swap;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
            swapped = false;
            end = end -1;
            for (int i = end - 1; i >= start; i--) {
                if(a[i].compareTo(a[i + 1]) < 0){
                    swap = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = swap;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
    public static int partitionReverse(String [] a, int i, int k) {
        int midpoint;
        int low;
        int high;
        String pivot;
        String temp;
        boolean done;

        midpoint = i + (k - i) / 2;
        pivot = a[midpoint];

        done = false;
        low = i;
        high = k;

        while(!done){
            while(a[low].compareTo(pivot) > 0){
                ++low;
            }
            while(a[high].compareTo(pivot) < 0){
                --high;

            }
            if(low >= high){
                done = true;
            }
            else {
                temp = a[low];
                a[low] = a[high];
                a[high] = temp;

                ++low;
                --high;
            }
        }
        return high;
    }
    private static void quickSortReverse(String [] a, int i, int k) {
        int j;
        if(i >= k){
            return;
        }

        j = partitionReverse(a, i, k);

        quickSortReverse(a, i, j);
        quickSortReverse(a, j + 1, k);
   }
    public static void quickSortReverse(String [] a){
        quickSortReverse(a, 0, a.length-1);
   }
    public static void mergeReverse(String [] a, int i, int j, int k){
        int mergedSize = k - i + 1;
        String mergedString [] = new String [mergedSize];
        int mergePos;
        int leftPos;
        int rightPos;

        mergePos = 0;
        leftPos = i;
        rightPos = j + 1;

        while(leftPos <= j && rightPos <= k){
            if(a[leftPos].compareTo(a[rightPos]) > 0){
                mergedString[mergePos] = a[leftPos];
                ++leftPos;
            }
            else{
                mergedString[mergePos] = a[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        while(leftPos <= j){
            mergedString[mergePos] = a[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while(rightPos <= k){
            mergedString[mergePos] = a[rightPos];
            ++rightPos;
            ++mergePos;
        }

        for(mergePos = 0; mergePos < mergedSize; ++mergePos){
            a[i + mergePos] = mergedString[mergePos];
        }
    }
    private static void mergeSortReverse(String [] a, int i, int k){
        int j;

        if(i < k){
            j = (i + k) / 2;

            mergeSortReverse(a, i, j);
            mergeSortReverse(a, j + 1, k);

            mergeReverse(a, i, j, k);
        }
    }
    public static void mergeSortReverse(String [] a){
        mergeSortReverse(a, 0, a.length-1);
    }
}
