import javax.swing.*;
//import java.math.*;
//import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
//import javax.imageio.ImageIO;
import java.util.Random;

@SuppressWarnings("serial")
public class board extends JFrame {
	
	backgroundimage tabuleiro;
	
	final int numpas = 0;
	
	String comodo;
	
	ArrayList<String> assassino = new ArrayList<String>();
	
	/* BOTOES */
	final JButton jogarDados = new JButton("Jogar Dados");
	final JButton finalizarTurno = new JButton("Finalizar Turno");
	final JButton mostrarMao = new JButton("Mostrar mao");
	final JButton bloco = new JButton("Bloco de Notas");
	final JButton acusar = new JButton("Acusar!");
	final JButton refazerTurno = new JButton("Refazer Turno");
	public JButton corJogador;
	final JButton numeroPassos = new JButton("Numero de passos: " + numpas);
	final JButton salvarJogo = new JButton("Salvar Jogo");
	final JButton passagemSecreta = new JButton("Passagem Secreta");
	public JButton palpite = new JButton("Dar Palpite");

	/* PEOES */
	final JButton b2 = new JButton(""); /* Peao verde */
	final JButton b3 = new JButton(""); /* Peao branco */
	final JButton b4 = new JButton(""); /* Peao rosa */
	final JButton b5 = new JButton(""); /* Peao azul */
	final JButton b6 = new JButton(""); /* Peao amarelo */
	final JButton b7 = new JButton(""); /* Peao vermelho */
	
	public int dados_ini; // Numero tirado nos dados e utilizado para refazer a jogada.
	public int dados;
	int placeturn = 0;
	//private JLabel texto;
	int numbplayers;
	Player[] players;
	
	ActionListener actionListener;
	ActionListener actionListener2;
	
	Dimension size;
	
