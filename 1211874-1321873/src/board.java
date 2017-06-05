import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class board extends JFrame {
	
	backgroundimage tabuleiro;

	final JButton b1 = new JButton("Jogar Dados");
	final JButton fimt = new JButton("Finalizar Turno");
	final JButton b2 = new JButton("");
	final JButton b3 = new JButton("");
	final JButton b4 = new JButton("");
	final JButton b5 = new JButton("");
	final JButton b6 = new JButton("");
	final JButton b7 = new JButton("");
	int numplayers = 0;
	int placeturn = 0;
	
	
	public board(String nome, int i1, int i2, int i3, int i4, int i5, int i6) {
		super(nome);
	
		setLayout(new GridLayout(0,1));
		
		tabuleiro = new backgroundimage("Tabuleiro-Original.JPG");
		
		getContentPane().add(tabuleiro);
		
		this.setResizable(false);
		
		Dimension size;
		// Pinos dos jogadores
		
		
		b1.addActionListener(new RollDice(this));
		size = b1.getPreferredSize();
		b1.setBounds(758, 119, size.width + 50, size.height + 10);
		fimt.setBounds(758,159, size.width+50, size.height + 10 );
		
		size = b2.getPreferredSize();
		b2.setBounds(400, 36, 25, 23); // Esta na posicao inicial
		b2.setBackground(Color.GREEN);
		size = b3.getPreferredSize();
		b3.setBounds(275, 36, 25, 23);
		b3.setBackground(Color.WHITE);
		size = b4.getPreferredSize();
		b4.setBounds(625, 511, 25, 23);
		b4.setBackground(Color.MAGENTA);
		size = b5.getPreferredSize();
		b5.setBounds(625, 186, 25, 23);
		b5.setBackground(Color.BLUE);
		size = b6.getPreferredSize();
		b6.setBounds(50, 459, 25, 23);
		b6.setBackground(Color.YELLOW);
		size = b7.getPreferredSize();
		b7.setBounds(225, 634, 25, 23);
		b7.setBackground(Color.RED);
		tabuleiro.add(b1);
		tabuleiro.add(fimt);
		if(i1 == 1)
		{
			tabuleiro.add(b2);
			b2.setEnabled(false);
			numplayers ++;
		}
		if(i2==1)
		{
			tabuleiro.add(b3);
			b3.setEnabled(false);
			numplayers ++;
		}
		if(i3==1)
		{
			tabuleiro.add(b4);
			b4.setEnabled(false);
			numplayers ++;
		}
		if(i4==1)
		{
			tabuleiro.add(b5);
			b5.setEnabled(false);
			numplayers ++;
		}
		if(i5==1)
		{
			tabuleiro.add(b6);
			b6.setEnabled(false);
			numplayers ++;
		}
		if(i6==1)
		{
			tabuleiro.add(b7);
			b7.setEnabled(false);
			numplayers ++;
		}
		//altura do quadrado 25
		//largura do quadrado 25
		
		
		
		setVisible(true);
	}
	
	class turn
	{
		void turn(JButton b, int posx, int posy, int dicenum)
		{
			JButton left = new JButton("esquerda");
			JButton up = new JButton("cima");
			JButton down = new JButton("baixo");
			JButton right = new JButton("direita");
			left.setBounds(posx-25, posy+0,  50,  10);
			right.setBounds(posx+25, posy+0,  50,  10);
			up.setBounds(posx-0, posy-25,  50,  10);
			down.setBounds(posx-0, posy+25,  50,  10);
			tabuleiro.add(left);
			tabuleiro.add(up);
			tabuleiro.add(down);
			tabuleiro.add(right);
			
		}
	}
	class mleft implements ActionListener {

		Component c;
		JButton b;
		int posx;
		int posy;
		
		public mleft(Component x, JButton p, int px, int py)
		{
			c = x;
			b = p;
			posx = px;
			posy = py;
		}
		public void actionPerformed(ActionEvent e)
		{
			b.setBounds(posx-25, posy, 25, 23);
			tabuleiro.remove(b);
			tabuleiro.add(b);
			
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


