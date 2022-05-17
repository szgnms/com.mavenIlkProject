package practice;

import java.util.Scanner;

public class test {

    public static int FirstFactorial(int num) {
        int num1=1;
        for(int i=num; i>0;i--){
            num1*=i;

        }
        return num1;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.print(FirstFactorial(num));

    }}