import java.awt.*;
import javax.swing.*;


public class charselect extends JFrame {
	public charselect(String nome) {
		super(nome);
		setLayout(null);
		JLabel l=new JLabel();
		Container c=getContentPane();
		JCheckBox cb1=new JCheckBox("Rev. Green",false);
		JCheckBox cb2=new JCheckBox("Coronel Mustard",false);
		JCheckBox cb3=new JCheckBox("Sra. Peacock",false);
		JCheckBox cb4=new JCheckBox("Professor Plum",false);
		JCheckBox cb5=new JCheckBox("Srta. Scarlet",false);
		JCheckBox cb6=new JCheckBox("Sra. White",false);
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
		setSize(600,400);
		setVisible(true);
		}
	}