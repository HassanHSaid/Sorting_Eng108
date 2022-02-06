package om.spartaglobal.com.sortingmanager.model.facade;

import om.spartaglobal.com.sortingmanager.model.BSTSort;
import om.spartaglobal.com.sortingmanager.model.BubbleSort;
import om.spartaglobal.com.sortingmanager.model.MergeSort;
import om.spartaglobal.com.sortingmanager.model.Sort;

//facade pattern sort maker class
public class SortMaker {
    Sort bubbleSort;
    Sort mergeSort;
    Sort bstSort;

    public SortMaker(){
        bubbleSort = new BubbleSort();
        mergeSort = new MergeSort();
        bstSort = new BSTSort();
    }

    public Sort getBstSort() {
        return bstSort;
    }

    public Sort getBubbleSort() {
        return bubbleSort;
    }

    public Sort getMergeSort() {
        return mergeSort;
    }
}
