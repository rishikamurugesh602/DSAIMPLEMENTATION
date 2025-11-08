// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int[] num={4,3,5,6,7,8};
    
        System.out.println(minimumelement(num));
    }
    static int minimumelement(int[] arr){
        if(arr.length==0){
            return -1;
        }
        int and=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<and){
                and=arr[i];
            }
        }
        return and;
        
        
    }
}
