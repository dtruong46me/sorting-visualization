package algorithm;

public class BubbleSort extends Sort {  

    private int length; 

    public BubbleSort(int[] arr)
    {   
        super(arr);
        this.length = length;
    }
    
    @Override
    public void sort(int[] arr)
    {
        int i, j;
        boolean  swapped = false;
        for (i = 0; i < this.length-1; i++)
        {
          for (j = 0; j < this.length-i-1;j++)
          {
             if(arr[j]>arr[j+1])
             {
                swap(arr, j, j+1);
                swapped = true;
             }
          }
          if (swapped == false)
          {
            break;
          }
        }
    }
}
