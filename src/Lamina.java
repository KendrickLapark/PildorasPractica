import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Lamina extends JPanel{
	
	private GridLayout gridLayout;
	private JPanel jPanel;

	public Lamina() {
				
		String [] opciones1 = {"Tipo","Message","Input","Confirm","Option"};
		String [] opciones2 = {"Tipo de mensaje","ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"};
		String [] opciones3 = {"Mensaje","Cadena","Icono","Componente","Otros","Object[]"};
		String [] opciones4 = {"Confirmar","DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"};
		String [] opciones5 = {"Opcion","String[]","Icon[]","Object[]"};
		String [] opciones6 = {"Entrada","Campo de texto","Combo"};
		
		setLayout(new BorderLayout());
		
		JButton jButton = new JButton("Aceptar");		
		
		JPanel jPanelButton = new JPanel();
		
		jPanelButton.add(jButton);
		
		gridLayout = new GridLayout(2,3);
		
		jPanel = new JPanel();
		
		jPanel.setLayout(gridLayout);
				
		configurar(opciones1);
		configurar(opciones2);
		configurar(opciones3);
		configurar(opciones4);
		configurar(opciones5);
		configurar(opciones6);
		
		add(jPanel, BorderLayout.CENTER);
		add(jPanelButton,BorderLayout.SOUTH);			
		
	}
	
	public void configurar(String [] opciones) {
				
		ButtonGroup buttonGroup = new ButtonGroup();

		Box verticalBox = Box.createVerticalBox();				
		
		JPanel jPanel2 = new JPanel();
		
		jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), opciones[0]));	
		
		for (int i = 1; i < opciones.length; i++) {
						
			JRadioButton jRadioButton = new JRadioButton(opciones[i]);
			
			buttonGroup.add(jRadioButton);
			
			verticalBox.add(jRadioButton);
			
		}	
		
		jPanel2.add(verticalBox);
		
		jPanel.add(jPanel2);
		
	}	
	
}
