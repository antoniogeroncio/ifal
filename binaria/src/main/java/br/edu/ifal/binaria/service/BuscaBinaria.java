package br.edu.ifal.binaria.service;

public interface BuscaBinaria<T> {

    String VALOR_NAO_ENCONTRADO = "Valor não encontrado";

    Boolean buscar(T elemento) throws RuntimeException;

    default Boolean lancarExcecaoValorNaoEncontrado() throws RuntimeException {
        throw new RuntimeException(VALOR_NAO_ENCONTRADO);
    }
}
