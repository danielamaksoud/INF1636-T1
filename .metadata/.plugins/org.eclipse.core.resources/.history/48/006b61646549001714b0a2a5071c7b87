import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.ActiveEvent;

public class charselect extends JFrame {
	
	JCheckBox cb1;
	JCheckBox cb2;
	JCheckBox cb3;
	JCheckBox cb4;
	JCheckBox cb5;
	JCheckBox cb6;
	final ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	final JButton b1 = new JButton("Comecar Jogo");
	int count = 0;
	
	backgroundimage tela;
	
	public charselect(String nome) {
		super(nome);
		Dimension size; /* Botao */
		
		/* Bloqueia redimensionamento da janela */
		this.setResizable(false);
		
		/* IMAGEM DE FUNDO */ 
		setLayout(new GridLayout(1,1));
		tela = new backgroundimage("Fundo2.png");
		getContentPane().add(tela);
		
		JCheckBox cb1 = new JCheckBox("Rev. Green", false);
		JCheckBox cb2 = new JCheckBox("Cel. Mustard", false);
		JCheckBox cb3 = new JCheckBox("Sra. Peacock", false);
		JCheckBox cb4 = new JCheckBox("Prof. Plum", false);
		JCheckBox cb5 = new JCheckBox("Srta. Scarlet", false);
		JCheckBox cb6 = new JCheckBox("Sra. White", false);
		
		b1.addActionListener(new startmatchT(this));
		b1.setEnabled(false);
		size = b1.getPreferredSize();
		
		cb1.setBounds(34, 52, 200, 30);
		cb2.setBounds(34, 82, 200, 30);
		cb3.setBounds(34, 112, 200, 30);
		cb4.setBounds(34, 142, 200, 30);
		cb5.setBounds(34, 172, 200, 30);
		cb6.setBounds(34, 202, 200, 30);
		cb1.addActionListener(actionListener);
		cb2.addActionListener(actionListener);
		cb3.addActionListener(actionListener);
		cb4.addActionListener(actionListener);
		cb5.addActionListener(actionListener);
		cb6.addActionListener(actionListener);
		checkBoxes.add(cb1);
		checkBoxes.add(cb2);
		checkBoxes.add(cb3);
		checkBoxes.add(cb4);
		checkBoxes.add(cb5);
		checkBoxes.add(cb6);
		
		b1.setBounds(209, 280, size.width + 50, size.height + 10);
		
		tela.add(cb1);
		tela.add(cb2);
		tela.add(cb3);
		tela.add(cb4);
		tela.add(cb5);
		tela.add(cb6);
		tela.add(b1);
		setSize(600, 400);
		setVisible(true);
		
	}
	
	
	ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            int index = checkBoxes.indexOf(checkbox) + 1;
            if(checkbox.isSelected() == true)
            {
            	count = count + 1;
            }
            else
            {
            	count = count - 1;
            }
            if(count >= 3) /* Se a partida possui o numero minimo de 3 jogadores */
            {
            	b1.setEnabled(true);
            }
            else
            {
            	b1.setEnabled(false);
            }
        }
    };
   
	
}

class startmatchT implements ActionListener {

	Component c;
	
	public startmatchT(Component x)
	{
		c = x;
	}
	public void actionPerformed(ActionEvent e)
	{
		
		c.setVisible(false);
		((Window) c).dispose();
		board l = new board("Tabuleiro");
		Insets ins = l.getInsets();
		l.setSize(1000 + ins.left + ins.right, 686 + ins.top + ins.bottom);
		l.setVisible(true);
	}
}


