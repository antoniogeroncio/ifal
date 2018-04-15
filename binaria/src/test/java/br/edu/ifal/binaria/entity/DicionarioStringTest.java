package br.edu.ifal.binaria.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DicionarioStringTest implements DicionarioTest {

    protected Dicionario dicionario;

    protected List<String> elementos;

    @Before
    @Override
    public void inicializarContexto(){
        dicionario = new DicionarioString();
        elementos = new ArrayList<>();
        elementos.add("Z");
        elementos.add("A");
        elementos.add("C");
    }

    @Test
    @Override
    public void dadoQueGetElementosQuandoDicionarioPopuladoComElementosEntaoDeveriaRetornarElementos(){
        dicionario.setElementos(elementos);

        List<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("Z");
        resultadoEsperado.add("A");
        resultadoEsperado.add("C");

        Assert.assertEquals(resultadoEsperado, dicionario.getElementos());
    }

    @Test
    @Override
    public void dadoQueGetElementosQuandoDicionarioVazioEntaoDeveriaRetornarVazio(){
        dicionario.setElementos(new ArrayList<>());

        List<String> resultadoEsperado = new ArrayList<>();

        Assert.assertEquals(resultadoEsperado, dicionario.getElementos());
    }

    @Test
    @Override
    public void dadoQueGetElementosQuandoElementosNuloEntaoDeveriaRetornarVazio(){
        dicionario.setElementos(null);

        Assert.assertTrue(dicionario.getElementos().isEmpty());
    }


    @Test
    @Override
    public void dadoQueOrdenarElementosQuandoDicionarioPopuladoComElementosDesordenadosEntaoDeveriaOrdenarElementos(){
        dicionario.setElementos(elementos);

        List<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("A");
        resultadoEsperado.add("C");
        resultadoEsperado.add("Z");

        dicionario.ordenarElementos();
        Assert.assertEquals(resultadoEsperado, dicionario.getElementos());
    }

    @Test
    @Override
    public void dadoQueOrdenarElementosQuandoElementosNuloEntaoDeveriaNaoOrdenarElementos(){
        dicionario.setElementos(null);

        dicionario.ordenarElementos();
        Assert.assertTrue(dicionario.getElementos().isEmpty());
    }
}