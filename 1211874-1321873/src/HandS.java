import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

public class HandS extends JFrame{

	backgroundimage tela;
	
	public HandS(String nome, ArrayList<String> mao) {
		super(nome);
		int i = 0;
		String buffer;
		setLayout(new GridLayout(1,1));
		this.setResizable(false);
		while((buffer = mao.get(i)) != null)
		{
			//Image img = new Image();
		}
		
	}

}