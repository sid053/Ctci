import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class HashTable {

    public static void main(String[] args) {
        System.out.println("HashTable");


//        System.out.println(numJewelsInStones("aA","aAAAbAAbAAbA"));
//        String [] words = new String[]{"suggest","letter","of","husband","easy","education","husah","drug","prevent","writer","old" };
//        System.out.println(shortestCompletingWord("Ah71752",words));
//        String str[] = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is","is"};
//        System.out.println(topKFrequent(str,4));

    }
    public static int numJewelsInStones(String J, String S) {

        HashSet<Character> hash = new HashSet<>();
        int count = 0;

        for(int i = 0 ; i < J.length(); i++){
            hash.add(J.charAt(i));
        }
        for(int i = 0 ; i < S.length() ; i++){
            if(hash.contains(S.charAt(i))){
                count++;
            }
        }

        return count ;
    }
    public static String shortestCompletingWord(String test, String[] words) {
        int count = 0;
        String licensePlate = test.toLowerCase();
        int i = 0;
        int arr[] = new int[words.length];
        int min=0 ;
        Hashtable<Character,Integer> hash = new Hashtable<>();
        for(i =0 ; i < licensePlate.length(); i++){
            if(Character.isLetter(licensePlate.charAt(i))){

                if(hash.containsKey(licensePlate.charAt(i))){
                    count = hash.get(licensePlate.charAt(i));
                    count++;
                    hash.put(licensePlate.charAt(i),count);
                }
                else{
                    hash.put(licensePlate.charAt(i), 1);
                }
            }
        }

        for(int j = 0 ; j < words.length;j++){
         //   System.out.println(hash);
          //  System.out.println();
           // System.out.println(words[j]);
            Hashtable<Character,Integer> temp = new Hashtable<>();
            temp = (Hashtable)hash.clone();
                if(Compare(temp,words[j])){
                    System.out.println(words[j]);
                    arr[j] = words[j].length();
                    min = words[j].length();
                }
        }

        int k=0 ;

        for(i = 0 ; i < arr.length;i++){
            if(arr[i]!=0){
             if(arr[i]<min){
                 min = arr[i];
                 //k = i;
             }
            }
        }
        for(i = 0; i< arr.length;i++){
            if(arr[i]==min){
                k = i;
                break;
            }
        }

        return words[k];
    }
    public static boolean Compare (Hashtable<Character,Integer> hash , String str){
        int count;
       // System.out.println("the hash table is :"+ hash);
       // System.out.println(str);
        for(int i = 0 ; i < str.length() ; i++){

            if(hash.containsKey(str.charAt(i))){
                count=hash.get(str.charAt(i));
                count--;
                if(count==0){
                    hash.remove(str.charAt(i));
         //           System.out.println(str.charAt(i));
                }
                else{
                    hash.put(str.charAt(i),count);
                }
            }
        }
        System.out.println("----------");
        System.out.println(hash);
        System.out.println("----------");
       // System.out.println("hashtable after the removal :"+ hash);
        if(hash.isEmpty()){
            return true;
        }
        return false;
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();

        for(int i = 0 ; i< nums1.length;i++){
            hash.add(nums1[i]);
        }
        for(int i=0; i<nums2.length;i++){
            if(hash.contains(nums2[i])){
                temp.add(nums2[i]);
            }
        }
        Integer array [] = new Integer [temp.size()];
        temp.toArray(array);
        int arr1[] = new int[array.length];
        for(int i =0;i<array.length;i++){
            arr1[i]=array[i];
        }
            return arr1;

    }


    public static List<String> topKFrequent(String[] words, int k) {
        int count ;
    LinkedHashMap<String,Integer> hash = new LinkedHashMap<>();
    int [] arr = new int [words.length];
    for(int i = 0; i < words.length ; i++ ) {
        if (hash.containsKey(words[i])) {
            count = hash.get(words[i]);
            count++;
            hash.remove(words[i]);
            hash.put(words[i], count);
        } else {
            hash.put(words[i], 1);
        }
    }
    hash = sortHash(hash);
        System.out.println(hash);
    List<String> lis = new ArrayList<>(hash.keySet());
        List<String> ret = new ArrayList<>();
        System.out.println(lis);
        for(int i = 0 ; i < k;i++) {
            ret.add(lis.get(i));
        }
    return ret;
    }
    public static LinkedHashMap<String,Integer> sortHash(LinkedHashMap<String,Integer> hash){

        LinkedHashMap<String,Integer> sort = new LinkedHashMap<>();
        List<String> inpString = new ArrayList<>(hash.keySet());
        List<Integer> inpInteger = new ArrayList<>(hash.values());

        Collections.sort(inpString);
        Collections.sort(inpInteger);
        Collections.reverse(inpInteger);
        Iterator<Integer> value = inpInteger.iterator();

        while(value.hasNext()){
            Integer in = value.next();
            Iterator<String> str = inpString.iterator();

            while (str.hasNext()){
                String s = str.next();

                Integer temp1 = hash.get(s);
                Integer temp2 = in;

                if(temp1.equals(temp2)){
                    str.remove();
                    sort.put(s,temp1);
                    break;
                }
            }
        }
        return sort;
    }    // function to sort the hashmap



}

