package lab11_new;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class MainWindow11 {
		
	MyList list = new MyList();
	
	private JFrame frame;
	private JTextField textField;
	char [][] buffer = new char[10][15];
	String stringToken = "";
	boolean flag = true;
	boolean first = true;
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
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 25));
		textArea_1.setBounds(115, 18, 400, 33);
		frame.getContentPane().add(textArea_1);		
		
		JButton btnAdd = new JButton("Head");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea_1.getText();
				list.AddToHead(text);

			}
		});
		btnAdd.setForeground(Color.GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(525, 18, 75, 33);
		frame.getContentPane().add(btnAdd);
		
		JButton btnTail = new JButton("Tail");
		btnTail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea_1.getText();
				list.AddToTail(text);
				
			}
		});
		btnTail.setForeground(Color.GRAY);
		btnTail.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTail.setBackground(Color.BLACK);
		btnTail.setBounds(610, 18, 75, 33);
		frame.getContentPane().add(btnTail);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				text = textArea_1.getText();
				
				list.deleteElement(text);
				
				
				
			}
		});
		btnDelete.setForeground(Color.GRAY);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(691, 18, 95, 34);
		frame.getContentPane().add(btnDelete);	
		
		JTextArea txtrOutput = new JTextArea();
		txtrOutput.setText("                                       \"output\"");
		txtrOutput.setForeground(Color.WHITE);
		txtrOutput.setBackground(Color.BLACK);
		txtrOutput.setFont(new Font("Arial", Font.PLAIN, 30));
		txtrOutput.setBounds(10, 69, 726, 393);
		frame.getContentPane().add(txtrOutput);
		
		/*JButton btnNewButton = new JButton("Add file");                         ///////add file
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
						txtrOutput.setText(text);
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setBounds(781, 18, 243, 33);
		frame.getContentPane().add(btnNewButton);*/
		
		/*JButton updateTextArea = new JButton("Update text area");
		updateTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = txtrOutput.getText();
				txtrOutput.setText(text);
				
			}
		});
		updateTextArea.setForeground(Color.RED);
		updateTextArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		updateTextArea.setBackground(Color.BLACK);
		updateTextArea.setBounds(781, 106, 243, 33);
		frame.getContentPane().add(updateTextArea);*/
		
		JRadioButton rdbtnReverse = new JRadioButton("Reverse output");
		rdbtnReverse.setForeground(Color.WHITE);
		rdbtnReverse.setBackground(Color.BLACK);
		rdbtnReverse.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnReverse.setBounds(819, 18, 180, 33);
		frame.getContentPane().add(rdbtnReverse);
		
		JButton btnProcessing = new JButton("Print");      ///////result
		btnProcessing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				if (list.isEmpty()) {
					txtrOutput.setText("null");
				}
				else {
					
					if (rdbtnReverse.isSelected()) {
						if (flag) {
							list.reverseList();
						}
						txtrOutput.setText(list.displayList());
						flag = false;
					}
					if (!rdbtnReverse.isSelected()) {
						if (!flag) {
							list.reverseList();
						}
						txtrOutput.setText(list.displayList());
						flag = true;
					}
				
				}
				

				
			}
		});
		btnProcessing.setForeground(Color.WHITE);
		btnProcessing.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProcessing.setBackground(Color.BLACK);
		btnProcessing.setBounds(781, 66, 243, 33);
		frame.getContentPane().add(btnProcessing);	
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.clear();
				first = true;
				
			}
		});
		btnClear.setForeground(Color.BLUE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(781, 110, 243, 33);
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save file");                       /////save file
		btnSave.setBackground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				int res = fd.showSaveDialog(frame);
				if (res == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fd.getSelectedFile().getAbsolutePath())));
						bw.write(txtrOutput.getText());
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSave.setForeground(Color.RED);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(781, 154, 243, 33);
		frame.getContentPane().add(btnSave);
		
		
		JLabel lblNewLabel_1 = new JLabel("Current path:");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(832, 381, 145, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Element:");
		lblNewLabel_1_1.setForeground(Color.GREEN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 18, 95, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		

		

		

		

		

		

		

	}
}
