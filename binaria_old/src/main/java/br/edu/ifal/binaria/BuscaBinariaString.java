package br.edu.ifal.binaria;

import java.util.ArrayList;
import static java.util.Collections.sort;

public class BuscaBinariaString {
	ArrayList<String> myList = new ArrayList<String>();
	
	public BuscaBinariaString() {
		myList.add("D");
		myList.add("ANTONIO FARREIRO");
		myList.add("ANTONIO PAI");		
		myList.add("C");
		myList.add("E");
		myList.add("F");
		sort(myList);
		
		
	}
	
public String buscarLetra(String nome) throws RuntimeException {
		int inicio = 0;   
		int fim = myList.size() - 1;
        while (inicio <= fim) {   
	        int meio = (inicio + fim)/2;   
	         if (myList.get(meio).equals(nome))   
	        	 return myList.get(meio);   
	         if (myList.get(meio).compareTo(nome) < 0)
	        	inicio = meio+1;
	         else   
	        	 fim = meio-1;   
        }   
		throw new RuntimeException("Valor n�o encontrado!");
	}
	
}
