package om.spartaglobal.com.sortingmanager.controller;

import om.spartaglobal.com.sortingmanager.model.BubbleSortFactory;
import om.spartaglobal.com.sortingmanager.model.MergeSortFactory;
import om.spartaglobal.com.sortingmanager.model.Sort;
import om.spartaglobal.com.sortingmanager.model.facade.SortMaker;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class SortManager {
    //controller logger object logs are stored in logs/log.out
    static Logger log = Logger.getLogger(SortManager.class.getName());
    //sort function sort array with all given sort methods and
    //returns the result and time it took to sort using each sorting method
    public String sort(String numbers){
        //clean extra spaces
        numbers = numbers.trim().replaceAll("\\s+"," ");

        //split user input to array
        String[] stringArray = numbers.split(" ");

        //make integer arrays for each sorting method
        int[] bubbleSortedArray = new int[stringArray.length];
        int[] mergeSortedArray = new int[stringArray.length];
        int[] bstSortedArray = new int[stringArray.length];

        //converting string array values to integer and storing in each integer array
        for (int i = 0; i < stringArray.length; i++) {
            bubbleSortedArray[i] = Integer.parseInt(stringArray[i]);
            bstSortedArray[i] = mergeSortedArray[i] = bubbleSortedArray[i];
        }

        // check if array has repeating values
        boolean check = false;
        for (int i = 0; i < stringArray.length; i++){
            for (int j = i + 1 ; j < stringArray.length; j++){ 
                if (stringArray[i].equals(stringArray[j])){
                    check = true;
                    break;
                }
            }
            if (check)
                break;
        }

        Sort bubbleSort = new BubbleSortFactory().getSort();
        Sort mergeSort = new MergeSortFactory().getSort();
        Sort bstSort = new SortMaker().getBstSort();


        ExecutionTimer timer = new ExecutionTimer();

        timer.start();
        bubbleSort.sortArray(bubbleSortedArray);
        timer.end();
        long bubbleTime = timer.duration();
        timer.reset();


        timer.start();
        mergeSort.sortArray(mergeSortedArray);
        timer.end();
        long mergeTime = timer.duration();
        timer.reset();

        //skip BST sorting if array has repeated elements
        if(!check){
            timer.start();
            bstSort.sortArray(bstSortedArray);
            timer.end();
        }
        long bstTime = timer.duration();

        //logging info about the sorts completed and time taken by each
        log.info("Bubble sorted in "+bubbleTime+" Nano Seconds");
        log.info("Merge sorted in "+mergeTime+" Nano Seconds");
        log.info("BST sorted in "+bstTime+" Nano Seconds");


        String results = "";
        results += "Bubble Sort Result:\n"+ Arrays.toString(bubbleSortedArray)+"\n" +
                "Time (nano): "+bubbleTime+"\n\n";

        results += "Merge Sort Result:\n"+ Arrays.toString(mergeSortedArray)+"\n" +
                "Time (nano): "+mergeTime+"\n\n";

        //if array has no repeating element the result is returned for BST otherwise
        //an error is sent
        if (!check)
        results += "BST Sort Result:\n"+ Arrays.toString(bstSortedArray)+"\n" +
                "Time (nano): "+bstTime+"\n\n";
        else
            results+="Repeating elements are not supported in BST tree sort";
        return results;
    }
}
