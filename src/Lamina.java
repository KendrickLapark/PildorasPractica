import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Lamina extends JPanel{
	
	private GridLayout gridLayout;
	private JPanel jPanel, jPanelDisplay;
	
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private ButtonGroup buttonGroup3 = new ButtonGroup();
	private ButtonGroup buttonGroup4 = new ButtonGroup();
	private ButtonGroup buttonGroup5 = new ButtonGroup();
	private ButtonGroup buttonGroup6 = new ButtonGroup();
	
	private ButtonGroup [] arrayGrupoBotones = new ButtonGroup[6];
	
	private Object [] object;
	private Object [] eleccion;
	private String [] arrayCadenas = {"Amarillo", "Azul", "Rojo"};
	private String [] valoresInput;
	private ImageIcon [] arrayIconos = {new ImageIcon("blue.png"), new ImageIcon("yellow.png"), new ImageIcon("red.png")};
	
	private String cadena;
	private int contador;
	
	private ImageIcon icono;
	
	private Date date;

	public Lamina() {
				
		String [] opciones1 = {"Tipo","Message","Input","Confirm","Option"};
		String [] opciones2 = {"Tipo de mensaje","ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"};
		String [] opciones3 = {"Mensaje","Cadena","Icono","Componente","Otros","Object[]"};
		String [] opciones4 = {"Confirmar","DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"};
		String [] opciones5 = {"Opcion","String[]","Icon[]","Objects[]"};
		String [] opciones6 = {"Entrada","Campo de texto","Combo"};
				
		arrayGrupoBotones[0] = buttonGroup1;
		arrayGrupoBotones[1] = buttonGroup2;
		arrayGrupoBotones[2] = buttonGroup3;
		arrayGrupoBotones[3] = buttonGroup4;
		arrayGrupoBotones[4] = buttonGroup5;
		arrayGrupoBotones[5] = buttonGroup6;
		
		setLayout(new BorderLayout());
		
		contador = 0;
		
		cadena = "HOLA ESTE ES EL MENSAJE";
		
		icono = new ImageIcon("blue.png", null);
		
		date = new Date();
		
		object = new Object[4];
		
		valoresInput = null;
				
		jPanelDisplay = new JPanel();
		
		jPanelDisplay.setBackground(Color.blue);
		
		object[0] = cadena;
		object[1] = icono;
		object[2] = jPanelDisplay;
		object[3] = date;
			
		JButton jButton = new JButton("Aceptar");	
		
		jButton.addActionListener(new CrearVentana());
		
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
			
			jRadioButton.setActionCommand(opciones[i]);
					
			arrayGrupoBotones[contador].add(jRadioButton);
						
			verticalBox.add(jRadioButton);
			
		}			
		
		contador++;
		
		jPanel2.add(verticalBox);
		
		jPanel.add(jPanel2);
						
		
	}
	
	public void comprobar() {
		
		int opcion = 0;
		int tipo_mensaje = 0;
		Object mensaje = null;
		int tipo_ventana = 0;
		
		
			for (int i = 0; i < arrayGrupoBotones.length; i++) {
				if(arrayGrupoBotones[i].getSelection() != null) {
					if(arrayGrupoBotones[i].getSelection().getActionCommand().equals("Message")) {
						opcion = 1;
					}
					
					if(arrayGrupoBotones[i].getSelection().getActionCommand().equals("Input")) {
						opcion = 2;
					}
					
					if(arrayGrupoBotones[i].getSelection().getActionCommand().equals("Confirm")) {
						opcion = 3;
					}
					
					if(arrayGrupoBotones[i].getSelection().getActionCommand().equals("Option")) {
						opcion = 4;
					}
					
							switch(arrayGrupoBotones[i].getSelection().getActionCommand()) {
							
								case "ERROR_MESSAGE":	
									tipo_mensaje = 0;
									break;
								case "INFORMATION_MESSAGE":
									tipo_mensaje = 1;
									break;
								case "WARNING_MESSAGE":
									tipo_mensaje = 2;
									break;
								case "QUESTION_MESSAGE":
									tipo_mensaje = 3;
									break;
								case "PLAIN_MESSAGE":
									tipo_mensaje = -1;
									break;
									
								case "DEFAULT_OPTION":
									tipo_ventana = -1;
									break;
								case "YES_NO_OPTION":
									tipo_ventana = 0;
									break;
								case "YES_NO_CANCEL_OPTION":
									tipo_ventana = 1;
									break;
								case "OK_CANCEL_OPTION":
									tipo_ventana = 2;
									break;
											
								case "Cadena":
									mensaje = cadena;
									break;
								case "Icono":
									mensaje = icono;
									break;
								case "Componente":
									mensaje = jPanelDisplay;
									break;
								case "Otros":
									mensaje = date;
									break;
								case "Object[]":																		
									mensaje = object;
									break;
									
								case "String[]":
									eleccion = arrayCadenas;
									break;
								case "Icon[]":
									eleccion = arrayIconos;
									break;
								case "Objects[]":
									eleccion = object;
									break;
									
								case "Campo de texto":									
									valoresInput = null;									
									break;									
								case "Combo":									
									valoresInput = arrayCadenas;							
									break;
						}					
					
				}
				
			}
		
			switch(opcion) {
				
				case 1:
					JOptionPane.showMessageDialog
					(jPanel, mensaje, "MessageDialog", tipo_mensaje);	
					break;
				case 2:
					
					JOptionPane.showInputDialog
					(jPanel, mensaje, "InputDialog", tipo_mensaje, null, valoresInput, null);
					break;
				case 3:
					JOptionPane.showConfirmDialog
					(jPanel, mensaje, "ConfirmDialog", tipo_ventana, tipo_mensaje);
					break;
				case 4:
					JOptionPane.showOptionDialog
					(jPanel, mensaje, "OptionDialog", tipo_ventana, tipo_mensaje, null, eleccion, null);
					break;
		
			}
		
	}
	
	private class CrearVentana implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comprobar();
		}
		
	}
	
}


