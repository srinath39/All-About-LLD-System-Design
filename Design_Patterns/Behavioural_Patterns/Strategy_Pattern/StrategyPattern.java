// when to use
// when a action has multiple bahaviours
// or an operation has multiple implementations 

// example 
// sorting can be done with different algorithms ( merge sort , Quick sort) 

// And the implementation behind the operation, behaviour behind the action need to decide at runtime

class SortingHelper{
    public void sortArray(int[] arr,ISorting sortalgo){
        sortalgo.sort(arr);
    }
}

interface ISorting{
    public void sort(int[] arr);
}

class MergeSort implements ISorting{
    public void sort(int[] arr){
        System.out.println("merge sort");
    }
}

class QuickSort implements ISorting{
    public void sort(int[] arr){
        System.out.println("merge sort");
    }
}

class Main{
    public static void main(String[] args){
        SortingHelper sortingHelper=new SortingHelper();
        sortingHelper.sortArray(new int[]{1,2,3},new MergeSort());
        sortingHelper.sortArray(new int[]{1,2,3},new QuickSort());
    }
}