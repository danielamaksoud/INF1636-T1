import javax.swing.*;
import java.awt.*;

public class firstframe extends JFrame {
	
	backgroundimage tela;
	
	public firstframe(String s) {
		
		super(s);
		Dimension size;
		
		/* Botoes */
		JButton b1, b2;
		
		/* Janela */
		JFrame j = new JFrame();
		
		/* Bloqueia redimensionamento da janela */
		this.setResizable(false);
		
		/* IMAGEM DE FUNDO */ 
		setLayout(new GridLayout(1,1));
		tela = new backgroundimage("Fundo1.png");
		getContentPane().add(tela);
		Insets ins = tela.getInsets();
		setSize(600 + ins.left, 400 + ins.top);
		
		/* BOTAO NOVO JOGO */
		b1 = new JButton("Novo Jogo");
		b1.addActionListener(new newgame(this));
		tela.add(b1);
		size = b1.getPreferredSize();
		b1.setBounds(191, 144, size.width + 109, size.height + 10);
		b1.setToolTipText("Voce acha que consegue descobrir o assassino?");
		
		/* BOTAO CARREGAR JOGO SALVO */
		b2 = new JButton("Carregar Jogo Salvo");
		b2.addActionListener(new choosefile(this));
		tela.add(b2);
		size = b2.getPreferredSize();
		b2.setBounds(191, 195, size.width + 52, size.height + 10);
		b2.setToolTipText("Reabrindo um caso antigo?");
		
		j.pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}