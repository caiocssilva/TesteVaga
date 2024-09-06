package com.target.desafio;

import java.util.Scanner;

public class InversaoString {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite uma string: ");
        String input = scanner.nextLine();
        
        String invertida = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }
        
        System.out.println("String invertida: " + invertida);
        scanner.close();
    }
}