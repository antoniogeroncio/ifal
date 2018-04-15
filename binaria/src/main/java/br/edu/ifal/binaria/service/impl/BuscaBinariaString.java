package br.edu.ifal.binaria.service.impl;

import br.edu.ifal.binaria.entity.DicionarioString;
import br.edu.ifal.binaria.service.BuscaBinaria;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Qualifier("buscaBinariaString")
@Service
public class BuscaBinariaString implements BuscaBinaria<String> {

    private final DicionarioString dicionario;

    public BuscaBinariaString(DicionarioString dicionario) {
        this.dicionario = dicionario;
    }

    @Override
    public Boolean buscar(String elemento) throws RuntimeException {

        dicionario.ordenarElementos();

        List<String> elementosDicionario = dicionario.getElementos();

        int inicio = 0;
        int fim = elementosDicionario.size() - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim)/2;
            if (elementosDicionario.get(meio).equals(elemento))
                return TRUE;
            if (elementosDicionario.get(meio).compareTo(elemento) < 0)
                inicio = meio+1;
            else
                fim = meio-1;
        }
        return lancarExcecaoValorNaoEncontrado();
    }
}
