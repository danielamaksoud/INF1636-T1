import java.math.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class assassin {
	
	assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3)
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
		armas.remove(0);
		comodos.remove(0);
		suspeitos.remove(0);
		cartas.addAll(suspeitos);
		cartas.addAll(armas);
		cartas.addAll(suspeitos);
		numcartas = numcartas - 3;
		Collections.shuffle(cartas);
		for(i=0;i<6;i++)
		{
			l1.add(cartas.get(i));
			l2.add(cartas.get(6+i));
			l3.add(cartas.get(12+i));
		}
	}
		
		assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4)
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
			armas.remove(0);
			comodos.remove(0);
			suspeitos.remove(0);
			cartas.addAll(suspeitos);
			cartas.addAll(armas);
			cartas.addAll(suspeitos);
			numcartas = numcartas - 3;
			Collections.shuffle(cartas);
			for(i=0;i<4;i++)
			{
				l1.add(cartas.get(i));
				l2.add(cartas.get(4+i));
				l3.add(cartas.get(8+i));
				l4.add(cartas.get(12+i));
			}
			l1.add(cartas.get(16));
			l2.add(cartas.get(17));
			
	}
		
		assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4, ArrayList<String> l5)
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
			armas.remove(0);
			comodos.remove(0);
			suspeitos.remove(0);
			cartas.addAll(suspeitos);
			cartas.addAll(armas);
			cartas.addAll(suspeitos);
			numcartas = numcartas - 3;
			Collections.shuffle(cartas);
			for(i=0;i<3;i++)
			{
				l1.add(cartas.get(i));
				l2.add(cartas.get(3+i));
				l3.add(cartas.get(6+i));
				l4.add(cartas.get(9+i));
				l5.add(cartas.get(12+i));
			}
			l1.add(cartas.get(15));
			l2.add(cartas.get(16));
			l2.add(cartas.get(17));
			
		}
		
		
		assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4, ArrayList<String> l5, ArrayList<String> l6)
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
			armas.remove(0);
			comodos.remove(0);
			suspeitos.remove(0);
			cartas.addAll(suspeitos);
			cartas.addAll(armas);
			cartas.addAll(suspeitos);
			numcartas = numcartas - 3;
			Collections.shuffle(cartas);
			for(i=0;i<3;i++)
			{
				l1.add(cartas.get(i));
				l2.add(cartas.get(3+i));
				l3.add(cartas.get(6+i));
				l4.add(cartas.get(9+i));
				l5.add(cartas.get(12+i));
				l6.add(cartas.get(15+i));
			}
		}

}