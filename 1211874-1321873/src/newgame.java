import java.awt.*;
import java.awt.event.*;

public class newgame implements ActionListener {

	Component c;
	
	public newgame(Component x)
	{
		c = x;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		c.setVisible(false);
		((Window) c).dispose();
		new charselect("Lista de Suspeitos");
	}
	
}
