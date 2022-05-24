/*
 * @Lab1.java 1.82 02/02/2022
 *
 * �������� (c) 1993-1996 Sun Microsystems, Inc. ��� ����� ��������.
 *
 * ��� ����������� ����������� �������� ���������������� � �������� ����������� Sun
 * Microsystems, Inc. (����������������� �����������). �� �� �������
 * ���������� ����� ���������������� ���������� � ������������ �� ������ �
 * ������������ � ��������� ������������� ����������, � ������� �� ��������
 * � Sun.
 *
 * SUN �� ���� ������� ��������, ����� ��� ��������� (������� - �� ��
 * ������������� ��� - �������� �������������), ������������ ������˨�����
 * ���������� ��� ����������� �������, ��� ���������� ������ ������������
 * �������� ��� �����-���� ����� ��� ��� ����� ������������� ��� ����������
 * ������ ����������� �� ����� �������� �����-���� �������� ������� �������,
 * ��������� ����, ������������ ����� ��� ���� ����.
 */
package Pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

/*
 * Name class MainLab1
 * 
 * Version: 2021-12 (4.22.0)
 * 
 * Author ������� �����
 */
public class lab3Application {

	private JFrame MyLab3;
	private JTextField FieldForN;
	private JTextField Body;
	private JTextField Legs;
	private JTextField Hands;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab3Application window = new lab3Application();
					window.MyLab3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lab3Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyLab3 = new JFrame();
		MyLab3.setIconImage(Toolkit.getDefaultToolkit().getImage(lab3Application.class.getResource("/Images/norka.jpg")));
		MyLab3.getContentPane().setBackground(Color.BLACK);
		MyLab3.setTitle("MyLab3");
		MyLab3.setBounds(100, 100, 800, 500);
		MyLab3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyLab3.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter number n:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 177, 33);
		lblNewLabel.setBackground(Color.WHITE);
		MyLab3.getContentPane().add(lblNewLabel);
		
		FieldForN = new JTextField();
		FieldForN.setBounds(206, 15, 291, 29);
		FieldForN.setBackground(Color.LIGHT_GRAY);
		MyLab3.getContentPane().add(FieldForN);
		FieldForN.setColumns(10);
		
		JRadioButton Eye_2 = new JRadioButton("");
		Eye_2.setSelected(true);
		Eye_2.setBackground(Color.WHITE);
		Eye_2.setForeground(Color.BLACK);
		Eye_2.setBounds(712, 314, 21, 21);
		MyLab3.getContentPane().add(Eye_2);
		
		Body = new JTextField();
		Body.setBounds(709, 332, 5, 79);
		MyLab3.getContentPane().add(Body);
		Body.setColumns(10);
		
		Legs = new JTextField();
		Legs.setColumns(10);
		Legs.setBounds(664, 404, 88, 7);
		MyLab3.getContentPane().add(Legs);
		
		Hands = new JTextField();
		Hands.setColumns(10);
		Hands.setBounds(664, 354, 88, 7);
		MyLab3.getContentPane().add(Hands);
		
		JLabel OutputLabel = new JLabel("Your Answer");
		OutputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		OutputLabel.setForeground(Color.WHITE);
		OutputLabel.setBackground(Color.WHITE);
		OutputLabel.setBounds(30, 55, 478, 356);
		MyLab3.getContentPane().add(OutputLabel);
		
		JRadioButton While_ON_OFF = new JRadioButton("While");
		While_ON_OFF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		While_ON_OFF.setSelected(true);
		While_ON_OFF.setBounds(519, 15, 60, 29);
		MyLab3.getContentPane().add(While_ON_OFF);
		
		
		
		
		JButton Button_OK = new JButton("OK");
		Button_OK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = Integer.parseInt(FieldForN.getText());
				String answer = "";
				
		        int i = 0; // ���������� ��� ������
		        int j = 0; // ���������� ��� ������
	        	int a = 1; // ���������� ��������� ������
	        	int b = 1; // ���������� ��������� �������
	        	answer += ("<html>");
	        	
	        	if (While_ON_OFF.isSelected()) {
	        		
	        		while (a <= n) { // ���� ������ �����
		        		
		            	while (b <= n) { // ���� ���������� ���� �� �������� � �������� "��������"
		            		answer += (b + "&ensp;");
		            		b++;
		            	}
		        		b = 1 + a; // ���������� ������� ����� � ������
		        		answer += ("<br>");
		            	if (a < n) {
		            		i = 0;
		            		
		            		while (i < a * 2) { // ���� ���������� ��������� ����� �������
		            			answer += ("&ensp;");
		            			i++;
		            		}
		            	}
		            	a++;
		        	}
		        	
		        	a = 2;
		        	
		        	while (a <= n) { // ���� ���������� �������� ����� �������
		        		i = 0;
		        		
		        		while (i < (n - 1) * 2) { // ���� ���������� �������� ����� �������
		        			answer += ("&ensp;");
		        			i++;
		        		}
		        		j = 0; // ���������� � ������� ������� ����������� �����
		        		
		            	while (j < a) { // ���� ������ ���� �� �������� � �������� "��������"
		            		answer += (n - j + "&ensp;");
		            		j++;
		            	}
		            	answer += ("<br>");
		            	a++;
		        	}
		        	answer += ("</html>");
	        	}
	        	
	        	
	        	
	        	else {
		        	if (n != 0) {
		        		
		            	do { //���� ������ �����
		            		
		                	do { //���� ���������� ���� �� �������� � �������� "��������"
		                		answer += (b + "&ensp;");
		                		b++;
		                	} while (b <= n);
		            		b = 1 + a; //���������� ������� ����� � ������
		            		answer += ("<br>");
		                	if (a < n) {
		                		i = 0;
		                		
		                		do { // ���� ���������� ��������� ����� �������
		                			answer += ("&ensp;");
		                			i++;
		                		} while (i < a * 2); 
		                	}
		                	a++;
		            	} while (a <= n);
		        	}
		        	
		        	
		        	a = 2;
		        	if ((n != 0) && (n != 1)) {
		        		
		        		do {
		        			i = 0;
		            		
		            		do { // ���� ���������� �������� ����� �������
		            			answer += ("&ensp;");
		            			i++;
		            		} while (i < (n - 1) * 2);
		            		j = 0; // ���������� � ������� ������� ����������� �����
		            		
		                	do { //���� ������ ���� �� �������� � �������� "��������"
		                		answer += (n - j + "&ensp;");
		                		j++;
		                	} while (j < a);
		                	answer += ("<br>");
		                	a++;
		            	} while (a <= n);
		        	}
	        	}
	        	
	        	OutputLabel.setText(answer);
			}
		});
		Button_OK.setBounds(10, 428, 764, 22);
		MyLab3.getContentPane().add(Button_OK);
		
		JRadioButton Eye_1 = new JRadioButton("");
		Eye_1.setSelected(true);
		Eye_1.setForeground(Color.BLACK);
		Eye_1.setBackground(Color.WHITE);
		Eye_1.setBounds(691, 314, 21, 21);
		MyLab3.getContentPane().add(Eye_1);
		
		JLabel NorkaIMG = new JLabel("");
		NorkaIMG.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/norka.jpg")).getImage().getScaledInstance(261, 183, Image.SCALE_SMOOTH)));
		NorkaIMG.setBounds(519, 61, 255, 200);
		MyLab3.getContentPane().add(NorkaIMG);
	}
}
