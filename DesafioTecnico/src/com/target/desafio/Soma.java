package com.target.desafio;

public class Soma {

	public static void main(String[] args) {
		
        int INDICE = 13, SOMA = 0, K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("Valor de SOMA: " + SOMA);
    }
}