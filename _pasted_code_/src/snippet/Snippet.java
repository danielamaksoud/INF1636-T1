package snippet;

public class Snippet {
	JFileChooser fileChooser = new JFileChooser();
	    if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
	        return;
	    }
	    lastSavedFile = fileChooser.getSelectedFile();
	    salvar(lastSavedFile);
}

