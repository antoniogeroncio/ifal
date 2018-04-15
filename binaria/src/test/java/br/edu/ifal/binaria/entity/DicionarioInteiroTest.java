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
public class DicionarioInteiroTest implements DicionarioTest {

    protected Dicionario dicionario;

    protected List<Integer> elementos;

    @Before
    @Override
    public void inicializarContexto(){
        dicionario = new DicionarioInteiro();
        elementos = new ArrayList<>();
        elementos.add(2);
        elementos.add(1);
        elementos.add(3);
    }

    @Test
    @Override
    public void dadoQueGetElementosQuandoDicionarioPopuladoComElementosEntaoDeveriaRetornarElementos(){
        dicionario.setElementos(elementos);

        List<Integer> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(2);
        resultadoEsperado.add(1);
        resultadoEsperado.add(3);

        Assert.assertEquals(resultadoEsperado, dicionario.getElementos());
    }

    @Test
    @Override
    public void dadoQueGetElementosQuandoDicionarioVazioEntaoDeveriaRetornarVazio(){
        dicionario.setElementos(new ArrayList<>());

        List<Integer> resultadoEsperado = new ArrayList<>();

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

        List<Integer> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(1);
        resultadoEsperado.add(2);
        resultadoEsperado.add(3);

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