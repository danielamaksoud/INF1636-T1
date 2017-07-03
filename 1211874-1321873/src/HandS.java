import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HandS extends JFrame{

	backgroundimage tela;
	
	public HandS(String nome, ArrayList<String> mao, int numcar) {
		super(nome);
		JFrame j = new JFrame();
		tela = new backgroundimage(mao.get(numcar)+".jpg");
		getContentPane().add(tela);
		j.pack();

		
	}

	private Image getImage(URL url) {
		// TODO Auto-generated method stub
		return null;
	}

}