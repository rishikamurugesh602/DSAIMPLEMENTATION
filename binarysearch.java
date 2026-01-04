// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class BinarySearch{
    public static void main(String[] args){
        int[] arr={-18,-1,0,3,4,5,6};
        int target=6;
        int ans=binary(arr,target);
        System.out.println(ans);
    }
    static int binary(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start)+(end-start)/2;//start +end might exceed value
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
