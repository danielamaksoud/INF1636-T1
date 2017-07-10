import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
//import java.awt.ActiveEvent;

public class assassinSelect extends JFrame {
	
	/* Suspeitos */
	final JCheckBox cb1 = new JCheckBox("Rev. Green (Verde)", false);
	final JCheckBox cb2 = new JCheckBox("Cel. Mustard (Amarelo)", false);
	final JCheckBox cb3 = new JCheckBox("Sra. Peacock (Azul)", false);
	final JCheckBox cb4 = new JCheckBox("Prof. Plum (Rosa)", false);
	final JCheckBox cb5 = new JCheckBox("Srta. Scarlet (Vermelho)", false);
	final JCheckBox cb6 = new JCheckBox("Sra. White (Branco)", false);
	
	/* Armas */
	final JCheckBox cb7 = new JCheckBox("Cano", false);
	final JCheckBox cb8 = new JCheckBox("Castical", false);
	final JCheckBox cb9 = new JCheckBox("Chave Inglesa", false);
	final JCheckBox cb10 = new JCheckBox("Corda", false);
	final JCheckBox cb11 = new JCheckBox("Faca", false);
	final JCheckBox cb12 = new JCheckBox("Revolver", false);
	
	/* Comodos */
	public JCheckBox cb13;
	
	final ArrayList<JCheckBox> suspeitos = new ArrayList<>();
	final ArrayList<JCheckBox> armas = new ArrayList<>();
	final ArrayList<JCheckBox> comodos = new ArrayList<>();
	final JButton b1 = new JButton("Adivinhar");
	
	int count = 0;
	int countSuspeitos = 0, countArmas = 0, countComodos = 1;
	
	public ArrayList<String> chute = new ArrayList<>();
	ArrayList<String> chuteS = new ArrayList<>();
	ArrayList<String> chuteA = new ArrayList<>();
	ArrayList<String> chuteC = new ArrayList<>();
	
	public String Comodo;
	
	ArrayList<String> Assassino = new ArrayList<>();
	
	backgroundimage tela;
	
	public char o;
	
	public assassinSelect(String nome, ArrayList<String> assassino, String comodo, char opcao) {
		
		super(nome);
		
		o = opcao;
		
		Assassino.add(assassino.get(0)); /* Arma */
		Assassino.add(assassino.get(1)); /* Comodo */
		Assassino.add(assassino.get(2)); /* Suspeito */
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension size; /* Botao */
		Comodo = comodo;
		
		chuteC.add(Comodo);
		
		System.out.println("");
		System.out.println("Comodo atual = " + comodo);
		System.out.println("");
		
		cb13 = new JCheckBox(comodo, true);
		
		/* Bloqueia redimensionamento da janela */
		this.setResizable(false);
		
		/* IMAGEM DE FUNDO */ 
		setLayout(new GridLayout(1,3));
		tela = new backgroundimage("Fundo3.png");
		 
		getContentPane().add(tela);
		
		b1.addActionListener(new submitGuess(this));
		b1.setEnabled(false);
		size = b1.getPreferredSize();
		
		cb1.setBounds(67, 26, 188, 30);
		cb2.setBounds(67, 56, 188, 30);
		cb3.setBounds(67, 86, 188, 30);
		cb4.setBounds(67, 116, 188, 30);
		cb5.setBounds(67, 146, 188, 30);
		cb6.setBounds(67, 176, 188, 30);
		
		cb7.setBounds(257, 26, 130, 30);
		cb8.setBounds(257, 56, 130, 30);
		cb9.setBounds(257, 86, 130, 30);
		cb10.setBounds(257, 116, 130, 30);
		cb11.setBounds(257, 146, 130, 30);
		cb12.setBounds(257, 176, 130, 30);
		
		cb13.setBounds(387, 26, 143, 30);
		
		cb1.addActionListener(selectSuspeitos);
		cb2.addActionListener(selectSuspeitos);
		cb3.addActionListener(selectSuspeitos);
		cb4.addActionListener(selectSuspeitos);
		cb5.addActionListener(selectSuspeitos);
		cb6.addActionListener(selectSuspeitos);
		
		cb7.addActionListener(selectArmas);
		cb8.addActionListener(selectArmas);
		cb9.addActionListener(selectArmas);
		cb10.addActionListener(selectArmas);
		cb11.addActionListener(selectArmas);
		cb12.addActionListener(selectArmas);
		
		cb13.addActionListener(selectComodos);
		
		suspeitos.add(cb1);
		suspeitos.add(cb2);
		suspeitos.add(cb3);
		suspeitos.add(cb4);
		suspeitos.add(cb5);
		suspeitos.add(cb6);
		
		armas.add(cb7);
		armas.add(cb8);
		armas.add(cb9);
		armas.add(cb10);
		armas.add(cb11);
		armas.add(cb12);
		
		comodos.add(cb13);
		
		b1.setBounds(225, 304, size.width + 50, size.height + 10);
		
		tela.add(cb1);
		tela.add(cb2);
		tela.add(cb3);
		tela.add(cb4);
		tela.add(cb5);
		tela.add(cb6);
		tela.add(cb7);
		tela.add(cb8);
		tela.add(cb9);
		tela.add(cb10);
		tela.add(cb11);
		tela.add(cb12);
		tela.add(cb13);
		tela.add(b1);
		
		Insets ins = tela.getInsets();
		
		setSize(600 + ins.left, 400 + ins.top);
		setVisible(true);
		
	}
	