	public board(String nome, int i1, int i2, int i3, int i4, int i5, int i6, int numplayers) {
		
		super(nome);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		/* BACKGROUND */
		setLayout(new GridLayout(0,1));
		tabuleiro = new backgroundimage("Tabuleiro-Original.JPG");
		getContentPane().add(tabuleiro);
		this.setResizable(false);
		
		players = new Player[numplayers+1];
		numbplayers = numplayers;
		int ord = 0;
		
		//Dimension size;
		// Pinos dos jogadores
		
		mostrarMao.addActionListener(new showhand());
		jogarDados.addActionListener(new RollDice(dados));
		System.out.println("Dados no turn " + dados);
		
		size = jogarDados.getPreferredSize();
		jogarDados.setBounds(764, 89, size.width + 50, size.height + 10);
		finalizarTurno.setBounds(764,129, size.width + 50, size.height + 10);
		mostrarMao.setBounds(764,169, size.width + 50, size.height + 10);
		bloco.setBounds(764,209, size.width + 50, size.height + 10);
		acusar.setBounds(764,249, size.width + 50, size.height + 10);
		refazerTurno.setBounds(764,329, size.width + 50, size.height + 10);
		numeroPassos.setBounds(764, 410, size.width + 50, size.height + 10);
		passagemSecreta.setBounds(764, 450, size.width + 50, size.height + 10);
		salvarJogo.setBounds(764, 490, size.width + 50, size.height + 10);
		palpite.setBounds(764,289, size.width + 50, size.height + 10);
		
		palpite.setEnabled(false);
		passagemSecreta.setEnabled(false);
		//numeroPassos.setEnabled(true);
		
		bloco.addActionListener(Notes);
		
		salvarJogo.addActionListener(new SalvarJogo());
		finalizarTurno.addActionListener(new PassTurn(this));
		//refazerTurno.addActionListener(new Reset());
		
		tabuleiro.add(jogarDados);
		tabuleiro.add(finalizarTurno);
		tabuleiro.add(mostrarMao);
		tabuleiro.add(bloco);
		tabuleiro.add(acusar);
		tabuleiro.add(palpite);
		tabuleiro.add(refazerTurno);
		tabuleiro.add(numeroPassos);
		tabuleiro.add(salvarJogo);
		tabuleiro.add(passagemSecreta);
		
		
		/* COLOCACAO DOS PEOES NO TABULEIRO */
		if(i1 == 1) /* Peao verde */
		{
			size = b2.getPreferredSize();
			b2.setBounds(447, 7, 47, 47); // Posicao inicial
			b2.setBackground(Color.GREEN);
			b2.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b2);
			b2.setEnabled(false);
			ArrayList<String> l1 = new ArrayList<String>();
			players[ord] = new Player(447, 7, b2, Color.GREEN, l1, "Verde");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i6 == 1) /* Peao branco */
		{
			size = b3.getPreferredSize();
			b3.setBounds(255, 7, 47, 47); // Posicao inicial
			b3.setBackground(Color.WHITE);
			b3.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b3);
			b3.setEnabled(false);
			ArrayList<String> l2 = new ArrayList<String>();
			players[ord] = new Player(255, 7, b3, Color.WHITE, l2, "Branco");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i4 == 1) /* Peao rosa */
		{
			size = b4.getPreferredSize();
			b4.setBounds(639, 487, 47, 47); // Posicao inicial
			b4.setBackground(Color.MAGENTA);
			b4.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b4);
			b4.setEnabled(false);
			ArrayList<String> l3 = new ArrayList<String>();
			players[ord] = new Player(639, 487, b4, Color.MAGENTA, l3, "Rosa");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i3 == 1) /* Peao azul */
		{
			size = b5.getPreferredSize();
			b5.setBounds(639, 199, 47, 47); // Posicao inicial
			b5.setBackground(Color.BLUE);
			b5.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b5);
			b5.setEnabled(false);
			ArrayList<String> l4 = new ArrayList<String>();
			players[ord] = new Player(639, 199, b5, Color.BLUE, l4, "Azul");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i2 == 1) /* Peao amarelo */
		{
			size = b6.getPreferredSize();
			b6.setBounds(15, 439, 47, 47); // Posicao inicial
			b6.setBackground(Color.YELLOW);
			b6.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b6);
			b6.setEnabled(false);
			ArrayList<String> l5 = new ArrayList<String>();
			players[ord] = new Player(15, 439, b6, Color.YELLOW, l5, "Amarelo");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i5 == 1) /* Peao vermelho */
		{
			size = b7.getPreferredSize();
			b7.setBounds(207, 631, 47, 47); // Posicao inicial
			b7.setBackground(Color.RED);
			b7.setOpaque(true); // Define opacidade de 100% (necessario para visualizacao do botao no Mac OS)
			tabuleiro.add(b7);
			b7.setEnabled(false);
			ArrayList<String> l6 = new ArrayList<String>();
			players[ord] = new Player(207, 631, b7, Color.RED, l6, "Vermelho");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		
		if(numbplayers==3)
		{
			new assassin(3, players[0].mao, players[1].mao, players[2].mao, assassino);
		}
		if(numbplayers==4)
		{
			new assassin(4, players[0].mao, players[1].mao, players[2].mao, players[3].mao, assassino);
		}
		
		if(numbplayers==5)
		{
			new assassin(5, players[0].mao, players[1].mao, players[2].mao, players[3].mao, players[4].mao, assassino);
		}
		
		if(numbplayers==6)
		{
			new assassin(6, players[0].mao, players[1].mao, players[2].mao, players[3].mao, players[4].mao, players[5].mao, assassino);
		}
		
		dados = 0;
		dados_ini = 0;
		finalizarTurno.setEnabled(false);
		refazerTurno.setEnabled(false);
		new turn(players[0]);
		
		corJogador = new JButton("Jogador: " + players[0].cor);
		tabuleiro.add(corJogador);
		corJogador.setBounds(764, 370, size.width+95, size.height + 10);
		
		// IMPORTANTE!
		// ============================
		// Altura do quadrado = 47
		// Largura do quadrado = 47
		// ============================
		
		setVisible(true);
	}
	
	ActionListener Notes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        	new notes("Bloco de Notas", assassino);
        }
	};
	
	public class turn
	{
		public JButton left;
		public JButton up;
		public JButton down;
		public JButton right;
		public int ncasas = 6;
		
		turn(Player act)
		{
			left = new JButton("←");
			up = new JButton("↑");
			down = new JButton("↓");
			right = new JButton("→");
			
			Limites limites = new Limites();
			
			left.setBounds(773, 599,  50,  50);
			right.setBounds(873, 599,  50,  50);
			up.setBounds(823, 549,  50,  50);
			down.setBounds(823, 599,  50,  50);
			
			left.addActionListener(new move(act, dados, left, right, up, down, 1));
			right.addActionListener(new move(act, dados, left, right, up, down, 2));
			up.addActionListener(new move(act, dados, left, right, up, down, 3));
			down.addActionListener(new move(act, dados, left, right, up, down, 4));			
			
			refazerTurno.addActionListener(new Reset(left, right, up, down));
			
			limites.colocarLimites(left, right, up, down, act.posx, act.posy); // Estabelece os limites de movimentacao dos peoes
			
			tabuleiro.add(left);
			tabuleiro.add(up);
			tabuleiro.add(down);
			tabuleiro.add(right);
			
			//passagemSecreta.setEnabled(false);
			palpite.setEnabled(false);
			
			palpite.removeActionListener(actionListener);
			passagemSecreta.removeActionListener(actionListener2);
		}

	}
	
	public class Limites {
		public Limites() {
			
		}
		
		public void colocarLimites(JButton left, JButton right, JButton up, JButton down, int posx, int posy)
		{
			/* Limite inicial do jogador */
			
			/* Verde */
			if(posx == 447 && posy == 7)
			{
				left.setEnabled(false);
				right.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Branco */
			if(posx == 255 && posy == 7)
			{
				left.setEnabled(false);
				right.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Amarelo */
			if(posx == 15 && posy == 439)
			{
				left.setEnabled(false);
				down.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Azul */
			if(posx == 639 && posy == 199)
			{
				right.setEnabled(false);
				down.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Rosa */
			if(posx == 639 && posy == 487)
			{
				right.setEnabled(false);
				down.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Vermelho */
			if(posx == 207 && posy == 631)
			{
				right.setEnabled(false);
				down.setEnabled(false);
				left.setEnabled(false);
			}
			
			/* Parede direita da sala de musica */
			if(posx == 447 && posy >= 103 && posy <= 151)
			{
				left.setEnabled(false);
			}
			if(posx == 447 && posy == 55)
			{
				up.setEnabled(false);
				left.setEnabled(false);
			}
			
			/* Parede inferior da sala de musica / Parede superior do detetive */
			if(posx > 303 && posx <= 446 && posy == 199)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 303 && posy == 199)
			{
				down.setEnabled(false);
			}
			if(posx == 303 && posy == 151) // Entrou na sala de musica
			{				
				comodo = "SalaDeMusica";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				up.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(true);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 303 && posy == 199 && players[placeturn].entrouComodo == 2) // Entrou na sala de musica
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede esquerda da sala de musica */
			if(posx == 255 && posy <= 198 && posy >= 103)
			{
				right.setEnabled(false);
			}
			if(posx == 255 && posy == 55)
			{
				up.setEnabled(false);
				right.setEnabled(false);
			}
			
			/* Parede esquerda do jardim de inverno */
			if(posx == 495 && posy == 55)
			{
				up.setEnabled(false);
				right.setEnabled(false);
			}
			if(posx == 495 && posy >= 103 && posy < 151)
			{
				right.setEnabled(false);
			}
			if(posx == 543 && posy == 151) // Entrou no jardim de inverno
			{
				comodo = "JardimInverno";
				
				System.out.println("");
				System.out.println("Entrou no " + comodo + ".");
				
				down.setEnabled(false);
				up.setEnabled(false);
				right.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}	
			}
			if(posx == 495 && posy == 151 && players[placeturn].entrouComodo == 2) // Entrou no jardim de inverno
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede inferior do jardim de inverno / Parede superior do salao de jogos */
			if(posx == 543 && posy == 199)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 591 && posy == 199)
			{
				right.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 495 && posy == 199)
			{
				down.setEnabled(false);
			}
			
			/* Parede esquerda do salao de jogos */
			if(posx == 447 && posy >= 247 && posy <= 295)
			{
				right.setEnabled(false);
				left.setEnabled(false);
			}
			
			/* Parede inferior do salao de jogos / Parede superior da biblioteca */
			if(posx >= 495 && posx <= 543 && posy == 343)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 591 && posy == 343)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 591 && posy == 295) // Entrou no salao de jogos
			{
				comodo = "SalaoDeJogos";
				
				System.out.println("");
				System.out.println("Entrou no " + comodo + ".");
				
				up.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 591 && posy == 343 && players[placeturn].entrouComodo == 2) // Entrou no salao de jogos
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede esquerda da biblioteca */
			if(posx == 447 && posy > 391 && posy <= 439)
			{
				right.setEnabled(false);
			}
			if(posx == 447 && posy == 391)
			{
				left.setEnabled(false);
			}
			if(posx == 495 && posy == 391) // Entrou na biblioteca
			{
				comodo = "Biblioteca";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				down.setEnabled(false);
				up.setEnabled(false);
				right.setEnabled(false);
					
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
					}
			}
			if(posx == 447 && posy == 391 && players[placeturn].entrouComodo == 2) // Entrou na biblioteca
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede inferior da biblioteca / Parede superior do escritorio */
			if(posx > 495 && posx <= 543 && posy == 487)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 591 && posy == 487)
			{
				up.setEnabled(false);
				down.setEnabled(false);
				right.setEnabled(false);
			}
			if(posx == 495 && posy == 535) // Entrou no escritorio
			{
				comodo = "Escritorio";
				
				System.out.println("");
				System.out.println("Entrou no " + comodo + ".");
				
				down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
				
				switch(players[placeturn].entrouComodo)
				{
				case 0:
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
					break;
				case 2:
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					passagemSecreta.setEnabled(true);
					System.out.println("hey bitches");
				}
			}
			if(posx == 495 && posy == 487 && players[placeturn].entrouComodo == 2) // Entrou no escritorio
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede esquerda do escritorio / Parede direita da entrada */
			if(posx == 447 && posy == 535)
			{
				left.setEnabled(false);
				right.setEnabled(false);
			}
			if(posx == 447 && posy == 583)
			{
				left.setEnabled(false);
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede superior da entrada */
			if(posx <= 399 && posx > 303 && posy == 487)
			{
				down.setEnabled(false);
			}
			if(posx == 303 && posy == 535) // Entrou na entrada
			{
				comodo = "Entrada";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 303 && posy == 487 && players[placeturn].entrouComodo == 2) // Entrou na entrada
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede esquerda da entrada */
			if(posx == 255 && posy == 535)
			{
				right.setEnabled(false);
			}
			if(posx == 255 && posy == 583)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede direita da sala de estar */
			if(posx == 207 && posy >= 487 && posy <= 535)
			{
				left.setEnabled(false);
			}
			if(posx == 207 && posy == 583)
			{
				left.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede superior da sala de estar */
			if(posx < 159 && posx >= 111 && posy == 439)
			{
				down.setEnabled(false);
			}
			if(posx == 159 && posy == 487) // Entrou na sala de estar
			{
				comodo = "SalaDeEstar";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 159 && posy == 439 && players[placeturn].entrouComodo == 2) // Entrou na sala de estar
			{
				players[placeturn].entrouComodo = 0;
			}
			if(posx == 63 && posy == 439)
			{
				left.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede inferior da sala de jantar */
			if(posx <= 159 && posx >= 111 && posy == 391)
			{
				up.setEnabled(false);
			}
			if(posx == 63 && posy == 391)
			{
				left.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Parede direita da sala de jantar */
			if(posx == 207 && posy > 247 && posy <= 343)
			{
				left.setEnabled(false);
			}
			if(posx == 159 && posy == 247) // Entrou na sala de jantar
			{
				comodo = "SalaDeJantar";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				up.setEnabled(false);
				left.setEnabled(false);
				down.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 207 && posy == 247 && players[placeturn].entrouComodo == 2) // Entrou na sala de jantar
			{
				players[placeturn].entrouComodo = 0;
			}
			
			/* Parede superior da sala de jantar / Parede inferior da cozinha */
			if(posx >= 111 && posx < 159 && posy == 199)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			if(posx == 159 && posy == 199)
			{
				down.setEnabled(false);
			}
			if(posx == 159 && posy == 151) // Entrou na cozinha
			{
				comodo = "Cozinha";
				
				System.out.println("");
				System.out.println("Entrou na " + comodo + ".");
				
				up.setEnabled(false);
				right.setEnabled(false);
				left.setEnabled(false);
				
				if(players[placeturn].entrouComodo == 0)
				{
					actionListener = new guess(assassino, comodo, palpite, tabuleiro, passagemSecreta, refazerTurno);
					palpite.addActionListener(actionListener);
					
					palpite.setEnabled(true);
					passagemSecreta.setEnabled(false);
					
					actionListener2 = new secretPassage(posx, posy, tabuleiro, passagemSecreta, refazerTurno);
					passagemSecreta.addActionListener(actionListener2);
					
					players[placeturn].entrouComodo = 1;
					
					dados = 0; // Finaliza movimentacao no tabuleiro
					System.out.println("Acabaram os passos.");
				
					numeroPassos.setText("Numero de passos: " + dados);
					
					players[placeturn].entrouComodo = 2;
				}
			}
			if(posx == 159 && posy == 199 && players[placeturn].entrouComodo == 2) // Entrou na cozinha
			{
				players[placeturn].entrouComodo = 0;
			}
			if(posx == 63 && posy == 199)
			{
				left.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede direita da cozinha */
			if(posx == 207 && posy <= 151 && posy >= 103)
			{
				left.setEnabled(false);
			}
			if(posx == 207 && posy == 55)
			{
				left.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Parede esquerda do detetive */
			if(posx == 255 && posy >= 247 && posy <= 391)
			{
				right.setEnabled(false);
			}
			
			/* Parede inferior do detetive */
			if(posx >= 303 && posx <= 399 && posy == 439)
			{
				up.setEnabled(false);
			}
			
			/* Parede direita do detetive */
			if(posx == 447 && posy == 343)
			{
				left.setEnabled(false);
			}
		}
		
	}
	
	class SalvarJogo implements ActionListener{
	
		public SalvarJogo()
		{
		}
		
		public void actionPerformed(ActionEvent e)
		{			
			System.out.println("Finalizou o jogo.");
			System.exit(0);	
		}
	}
	
	class PassTurn implements ActionListener{
		
			Component c;
		
		public PassTurn(Component x)
		{
			c = x;
		}
		public void actionPerformed(ActionEvent e)
		{						
			players[placeturn].startx = players[placeturn].posx; //atualizando a posicao inicial da rodada do jogador,
			players[placeturn].starty = players[placeturn].posy;// apos a finalizacao do seu turno.
			
			if(players[placeturn].entrouComodo == 1)
			{
				players[placeturn].entrouComodo = 2;
			}
			
			if(placeturn==numbplayers-1)
			{
				placeturn = 0;
			}
			else
			{
				placeturn +=1;
			}
			
			corJogador.setText("Jogador: " + players[placeturn].cor);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			
			jogarDados.setEnabled(true);
			finalizarTurno.setEnabled(false);
			refazerTurno.setEnabled(false);
			
			new turn(players[placeturn]);
			
		}
	}
	
	class Player
	{
		public int startx; //posicao no comeco da jogada
		public int starty;
		public int posx; //posicao atual
		public int posy;
		public JButton bb;
		public Color collo;
		public ArrayList<String> mao;
		public String cor;
		public int entrouComodo;
		
		ArrayList<JCheckBox> suspeitos = new ArrayList<>();
		ArrayList<JCheckBox> armas = new ArrayList<>();
		ArrayList<JCheckBox> comodos = new ArrayList<>();
		
		/* Suspeitos */
		JCheckBox cb1 = new JCheckBox("Rev. Green (Verde)", false);
		JCheckBox cb2 = new JCheckBox("Cel. Mustard (Amarelo)", false);
		JCheckBox cb3 = new JCheckBox("Sra. Peacock (Azul)", false);
		JCheckBox cb4 = new JCheckBox("Prof. Plum (Rosa)", false);
		JCheckBox cb5 = new JCheckBox("Srta. Scarlet (Vermelho)", false);
		JCheckBox cb6 = new JCheckBox("Sra. White (Branco)", false);
		
		/* Armas */
		JCheckBox cb7 = new JCheckBox("Cano", false);
		JCheckBox cb8 = new JCheckBox("Castical", false);
		JCheckBox cb9 = new JCheckBox("Chave Inglesa", false);
		JCheckBox cb10 = new JCheckBox("Corda", false);
		JCheckBox cb11 = new JCheckBox("Faca", false);
		JCheckBox cb12 = new JCheckBox("Revolver", false);
		
		/* Comodos */
		JCheckBox cb13 = new JCheckBox("Cozinha", false);
		JCheckBox cb14 = new JCheckBox("Entrada", false);
		JCheckBox cb15 = new JCheckBox("Escritorio", false);
		JCheckBox cb16 = new JCheckBox("JardimInverno", false);
		JCheckBox cb17 = new JCheckBox("SalaDeEstar", false);
		JCheckBox cb18 = new JCheckBox("SalaDeJantar", false);
		JCheckBox cb19 = new JCheckBox("SalaDeMusica", false);
		JCheckBox cb20 = new JCheckBox("SalaoDeJogos", false);
		JCheckBox cb21 = new JCheckBox("Biblioteca", false);
		
		public Player(int px, int py, JButton ba, Color col, ArrayList<String> m, String c)
		{
			startx = px;
			starty = py;
			posx = px;
			posy = py;
			bb = ba;
			collo = col;
			mao = m;
			cor = c;
			entrouComodo = 0;
		}
		
		
	}
	class move implements ActionListener {

		Player p;
		int f;
		JButton left;
		JButton right;
		JButton up;
		JButton down;
		
		public move(Player p1, int ncasas, JButton l, JButton r, JButton u, JButton d, int flag)
		{
			p = p1;
			left = l;
			right = r;
			up = u;
			down = d;
			f = flag;
			
			Limites limites = new Limites();
			
			limites.colocarLimites(left, right, up, down, p.posx, p.posy); // Estabelece os limites de movimentacao dos peoes
			
			//limites aqui
		}
		
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Dado no passo " + dados);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			
			if(dados > 0){

				Limites limites = new Limites();
				
				limites.colocarLimites(left, right, up, down, p.posx, p.posy); // Estabelece os limites de movimentacao dos peoes
				
				//limites aqui
				
				if(f == 1)
				{
						p.bb.setBounds(p.posx-48, p.posy, 47, 47);
						p.posx = p.posx - 48;
				}
				
				if(f == 2)
				{
						p.bb.setBounds(p.posx+48, p.posy, 47, 47);
						p.posx = p.posx + 48;
				}
				
				if(f == 3)
				{	
					p.bb.setBounds(p.posx, p.posy-48, 47, 47);
					p.posy = p.posy - 48;
				}
				
				if(f == 4)
				{	
					p.bb.setBounds(p.posx, p.posy+48, 47, 47);
					p.posy = p.posy + 48;
				}
				
				refazerTurno.setEnabled(true);
				p.bb.setBackground(p.collo);
				tabuleiro.remove(p.bb);
				dados -= 1;
				numeroPassos.setText("Numero de passos: " + dados);
				tabuleiro.add(p.bb);
				
				left.setEnabled(true);
				right.setEnabled(true);
				up.setEnabled(true);
				down.setEnabled(true);
				
				limites.colocarLimites(left, right, up, down, p.posx, p.posy); // Estabelece os limites de movimentacao dos peoes
				
				//limites aqui
				
				tabuleiro.revalidate();
				tabuleiro.repaint();
				
				if(dados == 0)
				{
					tabuleiro.remove(left);
					tabuleiro.remove(up);
					tabuleiro.remove(down);
					tabuleiro.remove(right);
					finalizarTurno.setEnabled(true);
					tabuleiro.revalidate();
					tabuleiro.repaint();
				}
			}
			
		}
	
	}
class Reset implements ActionListener {
		
		JButton left;
		JButton right;
		JButton up;
		JButton down;
		
		public Reset(JButton l, JButton r, JButton u, JButton d)
		{
			left = l;
			right = r;
			up = u;
			down = d;
		}
		
		public void actionPerformed(ActionEvent e)
		{

			if(dados == 0)
			{
				JButton left = new JButton("←");
				JButton up = new JButton("↑");
				JButton down = new JButton("↓");
				JButton right = new JButton("→");		
				
				Limites limites = new Limites();
				
				left.setBounds(773, 599,  50,  50);
				right.setBounds(873, 599,  50,  50);
				up.setBounds(823, 549,  50,  50);
				down.setBounds(823, 599,  50,  50);
				
				left.addActionListener(new move(players[placeturn], dados, left, right, up, down, 1));
				right.addActionListener(new move(players[placeturn], dados, left, right, up, down, 2));
				up.addActionListener(new move(players[placeturn], dados, left, right, up, down, 3));
				down.addActionListener(new move(players[placeturn], dados, left, right, up, down, 4));
				
				tabuleiro.add(left);
				tabuleiro.add(right);
				tabuleiro.add(up);
				tabuleiro.add(down);
				
				left.setEnabled(true);
				right.setEnabled(true);
				up.setEnabled(true);
				down.setEnabled(true);
				
				limites.colocarLimites(left, right, up, down, players[placeturn].startx, players[placeturn].starty); // Estabelece os limites de movimentacao dos peoes
				
			}
			
			else if (dados > 0) {
				/*tabuleiro.remove(left);
				tabuleiro.remove(right);
				tabuleiro.remove(up);
				tabuleiro.remove(down);*/
				
				left.setEnabled(true);
				right.setEnabled(true);
				up.setEnabled(true);
				down.setEnabled(true);
				
				Limites limites = new Limites();
				
				limites.colocarLimites(left, right, up, down, players[placeturn].startx, players[placeturn].starty); // Estabelece os limites de movimentacao dos peoes
				
			}
			
			players[placeturn].posx = players[placeturn].startx;
			players[placeturn].posy = players[placeturn].starty;
			
			dados = dados_ini;
			players[placeturn].bb.setBounds(players[placeturn].posx, players[placeturn].posy, 47, 47);
			players[placeturn].bb.setBackground(players[placeturn].collo);
			tabuleiro.remove(players[placeturn].bb);
			numeroPassos.setText("Numero de passos: " + dados);
			tabuleiro.add(players[placeturn].bb);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			
			palpite.setEnabled(false);
			passagemSecreta.setEnabled(false);
			finalizarTurno.setEnabled(false);
			
			palpite.removeActionListener(actionListener);
			passagemSecreta.removeActionListener(actionListener2);
		}

	}

	class imagem extends JPanel {
		public static final int TXT_X = 1000;
		public static final int TXT_Y = 686;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon i = new ImageIcon("Tabuleiro-Original.JPG");
			Image i3 = i.getImage();
			Image i2 = getScaledImage(i3, TXT_X, TXT_Y);
			g.drawImage(i2, 0, 0, this);
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	
	    return resizedImg;
	}
	
}
	
	

class RollDice implements ActionListener {

	int dices;
	
	public RollDice(int x)
	{
		dices = x;
	}
	public void actionPerformed(ActionEvent e)
	{
		Random r = new Random();
		int d1 = r.nextInt(6 - 1 + 1) + 1;
		int d2 = r.nextInt(6 - 1 + 1) + 1;
		int total = d1+d2;
		dados = total;
		dados_ini = total;
		numeroPassos.setText("Numero de passos: " + dados);
		
		//numeroPassos.setText("Numero de passos: " + total);
		//showdice l = new showdice("Dado", d1);
		//showdice l2 = new showdice("Dado2", d2);
		//Insets ins = l.getInsets();
		//l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		//l.setVisible(true);
		//l2.setVisible(true);
		
		
		jogarDados.setEnabled(false);
	}
}

class showhand implements ActionListener {
	
	public showhand()
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		int i = 0;
		int size = players[placeturn].mao.size();
		while(i < size)
		{
			HandS h = new HandS("Cartas na manga do jogador " + (placeturn+1), players[placeturn].mao, i);
			Insets ins = h.getInsets();
			h.setSize(400 + ins.left + ins.right, 386 + ins.top + ins.bottom);
			h.setVisible(true);
			i++;
		}
	}
}

}

