package algorithm;

public abstract class Sort implements Sortable {
    private int[] arr;

    public Sort(int[] arr)
    {
        this.arr = arr; 
    }

    public int[] getArray()
    {
        return arr;
    }

    public void setArray(int[] arr)
    {
        this.arr = arr;
    }
    
    public abstract void sort(int[] arr);
    
    @Override
    public void swap(int[] arr, int i1, int i2)
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


}
