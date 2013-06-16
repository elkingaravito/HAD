package snk.gui;

import snk.nucleo.validador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class HAD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRutaArchivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HAD frame = new HAD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HAD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblHerramientaDeAnalisis = new JLabel("Herramienta de Analisis de Datos y Tranformaci\u00F3n");
		lblHerramientaDeAnalisis.setHorizontalAlignment(SwingConstants.CENTER);
		lblHerramientaDeAnalisis.setBounds(28, 0, 393, 67);
		panel.add(lblHerramientaDeAnalisis);
		
		JLabel lblNewLabel = new JLabel("An\u00E1lisis B\u00E1sico de Archivos Planos");
		lblNewLabel.setBounds(1, 79, 242, 67);
		panel.add(lblNewLabel);
		
		textRutaArchivo = new JTextField();
		textRutaArchivo.setBounds(28, 139, 242, 67);
		panel.add(textRutaArchivo);
		textRutaArchivo.setColumns(10);
		
		JButton lblArchivo = new JButton("Seleccione el Archivo");
		lblArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
				 fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 int seleccion = fileChooser.showSaveDialog(fileChooser);
			if (seleccion == JFileChooser.APPROVE_OPTION){
				    File[] filesInDirectory = fileChooser.getCurrentDirectory().listFiles();
				    for ( File fichero : filesInDirectory ) {
				        System.out.println(fichero.getName());
					    //File fichero = fileChooser.getSelectedFile();
						final String adr=fichero.getAbsolutePath();
						String extension = adr.substring(adr.lastIndexOf('.'));
						validador validacion = null;
						if(extension.equals(".csv") || extension.equals(".txt")){
							try {
								validacion = new validador(adr,"Res" + fichero.getName() + ".html" );
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}
						}

				    
				    }
					
				}
			textRutaArchivo.setText(fileChooser.getSelectedFile().getAbsolutePath());
			

			}
		
		});
		lblArchivo.setBounds(275, 140, 146, 67);
		panel.add(lblArchivo);
	}

}
