import javax.swing.JFrame;

public class Marco extends JFrame{

	public Marco() {
		
		setBounds(650,250, 600, 600);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Lamina lamina = new Lamina();
		
		add(lamina);
		
		setVisible(true);
		
	}
	
}
