package br.edu.ifal.fabricamusica.service;

import br.edu.ifal.fabricamusica.model.Animal;

import java.util.List;

public interface MusicaService {

    String MENSAGEM_LISTA_DE_ANIMAIS_VAZIA = "Lista de animais vazia";
    String MENSAGEM_LISTA_DE_ANIMAIS_MAIOR_QUE_20 = "Lista de animais maior que 20";

    String gerar(List<Animal> animais);

}
