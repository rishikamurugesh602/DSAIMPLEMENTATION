// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        String name="rishika";
        char target='s';
        int ans=linearsearch(name,target);
        System.out.println(ans);
    }
    static int linearsearch(String str,char target){
        if(str.length()==0){
            return -1;
        }
        for(int i=0;i<str.length();i++){
            int element=str.charAt(i);
            if(element==target){
                return i;
            }
        }
        return -1;
    }
}
