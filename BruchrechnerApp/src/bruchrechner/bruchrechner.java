package bruchrechner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bruchrechner {
    private JButton divBtn;
    private JButton multiBtn;
    private JButton subBtn;
    private JButton addBtn;
    private JPanel panel1;
    private JTextField numerator1;
    private JTextField denominator1;
    private JTextField numerator2;
    private JTextField denominator2;
    private JTextField resultNumerator;
    private JTextField resultDenominator;
    private JLabel equalsLabel;
    private JLabel operatorLabel;
    private JButton equalsBtn;
    private JLabel GuiName;

    private char currentOperation;
    private Calculator calculator = new Calculator();

    public bruchrechner() {
        // Action Listener für die Buttons hinzufügen, damit man die rechenoperatoren auswählen kann und es das symbol anzeigt im []
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOperation = '+';  // Addition
                operatorLabel.setText("+");
            }
        });

        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOperation = '-';  // Subtraktion
                operatorLabel.setText("-");
            }
        });

        multiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOperation = '*';
                operatorLabel.setText("×");
            }
        });

        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOperation = '/';
                operatorLabel.setText("÷");
            }
        });

        // Berechnung durchführen, wenn der "=" Button geklickt wird
        equalsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(numerator1.getText());
                    int den1 = Integer.parseInt(denominator1.getText());
                    int num2 = Integer.parseInt(numerator2.getText());
                    int den2 = Integer.parseInt(denominator2.getText());

                    if (den1 == 0 || den2 == 0) {
                        JOptionPane.showMessageDialog(null, "Nenner darf nicht null sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int[] result = null;

                    // Rechenoperation anhand des gewählten Operators durchführen
                    switch (currentOperation) {
                        case '+':
                            result = calculator.add(num1, den1, num2, den2);
                            break;
                        case '-':
                            result = calculator.subtract(num1, den1, num2, den2);
                            break;
                        case '*':
                            result = calculator.multiply(num1, den1, num2, den2);
                            break;
                        case '/':
                            try {
                                result = calculator.divide(num1, den1, num2, den2);
                            } catch (ArithmeticException ex) {
                                JOptionPane.showMessageDialog(null, "Division durch Null!", "Fehler", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }

                    // Das Ergebnis anzeigen
                    if (result != null) {
                        resultNumerator.setText(String.valueOf(result[0]));
                        resultDenominator.setText(String.valueOf(result[1]));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte gültige ganze Zahlen eingeben!", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bruchrechner");
        frame.setContentPane(new bruchrechner().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 250);
        frame.setResizable(false);
    }
}
