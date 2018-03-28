import java.util.ArrayList;
import java.util.Stack;

public class WePay {


//    public static void main(String[] args) {
//        //System.out.println("hello ");
//           int arr[] = new int []{1,2,100,2,2};
//           float allowed = (float) 1.5;
//           int sum = 0;
//           float avg = 0;
//           int max = 0;
//           float prevavg = 0;
//           int window = 3;
//           for(int i = 0; i+window<=arr.length;i++){
//               max = arr[i];
//
//               for(int j = i ; j< i+window ; j++){
//                   sum = sum+ arr[j];
//                   if(arr[j]>max){
//                       max = arr[j];
//                   }
//               }
//               avg = (float) sum/window;
//               if(max > (avg*allowed)){
//                   System.out.println("True from 1");
//               }
//               else if (prevavg*allowed < avg && prevavg!=0){
//                   System.out.println("True");
//               }
//               sum = 0;
//               if(avg<prevavg) {
//                   prevavg = avg;
//               }
//           }
//
//
//    }   // the ma
    //above is the main function with a simple solution that does not check for the value in all ht

//    public static void main(String[] args) {
//         int arr[] = new int[]{1,2,100,2,2};
//         int window = 3;
//       //  Alert al[] = new Alert[];
//        ArrayList<Stack> Alert = new  ArrayList<Stack>();
//        Stack s = new Stack();
//        int max = 0;
//        int sum = 0 ;
//        float avg = 0;
//        int k = 0;
//        float allowed = (float) 2.5;
//        for(int i = 0; i <= arr.length-window;i++){
//              max = arr[i];
//                for(int j = i ; j<i+window ; j++){
//                    sum = sum+ arr[j];
//                   if(arr[j]>max){
//                       max = arr[j];
//                   }
//                }
//                avg = (float) sum/window;
//                sum = 0;
//                s.push(max);
//                s.push(avg*allowed);
//            System.out.println("The elements of stack are :"+s);
//
//
//
//               // s.push()
//
//
//        }
//        System.out.println(Alert);
//
//
//
//
//    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 100, 2, 90, 200, 5, 6, 7, 8, 9, 100, 0};
        int arr1[] = new int[arr.length];
        int window = 3;
        int max = 0;
        float avg = 0;
        int sum = 0;
        float prevavg = 0;
        float allowed = (float) 2.5;
        int k = 0;
        boolean flag = false;
        for (int i = 0; i <= arr.length - window; i++) {
            max = arr[i];
            for (int j = i; j < i + window; j++) {
                sum = sum + arr[j];
                if (arr[j] > max) {
                    max = arr[j];
                    k = j;
                }

            }
            avg = (float) sum / window;

//            System.out.println("the average is :"+avg);
//            System.out.println("The allowed increase is :"+ avg*allowed);
//            System.out.println("The max is :"+ max);
           if(max > avg*allowed) {
               //  System.out.println("in here");
               if (arr1[k] >= window - 1) {
                   // System.out.println("yo");
                   flag = true;
               } else {
                   arr1[k]++;

               }
           }

        if (prevavg == 0) {
            prevavg = avg;
        }
        if (prevavg * allowed < avg && prevavg != 0) {
            flag = true;
            break;
        }
        sum = 0;
        if (avg < prevavg) {
            prevavg = avg;

        }
    }
        for(int i = 0 ; i < arr1.length; i++)
        {
            System.out.println(arr1[i]);
        }
        System.out.println(flag);
    }


        }
//        for(int i = 0 ; i < arr1.length; i++)
//        {
//            System.out.println(arr1[i]);
//        }
       // System.out.println(flag);
     //   return flag;


