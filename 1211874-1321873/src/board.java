import javax.swing.*;
import java.math.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class board extends JFrame {
	
	backgroundimage tabuleiro;

	
	final JButton b1 = new JButton("Jogar Dados");
	final JButton fimt = new JButton("Finalizar Turno");
	final JButton mm = new JButton("Mostrar mao");
	final JButton b2 = new JButton("");
	final JButton b3 = new JButton("");
	final JButton b4 = new JButton("");
	final JButton b5 = new JButton("");
	final JButton b6 = new JButton("");
	final JButton b7 = new JButton("");
	int placeturn = 0;
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
		
		
		b1.addActionListener(new RollDice(this));
		size = b1.getPreferredSize();
		b1.setBounds(758, 119, size.width + 50, size.height + 10);
		fimt.setBounds(758,159, size.width+50, size.height + 10 );
		mm.setBounds(758,199, size.width+50, size.height + 10 );
		
		/* mm.addActionListener(new hand(this, players[placeturn].mao)); */
		fimt.addActionListener(new PassTurn(this));
		

		tabuleiro.add(b1);
		tabuleiro.add(fimt);
		tabuleiro.add(mm);
		
		if(i1 == 1)
		{
			size = b2.getPreferredSize();
			b2.setBounds(400, 36, 25, 23); // Esta na posicao inicial
			b2.setBackground(Color.GREEN);
			tabuleiro.add(b2);
			b2.setEnabled(false);
			ArrayList<String> l1 = new ArrayList<String>();
			players[ord] = new Player(400, 36, b2, Color.GREEN, l1);
			ord+=1;
		}
		if(i2 == 1)
		{
			size = b3.getPreferredSize();
			b3.setBounds(275, 36, 25, 23);
			b3.setBackground(Color.WHITE);
			tabuleiro.add(b3);
			b3.setEnabled(false);
			ArrayList<String> l2 = new ArrayList<String>();
			players[ord] = new Player(275, 36, b3, Color.WHITE, l2);
			ord+=1;
		}
		if(i3 == 1)
		{
			size = b4.getPreferredSize();
			b4.setBounds(625, 511, 25, 23);
			b4.setBackground(Color.MAGENTA);
			tabuleiro.add(b4);
			b4.setEnabled(false);
			ArrayList<String> l3 = new ArrayList<String>();
			players[ord] = new Player(625, 511, b3, Color.MAGENTA, l3);
			ord+=1;
		}
		if(i4 == 1)
		{
			size = b5.getPreferredSize();
			b5.setBounds(625, 186, 25, 23);
			b5.setBackground(Color.BLUE);
			tabuleiro.add(b5);
			b5.setEnabled(false);
			ArrayList<String> l4 = new ArrayList<String>();
			players[ord] = new Player(625, 186, b3, Color.BLUE, l4);
			ord+=1;
		}
		if(i5 == 1)
		{
			size = b6.getPreferredSize();
			b6.setBounds(50, 459, 25, 23);
			b6.setBackground(Color.YELLOW);
			tabuleiro.add(b6);
			b6.setEnabled(false);
			ArrayList<String> l5 = new ArrayList<String>();
			players[ord] = new Player(50, 459, b3, Color.YELLOW, l5);
			ord+=1;
		}
		if(i6 == 1)
		{
			size = b7.getPreferredSize();
			b7.setBounds(225, 634, 25, 23);
			b7.setBackground(Color.RED);
			tabuleiro.add(b7);
			b7.setEnabled(false);
			ArrayList<String> l6 = new ArrayList<String>();
			players[ord] = new Player(225, 634, b3, Color.RED, l6);
			ord+=1;
		}
		
		//altura do quadrado 25
		//largura do quadrado 25
		/* ArrayList<String> m1 = new ArrayList<String>();
		ArrayList<String> m2 = new ArrayList<String>();
		ArrayList<String> m3 = new ArrayList<String>();
		ArrayList<String> m4 = new ArrayList<String>();
		ArrayList<String> m5 = new ArrayList<String>();
		ArrayList<String> m6 = new ArrayList<String>();
		
		if(numplayers == 3)
		{
			while (m1 == null){
				if (i1 == 1)
				{
					m1 = players[0].mao;
				}
				else if (i2 == 1)
				{
					m1 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m1 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m1 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m1 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m1 = players[5].mao;
				}
			}
			while (m2 == null){
				if (i2 == 1)
				{
					m2 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m2 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m2 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m2 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m2 = players[5].mao;
				}
			}
			while (m3 == null){
				if (i3 == 1)
				{
					m3 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m3 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m3 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m3 = players[5].mao;
				}
			}
			
			new assassin(3, m1, m2, m3);
		}
		else if(numplayers == 4)
		{
			while (m1 == null){
				if (i1 == 1)
				{
					m1 = players[0].mao;
				}
				else if (i2 == 1)
				{
					m1 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m1 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m1 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m1 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m1 = players[5].mao;
				}
			}
			while (m2 == null){
				if (i2 == 1)
				{
					m2 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m2 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m2 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m2 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m2 = players[5].mao;
				}
			}
			while (m3 == null){
				if (i3 == 1)
				{
					m3 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m3 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m3 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m3 = players[5].mao;
				}
			}
			while (m4 == null){
				if (i4 == 1)
				{
					m4 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m4 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m4 = players[5].mao;
				}
			}
			
			new assassin(4, m1, m2, m3, m4);
		}
		else if(numplayers == 5)
		{
			while (m1 == null){
				if (i1 == 1)
				{
					m1 = players[0].mao;
				}
				else if (i2 == 1)
				{
					m1 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m1 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m1 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m1 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m1 = players[5].mao;
				}
			}
			while (m2 == null){
				if (i2 == 1)
				{
					m2 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m2 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m2 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m2 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m2 = players[5].mao;
				}
			}
			while (m3 == null){
				if (i3 == 1)
				{
					m3 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m3 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m3 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m3 = players[5].mao;
				}
			}
			while (m4 == null){
				if (i4 == 1)
				{
					m4 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m4 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m4 = players[5].mao;
				}
			}
			while (m5 == null){
				if (i5 == 1)
				{
					m4 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m4 = players[5].mao;
				}
			}
			
			new assassin(5, m1, m2, m3, m4, m5);
		}
		else if(numplayers == 6)
		{
			while (m1 == null){
				if (i1 == 1)
				{
					m1 = players[0].mao;
				}
				else if (i2 == 1)
				{
					m1 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m1 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m1 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m1 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m1 = players[5].mao;
				}
			}
			while (m2 == null){
				if (i2 == 1)
				{
					m2 = players[1].mao;
				}
				else if (i3 == 1)
				{
					m2 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m2 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m2 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m2 = players[5].mao;
				}
			}
			while (m3 == null){
				if (i3 == 1)
				{
					m3 = players[2].mao;
				}
				else if (i4 == 1)
				{
					m3 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m3 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m3 = players[5].mao;
				}
			}
			while (m4 == null){
				if (i4 == 1)
				{
					m4 = players[3].mao;
				}
				else if (i5 == 1)
				{
					m4 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m4 = players[5].mao;
				}
			}
			while (m5 == null){
				if (i5 == 1)
				{
					m4 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m4 = players[5].mao;
				}
			}
			while (m6 == null){
				if (i5 == 1)
				{
					m6 = players[4].mao;
				}
				else if (i6 == 1)
				{
					m6 = players[5].mao;
				}
			}
			
			new assassin(6, m1, m2, m3, m4, m5, m6);
		} */
		
		setVisible(true);
	}
	
	class turn
	{
		public JButton left;
		public JButton up;
		public JButton down;
		public JButton right;
		turn(Player act)
		{
			left = new JButton("esquerda");
			up = new JButton("cima");
			down = new JButton("baixo");
			right = new JButton("direita");
			
			left.setBounds(act.posx-100, act.posy+50,  50,  25);
			right.setBounds(act.posx+100, act.posy+50,  50,  25);
			up.setBounds(act.posx-0, act.posy-50,  50,  25);
			down.setBounds(act.posx-0, act.posy+50,  50,  25);
			
			left.addActionListener(new mleft(act));
			right.addActionListener(new mright(act));
			up.addActionListener(new mup(act));
			down.addActionListener(new mdown(act));
			left.addActionListener(new adjustbb());
			right.addActionListener(new adjustbb());
			up.addActionListener(new adjustbb());
			down.addActionListener(new adjustbb());
			
			tabuleiro.add(left);
			tabuleiro.add(up);
			tabuleiro.add(down);
			tabuleiro.add(right);
			
		}
		public void passed()
		{
			
		}
		class adjustbb implements ActionListener
		{
			
			
			public adjustbb()
			{
			}
			public void actionPerformed(ActionEvent e)
			{
				
			}
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
			
			if(placeturn==numbplayers)
			{
				placeturn = 0;
			}
			else
			{
				placeturn +=1;
			}
			System.out.println("passou a vez");
			
					
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
	class mleft implements ActionListener {

		Player p;
		
		
		public mleft( Player p1)
		{
			p = p1;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton n = new JButton();
			n = p.bb;
			
			n.setBounds(p.posx-25, p.posy, 25, 23);
			n.setBackground(p.collo);
			tabuleiro.remove(p.bb);
			
			tabuleiro.add(n);
			p.bb = n;
			
		}
	}
	
	class mup implements ActionListener {

		Player p;
		
		public mup(Player p1)
		{
			p = p1;
		}
		public void actionPerformed(ActionEvent e)
		{
			
			JButton n = new JButton();
			n = p.bb;
			n.setBounds(p.posx, p.posy-25, 25, 23);
			n.setBackground(p.collo);
			tabuleiro.remove(p.bb);
			tabuleiro.add(n);			
			p.bb = n;
			
		}
	}
	
	class mdown implements ActionListener {

		Player p;
		
		public mdown(Player p1)
		{
			p = p1;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton n = new JButton();
			n = p.bb;
			n.setBounds(p.posx, p.posy+25, 25, 23);
			n.setBackground(p.collo);
			tabuleiro.remove(p.bb);
			tabuleiro.add(n);
			p.bb = n;
			
		}
	}
	
	class mright implements ActionListener {

		Player p;
		
		public mright(Player p1)
		{
			p = p1;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton n = new JButton();
			n = p.bb;
			n.setBounds(p.posx+25, p.posy, 25, 23);
			n.setBackground(p.collo);
			tabuleiro.remove(p.bb);
			tabuleiro.add(n);
			p.bb = n;
			
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

	Component c;
	
	public RollDice(Component x)
	{
		c = x;
	}
	public void actionPerformed(ActionEvent e)
	{
		Dices l = new Dices("Dados");
		Insets ins = l.getInsets();
		l.setSize(320 + ins.left + ins.right, 260 + ins.top + ins.bottom);
		l.setVisible(true);
	}
}
}

class Dices extends JFrame{
	
	public Dices(String nome)
	{
		super(nome);
		JPanel p = new JPanel();
		getContentPane().add(p);
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new pressdice(this, 2));
		
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


