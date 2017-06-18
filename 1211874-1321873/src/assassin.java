import java.math.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class assassin {
	
	void assassin(int numplayers, ArrayList l1, ArrayList l2, ArrayList l3)
	{
		ArrayList<String> cartas = new ArrayList<String>();
		ArrayList<String> Assassino = new ArrayList<String>();
		int numcartas = 21;
		int i;
		ArrayList<String> armas = new ArrayList<String>();
		ArrayList<String> comodos = new ArrayList<String>();
		ArrayList<String> suspeitos = new ArrayList<String>();
		armas.add("Cano");
		armas.add("Castical");
		armas.add("ChaveInglesa");
		armas.add("Corda");
		armas.add("Faca");
		armas.add("Revolver");
		comodos.add("Cozinha");
		comodos.add("Entrada");
		comodos.add("Escritorio");
		comodos.add("JardimInverno");
		comodos.add("SalaDeEstar");
		comodos.add("SalaDeJantar");
		comodos.add("SalaDeMusica");
		comodos.add("SalaDeJogos");
		comodos.add("Biblioteca");
		suspeitos.add("Green");
		suspeitos.add("Mustard");
		suspeitos.add("Peacock");
		suspeitos.add("Plum");
		suspeitos.add("Scarlet");
		suspeitos.add("White");
		Collections.shuffle(armas);
		Collections.shuffle(comodos);
		Collections.shuffle(suspeitos);
		Assassino.add(armas.get(0));
		Assassino.add(comodos.get(0));
		Assassino.add(suspeitos.get(0));
		for(i=1;i<6;i++)
		{
			cartas.add(suspeitos.get(i));
			cartas.add(armas.get(i));
		}
		
			
	}

}
