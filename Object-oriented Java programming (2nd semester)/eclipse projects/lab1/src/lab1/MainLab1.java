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

package lab1;

import java.util.Scanner;

/*
 * Name class MainLab1
 * 
 * Version: 2021-12 (4.22.0)
 * 
 * Author ������� �����
 */
public class MainLab1 {

	public static void main(String[] args) {
		System.out.print("������� 1(while) ��� 2(do while): ");
		int x; // ������������� ����� ���� ��������� ���������
		Scanner flagX = new Scanner(System.in);
		x = flagX.nextInt();
		
		if (x == 1) { // �������� ��� ����� � ���������� ����� 1
			int n; // ���� ����� ��� ����� ���������
			int i = 1; // ����������
			Scanner sc = new Scanner(System.in);
			System.out.print("������� n: ");
			n = sc.nextInt();
			double count = 0.0; // ���������� � ������� ��������� �����
			double number = 0.0; // ���������� � ������� ������������ ������������� �����
			
			while (i <= n)	{ // ���� �������� ������
				number = 1.0 / i;
				count += number;
				i++;
			}
			System.out.print("" + count + " ");
			sc.close();
		}
		
		else if (x == 2) { // �������� ��� ����� � ���������� ����� 2
			int n; // ���� ����� ��� ����� ���������
			int i = 1; // ����������
			Scanner sc = new Scanner(System.in);
			System.out.print("������� n: ");
			n = sc.nextInt();
			double count = 0.0; // ���������� � ������� ��������� �����
			double number = 0.0; // ���������� � ������� ������������ ������������� �����
			
			if (n != 0) {
				do { // ���� �������� ������
					number = 1.0 / i;
					count += number;
					i++;
				} while (i <= n);
			}
			System.out.print("" + count + " ");
			sc.close();
		}
		flagX.close();
	}
}