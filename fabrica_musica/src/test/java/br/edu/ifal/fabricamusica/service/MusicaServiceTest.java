package br.edu.ifal.fabricamusica.service;

import br.edu.ifal.fabricamusica.model.Animal;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicaServiceTest {

	@Autowired
	private MusicaService musicaService;

	@Mock
	private List<Animal> animais;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void aoGerarMusicaDadoQueSejaInformadoListaValidaEntaoDeveriaRetornarMusicaEsperada() {

		animais = new ArrayList<>();
		animais.add(new Animal("Fly"));
		animais.add(new Animal("Spider"));
		animais.add(new Animal("Bird"));
		animais.add(new Animal("Cat"));
		animais.add(new Animal("Horse"));

		String musicaEsperada = "There was an old lady who swallowed a Fly\n";
		musicaEsperada+= "I don't know why she swallowed a Fly - perhaps she'll die!\n";
		musicaEsperada+= "There was an old lady who swallowed a Spider\n";
		musicaEsperada+= "She swallowed the Spider to catch the Fly,\n";
		musicaEsperada+= "I don't know why she swallowed a Fly - perhaps she'll die!\n";
		musicaEsperada+= "There was an old lady who swallowed a Bird\n";
		musicaEsperada+= "She swallowed the Bird to catch the Spider,\n";
		musicaEsperada+= "She swallowed the Spider to catch the Fly,\n";
		musicaEsperada+= "I don't know why she swallowed a Fly - perhaps she'll die!\n";
		musicaEsperada+= "There was an old lady who swallowed a Cat\n";
		musicaEsperada+= "She swallowed the Cat to catch the Bird,\n";
		musicaEsperada+= "She swallowed the Bird to catch the Spider,\n";
		musicaEsperada+= "She swallowed the Spider to catch the Fly,\n";
		musicaEsperada+= "I don't know why she swallowed a Fly - perhaps she'll die!\n";
		musicaEsperada+= "There was an old lady who swallowed a Horse\n";
		musicaEsperada+= "...She's dead, of course!";

		String musicaRetornada = musicaService.gerar(animais);

		Assert.assertEquals(musicaEsperada, musicaRetornada);
		
	}

	@Test
	public void aoGerarMusicaDadoQueSejaInformadoListaNulaEntaoDeveriaLancarExcecao() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Lista de animais vazia");
		musicaService.gerar(null);
	}
	
	@Test
	public void aoGerarMusicaDadoQueSejaInformadoListaVaziaEntaoDeveriaLancarExcecao() {
		when(animais.size()).thenReturn(0);
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Lista de animais vazia");
		musicaService.gerar(animais);
	}
	
	@Test
	public void aoGerarMusicaDadoQueSejaInformadoListaContendoMaisObjetoQueOhSuportadoEntaoDeveriaLancarExcecao() {
		when(animais.size()).thenReturn(21);
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Lista de animais maior que 20");
		musicaService.gerar(animais);
	}


}
