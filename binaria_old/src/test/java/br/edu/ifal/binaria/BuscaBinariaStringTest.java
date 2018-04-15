package br.edu.ifal.binaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuscaBinariaStringTest {
	
	@Test
	public void verificaBuscaNomeAntonioFarreiro() {
		assertEquals("ANTONIO FARREIRO", new BuscaBinariaString().buscarLetra("ANTONIO FARREIRO"));
	}
	
	@Test
	public void verificaBuscaNomeAntonioPai() {
		assertEquals("ANTONIO PAI", new BuscaBinariaString().buscarLetra("ANTONIO PAI"));
	}


}
