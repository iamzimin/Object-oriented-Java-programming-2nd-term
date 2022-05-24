package lab5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class lab5Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab5Application window = new lab5Application();
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
	public lab5Application() {
		initialize();
	}
	
	
	
	public double recur(double N, long x, long factorial, double result) { //////////////////////рекурсия
		if (x <= N) 
		{
			if (x != 0)
			{
				factorial = x * 2;
				factorial = factor(factorial);			
			}
			double pow = x * 2;
			result += (Math.pow(N, pow)/factorial + recur(N, x + 1, factorial, result));
		}	
		
		return result;
	}
	
	public long factor(long x){
	     
	    if (x == 1){
	        return 1;
	    }
	    return x * factor(x - 1);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(629, 50, 145, 29);
		spinner.setValue(1);
		frame.getContentPane().add(spinner);
		
		JPanel panel = new MyPanel(spinner);
		panel.setBounds(26, 11, 600, 350);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Banshee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.repaint();
                spinner.setValue((int)spinner.getValue());
			}
		});
		
		
		
		
		btnNewButton.setBounds(629, 90, 145, 29);
		frame.getContentPane().add(btnNewButton);
		

		

		
		JLabel lblNewLabel = new JLabel("\u0420\u0435\u043A\u0443\u0440\u0441\u0438\u044F \u0444\u043E\u0440\u043C\u0443\u043B\u044B");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel.setBounds(629, 425, 145, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0420\u0435\u043A\u0443\u0440\u0441\u0438\u044F \u0437\u0432\u0435\u0437\u0434\u044B");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(629, 11, 145, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblChX = new JLabel("ch x =");
		lblChX.setForeground(Color.MAGENTA);
		lblChX.setFont(new Font("Monospaced", Font.BOLD, 50));
		lblChX.setBounds(26, 441, 190, 49);
		frame.getContentPane().add(lblChX);
		
		
		
		JTextArea input = new JTextArea();
		input.setFont(new Font("Monospaced", Font.BOLD, 18));
		input.setText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E");
		input.setBounds(629, 462, 145, 29);
		frame.getContentPane().add(input);
		
		JTextArea output = new JTextArea();
		output.setFont(new Font("Monospaced", Font.BOLD, 50));
		output.setText("\u043E\u0442\u0432\u0435\u0442");
		output.setBounds(221, 434, 350, 59);
		frame.getContentPane().add(output);
		
		
		JButton btnNorka = new JButton("Norka");
		btnNorka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double N = Float.parseFloat(input.getText());
				if (N < 0) {
					N *= -1;
				}
				long x = 0;
				long factorial = 1;
				double result = 0;
				String answer = "" + recur(N, x, factorial, result);
				
				output.setText(answer);
				
			}
		});
		btnNorka.setBounds(629, 505, 145, 29);
		frame.getContentPane().add(btnNorka);
		
	}
}






