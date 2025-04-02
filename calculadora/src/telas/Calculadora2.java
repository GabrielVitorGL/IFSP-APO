package telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField display = new JTextField();

	private JButton[] buttons = new JButton[20];
	private String[] labels = { "C", "M1", "M2", "+/-", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".",
			"0", "=", "/" };
	private Font fonte1 = new Font("Arial", Font.BOLD, 20);
	private Font fonte2 = new Font("Arial", Font.BOLD, 10);

	private String operador = "";
	private String valorAcumulado = "";
	private double memoria1;
	private double memoria2;
	private boolean apagaDisplay = false;

	public Calculadora2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculadora");
		this.setBounds(500, 500, 250, 370);
		this.setLayout(null);

		this.display.setBounds(5, 5, 215, 40);
		this.display.setFont(fonte1);

		int i = 0;
		for (int linha = 55; linha <= 275; linha += 55) {
			for (int coluna = 5; coluna <= 170; coluna += 55) {
				this.buttons[i] = new JButton(this.labels[i]);
				this.buttons[i].setBounds(coluna, linha, 50, 50);
				this.buttons[i].setFont((this.buttons[i].getText() == "+/-" ||
						this.buttons[i].getText() == "M1" ||
						this.buttons[i].getText() == "M2") ? fonte2 : fonte1);
				this.buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						digito(((JButton) e.getSource()).getText());
					}
				});
				this.add(this.buttons[i]);
				i++;
			}
		}
		this.add(display);
		this.setVisible(true);
	}

	public void igual() {
		if ((display.getText() != "") && (operador != "") && (valorAcumulado != "")) {
			switch (operador) {
				case "+": {
					display.setText((Double.parseDouble(valorAcumulado) + Double.parseDouble(display.getText())) + "");
				}
					break;
				case "-": {
					display.setText((Double.parseDouble(valorAcumulado) - Double.parseDouble(display.getText())) + "");

				}
					break;
				case "*": {
					display.setText((Double.parseDouble(valorAcumulado) * Double.parseDouble(display.getText())) + "");

				}
					break;
				case "/": {
					display.setText((Double.parseDouble(valorAcumulado) / Double.parseDouble(display.getText())) + "");
				}
					break;
			}
			valorAcumulado = "";
			operador = "";
		} else {

		}
	}

	public void execOperador(String identificador) {
		if ((valorAcumulado == "") && (operador == "")) {
			operador = identificador;
			valorAcumulado = display.getText();
			// display.setText("");
			apagaDisplay = true;
		} else {
			if ((valorAcumulado != "") && (operador != "")) {
				igual();
				operador = identificador;
				valorAcumulado = display.getText();
				apagaDisplay = true;
			}
		}
	}

	public void zerarTudo() {
		display.setText("");
		valorAcumulado = "";
		operador = "";
	}

	public void trocaSinal() {
		display.setText(Double.parseDouble(display.getText()) * -1 + "");
	}

	public void addMemoria(String identificador) {
		if (identificador == "M1") {
			if (this.memoria1 != 0) {
				display.setText(this.memoria1 + "");
				this.memoria1 = 0;
			} else {
				this.memoria1 = Double.parseDouble(display.getText());
				zerarTudo();
			}
		}
		if (identificador == "M2") {
			if (this.memoria2 != 0) {
				display.setText(this.memoria2 + "");
				this.memoria2 = 0;
			} else {
				this.memoria2 = Double.parseDouble(display.getText());
				zerarTudo();
			}
		}
	}

	public String digito(String identificador) {
		switch (identificador) {
			case "C": {
				zerarTudo();
			}
				break;
			case "M1": {
				addMemoria(identificador);
			}
				break;
			case "M2": {
				addMemoria(identificador);
			}
				break;
			case "+/-": {
				trocaSinal();
			}
				break;
			case "+": {
				execOperador(identificador);
			}
				break;
			case "-": {
				execOperador(identificador);
			}
				break;
			case "*": {
				execOperador(identificador);
			}
				break;
			case "/": {
				execOperador(identificador);
			}
				break;
			case "=": {
				igual();
			}
				break;
			case ".": {
				if (!display.getText().contains(".")) {
					display.setText(display.getText() + identificador);
				}
			}
				break;
			default: {
				if (apagaDisplay) {
					display.setText("");
					apagaDisplay = false;
				}
				display.setText(display.getText() + identificador);
			}
		}

		return "";
	}
}