package lab11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow11 {
	
	private Scanner sc = null;

	private JFrame frame;
	private JTextField textField;
	char [][] buffer = new char[10][15];
	String stringToken = "";
	boolean flag = true;
	StringBuilder sb;
	String text = "";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow11 window = new MainWindow11();
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
	public MainWindow11() {
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
		frame.setBounds(100, 100, 1050, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(781, 432, 243, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		textArea.setBounds(10, 28, 726, 444);
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
		btnNewButton.setBounds(781, 11, 243, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton updateTextArea = new JButton("Update text area");
		updateTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea.getText();
				textArea.setText(text);
				
			}
		});
		updateTextArea.setForeground(Color.GRAY);
		updateTextArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		updateTextArea.setBackground(Color.BLACK);
		updateTextArea.setBounds(781, 113, 243, 40);
		frame.getContentPane().add(updateTextArea);
		
		
		JButton btnProcessing = new JButton("Processing (result)");      ///////result
		btnProcessing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//MyList list = new MyList();
				//list.AddToHead(5);
				//list.AddToHead(10);
				//list.AddToHead(15);
				//System.out.println(list.toString());
				
				
				LinkList linkList = new LinkList();
				
				/*Scanner input = new Scanner(System.in);
				int n = input.nextInt();
				int [] x = new int [n];
				for (int i = 0; i < n; i ++) {
					x[i] = i;
				}
				input.close();*/
				
				linkList.createLinkList(text);
				textArea.setText(linkList.displayLinkList());
				
				linkList.reverseLinkList();
				textArea.setText(linkList.displayLinkList());
				

				
			}
		});
		btnProcessing.setForeground(Color.RED);
		btnProcessing.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProcessing.setBackground(Color.BLACK);
		btnProcessing.setBounds(781, 62, 243, 40);
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
		btnSave.setBounds(781, 164, 243, 40);
		frame.getContentPane().add(btnSave);
		
		
		JLabel lblNewLabel_1 = new JLabel("Current path:");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(840, 381, 145, 40);
		frame.getContentPane().add(lblNewLabel_1);
		

	}

}