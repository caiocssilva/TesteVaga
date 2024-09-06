package com.target.desafio;

import java.util.Scanner;

public class Fibonacci {
	
    public static boolean isFibonacci(int num) {
        int a = 0, b = 1;
        if (num == 0 || num == 1) {
            return true;
        }
        
        while (b < num) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == num;
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = scanner.nextInt();
        
        if (isFibonacci(num)) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
        scanner.close();
    }
    
}