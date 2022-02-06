package om.spartaglobal.com.sortingmanager.model;

public class BubbleSortFactory implements SortFactory{
    @Override
    public Sort getSort() {
        return new BubbleSort();
    }
}
