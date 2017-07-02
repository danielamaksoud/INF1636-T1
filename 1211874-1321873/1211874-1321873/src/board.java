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
	final JButton mm = new JButton("Mostrar m�o");
	final JButton bloco = new JButton("Bloco de Notas");
	final JButton palp = new JButton("Dar Palpite");
	final JButton JACUSE = new JButton("Acusar!");
	final JButton RT = new JButton("Refazer Turno");
	final JButton numpassos = new JButton("N�mero de passos: " + numpas);
	final JButton b2 = new JButton("");
	final JButton b3 = new JButton("");
	final JButton b4 = new JButton("");
	final JButton b5 = new JButton("");
	final JButton b6 = new JButton("");
	final JButton b7 = new JButton("");
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
		
		Dimension size;
		// Pinos dos jogadores
		
		b1.addActionListener(new RollDice(dados));
		System.out.println("dados no turn" + dados);
		size = b1.getPreferredSize();
		b1.setBounds(758, 119, size.width + 50, size.height + 10);
		fimt.setBounds(758,159, size.width+50, size.height + 10 );
		mm.setBounds(758,199, size.width+50, size.height + 10 );
		bloco.setBounds(758,239, size.width+50, size.height + 10 );
		RT.setBounds(758,359, size.width+50, size.height + 10 );
		palp.setBounds(758,319, size.width+50, size.height + 10 );
		JACUSE.setBounds(758,279, size.width+50, size.height + 10 );
		numpassos.setBounds(758, 409, size.width+50, size.height + 10 );
		
		numpassos.setEnabled(false);
		
		
		fimt.addActionListener(new PassTurn(this));
		
		
		tabuleiro.add(b1);
		tabuleiro.add(fimt);
		tabuleiro.add(mm);
		tabuleiro.add(bloco);
		tabuleiro.add(RT);
		tabuleiro.add(palp);
		tabuleiro.add(JACUSE);
		tabuleiro.add(numpassos);
		
		if(i1 == 1)
		{
			size = b2.getPreferredSize();
			b2.setBounds(400, 36, 25, 23); // Esta na posicao inicial
			b2.setBackground(Color.GREEN);
			tabuleiro.add(b2);
			b2.setEnabled(false);
			ArrayList<String> l1 = new ArrayList<String>();
			players[ord] = new Player(400, 36, b2, Color.GREEN, l1);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i6 == 1)
		{
			size = b3.getPreferredSize();
			b3.setBounds(275, 36, 25, 23);
			b3.setBackground(Color.WHITE);
			tabuleiro.add(b3);
			b3.setEnabled(false);
			ArrayList<String> l2 = new ArrayList<String>();
			players[ord] = new Player(275, 36, b3, Color.WHITE, l2);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i4 == 1)
		{
			size = b4.getPreferredSize();
			b4.setBounds(625, 511, 25, 23);
			b4.setBackground(Color.MAGENTA);
			tabuleiro.add(b4);
			b4.setEnabled(false);
			ArrayList<String> l3 = new ArrayList<String>();
			players[ord] = new Player(625, 511, b4, Color.MAGENTA, l3);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i3 == 1)
		{
			size = b5.getPreferredSize();
			b5.setBounds(625, 186, 25, 23);
			b5.setBackground(Color.BLUE);
			tabuleiro.add(b5);
			b5.setEnabled(false);
			ArrayList<String> l4 = new ArrayList<String>();
			players[ord] = new Player(625, 186, b5, Color.BLUE, l4);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i2 == 1)
		{
			size = b6.getPreferredSize();
			b6.setBounds(50, 459, 25, 23);
			b6.setBackground(Color.YELLOW);
			tabuleiro.add(b6);
			b6.setEnabled(false);
			ArrayList<String> l5 = new ArrayList<String>();
			players[ord] = new Player(50, 459, b6, Color.YELLOW, l5);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		if(i5 == 1)
		{
			size = b7.getPreferredSize();
			b7.setBounds(225, 634, 25, 23);
			b7.setBackground(Color.RED);
			tabuleiro.add(b7);
			b7.setEnabled(false);
			ArrayList<String> l6 = new ArrayList<String>();
			players[ord] = new Player(225, 634, b7, Color.RED, l6);
			//tabuleiro.add(players[ord].bb);
			ord+=1;
		}
		fimt.setEnabled(false);
		new turn(players[0]);
		
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
			left = new JButton("E");
			up = new JButton("C");
			down = new JButton("B");
			right = new JButton("D");			
			
			left.setBounds(758, 559,  50,  50);
			right.setBounds(858, 559,  50,  50);
			up.setBounds(808, 509,  50,  50);
			down.setBounds(808, 559,  50,  50);
			
			left.addActionListener(new move(act, dados, left, right, up, down, 1));
			right.addActionListener(new move(act, dados, left, right, up, down, 2));
			up.addActionListener(new move(act, dados, left, right, up, down, 3));
			down.addActionListener(new move(act, dados, left, right, up, down, 4));
			if(act.posx==400 && act.posy==36)
			{
				left.setVisible(false);
				right.setVisible(false);
				up.setVisible(false);
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
			if(placeturn==numbplayers-1)
			{
				placeturn = 0;
			}
			else
			{
				placeturn +=1;
			}		
			b1.setEnabled(true);
			fimt.setEnabled(false);
			new turn(players[placeturn]);
			
		}
	}
	class Player{
		public int posx;
		public int posy;
		public JButton bb;
		public Color collo;
		public ArrayList<String> mao;
		
		public Player(int startx, int starty, JButton ba, Color col, ArrayList<String> m)
		{
			posx = startx;
			posy = starty;
			bb = ba;
			collo = col;
			mao = m;
		}
		
		
	}
	class move implements ActionListener {

		Player p;
		int f;
		JButton left;
		JButton right;
		JButton up;
		JButton down;
		
		
		public move( Player p1, int ncasas, JButton l,JButton r, JButton u, JButton d, int flag)
		{
			p = p1;
			left = l;
			right = r;
			up = u;
			down = d;
			f = flag;
		}
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("dado no move:" + dados);
			tabuleiro.revalidate();
			tabuleiro.repaint();
			if(f==1)
			{
				p.bb.setBounds(p.posx-25, p.posy, 25, 23);
				p.posx = p.posx - 25;
			}
			if(f==2)
			{
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
			p.bb.setBackground(p.collo);
			tabuleiro.remove(p.bb);
			dados -= 1;
			numpassos.setText("N�mero de passos: " + dados);
			tabuleiro.add(p.bb);
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
		numpassos.setText("N�mero de passos: " + dados);
		
		//numpassos.setText("N�mero de passos: " + total);
		//showdice l = new showdice("Dado", d1);
		//showdice l2 = new showdice("Dado2", d2);
		//Insets ins = l.getInsets();
		//l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		//l.setVisible(true);
		//l2.setVisible(true);
		
		
		b1.setEnabled(false);
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

