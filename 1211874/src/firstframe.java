import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class firstframe extends JFrame {
	
	FundoBg tela;
	
	public firstframe(String s) {
		super(s);
		Dimension size;
		JButton b1, b2; /* Botoes */
		JFrame j = new JFrame(); /* Janela */
		
		/* IMAGEM DE FUNDO */ 
		
		setLayout(new GridLayout(1,1));
		tela = new FundoBg("firstframe.png");
		getContentPane().add(tela);
		
		/* BOTAO NOVO JOGO */
		
		b1 = new JButton("Novo Jogo");
		b1.addActionListener(new newgame(this));
		tela.add(b1);
		size = b1.getPreferredSize();
		b1.setBounds(220, 144, size.width + 50, size.height + 10);
		b1.setToolTipText("Voce acha que consegue descobrir o assassino?");
		
		/* BOTAO CARREGAR JOGO SALVO */
		
		b2 = new JButton("Carregar Jogo Salvo");
		b2.addActionListener(new choosefile(this));
		tela.add(b2);
		size = b2.getPreferredSize();
		b2.setBounds(191, 195, size.width + 50, size.height + 10);
		b2.setToolTipText("Reabrindo um caso antigo?");
		
		j.pack();
	}

}