package snk.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import snk.nucleo.MyFrame;
import snk.nucleo.validador;

/**
 */
public class ventanaPrincipal {

	private JFrame frmValidacion;
	private JButton lblArchivo;
	private JTextField textField;
	private JLabel headerh1;
	private Component rigidArea;
	private Component rigidArea_1;

	/**
	 * Launch the application.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal window = new ventanaPrincipal();
					window.frmValidacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final JFileChooser fileChooser = new JFileChooser();
		frmValidacion = new JFrame();
		frmValidacion.setTitle("Validacion CSV");
		frmValidacion.setBounds(100, 100, 640, 480);
		frmValidacion.setSize(640,480);
		frmValidacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblArchivo = new JButton("Archivo");
		lblArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int seleccion = fileChooser.showSaveDialog(fileChooser);
				if (seleccion == JFileChooser.APPROVE_OPTION){
					File fichero = fileChooser.getSelectedFile();
					final String adr=fichero.getAbsolutePath();
					String extension = adr.substring(adr.lastIndexOf('.'));
					validador validacion = null;
					if(extension.equals(".csv")){
						try {
							validacion = new validador(adr, "Validador.html");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				JFrame myFrame = MyFrame.getInstance();
				myFrame.setSize(100, 100);
				myFrame.setVisible(true);
			}
		});
		frmValidacion.getContentPane().add(lblArchivo, BorderLayout.EAST);
		lblArchivo.setSize(10,10);
		JLabel lblTitulo = new JLabel("Herramienta de An?lisis de Archivos");		
		JLabel lblNewLabel = new JLabel("Archivo:");
		frmValidacion.getContentPane().add(lblTitulo, BorderLayout.WEST);
		frmValidacion.getContentPane().add(lblNewLabel, BorderLayout.WEST);
		
		textField = new JTextField();
		frmValidacion.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		frmValidacion.getContentPane().add(rigidArea, BorderLayout.NORTH);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(208, 40));
		frmValidacion.getContentPane().add(rigidArea_1, BorderLayout.SOUTH);
	}

	/**
	 * Method getLblArchivo.
	 * @return JButton
	 */
	public JButton getLblArchivo() {
		return lblArchivo;
	}
}
