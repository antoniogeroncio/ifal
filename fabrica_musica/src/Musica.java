import java.util.ArrayList;

public class Musica {
	
	
	
	public String gerarMusica(ArrayList<Animal> animais) {
		if(animais.size()<1) {
			throw new RuntimeException("Lista de animais vazia");
		}else if(animais.size()>20) {
			throw new RuntimeException("Lista de animais maior que 20");
		}else {
			String musica = "";
			for(int i = 0; i<animais.size(); i++) {
				musica+="There was an old lady who swallowed a "+animais.get(i).getDescricao()+"\n";
				if(primeiroDaLista(i)) {
					musica+= "I don't know why she swallowed a "+animais.get(i).getDescricao()+" - perhaps she'll die!\n";
				}else if(ultimoDaLista(animais, i)) {
					musica+= "...She's dead, of course!";
				}else {
					musica+= gerarVersoParaAnimal(animais, i);
					musica+= "I don't know why she swallowed a "+animais.get(0).getDescricao()+" - perhaps she'll die!\n";
				}
			}
			
			return musica;
		}
		
	}
	
	
	private String gerarVersoParaAnimal(ArrayList<Animal> animais, int i) {
		String musica = "";
		for(int j = i+1; j>1; j--) {
			musica+="She swallowed the "+animais.get(j-1).getDescricao()+" to catch the "+animais.get(j-2).getDescricao()+",\n";
		}	
		return musica;
	}
	
	private boolean primeiroDaLista(int index) {
		if(index == 0)
			return true;
		return false;
	}
	private boolean ultimoDaLista(ArrayList<Animal> animais, int index) {
		if(index == animais.size()-1)
			return true;
		return false;
	}
}
