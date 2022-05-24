package lab6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;


public class lab6Application {

	private JFrame frame;
	private JTextField textField;
	private Scanner sc = null;
	
	int stroka;
	int stolb;
	int strokaEdit;
	int stolbEdit;
	int [][] arr;
	int [][] arrEdit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab6Application window = new lab6Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lab6Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(534, 485, 340, 61);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lab6Graphics panel = new lab6Graphics();
		panel.setBounds(10, 11, 864, 463);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Add file");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		btnNewButton.setBounds(10, 485, 170, 65);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLetsGo = new JButton("Let's go");
		btnLetsGo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLetsGo.setForeground(Color.RED);
		btnLetsGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					sc = new Scanner(new File(textField.getText()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				stroka = sc.nextInt();
				stolb = sc.nextInt();
				strokaEdit = stroka;
				stolbEdit = stolb;
				
				arr = new int[stolb][stroka];
				arrEdit = new int[stolb][stroka];
				for (int y = 0; y < stroka; y++) {
					for (int x = 0; x < stolb; x++) {
						arr[x][y] = sc.nextInt();
						arrEdit[x][y] = arr[x][y];
					}
				}
				
                panel.SetData(stroka, stolb, strokaEdit, stolbEdit, arr, arrEdit);
                panel.repaint();
				
			}
		});
		btnLetsGo.setBounds(190, 485, 170, 65);
		frame.getContentPane().add(btnLetsGo);
		
		JLabel lblNewLabel = new JLabel("Current path:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(370, 485, 154, 61);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
