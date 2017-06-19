import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class showHand extends JFrame{

	ArrayList<String> m;
	backgroundimage tela;
	
	public showHand(String nome, ArrayList<String> mao) {
		super(nome);
		m = mao;
		ShowScreen();
		this.setResizable(false);
	}
	
	void ShowScreen (){
		setLayout(new GridLayout(1,1));
		
		tela = new backgroundimage("dado2.jpg");

		System.out.println(m);
		
		getContentPane().add(tela);

	}
	
}


