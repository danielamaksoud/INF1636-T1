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
	char o;
	JButton ac;
	ArrayList<ArrayList <String>> m = new ArrayList<ArrayList <String>>();
	int j;
	ArrayList<JCheckBox> s = new ArrayList<>();
	ArrayList<JCheckBox> ar = new ArrayList<>();
	ArrayList<JCheckBox> cmds = new ArrayList<>();
	ArrayList<Integer> f = new ArrayList<>();
	
	public guess(ArrayList<String> assassino, String comodo, JButton palpite, backgroundimage tabuleiro, JButton passagemSecreta, JButton refazerTurno, ArrayList<Integer> flag, JButton acusar, ArrayList<ArrayList <String>> maos, int jogador, ArrayList<JCheckBox> suspeitos, ArrayList<JCheckBox> armas, ArrayList<JCheckBox> comodos, char opcao)
	{
		a.add(assassino.get(0)); /* Arma */
		a.add(assassino.get(1)); /* Comodo */
		a.add(assassino.get(2)); /* Suspeito */
		cmd = comodo;
		p = palpite;
		t = tabuleiro;
		ps = passagemSecreta;
		rt = refazerTurno;
		ac = acusar;
		m = maos;
		j = jogador;
		ar = armas;
		s = suspeitos;
		cmds = comodos;
		f = flag;
		o = opcao;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new assassinSelect("Lista de Suspeitos, comodos e armas", a, cmd, f, m, j, s, ar, cmds, o);
		t.revalidate();
		t.repaint();
		p.setEnabled(false);
		ps.setEnabled(false);
		rt.setEnabled(false);
		ac.setEnabled(false);
	}
	
}
