import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class layout extends JFrame {
	public layout(String s) {
		super(s);
		Dimension size;
		JButton b1,b2;
		JFrame j = new JFrame();
		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setLayout(null);
		b1=new JButton("Novo Jogo");
		b1.addActionListener(new startpage(this));
		p.add(b1);
		b2=new JButton("Carregar Jogo Salvo");
		p.add(b2);
		Insets in=p.getInsets();
		size=b1.getPreferredSize();
		b1.setBounds(240+in.left, 140+in.top,size.width+50,size.height+10);
		b1.setToolTipText("Voc� acha que consegue descobrir o assassino?");
		size=b2.getPreferredSize();
		b2.setBounds(210+in.left,190+in.top,size.width+50,size.height+10);
		b2.setToolTipText("Reabrindo um caso antigo?");
		j.pack();
	}	
}
