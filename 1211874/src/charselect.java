import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class charselect extends JFrame {
	
	JCheckBox cb1;
	JCheckBox cb2;
	JCheckBox cb3;
	JCheckBox cb4;
	JCheckBox cb5;
	JCheckBox cb6;
	JButton b1;
	
	public charselect(String nome) {
		super(nome);
		Dimension size;
		JButton b1;
		int i;
		setLayout(null);
		JLabel l=new JLabel();
		Container c=getContentPane();
		b1=new JButton("Come�ar Jogo");
		b1.addActionListener(new startmatchT(this));
		JCheckBox cb1=new JCheckBox("Rev. Green",false);
		JCheckBox cb2=new JCheckBox("Coronel Mustard",false);
		JCheckBox cb3=new JCheckBox("Sra. Peacock",false);
		JCheckBox cb4=new JCheckBox("Professor Plum",false);
		JCheckBox cb5=new JCheckBox("Srta. Scarlet",false);
		JCheckBox cb6=new JCheckBox("Sra. White",false);
		Insets in=l.getInsets();
		size = b1.getPreferredSize();
		b1.setBounds(300+in.left, 250+in.top,size.width+50,size.height+10);
		cb1.setBounds(50,50,200,30);
		cb2.setBounds(50,80,200,30);
		cb3.setBounds(50,110,200,30);
		cb4.setBounds(50,140,200,30);
		cb5.setBounds(50,170,200,30);
		cb6.setBounds(50,200,200,30);
		c.add(l);
		c.add(cb1);
		c.add(cb2);
		c.add(cb3);
		c.add(cb4);
		c.add(cb5);
		c.add(cb6);
		c.add(b1);
		setSize(600,400);
		setVisible(true);
		
		}
	public int getchecks()
	{
		int i = 0;
		i++;
		return i;
	}
	}

class startmatchT implements ActionListener {

	Component c;
	
	
	public startmatchT(Component x)
	{
		c=x;
	}
	public void actionPerformed(ActionEvent e)
	{
		
		c.setVisible(false);
		((Window) c).dispose();
		board l = new board("Tabuleiro");
		Insets ins=l.getInsets();
		l.setSize(2000+ins.left+ins.right,3000+ins.top+ins.bottom);
		l.setVisible(true);
	}
}

class startmatchF implements ActionListener {

	Component c;
	
	
	public startmatchF(Component x)
	{
		c=x;
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
	}
}

