import java.awt.*;
import javax.swing.*;


public class exemplo {
	public static void main(String[] args) {
		layout l = new layout("Detetive");
		Insets ins=l.getInsets();
		l.setSize(600+ins.left+ins.right,400+ins.top+ins.bottom);
		personagens p = new personagens("Suspeitos");
		l.setVisible(true);
	}

}
