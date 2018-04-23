package br.edu.ifal.fabricamusica.service.impl;

import br.edu.ifal.fabricamusica.model.Animal;
import br.edu.ifal.fabricamusica.service.MusicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {

	@Override
	public String gerar(List<Animal> animais) {
		StringBuilder musica = new StringBuilder();
		casoListaAnimaisEstejaVaziaDeveriaLancarExcecao(animais);
		casoListaAnimaisContenhaMaisQueVinteAnimaisDeveriaLancarExcecao(animais);
		for(int i = 0; i < animais.size(); i++) {
			musica.append("There was an old lady who swallowed a "+animais.get(i).getDescricao()+"\n");
			if(primeiroDaLista(i)) {
				musica.append("I don't know why she swallowed a "+animais.get(i).getDescricao()+" - perhaps she'll die!\n");
			}else if(ultimoDaLista(animais, i)) {
				musica.append("...She's dead, of course!");
			}else {
				musica.append(gerarVersoParaAnimal(animais, i));
				musica.append("I don't know why she swallowed a "+animais.get(0).getDescricao()+" - perhaps she'll die!\n");
			}
		}
		return musica.toString();
	}

	private void casoListaAnimaisContenhaMaisQueVinteAnimaisDeveriaLancarExcecao(List<Animal> animais) {
		if(animais.size() > 20){
			lancarExcecao(MENSAGEM_LISTA_DE_ANIMAIS_MAIOR_QUE_20);
		}
	}

	private void casoListaAnimaisEstejaVaziaDeveriaLancarExcecao(List<Animal> animais) {
		if(animais == null || animais.size() < 1){
			lancarExcecao(MENSAGEM_LISTA_DE_ANIMAIS_VAZIA);
		}
	}

	private void lancarExcecao(String mensagemListaDeAnimaisMaiorQue20) throws RuntimeException {
		throw new RuntimeException(mensagemListaDeAnimaisMaiorQue20);
	}

	private boolean primeiroDaLista(int index) {
		if(index == 0)
			return true;
		return false;
	}
	private boolean ultimoDaLista(List<Animal> animais, int index) {
		if(index == animais.size()-1)
			return true;
		return false;
	}

	private String gerarVersoParaAnimal(List<Animal> animais, int i) {
		String musica = "";
		for(int j = i+1; j>1; j--) {
			musica+="She swallowed the "+animais.get(j-1).getDescricao()+" to catch the "+animais.get(j-2).getDescricao()+",\n";
		}
		return musica;
	}
}
