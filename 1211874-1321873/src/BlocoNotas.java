import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BlocoNotas extends JFrame{
	
	backgroundimage tela;
	public BlocoNotas(String nome, ArrayList<JCheckBox> suspeitos, ArrayList<JCheckBox> armas, ArrayList<JCheckBox> comodos) {
	
		super(nome);
		
		/* Bloqueia redimensionamento da janela */
		this.setResizable(false);
		
		/* IMAGEM DE FUNDO */ 
		setLayout(new GridLayout(1,3));
		tela = new backgroundimage("Fundo3.png");
		 
		getContentPane().add(tela);
		int i = 0;
		for(i = 0; i<6; i++)
		{
			tela.add(suspeitos.get(i));
			tela.add(armas.get(i));
			tela.add(comodos.get(i));
		}
		tela.add(comodos.get(6));
		tela.add(comodos.get(7));
		tela.add(comodos.get(8));

		Insets ins = tela.getInsets();	
		setSize(600 + ins.left, 400 + ins.top);
		setVisible(true);

		
	}

}