class Dices extends JFrame{
	
	public Dices(String nome)
	{
		super(nome);
		JPanel p = new JPanel();
		getContentPane().add(p);
		int d1, d2;
		Random r = new Random();
		d1 = r.nextInt(6 - 1 + 1) + 1;
		d2 = r.nextInt(6 - 1 + 1) + 1;
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new pressdice(this, d1));
		b2.addActionListener(new pressdice(this, d2));
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new pressdice(this, 3));
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new pressdice(this, 4));
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new pressdice(this, 5));
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new pressdice(this, 6));
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new pressdice(this, 7));
		
		JButton b8 = new JButton("8");
		b8.addActionListener(new pressdice(this, 8));
		
		JButton b9 = new JButton("9");
		b9.addActionListener(new pressdice(this, 9));
		
		JButton b10 = new JButton("10");
		b10.addActionListener(new pressdice(this, 10));
		
		JButton b11 = new JButton("11");
		b11.addActionListener(new pressdice(this, 11));
		
		JButton b12 = new JButton("12");
		b12.addActionListener(new pressdice(this, 12));
		
		setLayout(new GridLayout(0,2));
		URL url;
		try {
			url = new URL("file:///C:/Users/lipin/POO/1211874-1321873/dice.gif");
		} catch (MalformedURLException e) {
			url = null;
			e.printStackTrace();
		}
		if(url == null)
		{
			System.out.println("ERROR ON DICE GIF");
		}
		
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);	
        p.add(label);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        pack();
		
	}
		
}





