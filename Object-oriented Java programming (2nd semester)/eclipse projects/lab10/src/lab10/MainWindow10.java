package lab10;


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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextField;

public class MainWindow10 {
	
	private Scanner sc = null;

	private JFrame frame;
	private JTextField textField;
	char [][] buffer = new char[10][15];
	String stringToken = "";
	String[] list = stringToken.split("\n");
	boolean flag = true;
	StringBuilder sb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow10 window = new MainWindow10();
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
	public MainWindow10() {
		initialize();
	}
	
	
	public void sort(String[] s1, String[] s2) {
		
		//char[] str1 = s1.toCharArray();
		//char[] str2 = s2.toCharArray();
		
		for (int i = 0; i < s1.length && i < s2.length; i++) {
			for (int j = 0; j < 1; j++) {
				if (s1[i].toCharArray()[j] < s2[j].toCharArray()[j]) {
					
				}
			}
			
			
		}
		
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
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea.setBounds(10, 28, 950, 653);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Add file");                         ///////add file
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
						stringToken = "";
						
						while (sc.hasNext()) {
							text += sc.nextLine() + " \n";
						}
						
						StringTokenizer st = new StringTokenizer(text, " \t\n\r,.");

						while(st.hasMoreTokens()){
							stringToken += st.nextToken() + "\n";
						}
						
						
						
						sc.close();
						textArea.setText(text);
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					list = stringToken.split("\n");
				}
			}
		});
		btnNewButton.setBounds(970, 11, 243, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton updateTextArea = new JButton("Update text area");
		updateTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuilder(textArea.getText());
				String sbStr = sb.toString();
				stringToken = "";
				
				StringTokenizer st = new StringTokenizer(sbStr, " \t\n\r,.");

				while(st.hasMoreTokens()){
					stringToken += st.nextToken() + "\n";
				}
				
				list = stringToken.split("\n");
			}
		});
		updateTextArea.setForeground(Color.GRAY);
		updateTextArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		updateTextArea.setBackground(Color.BLACK);
		updateTextArea.setBounds(970, 164, 243, 40);
		frame.getContentPane().add(updateTextArea);
		
		JButton btnProcess = new JButton("Processing (1 step)");        ///////// 1 step
		btnProcess.setBackground(Color.BLACK);
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
		        for (int i = 0; i < list.length; i++) {                                                        
		        	
		        	for (int j = 0; j + i < list.length; j++) {                                                  
		        		
		        		for (int wordId = 0; wordId != list[i].length() && wordId != list[j].length(); wordId++) { 
		        			
		        			if (list[i].toCharArray()[wordId] < list[j + i].toCharArray()[wordId]) {               
			        			break;
			        		}
			        		
			        		if (list[i].toCharArray()[wordId] > list[j + i].toCharArray()[wordId]) {              
	        					
	        					String temp = list[j + i];
	        					list[j + i] = list[i];
	        					list[i] = temp;
	        					
	        					String output = "";
	        					String forToken = String.join(",", list);
	        					StringTokenizer st = new StringTokenizer(forToken, " \t\n\r,.");
	    						while(st.hasMoreTokens()){
	    							output += st.nextToken() + "\n";
	    						}
	        					textArea.setText(output.toString());
	        					return;
			        		}
		        		}
		        	}
		        }
		        
		        
			}
		});
		btnProcess.setForeground(Color.BLUE);
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProcess.setBounds(970, 62, 243, 40);
		frame.getContentPane().add(btnProcess);
		
		
		JButton btnProcessing = new JButton("Processing (result)");      ///////result
		btnProcessing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				while (flag) {
					
			        for (int i = 0; i < list.length; i++) {                                                            //����� ����� ������
			        	
			        	for (int j = 0; j + i < list.length; j++) {                                                    //��������� 1 � 2  1 � 3  1 � 4
			        		
			        		for (int wordId = 0; wordId != list[i].length() && wordId != list[j].length(); wordId++) { //����� ���� ������� ����� � �������� �� ����� �� ������ �������
			        			
			        			if (list[i].toCharArray()[wordId] < list[j + i].toCharArray()[wordId]) {               //���� ����� ������ �� ����� 
				        			break;
				        		}
				        		
			        			flag = false;
				        		if (list[i].toCharArray()[wordId] > list[j + i].toCharArray()[wordId]) {               //���� ����� ������ �� ����� ����������
		        					
		        					String temp = list[j + i];
		        					list[j + i] = list[i];
		        					list[i] = temp;
		        					flag = true;
		        					
		        					String output = "";
		        					String forToken = String.join(",", list);
		        					StringTokenizer st = new StringTokenizer(forToken, " \t\n\r,.");
		    						while(st.hasMoreTokens()){
		    							output += st.nextToken() + "\n";
		    						}
		        					textArea.setText(output.toString());
		        					break;
				        		}
			        		}
			        	}
			        }
					
				}
				
				
			}
		});
		btnProcessing.setForeground(Color.RED);
		btnProcessing.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProcessing.setBackground(Color.BLACK);
		btnProcessing.setBounds(970, 113, 243, 40);
		frame.getContentPane().add(btnProcessing);	
		
		
		JButton btnSave = new JButton("Save file");                       /////save file
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
		btnSave.setForeground(Color.GRAY);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(970, 215, 243, 40);
		frame.getContentPane().add(btnSave);
		
		
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
