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
package lab4;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Rectangle;

/*
 * Name class MainLab1
 * 
 * Version: 2021-12 (4.22.0)
 * 
 * Author ������� �����
 */
public class lab4Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab4Application window = new lab4Application();
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
	public lab4Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Label = new MyPanel();
		Label.setBounds(10, 11, 800, 404);
		frame.getContentPane().add(Label);
	}
}
