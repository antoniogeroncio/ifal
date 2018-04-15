package br.edu.ifal.binaria.service.impl;

import br.edu.ifal.binaria.entity.DicionarioInteiro;
import br.edu.ifal.binaria.service.BuscaBinaria;
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
public class BuscaBinariaInteiroTest {

	protected BuscaBinaria buscaBinaria;

	@Mock
	protected DicionarioInteiro dicionarioMock;

	private List<Integer> elementosDicionario;

	@Before
	public void inicializarContexto(){
		buscaBinaria = new BuscaBinariaInteiro(dicionarioMock);
		elementosDicionario = new ArrayList<>();
		elementosDicionario.add(1);
		elementosDicionario.add(2);
		elementosDicionario.add(3);
		elementosDicionario.add(4);
		elementosDicionario.add(5);
		elementosDicionario.add(6);
		elementosDicionario.add(7);
		elementosDicionario.add(8);
		elementosDicionario.add(9);
	}

	@Test
	public void dadoQueBuscarQuandoNumeroEstaContidoNoDicionarioEntaoDeveriaRetornaVerdadeiro() {
		when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
		assertTrue(buscaBinaria.buscar(3));
		verify(dicionarioMock, times(1)).ordenarElementos();
	}

	@Test(expected = RuntimeException.class)
	public void dadoQueBuscarQuandoNumeroNaoEstaContidoNoDicionarioEntaoDeveriaRetornaExcecao() {
		when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
		buscaBinaria.buscar(10);
		verify(dicionarioMock, times(1)).ordenarElementos();

	}

	@Test(expected = RuntimeException.class)
	public void dadoQueBuscarQuandoNumeroNuloEntaoDeveriaRetornaExcecao() {
		when(dicionarioMock.getElementos()).thenReturn(elementosDicionario);
		buscaBinaria.buscar(null);
		verify(dicionarioMock, times(1)).ordenarElementos();
	}
	
	
	

}
