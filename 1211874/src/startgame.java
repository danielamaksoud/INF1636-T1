import java.awt.*;
import javax.swing.*;

public class startgame {
	public static void main(String[] args) {
		firstframe l = new firstframe("Jogo de Detetive");
		Insets ins = l.getInsets();
		l.setSize(600 + ins.left + ins.right, 400 + ins.top + ins.bottom);
		l.setVisible(true);
	}
}