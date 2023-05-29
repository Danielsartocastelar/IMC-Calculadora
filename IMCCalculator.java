/**
 * 
 */
/**
 * @author daniel
 *
 */
package IMCCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    private JTextField weightField;
    private JTextField heightField;
    private JLabel resultLabel;
    private JLabel classificationLabel;

    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(10, 2));

        mainPanel.add(new JLabel("Peso (Kg):"));
        weightField = new JTextField();
        mainPanel.add(weightField);

        mainPanel.add(new JLabel("Altura (Cm):"));
        heightField = new JTextField();
        mainPanel.add(heightField);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(e -> calculateIMC());
        mainPanel.add(calculateButton);

        mainPanel.add(new JLabel("Resultado:"));
        resultLabel = new JLabel();
        mainPanel.add(resultLabel);

        mainPanel.add(new JLabel("Classificação:"));
        classificationLabel = new JLabel();
        mainPanel.add(classificationLabel);

        add(mainPanel);

        setVisible(true);
    }

    private void calculateIMC() {
        double weight;
        double height;
        try {
            weight = Double.parseDouble(weightField.getText());
            height = Double.parseDouble(heightField.getText()) / 100;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para peso e altura.");
            return;
        }

        double imc = weight / (height * height);
        String result;
        String classification;

        if (imc < 18.5) {
            result = "Abaixo do peso";
            classification = "Magreza";
        } else if (imc < 25) {
            result = "Peso normal";
            classification = "Normal";
        } else if (imc < 30) {
            result = "Sobrepeso";
            classification = "Acima do peso";
        } else if (imc < 35) {
            result = "Obesidade grau I";
            classification = "Obesidade";
        } else if (imc < 40) {
            result = "Obesidade grau II";
            classification = "Obesidade";
        } else {
            result = "Obesidade grau III";
            classification = "Obesidade";
        }

        resultLabel.setText(result);
        classificationLabel.setText(classification);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IMCCalculator::new);
    }
}
