package br.edu.ifal.binaria.service.impl;

import br.edu.ifal.binaria.entity.DicionarioString;
import br.edu.ifal.binaria.service.BuscaBinaria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BuscaBinariaStringTest {

    protected BuscaBinaria buscaBinaria;

    @Mock
    protected DicionarioString dicionarioMock;

    private List<String> elementosDicionario;

    @Before
    public void inicializarContexto(){
        elementosDicionario = new ArrayList<>();
        elementosDicionario.add("ANTONIO");
        elementosDicionario.add("BIA");
        elementosDicionario.add("CARLA");
        elementosDicionario.add("JOANA");
        elementosDicionario.add("ELIETE");
        elementosDicionario.add("JULIA");
        buscaBinaria = new BuscaBinariaString(dicionarioMock);
    }

    @Before
    public void configurarChamadas(){
    }

    @After
    public void checarExpectativasChamadas(){
    }

    @Test
    public void dadoQueBuscarQuandoStringEstaContidoNoDicionarioEntaoDeveriaRetornaVerdadeiro() {
        when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
        assertTrue(buscaBinaria.buscar("CARLA"));
        verify(dicionarioMock, times(1)).ordenarElementos();
    }

    @Test(expected = RuntimeException.class)
    public void dadoQueBuscarQuandoStringNaoEstaContidoNoDicionarioEntaoDeveriaRetornaExcecao() {
        when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
        buscaBinaria.buscar("HELENA");
        verify(dicionarioMock, times(1)).ordenarElementos();
    }

    @Test(expected = RuntimeException.class)
    public void dadoQueBuscarQuandoStringNuloEntaoDeveriaRetornaExcecao() {
        when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
        buscaBinaria.buscar(null);
        verify(dicionarioMock, times(1)).ordenarElementos();
    }
}