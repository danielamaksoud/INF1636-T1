import java.awt.GridLayout;
import javax.swing.JFrame;

public class showHand extends JFrame{

	backgroundimage tela;
	
	public showHand(String nome) {
		super(nome);
		ShowScreen();
		this.setResizable(false);
	}
	
	void ShowScreen (){
		setLayout(new GridLayout(1,1));
		
		tela = new backgroundimage("dado2.jpg");
		
		getContentPane().add(tela);

	}
	
}


