package org.example;
import java.util.*;

public class Basic_Caluclator {
    String Str;

    public Basic_Caluclator(String str){
        this.Str=str;
    }

    public int Calculate(String Str){
        if(Str==null || Str.isEmpty()) return 0;
        int len=Str.length();
        Stack<Integer> stack=new Stack<Integer>();
        int current=0;
        char operation='+';
        for(int i=0;i<len;i++){
            char ch=Str.charAt(i);
            if(Character.isDigit(ch)){
                current=(current*10)+(ch-'0');
            }

            if (!Character.isDigit(ch) &&
                    !Character.isWhitespace(ch) || i == len - 1) {
                if(operation=='-'){
                    stack.push(-current);
                }else if(operation=='+'){
                    stack.push(current);
                }else if(operation=='*'){
                    int h=stack.pop();
                    stack.push(h*current);
                }else if(operation=='/'){
                    int u=stack.pop();
                    stack.push(u/current);
                }
                operation=ch;
                current=0;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Basic_Caluclator b=new Basic_Caluclator("0");

        Scanner sc=new Scanner(System.in);
        System.out.println("**********WELCOME TO THE WEBKNOT CALCULATOR*************");

        while(true){
            System.out.println("Enter the operation to be performed");
            try {
                String input = sc.next();

                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid input: Empty string or whitespace. Please enter a valid input.");
                }
                int answer=b.Calculate(input);
                System.out.println(answer);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }



    }

}
