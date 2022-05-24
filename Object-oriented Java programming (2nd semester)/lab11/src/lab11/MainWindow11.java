package lab11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class MainWindow11 {
		
	MyList list = new MyList();
	
	private JFrame frame;
	boolean flag = true;
	boolean first = true;
	ListElem activeElem = list.head;
	StringBuilder sb;
	String text = "";
	int count = 0;
	int countNumberElem = 1;
	
	
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
		frame.setBounds(100, 100, 1050, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea_QuantityList = new JTextArea();
		textArea_QuantityList.setForeground(Color.WHITE);
		textArea_QuantityList.setBackground(Color.BLACK);
		textArea_QuantityList.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea_QuantityList.setBounds(781, 198, 243, 31);
		frame.getContentPane().add(textArea_QuantityList);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 25));
		textArea_1.setBounds(115, 18, 270, 33);
		frame.getContentPane().add(textArea_1);		
		
		JButton btnHead = new JButton("Head");
		btnHead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea_1.getText();
				if (text.isEmpty()) {
					return;
				}
				list.AddToHead(text);

			}
		});
		btnHead.setForeground(Color.GRAY);
		btnHead.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHead.setBackground(Color.BLACK);
		btnHead.setBounds(529, 18, 75, 33);
		frame.getContentPane().add(btnHead);
		
		JButton btnTail = new JButton("Tail");
		btnTail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea_1.getText();
				if (text.isEmpty()) {
					return;
				}
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
				if (text.isEmpty()) {
					return;
				}
				list.deleteElement(text);
				
			}
		});
		btnDelete.setForeground(Color.GRAY);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(691, 18, 91, 34);
		frame.getContentPane().add(btnDelete);	
		
		JTextArea txtrOutput = new JTextArea();
		txtrOutput.setText("                                       \"output\"");
		txtrOutput.setForeground(Color.WHITE);
		txtrOutput.setBackground(Color.BLACK);
		txtrOutput.setFont(new Font("Arial", Font.PLAIN, 30));
		txtrOutput.setBounds(10, 69, 761, 328);
		frame.getContentPane().add(txtrOutput);
		
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
						txtrOutput.setText(list.toStringReverse());
					}
					else if (!rdbtnReverse.isSelected()) {
						txtrOutput.setText(list.toString());
					}
				}
				String QuantityList = "���������� ��������� � ������: " + list.size(list);
				textArea_QuantityList.setText(QuantityList);
				
				if (list.error()) {
					txtrOutput.setText("������ � ����� �������\n�������� ������ � ��������� �������");
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
				String QuantityList = "���������� ��������� � ������: " + list.size(list);
				textArea_QuantityList.setText(QuantityList);
				
			}
		});
		btnClear.setForeground(Color.WHITE);
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
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(781, 154, 243, 33);
		frame.getContentPane().add(btnSave);
		
		JLabel lblNewLabel_1_1 = new JLabel("Element:");
		lblNewLabel_1_1.setForeground(Color.GREEN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 18, 95, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(395, 19, 45, 31);
		frame.getContentPane().add(spinner);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text = textArea_1.getText();
				int index = (Integer)spinner.getValue();
				if (text.isEmpty()) {
					return;
				}
				list.addByIndex(text, index);
				
			}
		});
		btnAdd.setForeground(Color.GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(448, 18, 75, 33);
		frame.getContentPane().add(btnAdd);	
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Arial", Font.BOLD, 30));
		textArea.setBounds(779, 307, 245, 46);
		frame.getContentPane().add(textArea);
		
		JButton btnLeft = new JButton("<<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (list.isEmpty()) {
					textArea.setText("null");
					return;
				}
				
				if (list.size(list) == 1) {
					if (countNumberElem == 1) {
						textArea.setText("Head");
					}
					else if (countNumberElem == 2) {
						countNumberElem--;
						textArea.setText(list.displayList());
					}
					return;
				}
				
				if (count < 0) {
					count++;
					return;
				}

				count--;
				textArea.setText(list.displayElemTail());
				
			}
		});
		btnLeft.setFont(new Font("Arial", Font.BOLD, 25));
		btnLeft.setBounds(782, 364, 118, 33);
		frame.getContentPane().add(btnLeft);
		
		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.isEmpty()) {
					textArea.setText("null");
					return;
				}
				if (list.size(list) == 1) {
					if (countNumberElem == 1) {
						textArea.setText(list.displayList());
						countNumberElem++;
					}
					else if (countNumberElem == 2) {
						textArea.setText("Tail");
					}
					return;
				}
				
				if (count > list.size(list)) {
					count--;
					return;
				}
				count++;
				
				textArea.setText(list.displayElemHead());
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_1.setBounds(906, 364, 118, 33);
		frame.getContentPane().add(btnNewButton_1);


	}
}