	ActionListener selectSuspeitos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            int index = suspeitos.indexOf(checkbox) + 1;
            
            int i;
			
            if(checkbox.isSelected() == true)
            {
            	countSuspeitos = countSuspeitos + 1;
            	
            	if (index == 1)
            	{
            		chuteS.add("Green");
            	}
            	else if(index == 2)
            	{
            		chuteS.add("Mustard");
            	}
            	else if(index == 3)
            	{
            		chuteS.add("Peacock");
            	}
            	else if(index == 4)
            	{
            		chuteS.add("Plum");
            	}
            	else if(index == 5)
            	{
            		chuteS.add("Scarlet");
            	}
            	else if(index == 6)
            	{
            		chuteS.add("White");
            	}
            }
            else
            {
            	countSuspeitos = countSuspeitos - 1;
            	
            	if(index == 1)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "Green")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 2)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "Mustard")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 3)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "Peacock")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 4)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "Plum")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 5)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "Scarlet")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 6)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "White")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            }
            
            if (countSuspeitos == 1 && countArmas == 1 && countComodos == 1) /* Se o jogador selecionou 3 itens (1 suspeito, 1 arma e 1 comodo) */
            {
            	b1.setEnabled(true);
            }
            else
            {
            	b1.setEnabled(false);
            }
        }
    };
    
	ActionListener selectArmas = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            int index = armas.indexOf(checkbox) + 1;
            int i;
			
            if(checkbox.isSelected() == true)
            {
            	countArmas = countArmas + 1;
            	
            	if (index == 1)
            	{
            		chuteA.add("Cano");
            	}
            	else if(index == 2)
            	{
            		chuteA.add("Castical");
            	}
            	else if(index == 3)
            	{
            		chuteA.add("ChaveInglesa");
            	}
            	else if(index == 4)
            	{
            		chuteA.add("Corda");
            	}
            	else if(index == 5)
            	{
            		chuteA.add("Faca");
            	}
            	else if(index == 6)
            	{
            		chuteA.add("Revolver");
            	}
            }
            else
            {
            	countArmas = countArmas - 1;
            	
            	if(index == 1)
            	{
            		for(i = 0; i < chuteA.size(); i++)
            		{
            			if(chuteA.get(i) == "Cano")
            			{
            				chuteA.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 2)
            	{
            		for(i = 0; i < chuteA.size(); i++)
            		{
            			if(chuteA.get(i) == "Castical")
            			{
            				chuteA.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 3)
            	{
            		for(i = 0; i < chuteS.size(); i++)
            		{
            			if(chuteS.get(i) == "ChaveInglesa")
            			{
            				chuteS.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 4)
            	{
            		for(i = 0; i < chuteA.size(); i++)
            		{
            			if(chuteA.get(i) == "Corda")
            			{
            				chuteA.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 5)
            	{
            		for(i = 0; i < chuteA.size(); i++)
            		{
            			if(chuteA.get(i) == "Faca")
            			{
            				chuteA.remove(i);
            				break;
            			}
            		}
            	}
            	else if(index == 6)
            	{
            		for(i = 0; i < chuteA.size(); i++)
            		{
            			if(chuteA.get(i) == "Revolver")
            			{
            				chuteA.remove(i);
            				break;
            			}
            		}
            	}
            }
            
            if (countSuspeitos == 1 && countArmas == 1 && countComodos == 1) /* Se o jogador selecionou 3 itens (1 suspeito, 1 arma e 1 comodo) */
            {
            	b1.setEnabled(true);
            }
            else
            {
            	b1.setEnabled(false);
            }
        }
    };
    
	ActionListener selectComodos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            JCheckBox checkbox = (JCheckBox) event.getSource();
            //int index = comodos.indexOf(checkbox) + 1; 	
        	
            if(checkbox.isSelected() == true)
            {
            	countComodos = countComodos + 1;
            }
            else
            {
            	countComodos = countComodos - 1;
            	
            }
            
            if (countSuspeitos == 1 && countArmas == 1 && countComodos == 1) /* Se o jogador selecionou 3 itens (1 suspeito, 1 arma e 1 comodo) */
            {
            	b1.setEnabled(true);
            }
            else
            {
            	b1.setEnabled(false);
            }
            
        }
    };

	class submitGuess implements ActionListener {
	
		Component c;
		
		public submitGuess(Component x)
		{
			c = x;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			c.setVisible(false);
			((Window) c).dispose();

			System.out.println("Suspeito = " + Assassino.get(2));
			System.out.println("Arma = " + Assassino.get(0));
			System.out.println("Comodo = " + Assassino.get(1));
			System.out.println("");
			
			System.out.println("Suspeito do Palpite = " + chuteS.get(0));
			System.out.println("Arma do Palpite = " + chuteA.get(0));
			System.out.println("Comodo do Palpite = " + chuteC.get(0));
			System.out.println("");
			
			/* Opcao de acusar */
			if (o == 'a')
			{
				if((chuteS.get(0) == Assassino.get(2)) && (chuteA.get(0) == Assassino.get(0)) && (chuteC.get(0) == Assassino.get(1)))
				{
					JOptionPane.showMessageDialog(c,"Venceu! Parabens! Voce e um otimo detetive!");
					System.out.println("Ganhou o jogo.");
					System.out.println("");
				}
				else
				{
					JOptionPane.showMessageDialog(c,"Errou! Mais sorte na proxima vez.");
					System.out.println("Errou o palpite.");
					System.out.println("");
				}
			}
			
			/* Opcao de dar palpite */
		}
	}

}