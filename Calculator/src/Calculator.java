import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JPanel numPanel, topPanel, sidePanel;
	private static final int WIDTH = 350;
	private static final int HEIGHT = 500;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] funcButtons = new JButton[9];
	private JButton addBtn, subBtn, mulBtn, divBtn, equBtn, decBtn, clrBtn, delBtn, negBtn;
	private Color numBtnColors, calcBgColor, funcBtnColors, equBtnColor;
	private double num1 = 0, num2 = 0, total = 0;
	private char operator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		funcBtnColors = new Color(25, 25, 25);
		numBtnColors = new Color(10, 10, 10);
		calcBgColor = new Color(55, 55, 55);
		equBtnColor = new Color(0, 57, 85);

		frame = new JFrame("Calculator");
		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(calcBgColor);

		textField = new JTextField();
		textField.setBounds(2, 11, 336, 73);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setForeground(Color.WHITE);
		textField.setBackground(calcBgColor);

		// function buttons
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("x");
		divBtn = new JButton("/");
		equBtn = new JButton("=");
		decBtn = new JButton(".");
		clrBtn = new JButton("Clear");
		delBtn = new JButton("del");
		negBtn = new JButton("-/+");

		funcButtons[0] = addBtn;
		funcButtons[1] = subBtn;
		funcButtons[2] = mulBtn;
		funcButtons[3] = divBtn;
		funcButtons[4] = equBtn;
		funcButtons[5] = decBtn;
		funcButtons[6] = delBtn;
		funcButtons[7] = clrBtn;
		funcButtons[8] = negBtn;

		for (int i = 0; i < funcButtons.length; i++) {
			funcButtons[i].addActionListener(this);
			funcButtons[i].setFocusable(false);
			funcButtons[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			funcButtons[i].setForeground(Color.WHITE);
			funcButtons[i].setOpaque(true);
			funcButtons[i].setBorderPainted(false);
			funcButtons[i].setBackground(funcBtnColors);
			// decimal and negative btns
			funcButtons[5].setBackground(numBtnColors);
			funcButtons[8].setBackground(numBtnColors);

		}
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton("" + i);
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			numberButtons[i].setForeground(Color.WHITE);
			numberButtons[i].setOpaque(true);
			numberButtons[i].setBorderPainted(false);
			numberButtons[i].setBackground(numBtnColors);

		}

		numPanel = new JPanel();
		numPanel.setBounds(2, 189, 248, 274);
		numPanel.setBackground(calcBgColor);
		frame.getContentPane().add(numPanel);
		numPanel.setLayout(new GridLayout(4, 3, 2, 2));
		numPanel.add(numberButtons[7]);
		numPanel.add(numberButtons[8]);
		numPanel.add(numberButtons[9]);
		numPanel.add(numberButtons[4]);
		numPanel.add(numberButtons[5]);
		numPanel.add(numberButtons[6]);
		numPanel.add(numberButtons[1]);
		numPanel.add(numberButtons[2]);
		numPanel.add(numberButtons[3]);
		numPanel.add(negBtn);
		numPanel.add(numberButtons[0]);
		numPanel.add(decBtn);

		topPanel = new JPanel();
		topPanel.setBounds(2, 120, 248, 67);
		topPanel.setBackground(calcBgColor);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(new GridLayout(1, 4, 2, 2));
		topPanel.add(clrBtn);
		topPanel.add(delBtn);
		topPanel.add(divBtn);

		sidePanel = new JPanel();
		sidePanel.setBounds(251, 120, 83, 206);
		sidePanel.setBackground(calcBgColor);
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(new GridLayout(3, 1, 2, 2));
		sidePanel.add(mulBtn);
		sidePanel.add(subBtn);
		sidePanel.add(addBtn);
//		sidePanel.add(equBtn);
		equBtn.setBounds(251, 327, 83, 133);
		equBtn.setBackground(equBtnColor);
		frame.getContentPane().add(equBtn);
//		frame.setResizable(false);

		hover(numberButtons, funcButtons, equBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < numberButtons.length; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}

		if (e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}

		if (e.getSource() == mulBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}

		if (e.getSource() == divBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if (e.getSource() == decBtn) {
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource() == negBtn) {
			Double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));

		}
		if (e.getSource() == clrBtn) {
			textField.setText("");

		}

		if (e.getSource() == delBtn) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == equBtn) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
			case '+':
				total = num1 + num2;
				break;
			case '-':
				total = num1 - num2;
				break;
			case '*':
				total = num1 * num2;
				break;
			case '/':
				total = num1 / num2;
				break;
			}

			textField.setText(String.valueOf(total));
			num1 = total;

		}

	}

	private void hover(JButton[] numberButtons, JButton[] funcButtons, JButton equBtn) {

		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i].addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent e) {
					for (int i = 0; i < numberButtons.length; i++)
						if (numberButtons[i] == e.getSource()) {
							numberButtons[i].setBackground(Color.GRAY);
						}
				}

				public void mouseExited(MouseEvent e) {
					for (int i = 0; i < numberButtons.length; i++)
						if (numberButtons[i] == e.getSource()) {
							numberButtons[i].setBackground(numBtnColors);
						}
				}
			});

		}
		for (int i = 0; i < funcButtons.length; i++) {
			funcButtons[i].addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent e) {
					for (int i = 0; i < funcButtons.length; i++)
						if (funcButtons[i] == e.getSource()) {
							funcButtons[i].setBackground(Color.GRAY);
						}
				}

				public void mouseExited(MouseEvent e) {
					for (int i = 0; i < funcButtons.length; i++)
						if (funcButtons[i] == e.getSource()) {
							funcButtons[i].setBackground(funcBtnColors);
							funcButtons[5].setBackground(numBtnColors);
							funcButtons[8].setBackground(numBtnColors);
						}
				}
			});

		}

		equBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				funcButtons[4].setBackground(new Color(0, 106, 157));
			}

			public void mouseExited(MouseEvent e) {
				funcButtons[4].setBackground(equBtnColor);

			}
		});

	}

}
