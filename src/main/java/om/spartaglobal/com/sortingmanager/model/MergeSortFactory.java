package om.spartaglobal.com.sortingmanager.model;

public class MergeSortFactory implements SortFactory{
    @Override
    public Sort getSort() {
        return new MergeSort();
    }
}
