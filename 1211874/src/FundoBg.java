import javax.swing.*;
import java.awt.*;

public class FundoBg extends JDesktopPane {  
	private Image imagem;
	
	public FundoBg(String imagem){
		this.imagem = new ImageIcon(imagem).getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
	}
}