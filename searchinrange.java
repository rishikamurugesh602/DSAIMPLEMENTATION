// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int[] num={3,4,5,6,7,8};
        int target=7;
        int start=1;
        int end=4;
        int ans=linearsearch(num,target,start,end);
        System.out.println(ans);
    }
    static int linearsearch(int[] arr,int target,int start,int end){
        if(arr.length==0){
            return -1;
        }
        for(int i=start;i<=end;i++){
            int element=arr[i];
            if(element==target){
                return i;
            }
        }
        return -1;
        
        
    }
}
