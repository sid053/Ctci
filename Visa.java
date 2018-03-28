public final class Visa
{
    public static void main(String[] args) {
        int arr[] = new int []{1,2,3,5,6};
        //set(arr,arr[arr.length-1]);
        System.out.println(maxDifference(arr));

    }
    static int maxDifference(int[] a) {
     int max = a[0];
        for(int i = 0; i<a.length ; i++){
            for(int j = i ; j< a.length ; j++){
                if(a[j]>a[i]){
                    if(a[j]-a[i]>max){
                        max = a[j]-a[i];
                    }
                }
            }

        }
        return max;


    }

}

