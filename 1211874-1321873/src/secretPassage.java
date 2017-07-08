import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;

//import board.move;

public class secretPassage implements ActionListener {

	backgroundimage t;
	JButton ps;
	JButton rt;
	int x, y;
	
	public secretPassage(int posx, int posy, backgroundimage tabuleiro, JButton passagemSecreta, JButton refazerTurno)
	{
		t = tabuleiro;
		ps = passagemSecreta;
		rt = refazerTurno;
		x = posx;
		y = posy;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(x == 159 && y == 151) // Entrou na cozinha
		{
			x = 495;
			y = 535;
		}
		if(x == 495 && y == 535) // Entrou no escritorio
		{
			x = 159;
			y = 151;
		}
		
		if(x == 543 && y == 151) // Entrou no jardim de inverno
		{
			x = 159;
			y = 487;
		}
		if(x == 159 && y == 487) // Entrou na sala de estar
		{
			x = 542;
			y = 151;
		}
		
		t.revalidate();
		t.repaint();
		ps.setEnabled(false);
		rt.setEnabled(false);
		
		System.out.println("oie");
	}
	
}
