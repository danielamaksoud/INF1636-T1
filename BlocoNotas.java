import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BlocoNotas extends JFrame{
	
	backgroundimage tela;
	public BlocoNotas(String nome, ArrayList<JCheckBox> blocos, int numbox) {
		super(nome);
		tela = new backgroundimage("Cozinha.jpg");
		JFrame j = new JFrame();
		getContentPane().add(tela);
		int i = 0;
		while(i<numbox)
		{
			JCheckBox b = new JCheckBox();
			b = blocos.get(i);
			b.setBounds(34, 52+(i*30), 200, 30);
			tela.add(b);
		}
		j.pack();

		

		
	}

}