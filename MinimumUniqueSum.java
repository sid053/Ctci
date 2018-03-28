import java.util.Arrays;
import java.util.HashSet;

public class MinimumUniqueSum {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int arr[] = new int []{1,5,3,2};
        int temp[] = arr;
        Arrays.sort(temp);
        System.out.println(nextMinNumber(temp,0));
        System.out.println(minimumUniqueSum(temp));

    }
    public static int minimumUniqueSum(int [] arr){
        int sum = 0;

        for(int i = 0 ; i <arr.length-1 ; i++){

            if(arr[i]==arr[i+1]){
               arr[i+1] = nextMinNumber(arr,i);
            }
            sum = sum + arr[i];
        }

        return sum+arr[arr.length-1];
    }
    public static int nextMinNumber(int arr[],int num){

        for(int i = num ; i< arr.length-1 ; i++){
            if(arr[i+1]-arr[i]>1){
                return arr[i]+1;
            }
        }
        return arr[arr.length-1]+1;

    }
}
