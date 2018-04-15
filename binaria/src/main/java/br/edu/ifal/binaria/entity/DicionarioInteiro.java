package br.edu.ifal.binaria.entity;

import java.util.Collections;

public class DicionarioInteiro extends Dicionario<Integer> {
    @Override
    public void ordenarElementos() {
        if(elementos != null){
            Collections.sort(elementos);
        }
    }
}
