import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileChooserTest extends JFrame {
  private JTextField filename = new JTextField(), dir = new JTextField();

  public int numpl;
  public board.Player[] player;
  private JButton open = new JButton("Open"), save = new JButton("Save");

  public FileChooserTest(board.Player[] players, int nump) {
    JPanel p = new JPanel();
    numpl = nump;
    player = players;
    open.addActionListener(new OpenL());
    p.add(open);
    save.addActionListener(new SaveL());
    p.add(save);
    Container cp = getContentPane();
    cp.add(p, BorderLayout.SOUTH);
    dir.setEditable(false);
    filename.setEditable(false);
    p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(filename);
    p.add(dir);
    cp.add(p, BorderLayout.NORTH);
  }

  class OpenL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(FileChooserTest.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }

  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
     
      int rVal = c.showSaveDialog(FileChooserTest.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
        Hashtable<String, String> h = new Hashtable<String, String>();
		
  	  int i = 0;
  	  for(i=0; i<numpl;i++)
  	  {
  		  h.put("int", "Players[i].startposx");
  		  h.put("int", "Players[i].startposy");
  		  h.put("int", "Players[i].posx");
  		  h.put("int", "Players[i].posy");
  		  h.put("JButton", "Players[i].bb");
  		  h.put("Color", "Players[i].collo");
  		  h.put("ArrayList<String>", "Players[i].mao");
  		  h.put("String", "Players[i].cor");
  		  h.put("int", "Players[i].entrouComodo");
  		  h.put("ArrayList<JCheckBox>", "Players[i].suspeitos");
  		  h.put("intArrayList<JCheckBox>", "Players[i].armas");
  		  h.put("ArrayList<JCheckBox>", "Players[i].comodos");
  		  
  	  }
        
        try {

            System.out.println("Creating File/Object output stream...");
            
            FileOutputStream fileOut = new FileOutputStream("HTExample.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            System.out.println("Writing Hashtable Object...");
            out.writeObject(h);

            System.out.println("Closing all output streams...\n");
            out.close();
            fileOut.close();
            
        } catch(FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }

  
} 