import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class hand implements ActionListener {
	
	Component c;
	
	public hand(Component x, ArrayList<String> mao)
	{
		c = x;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		c.setVisible(true);	
		
		showHand l = new showHand("Mao do Jogador");
		Insets ins = l.getInsets();
		l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		l.setVisible(true);
	}

}
