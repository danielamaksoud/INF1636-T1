import java.math.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class assassin {
	
	public assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> assassino)
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
		comodos.add("SalaoDeJogos");
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
		assassino.add(Assassino.get(0)); /* Arma */
		assassino.add(Assassino.get(1)); /* Comodo */
		assassino.add(Assassino.get(2)); /* Suspeito */
		
		System.out.println("");
		System.out.println("Arma = " + assassino.get(0));
		System.out.println("Comodo = " + assassino.get(1));
		System.out.println("Suspeito = " + assassino.get(2));
		System.out.println("");
		
		armas.remove(0);
		comodos.remove(0);
		suspeitos.remove(0);
		cartas.addAll(suspeitos);
		cartas.addAll(armas);
		cartas.addAll(comodos);
		numcartas = numcartas - 3;
		Collections.shuffle(cartas);
		for(i=0;i<6;i++)
		{
			l1.add(cartas.get(i));
			l2.add(cartas.get(6+i));
			l3.add(cartas.get(12+i));
		}
	}
		
	public assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4, ArrayList<String> assassino)
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
			comodos.add("SalaoDeJogos");
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
			assassino.add(Assassino.get(0)); /* Arma */
			assassino.add(Assassino.get(1)); /* Comodo */
			assassino.add(Assassino.get(2)); /* Suspeito */
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
				l4.add(cartas.get(11+i));
			}
			
	}
		
	public assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4, ArrayList<String> l5, ArrayList<String> assassino)
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
			comodos.add("SalaoDeJogos");
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
			assassino.add(Assassino.get(0)); /* Arma */
			assassino.add(Assassino.get(1)); /* Comodo */
			assassino.add(Assassino.get(2)); /* Suspeito */
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
			
		}
		
		
		public assassin(int numplayers, ArrayList<String> l1, ArrayList<String> l2, ArrayList<String> l3, ArrayList<String> l4, ArrayList<String> l5, ArrayList<String> l6, ArrayList<String> assassino)
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
			comodos.add("SalaoDeJogos");
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
			assassino.add(Assassino.get(0)); /* Arma */
			assassino.add(Assassino.get(1)); /* Comodo */
			assassino.add(Assassino.get(2)); /* Suspeito */
			armas.remove(0);
			comodos.remove(0);
			suspeitos.remove(0);
			cartas.addAll(suspeitos);
			cartas.addAll(armas);
			cartas.addAll(suspeitos);
			numcartas = numcartas - 3;
			Collections.shuffle(cartas);
			for(i=0;i<2;i++)
			{
				l1.add(cartas.get(i));
				l2.add(cartas.get(2+i));
				l3.add(cartas.get(5+i));
				l4.add(cartas.get(8+i));
				l5.add(cartas.get(11+i));
				l6.add(cartas.get(13+i));
			}
		}

}
