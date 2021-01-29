package banyuan;

import java.util.Stack;

public class dailyTemperatures {



    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<Integer>();
        int []out=new int[T.length];

        stack.push(T[0]);
        for (int i = 1; i < T.length; i++) {
             int count=0;
             int temp= stack.peek();
             while(T[i+count]<=temp){
                 count++;
                 if(i+count>=T.length){
                     break;
                 }
             }
             stack.push(T[i]);
             out[i-1]=count+1;
        }
        out[T.length-1]=0;
        return out;


    }
    public static void main(String[] args) {
        int [] T=new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[]out=dailyTemperatures(T);
        for (int i : out) {
            System.out.println(i);
        }
    }
}
