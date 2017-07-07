import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;

//import board.move;

public class secretPassage implements ActionListener {

	backgroundimage t;
	JButton ps;
	JButton rt;
	
	public secretPassage(int posx, int posy, backgroundimage tabuleiro, JButton passagemSecreta, JButton refazerTurno)
	{
		t = tabuleiro;
		ps = passagemSecreta;
		rt = refazerTurno;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		t.revalidate();
		t.repaint();
		ps.setEnabled(false);
		rt.setEnabled(false);
	}
	
}
