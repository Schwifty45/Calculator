import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private JPanel MainPanel;
    private JTextField textField1;
    private JButton plusBtn;
    private JButton milesBtn;
    private JButton multiplyBtn;
    private JButton divBtn;
    private JButton clearBtn;
    private JLabel resultLabel;
    private JButton equalsButton;

    private int sign=3;
    private double temp=0;

    private ArrayList<Double> numbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();

public Calculator() {
    add(MainPanel);
    setSize(400, 400);
    setTitle("Calculator");

    plusBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()) {
                double number = Double.parseDouble(textField1.getText());
                numbers.add(number);
                operators.add("+");
                textField1.setText("");
            }
        }
    });

    milesBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()) {
                double number = Double.parseDouble(textField1.getText());
                numbers.add(number);
                operators.add("-");
                textField1.setText("");
            }
        }
    });

    multiplyBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()) {
                double number = Double.parseDouble(textField1.getText());
                numbers.add(number);
                operators.add("*");
                textField1.setText("");
            }
        }
    });

    divBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()) {
                double number = Double.parseDouble(textField1.getText());
                numbers.add(number);
                operators.add("/");
                textField1.setText("");
            }
        }
    });

    clearBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("");
            resultLabel.setText("");
            numbers.clear();
            operators.clear();
        }
    });

    equalsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textField1.getText().isEmpty()) {
                double number = Double.parseDouble(textField1.getText());
                numbers.add(number);
            }

            double result = numbers.get(0);

            for (int i = 0; i < operators.size(); i++) {
                String operator = operators.get(i);
                double number2 = numbers.get(i + 1);

                switch (operator) {
                    case "+":
                        result += number2;
                        break;
                    case "-":
                        result -= number2;
                        break;
                    case "*":
                        result *= number2;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result /= number2;
                        } else {
                            resultLabel.setText("Cannot divide by zero");
                            return;
                        }
                        break;
                }
            }

            resultLabel.setText(String.valueOf(result));
            numbers.clear();
            operators.clear();
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
