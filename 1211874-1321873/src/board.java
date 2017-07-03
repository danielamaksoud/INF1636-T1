import javax.swing.*;
import java.math.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class board extends JFrame {
	
	backgroundimage tabuleiro;

	final int numpas = 0;
	final JButton b1 = new JButton("Jogar Dados");
	final JButton fimt = new JButton("Finalizar Turno");
	final JButton mm = new JButton("Mostrar mao");
	final JButton bloco = new JButton("Bloco de Notas");
	final JButton palp = new JButton("Dar Palpite");
	final JButton JACUSE = new JButton("Acusar!");
	final JButton RT = new JButton("Refazer Turno");
	final JButton numpassos = new JButton("Numero de passos: " + numpas);
	final JButton salvarJogo = new JButton("Salvar Jogo");
	public JButton corJogador;
	final JButton b2 = new JButton("");
	final JButton b3 = new JButton("");
	final JButton b4 = new JButton("");
	final JButton b5 = new JButton("");
	final JButton b6 = new JButton("");
	final JButton b7 = new JButton("");
	
	public int dados_ini; // Numero tirado nos dados, utilizado para refazer a jogada.
	public int dados;
	int placeturn = 0;
	private JLabel texto;
	int numbplayers;
	Player[] players;
	
	
	public board(String nome, int i1, int i2, int i3, int i4, int i5, int i6, int numplayers) {
		super(nome);
	
		setLayout(new GridLayout(0,1));
		
		tabuleiro = new backgroundimage("Tabuleiro-Original.JPG");
		
		getContentPane().add(tabuleiro);
		players = new Player[numplayers+1];
		numbplayers = numplayers;
		int ord = 0;
		this.setResizable(false);
		mm.addActionListener(new showhand());
		
		Dimension size;
		// Pinos dos jogadores
		
		b1.addActionListener(new RollDice(dados));
		System.out.println("dados no turn" + dados);
		size = b1.getPreferredSize();
		b1.setBounds(764, 119, size.width + 50, size.height + 10);
		fimt.setBounds(764,159, size.width+50, size.height + 10 );
		mm.setBounds(764,199, size.width+50, size.height + 10 );
		bloco.setBounds(764,239, size.width+50, size.height + 10 );
		RT.setBounds(764,359, size.width+50, size.height + 10 );
		palp.setBounds(764,319, size.width+50, size.height + 10 );
		JACUSE.setBounds(764,279, size.width+50, size.height + 10 );
		numpassos.setBounds(764, 440, size.width+50, size.height + 10);
		salvarJogo.setBounds(764, 480, size.width+50, size.height + 10);
		
		numpassos.setEnabled(false);
		
		
		fimt.addActionListener(new PassTurn(this));
		RT.addActionListener(new Reset());
		
		tabuleiro.add(b1);
		tabuleiro.add(fimt);
		tabuleiro.add(mm);
		tabuleiro.add(bloco);
		tabuleiro.add(RT);
		tabuleiro.add(palp);
		tabuleiro.add(JACUSE);
		tabuleiro.add(numpassos);
		tabuleiro.add(salvarJogo);
		
		if(i1 == 1)
		{
			size = b2.getPreferredSize();
			b2.setBounds(400, 36, 25, 23); // Esta na posicao inicial
			b2.setBackground(Color.GREEN);
			b2.setOpaque(true);
			tabuleiro.add(b2);
			b2.setEnabled(false);
			ArrayList<String> l1 = new ArrayList<String>();
			players[ord] = new Player(400, 36, b2, Color.GREEN, l1, "Verde");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i6 == 1)
		{
			size = b3.getPreferredSize();
			b3.setBounds(275, 36, 25, 23);
			b3.setBackground(Color.WHITE);
			b3.setOpaque(true);
			tabuleiro.add(b3);
			b3.setEnabled(false);
			ArrayList<String> l2 = new ArrayList<String>();
			players[ord] = new Player(275, 36, b3, Color.WHITE, l2, "Branco");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i4 == 1)
		{
			size = b4.getPreferredSize();
			b4.setBounds(625, 511, 25, 23);
			b4.setBackground(Color.MAGENTA);
			b4.setOpaque(true);
			tabuleiro.add(b4);
			b4.setEnabled(false);
			ArrayList<String> l3 = new ArrayList<String>();
			players[ord] = new Player(625, 511, b4, Color.MAGENTA, l3, "Rosa");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i3 == 1)
		{
			size = b5.getPreferredSize();
			b5.setBounds(625, 186, 25, 23);
			b5.setBackground(Color.BLUE);
			b5.setOpaque(true);
			tabuleiro.add(b5);
			b5.setEnabled(false);
			ArrayList<String> l4 = new ArrayList<String>();
			players[ord] = new Player(625, 188, b5, Color.BLUE, l4, "Azul");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i2 == 1)
		{
			size = b6.getPreferredSize();
			b6.setBounds(50, 459, 25, 23);
			b6.setBackground(Color.YELLOW);
			b6.setOpaque(true);
			tabuleiro.add(b6);
			b6.setEnabled(false);
			ArrayList<String> l5 = new ArrayList<String>();
			players[ord] = new Player(50, 459, b6, Color.YELLOW, l5, "Amarelo");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i5 == 1)
		{
			size = b7.getPreferredSize();
			b7.setBounds(225, 634, 25, 23);
			b7.setBackground(Color.RED);
			b7.setOpaque(true);
			tabuleiro.add(b7);
			b7.setEnabled(false);
			ArrayList<String> l6 = new ArrayList<String>();
			players[ord] = new Player(225, 634, b7, Color.RED, l6, "Vermelho");
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		
		if(numbplayers==3)
		{
			new assassin(3, players[0].mao, players[1].mao, players[2].mao);
		}
		if(numbplayers==4)
		{
			new assassin(4, players[0].mao, players[1].mao, players[2].mao, players[3].mao);
		}
		
		if(numbplayers==5)
		{
			new assassin(5, players[0].mao, players[1].mao, players[2].mao, players[3].mao, players[4].mao);
		}
		
		if(numbplayers==6)
		{
			new assassin(6, players[0].mao, players[1].mao, players[2].mao, players[3].mao, players[4].mao, players[5].mao);
		}
		
		dados = 0;
		dados_ini = 0;
		fimt.setEnabled(false);
		RT.setEnabled(false);
		new turn(players[0]);
		
		corJogador = new JButton("Jogador: " + players[0].cor);
		tabuleiro.add(corJogador);
		corJogador.setBounds(764, 400, size.width+50, size.height + 10);
		
		//altura do quadrado 25
		//largura do quadrado 25
		
		
		
		setVisible(true);
	}
	
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
			
			left.setBounds(773, 579,  50,  50);
			right.setBounds(873, 579,  50,  50);
			up.setBounds(823, 529,  50,  50);
			down.setBounds(823, 579,  50,  50);
			
			left.addActionListener(new move(act, dados, left, right, up, down, 1));
			right.addActionListener(new move(act, dados, left, right, up, down, 2));
			up.addActionListener(new move(act, dados, left, right, up, down, 3));
			down.addActionListener(new move(act, dados, left, right, up, down, 4));			
			
			if(act.posx == 400 && act.posy == 36)
			{
				left.setEnabled(false);
				right.setEnabled(false);
				up.setEnabled(false);
			}
			//is_wall(act.posx, act.posy);		
			tabuleiro.add(left);
			tabuleiro.add(up);
			tabuleiro.add(down);
			tabuleiro.add(right);
			
		}
		//public boolean is_wall(int posx, int posy)
		{
			
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
			
			b1.setEnabled(true);
			fimt.setEnabled(false);
			RT.setEnabled(false);
			new turn(players[placeturn]);
			
		}
	}
	class Player{
		public int startx;//posicao no comeco da jogada
		public int starty;
		public int posx;//posicao atual
		public int posy;
		public JButton bb;
		public Color collo;
		public ArrayList<String> mao;
		public String cor;
		
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
		}
		
		
	}
	class move implements ActionListener {

		Player p;
		int f;
		JButton left;
		JButton right;
		JButton up;
		JButton down;
		
		
		public move(Player p1, int ncasas, JButton l,JButton r, JButton u, JButton d, int flag)
		{
			p = p1;
			left = l;
			right = r;
			up = u;
			down = d;
			f = flag;
			
			p1.posx = p.posx;
			p1.posy = p.posy;
			
			if(p.posx == 400 && p.posy == 61)
			{
				left.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 425 && p.posy == 61)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 450 && p.posy == 61)
			{
				right.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Parede direita da sala de musica */
			if(p.posx == 450 && p.posy >= 86 && p.posy <= 211)
			{
				left.setEnabled(false);
			}
			
			/* Parede inferior da sala de musica */
			if(p.posx >= 250 && p.posx <= 425 && p.posy == 236)
			{
				up.setEnabled(false);
			}
			
			/* Parede esquerda da sala de musica */
			if(p.posx == 225 && p.posy >= 86 && p.posy <= 211)
			{
				right.setEnabled(false);
			}
			
			if(p.posx == 225 && p.posy == 61)
			{
				up.setEnabled(false);
				left.setEnabled(false);
			}
			
			if(p.posx == 250 && p.posy == 61)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 275 && p.posy == 61)
			{
				up.setEnabled(false);
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 475 && p.posy == 86)
			{
				up.setEnabled(false);
				right.setEnabled(false);
			}
			
			/* Parede esquerda do jardim de inverno */
			if(p.posx == 475 && p.posy >= 111 && p.posy <= 136)
			{
				right.setEnabled(false);
			}
			
			if(p.posx == 500 && p.posy == 161)
			{
				up.setEnabled(false);
				right.setEnabled(false);
			}
			
			/* Parede inferior do jardim de inverno */
			if(p.posx >= 525 && p.posx <= 575 && p.posy == 186)
			{
				up.setEnabled(false);
			}
			
			if(p.posx == 600 && p.posy == 186)
			{
				right.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Parede superior do salao de jogos */
			if(p.posx >= 500 && p.posx <= 575 && p.posy == 211)
			{
				down.setEnabled(false);
			}
			
			if(p.posx == 600 && p.posy == 211)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede esquerda do salao de jogos */
			if(p.posx == 475 && p.posy >= 236 && p.posy <= 336)
			{
				right.setEnabled(false);
			}
			
			/* Parede inferior do salao de jogos/ Parede superior da biblioteca */
			if(p.posx >= 500 && p.posx <= 575 && p.posy == 361)
			{
				up.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 600 && p.posy == 361)
			{
				right.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
			}
			
			if(p.posx == 475 && p.posy == 386)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede esquerda da biblioteca */
			if(p.posx == 450 && p.posy >= 411 && p.posy <= 461)
			{
				right.setEnabled(false);
			}
			
			if(p.posx == 475 && p.posy == 486)
			{
				up.setEnabled(false);
				right.setEnabled(false);
			}
			
			/* Parede inferior da biblioteca */
			if(p.posx >= 500 && p.posx <= 575 && p.posy == 511)
			{
				up.setEnabled(false);
			}
			
			if(p.posx == 600 && p.posy == 511)
			{
				right.setEnabled(false);
				up.setEnabled(false);
			}
			
			/* Parede superior do escritorio */
			if(p.posx >= 475 && p.posx <= 575 && p.posy == 536)
			{
				down.setEnabled(false);
			}
			
			if(p.posx == 600 && p.posy == 536)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			/* Parede esquerda do escritorio */
			if(p.posx == 450 && p.posy >= 561 && p.posy <= 611)
			{
				right.setEnabled(false);
			}
			
			/* Parede direita da entrada */
			if(p.posx == 425 && p.posy >= 486 && p.posy <= 586)
			{
				left.setEnabled(false);
			}
			
			if(p.posx == 425 && p.posy == 611)
			{
				down.setEnabled(false);
				left.setEnabled(false);
			}
			
			/* Parede superior da entrada */
			if(p.posx >= 275 && p.posx <= 425 && p.posy == 461)
			{
				down.setEnabled(false);
			}
			
			/* Parede esquerda da entrada */
			if(p.posx == 275 && p.posy >= 486 && p.posy <= 586)
			{
				right.setEnabled(false);
			}
			
			if(p.posx == 275 && p.posy == 611)
			{
				right.setEnabled(false);
				down.setEnabled(false);
			}
			
			// Limite superior do tabuleiro
			if (p.posy-25 < 36){
				System.out.println("passou do limite superior 1:");
				up.setEnabled(false);
			}
			
			// Limite inferior do tabuleiro
			if (p.posy+25 > 638) {
				System.out.println("passou do limite inferior 1:");
				down.setEnabled(false);
			}
			
			// Limite do lado esquerdo do tabuleiro
			if (p.posx-25 < 50) {
				System.out.println("passou do limite esquerdo 1:");
				left.setEnabled(false);
			}
			
			// Limite do lado direito do tabuleiro
			if (p.posx+25 > 625) {
				System.out.println("passou do limite direito 1:");
				right.setEnabled(false);
			}
		}
		
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Dado no move:" + dados);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			if(dados > 0){
				
				if(p.posx == 400 && p.posy == 61)
				{
					left.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 425 && p.posy == 61)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 450 && p.posy == 61)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede direita da sala de musica */
				if(p.posx == 450 && p.posy >= 86 && p.posy <= 211)
				{
					left.setEnabled(false);
				}
				
				/* Parede inferior da sala de musica */
				if(p.posx >= 250 && p.posx <= 425 && p.posy == 236)
				{
					up.setEnabled(false);
				}
				
				/* Parede esquerda da sala de musica */
				if(p.posx == 225 && p.posy >= 86 && p.posy <= 211)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 225 && p.posy == 61)
				{
					up.setEnabled(false);
					left.setEnabled(false);
				}
				
				if(p.posx == 250 && p.posy == 61)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 275 && p.posy == 61)
				{
					up.setEnabled(false);
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 86)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede esquerda do jardim de inverno */
				if(p.posx == 475 && p.posy >= 111 && p.posy <= 136)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 500 && p.posy == 161)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede inferior do jardim de inverno */
				if(p.posx >= 525 && p.posx <= 575 && p.posy == 186)
				{
					up.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 186)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede superior do salao de jogos */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 211)
				{
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 211)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda do salao de jogos */
				if(p.posx == 475 && p.posy >= 236 && p.posy <= 336)
				{
					right.setEnabled(false);
				}
				
				/* Parede inferior do salao de jogos/ Parede superior da biblioteca */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 361)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 361)
				{
					right.setEnabled(false);
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 386)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda da biblioteca */
				if(p.posx == 450 && p.posy >= 411 && p.posy <= 461)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 486)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede inferior da biblioteca */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 511)
				{
					up.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 511)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede superior do escritorio */
				if(p.posx >= 475 && p.posx <= 575 && p.posy == 536)
				{
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 536)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda do escritorio */
				if(p.posx == 450 && p.posy >= 561 && p.posy <= 611)
				{
					right.setEnabled(false);
				}
				
				/* Parede direita da entrada */
				if(p.posx == 425 && p.posy >= 486 && p.posy <= 586)
				{
					left.setEnabled(false);
				}
				
				if(p.posx == 425 && p.posy == 611)
				{
					down.setEnabled(false);
					left.setEnabled(false);
				}
				
				/* Parede superior da entrada */
				if(p.posx >= 275 && p.posx <= 425 && p.posy == 461)
				{
					down.setEnabled(false);
				}
				
				/* Parede esquerda da entrada */
				if(p.posx == 275 && p.posy >= 486 && p.posy <= 586)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 275 && p.posy == 611)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				// Limite superior do tabuleiro
				if (p.posy-25 < 36){
					System.out.println("passou do limite superior 2:");
					up.setEnabled(false);
				}
				
				// Limite inferior do tabuleiro
				if (p.posy+25 > 638) {
					System.out.println("passou do limite inferior 2:");
					down.setEnabled(false);
				}
				
				// Limite do lado esquerdo do tabuleiro
				if (p.posx-25 < 50) {
					System.out.println("passou do limite esquerdo 2:");
					left.setEnabled(false);
				}
				
				// Limite do lado direito do tabuleiro
				if (p.posx+25 > 625) {
					System.out.println("passou do limite direito 2:");
					right.setEnabled(false);
				}
				
				if(f == 1)
				{
						left.setEnabled(true);
						p.bb.setBounds(p.posx-25, p.posy, 25, 23);
						p.posx = p.posx - 25;
				}
				if(f==2)
				{
						right.setEnabled(true);
						p.bb.setBounds(p.posx+25, p.posy, 25, 23);
						p.posx = p.posx + 25;
				}
				if(f==3)
				{	
					p.bb.setBounds(p.posx, p.posy-25, 25, 23);
					p.posy = p.posy-25;
				}
				if(f==4)
				{	
					p.bb.setBounds(p.posx, p.posy+25, 25, 23);
					p.posy = p.posy+25;
				}
				
				RT.setEnabled(true);
				p.bb.setBackground(p.collo);
				tabuleiro.remove(p.bb);
				dados -= 1;
				numpassos.setText("Numero de passos: " + dados);
				tabuleiro.add(p.bb);
				
				left.setEnabled(true);
				right.setEnabled(true);
				up.setEnabled(true);
				down.setEnabled(true);
				
				if(p.posx == 400 && p.posy == 61)
				{
					left.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 425 && p.posy == 61)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 450 && p.posy == 61)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede direita da sala de musica */
				if(p.posx == 450 && p.posy >= 86 && p.posy <= 211)
				{
					left.setEnabled(false);
				}
				
				/* Parede inferior da sala de musica */
				if(p.posx >= 250 && p.posx <= 425 && p.posy == 236)
				{
					up.setEnabled(false);
				}
				
				/* Parede esquerda da sala de musica */
				if(p.posx == 225 && p.posy >= 86 && p.posy <= 211)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 225 && p.posy == 61)
				{
					up.setEnabled(false);
					left.setEnabled(false);
				}
				
				if(p.posx == 250 && p.posy == 61)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 275 && p.posy == 61)
				{
					up.setEnabled(false);
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 86)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede esquerda do jardim de inverno */
				if(p.posx == 475 && p.posy >= 111 && p.posy <= 136)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 500 && p.posy == 161)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede inferior do jardim de inverno */
				if(p.posx >= 525 && p.posx <= 575 && p.posy == 186)
				{
					up.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 186)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede superior do salao de jogos */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 211)
				{
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 211)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda do salao de jogos */
				if(p.posx == 475 && p.posy >= 236 && p.posy <= 336)
				{
					right.setEnabled(false);
				}
				
				/* Parede inferior do salao de jogos/ Parede superior da biblioteca */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 361)
				{
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 361)
				{
					right.setEnabled(false);
					up.setEnabled(false);
					down.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 386)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda da biblioteca */
				if(p.posx == 450 && p.posy >= 411 && p.posy <= 461)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 475 && p.posy == 486)
				{
					up.setEnabled(false);
					right.setEnabled(false);
				}
				
				/* Parede inferior da biblioteca */
				if(p.posx >= 500 && p.posx <= 575 && p.posy == 511)
				{
					up.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 511)
				{
					right.setEnabled(false);
					up.setEnabled(false);
				}
				
				/* Parede superior do escritorio */
				if(p.posx >= 475 && p.posx <= 575 && p.posy == 536)
				{
					down.setEnabled(false);
				}
				
				if(p.posx == 600 && p.posy == 536)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				/* Parede esquerda do escritorio */
				if(p.posx == 450 && p.posy >= 561 && p.posy <= 611)
				{
					right.setEnabled(false);
				}
				
				/* Parede direita da entrada */
				if(p.posx == 425 && p.posy >= 486 && p.posy <= 586)
				{
					left.setEnabled(false);
				}
				
				if(p.posx == 425 && p.posy == 611)
				{
					down.setEnabled(false);
					left.setEnabled(false);
				}
				
				/* Parede superior da entrada */
				if(p.posx >= 275 && p.posx <= 425 && p.posy == 461)
				{
					down.setEnabled(false);
				}
				
				/* Parede esquerda da entrada */
				if(p.posx == 275 && p.posy >= 486 && p.posy <= 586)
				{
					right.setEnabled(false);
				}
				
				if(p.posx == 275 && p.posy == 611)
				{
					right.setEnabled(false);
					down.setEnabled(false);
				}
				
				// Limite superior do tabuleiro
				if (p.posy-25 < 36){
					System.out.println("passou do limite superior 3:");
					up.setEnabled(false);
				}
				
				// Limite inferior do tabuleiro
				if (p.posy+25 > 638) {
					System.out.println("passou do limite inferior 3:" + p.posy);
					down.setEnabled(false);
				}
				
				// Limite do lado esquerdo do tabuleiro
				if (p.posx-25 < 50) {
					System.out.println("passou do limite esquerdo 3:");
					left.setEnabled(false);
				}
				
				// Limite do lado direito do tabuleiro
				if (p.posx+25 > 625) {
					System.out.println("passou do limite direito 3:");
					right.setEnabled(false);
				}
				
				tabuleiro.revalidate();
				tabuleiro.repaint();
				
				if(dados==0)
				{
					tabuleiro.remove(left);
					tabuleiro.remove(up);
					tabuleiro.remove(down);
					tabuleiro.remove(right);
					fimt.setEnabled(true);
					tabuleiro.revalidate();
					tabuleiro.repaint();
					
				}
			}
			
		}
	
	}
	class Reset implements ActionListener {
		
		public Reset()
		{
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(dados == 0)
			{
				JButton left = new JButton("←");
				JButton up = new JButton("↑");
				JButton down = new JButton("↓");
				JButton right = new JButton("→");			
				
				left.setBounds(773, 579,  50,  50);
				right.setBounds(873, 579,  50,  50);
				up.setBounds(823, 529,  50,  50);
				down.setBounds(823, 579,  50,  50);
				
				left.addActionListener(new move(players[placeturn], dados, left, right, up, down, 1));
				right.addActionListener(new move(players[placeturn], dados, left, right, up, down, 2));
				up.addActionListener(new move(players[placeturn], dados, left, right, up, down, 3));
				down.addActionListener(new move(players[placeturn], dados, left, right, up, down, 4));
				tabuleiro.add(left);
				tabuleiro.add(right);
				tabuleiro.add(up);
				tabuleiro.add(down);
			}
			players[placeturn].posx = players[placeturn].startx;
			players[placeturn].posy = players[placeturn].starty;
			dados = dados_ini;
			players[placeturn].bb.setBounds(players[placeturn].posx, players[placeturn].posy, 25, 23);
			players[placeturn].bb.setBackground(players[placeturn].collo);
			tabuleiro.remove(players[placeturn].bb);
			numpassos.setText("Numero de passos: " + dados);
			tabuleiro.add(players[placeturn].bb);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			
		}

	}
	
	
	class imagem extends JPanel {
		public static final int TXT_X = 700;
		public static final int TXT_Y = 703;
		
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
		numpassos.setText("Numero de passos: " + dados);
		
		//numpassos.setText("Numero de passos: " + total);
		//showdice l = new showdice("Dado", d1);
		//showdice l2 = new showdice("Dado2", d2);
		//Insets ins = l.getInsets();
		//l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		//l.setVisible(true);
		//l2.setVisible(true);
		
		
		b1.setEnabled(false);
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
			System.out.println("oi1");
		}
		System.out.println("oi2");
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





