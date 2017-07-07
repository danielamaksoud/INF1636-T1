import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class guess implements ActionListener {

	ArrayList<String> a = new ArrayList<String>();
	String cmd;
	
	public guess(ArrayList<String> assassino, String comodo)
	{
		a.add(assassino.get(0)); /* Arma */
		a.add(assassino.get(1)); /* Comodo */
		a.add(assassino.get(2)); /* Suspeito */
		cmd = comodo;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new assassinSelect("Lista de Suspeitos, comodos e armas", a, cmd);
	}
	
}
