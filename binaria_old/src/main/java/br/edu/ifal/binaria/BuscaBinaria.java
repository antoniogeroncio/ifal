package br.edu.ifal.binaria;

import java.util.ArrayList;
import java.util.List;

public class BuscaBinaria {
	ArrayList<Integer> myList = new ArrayList<Integer>();
	public BuscaBinaria() {
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		myList.add(9);
	}
	
	public int buscarNumero(int numero) {
		int inicio = 0;   
		int fim = myList.size() - 1;

    while (inicio <= fim) {   
	     int meio = (inicio + fim)/2;   
	     if (numero == myList.get(meio))   
	    	 return myList.get(meio);   
	     if (numero < myList.get(meio))   
	        fim = meio+1;   
	     else   
	        inicio = meio+1;   
    }   
		throw new RuntimeException("Valor nao encontrado");

	}
}
