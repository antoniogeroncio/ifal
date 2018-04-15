package br.edu.ifal.binaria.entity;

import java.util.Collections;

public class DicionarioString extends Dicionario<String> {
    @Override
    public void ordenarElementos() {
        if(elementos != null){
            Collections.sort(elementos);
        }
    }
}
