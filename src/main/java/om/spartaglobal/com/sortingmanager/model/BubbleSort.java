package om.spartaglobal.com.sortingmanager.model;

public class BubbleSort implements Sort{
    @Override
    public void sortArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                //check if leading array element is smaller
                if (array[j] > array[j+1])
                {
                    // swap elements if condition is true
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
}
