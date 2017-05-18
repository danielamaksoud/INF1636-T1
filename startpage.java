import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class startpage implements ActionListener {

	Component c;
	
	public startpage(Component x)
	{
		c=x;
	}
	public void actionPerformed(ActionEvent e)
	{
		c.setVisible(false);
		((Window) c).dispose();
		personagens p = new personagens("Suspeitos");
	}
}
