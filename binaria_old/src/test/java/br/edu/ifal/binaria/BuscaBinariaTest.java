package br.edu.ifal.binaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuscaBinariaTest {

	
	@Test
	public void verificaBuscaBinaria() {
		assertEquals(9, new BuscaBinaria().buscarNumero(9));
	}

	@Test
	public void verificaBuscaBinariaNumero3() {
		assertEquals(3, new BuscaBinaria().buscarNumero(3));
	}
	
	@Test(expected = RuntimeException.class)
	public void verificaBuscaBinariaNumeroNaoExiste() {
		new BuscaBinaria().buscarNumero(10);
	}


}
