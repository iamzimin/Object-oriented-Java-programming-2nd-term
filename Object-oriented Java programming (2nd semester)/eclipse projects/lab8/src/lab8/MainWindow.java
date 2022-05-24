package lab8;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class MainWindow {
	
	private Scanner sc = null;

	private JFrame frame;
	private JTextField textField;
	char [][] buffer = new char[100][500];
	String bufferStr = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1239, 731);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Arial", Font.PLAIN, 25));
		textArea.setBounds(10, 28, 950, 653);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Add file");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int res = jfc.showOpenDialog(frame);
				jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
				}
				
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					try {
						Scanner sc = new Scanner(new File(jfc.getSelectedFile().getAbsolutePath()));
						String text = "";
						while (sc.hasNext()) {
							text += sc.nextLine() + "\n";
						}
						sc.close();
						textArea.setText(text);
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(970, 11, 243, 40);
		frame.getContentPane().add(btnNewButton);
				
		JButton btnSave = new JButton("Save file");
		btnSave.setBackground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				int res = fd.showSaveDialog(frame);
				if (res == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fd.getSelectedFile().getAbsolutePath())));
						bw.write(textArea.getText());
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(970, 60, 243, 40);
		frame.getContentPane().add(btnSave);
		
		JButton btnProcess = new JButton("Processing");
		btnProcess.setBackground(Color.BLACK);
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(textArea.getText());
				
				int startWord = 0;
				
				String sbStr = sb.toString();
		        char [] arrayChars = sbStr.toCharArray();
		        for(int i = 0; i < arrayChars.length - 1;i++) {
		        	
		        	if (arrayChars[i] == ' ') {
		        		startWord = i + 1;
		        	}
		        	
		        	if (arrayChars[i] == arrayChars[i + 1]) {
		        		
		        		for (int z = startWord; arrayChars[z] != ' ' && arrayChars[z] != '\n'; z++, i++) {
		        			
		        			char c = arrayChars[z];
		        			if (Character.isLowerCase(c)) {
		        		    	arrayChars[z] = Character.toUpperCase(c);
		        		    }
		        		}
		        	}
		        }			
		        String string = String.valueOf(arrayChars);
		        textArea.setText(string.toString());		
			}
		});
		btnProcess.setForeground(Color.RED);
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProcess.setBounds(970, 110, 243, 40);
		frame.getContentPane().add(btnProcess);
		
		JLabel lblNewLabel_1 = new JLabel("Current path:");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(1021, 568, 145, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(982, 619, 225, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	}	
}
