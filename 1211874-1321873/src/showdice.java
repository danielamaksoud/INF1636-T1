import java.awt.GridLayout;
import javax.swing.JFrame;

public class showdice extends JFrame{

	backgroundimage tela;
	
	public showdice(String nome, int n) {
		super(nome);
		ShowImage(n);
		this.setResizable(false);
	}
	
	void ShowImage (int n){
		setLayout(new GridLayout(1,1));
		
		if (n == 2) {
			tela = new backgroundimage("dado2.jpg");
		}
		if (n == 3) {
			tela = new backgroundimage("dado3.jpg");
		}
		if (n == 4) {
			tela = new backgroundimage("dado4.jpg");
		}
		if (n == 5) {
			tela = new backgroundimage("dado5.jpg");
		}
		if (n == 6) {
			tela = new backgroundimage("dado6.jpg");
		}
		if (n == 7) {
			tela = new backgroundimage("dice.gif");
		}
		if (n == 8) {
			tela = new backgroundimage("dice.gif");
		}
		if (n == 9) {
			tela = new backgroundimage("dice.gif");
		}
		if (n == 10) {
			tela = new backgroundimage("dice.gif");
		}
		if (n == 11) {
			tela = new backgroundimage("dice.gif");
		}
		if (n == 12) {
			tela = new backgroundimage("dice.gif");
		}
		
		getContentPane().add(tela);

	}
	
}


