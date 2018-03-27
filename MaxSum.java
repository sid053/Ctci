public class MaxSum {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int arr[] = new int[]{-1,-2,-6,-4};
        System.out.println(maxsum(arr));

    }
    public static int max(int [] arr){
        int max = arr[0];
        for(int i = 1 ; i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int maxsum(int []arr){
        int []temp = new int [arr.length];
        int maxDiff = arr[1]-arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j<i ; j++){
                System.out.println("for "+i + "  " + j + " " + (arr[i]-arr[j]));
                if(arr[i]-arr[j]>maxDiff){
                    maxDiff = arr[i]-arr[j];
                    System.out.println("the difference is :"+ maxDiff);
                }
            }
            temp[i] = maxDiff;
        }
        return max(temp);
    }
}
