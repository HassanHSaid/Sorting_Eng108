import om.spartaglobal.com.sortingmanager.model.BubbleSortFactory;
import om.spartaglobal.com.sortingmanager.model.MergeSortFactory;
import om.spartaglobal.com.sortingmanager.model.facade.SortMaker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnitTest {

    @Test
    void mergeTest() {
        int[] arr = {12,23,13,5556,222,1,1};
        new MergeSortFactory().getSort().sortArray(arr);
        assertEquals("[1, 1, 12, 13, 23, 222, 5556]", Arrays.toString(arr));
    }

    @Test
    void bubbleTest(){
        int[] arr = {12,23,13,5556,222,1,1};
        new BubbleSortFactory().getSort().sortArray(arr);
        assertEquals("[1, 1, 12, 13, 23, 222, 5556]", Arrays.toString(arr));

    }

    @Test
    void BstTest(){
        int[] arr = {12,23,13,5556,222,1};
        new SortMaker().getBstSort().sortArray(arr);
        assertEquals("[1, 12, 13, 23, 222, 5556]", Arrays.toString(arr));

    }
}