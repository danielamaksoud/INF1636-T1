import javax.swing.*;
import java.awt.*;

public class backgroundimage extends JDesktopPane {
	
	private Image imagem;
	
	public backgroundimage(String imagem){
		this.imagem = new ImageIcon(imagem).getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
	}
	
}
