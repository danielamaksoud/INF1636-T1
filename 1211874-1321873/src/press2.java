import java.awt.Component;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class press2 implements ActionListener {

	Component c;
	int n1;
	
	public press2(Component x, int n)
	{
		c = x;
		n1 = n;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		showdice l = new showdice("Dado", n1);
		Insets ins = l.getInsets();
		l.setSize(95 + ins.left + ins.right, 106 + ins.top + ins.bottom);
		l.setVisible(true);
		
		c.setVisible(false);
		((Window) c).dispose();
	}
	
}