package br.edu.ifal.binaria.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Dicionario<T> {

    List<T> elementos;

    public List<T> getElementos() {
        return elementos != null ? elementos : new ArrayList<>();
    }

    public void setElementos(List<T> elementos) {
        this.elementos = elementos;
    }

    public abstract void ordenarElementos();
}
