package om.spartaglobal.com.sortingmanager.model;

public class MergeSort implements Sort{
    @Override
    public void sortArray(int[] array) {
       sort(array,0, array.length-1);
    }


    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two sub arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        //Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        //Copy data to temp arrays
        for(int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for(int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;
        // Initial index of merged sub array
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements of L[] if any
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        //Copy remaining elements of R[] if any
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts using merge function
    void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }


}
