import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.ActiveEvent;

public class charselect extends JFrame {
	
	final JCheckBox cb1 = new JCheckBox("Rev. Green (Verde)", false);
	final JCheckBox cb2 = new JCheckBox("Cel. Mustard (Amarelo)", false);
	final JCheckBox cb3 = new JCheckBox("Sra. Peacock (Azul)", false);
	final JCheckBox cb4 = new JCheckBox("Prof. Plum (Rosa)", false);
	final JCheckBox cb5 = new JCheckBox("Srta. Scarlet (Vermelho)", false);
	final JCheckBox cb6 = new JCheckBox("Sra. White (Branco)", false);
	final ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	final JButton b1 = new JButton("Comecar Jogo");
	
	int count = 0;
	
	backgroundimage tela;
	
	public charselect(String nome) {
		
		super(nome);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension size; /* Botao */
		
		/* Bloqueia redimensionamento da janela */
		this.setResizable(false);
		
		/* IMAGEM DE FUNDO */ 
		setLayout(new GridLayout(1,1));
		tela = new backgroundimage("Fundo2.png");
		getContentPane().add(tela);
		
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
		
		Insets ins = tela.getInsets();
		
		setSize(600 + ins.left, 400 + ins.top);
		setVisible(true);
		
	}
	
	
	ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            //int index = checkBoxes.indexOf(checkbox) + 1;
            if(checkbox.isSelected() == true)
            {
            	count = count + 1;
            }
            else
            {
            	count = count - 1;
            }
            if (count >= 3) /* Se a partida possui o numero minimo de 3 jogadores */
            {
            	b1.setEnabled(true);
            }
            else
            {
            	b1.setEnabled(false);
            }
        }
    };

	class startmatchT implements ActionListener {
	
		Component c;
		
		public startmatchT(Component x)
		{
			c = x;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			boolean ic1 = cb1.isSelected();
			boolean ic2 = cb2.isSelected();
			boolean ic3 = cb3.isSelected();
			boolean ic4 = cb4.isSelected();
			boolean ic5 = cb5.isSelected();
			boolean ic6 = cb6.isSelected();
			int i1, i2, i3, i4, i5, i6, contador;
			contador = 0;
			
			if(ic1 == true)
			{
				i1 = 1;
				contador+=1;
			}
			else
			{
				i1 = 0;
			}
			
			if(ic2 == true)
			{
				i2 = 1;
				contador+=1;
			}
			else
			{
				i2 = 0;
			}
			
			if(ic3 == true)
			{
				i3 = 1;
				contador+=1;
			}
			else
			{
				i3 = 0;
			}
			
			if(ic4 == true)
			{
				i4 = 1;
				contador+=1;
			}
			else
			{
				i4 = 0;
			}
			
			if(ic5 == true)
			{
				i5 = 1;
				contador+=1;
			}
			else
			{
				i5 = 0;
			}
			
			if(ic6 == true)
			{
				i6 = 1;
				contador+=1;
			}
			else
			{
				i6 = 0;
			}
			
			c.setVisible(false);
			((Window) c).dispose();
			board l = new board("Tabuleiro", i1, i2, i3, i4, i5, i6, contador);
			Insets ins = l.getInsets();
			l.setSize(1000 + ins.left, 686 + ins.top);
			l.setVisible(true);
		}
	}

}
