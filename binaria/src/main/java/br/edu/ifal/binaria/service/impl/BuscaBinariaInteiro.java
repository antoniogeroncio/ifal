package br.edu.ifal.binaria.service.impl;

import br.edu.ifal.binaria.entity.DicionarioInteiro;
import br.edu.ifal.binaria.service.BuscaBinaria;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("buscaBinariaInteiro")
@Service
public class BuscaBinariaInteiro implements BuscaBinaria<Integer> {

    private final DicionarioInteiro dicionario;

    public BuscaBinariaInteiro(DicionarioInteiro dicionario) {
        this.dicionario = dicionario;
    }

    @Override
    public Boolean buscar(Integer elemento) throws RuntimeException {

        dicionario.ordenarElementos();

        List<Integer> elementosDicionarioOrdenados = dicionario.getElementos();

        int inicio = 0;

        int fim = elementosDicionarioOrdenados.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim)/2;
            if (elemento == elementosDicionarioOrdenados.get(meio))
                return Boolean.TRUE;
            if (elemento < elementosDicionarioOrdenados.get(meio))
                fim = meio+1;
            else
                inicio = meio+1;
        }
        return lancarExcecaoValorNaoEncontrado();
    }
}
