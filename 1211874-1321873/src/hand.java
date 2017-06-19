import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class hand implements ActionListener {
	
	Component c;
	ArrayList<String> m;
	
	public hand(Component x, ArrayList<String> mao)
	{
		c = x;	
		m = mao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		c.setVisible(true);	
		
		showHand l = new showHand("Mao do Jogador", m);
		Insets ins = l.getInsets();
		l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		l.setVisible(true);
	}

}
