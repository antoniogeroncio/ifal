import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MusicaTest {

	@Test
	void testGerarMusica() {
		ArrayList<Animal> animais = new ArrayList<Animal>();
		animais.add(new Animal("Fly"));
		animais.add(new Animal("Spider"));
		animais.add(new Animal("Bird"));
		animais.add(new Animal("Cat"));
		animais.add(new Animal("Horse"));
		System.out.println(new Musica().gerarMusica(animais));
		
	}
	
	@Test
	void verificaGerarMusicaComListaVazia() {
		assertThrows(java.lang.RuntimeException.class, () -> new Musica().gerarMusica(new ArrayList<Animal>()));
		
	}
	
	@Test
	void verificaGerarMusicaComListaMaiorQueVinte() {
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for(int i = 0; i <= 20; i++ ) {
			animais.add(new Animal("Animal"+i));
		}
		assertThrows(java.lang.RuntimeException.class, () -> new Musica().gerarMusica(animais));
		
	}


}
