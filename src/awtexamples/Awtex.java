package awtexamples;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Awtex extends JFrame implements ActionListener {

	private JButton calc;
	private JButton clear;
	private JTextField a;
	private JTextField b;
	private JTextField result;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem close;

	public Awtex() {
		prepareGUI();
	}

	public void prepareGUI() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Window Closed");
				System.exit(0);
			}
		});

		JPanel panel1 = new JPanel();
		JPanel panel3 = new JPanel();

		menu = new JMenu("File");
		menuBar = new JMenuBar();
		menuBar.add(menu);
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		a = new JTextField();
		b = new JTextField();
		calc = new JButton("Calculate");
		clear = new JButton("Clear");
		result = new JTextField();
		close = new JMenuItem("Exit");

		menu.add(close);
		setLayout(new GridLayout(4, 1));
		panel1.add(menuBar);

		add(panel1);
		add(panel);
		add(panel2);
		add(panel3);
		panel.setLayout(new FlowLayout());
		a.setColumns(10);
		b.setColumns(10);
		result.setColumns(10);

		a.setText("Enter number 1");
		b.setText("Enter number 2");
		result.setText("Result");

		panel.add(a);
		panel.add(b);

		panel2.setLayout(new FlowLayout());
		panel2.add(calc);
		panel2.add(clear);
		panel3.add(result);
		calc.addActionListener(this);
		clear.addActionListener(this);
		close.addActionListener(this);
		a.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				a.setText(null);
			}
		});

		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				b.setText(null);
			}
		});

	}

	public static void main(String args[]) {
		Awtex ex = new Awtex();
		ex.setLocation(10, 10);
		ex.setSize(400, 400);
		ex.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == calc) {
			int num1 = Integer.parseInt(a.getText());
			int num2 = Integer.parseInt(b.getText());

			int sum = add(num1, num2);

			result.setText(Integer.toString(sum));
		} else if (e.getSource() == clear) {
			a.setText("Enter number 1");
			b.setText("Enter number 2");
			result.setText("Result");
		} else if (e.getSource() == close) {
			dispose();
		}
	}

	public int add(int a, int b) {
		return a + b;
	}

}
