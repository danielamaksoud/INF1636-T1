import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

//import board.move;

public class guess implements ActionListener {

	ArrayList<String> a = new ArrayList<String>();
	String cmd;
	JButton p;
	backgroundimage t;
	JButton ps;
	JButton rt;
	int o;
	JButton ac;
	ArrayList<ArrayList <String>> m = new ArrayList<ArrayList <String>>();
	int j;
	ArrayList<JCheckBox> s = new ArrayList<>();
	ArrayList<JCheckBox> ar = new ArrayList<>();
	ArrayList<JCheckBox> cmds = new ArrayList<>();
	
	public guess(ArrayList<String> assassino, String comodo, JButton palpite, backgroundimage tabuleiro, JButton passagemSecreta, JButton refazerTurno, int opcao, JButton acusar, ArrayList<ArrayList <String>> maos, int jogador, ArrayList<JCheckBox> suspeitos, ArrayList<JCheckBox> armas, ArrayList<JCheckBox> comodos)
	{
		a.add(assassino.get(0)); /* Arma */
		a.add(assassino.get(1)); /* Comodo */
		a.add(assassino.get(2)); /* Suspeito */
		cmd = comodo;
		p = palpite;
		t = tabuleiro;
		ps = passagemSecreta;
		rt = refazerTurno;
		o = opcao;
		ac = acusar;
		m = maos;
		j = jogador;
		ar = armas;
		s = suspeitos;
		cmds = comodos;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new assassinSelect("Lista de Suspeitos, comodos e armas", a, cmd, o, m, j, s, ar, cmds);
		t.revalidate();
		t.repaint();
		p.setEnabled(false);
		ps.setEnabled(false);
		rt.setEnabled(false);
		ac.setEnabled(false);
	}
	
}
