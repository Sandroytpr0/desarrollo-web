package prestamocuotas;

import javax.swing.*;
import java.awt.event.*;

public class PrestamoCuotas extends JFrame implements ActionListener {

    // Declarar componentes
    private JLabel lblMonto, lblCuotas, lblCuotaMensual, lblInteresTotal;
    private JTextField txtMonto, txtCuotas, txtCuotaMensual, txtInteresTotal;
    private JButton btnCalcular;

    // Constructor
    public PrestamoCuotas() {
        setSize(400, 300);
        setTitle("Cálculo de Préstamo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setResizable(false);
        setLayout(null);

        // Etiquetas y cajas de texto
        lblMonto = new JLabel("Monto del préstamo:");
        lblMonto.setBounds(30, 30, 150, 25);
        add(lblMonto);

        txtMonto = new JTextField();
        txtMonto.setBounds(180, 30, 150, 25);
        add(txtMonto);

        lblCuotas = new JLabel("Número de cuotas:");
        lblCuotas.setBounds(30, 70, 150, 25);
        add(lblCuotas);

        txtCuotas = new JTextField();
        txtCuotas.setBounds(180, 70, 150, 25);
        txtCuotas.setEnabled(false);
        add(txtCuotas);

        lblCuotaMensual = new JLabel("Cuota mensual:");
        lblCuotaMensual.setBounds(30, 110, 150, 25);
        add(lblCuotaMensual);

        txtCuotaMensual = new JTextField();
        txtCuotaMensual.setBounds(180, 110, 150, 25);
        txtCuotaMensual.setEnabled(false);
        add(txtCuotaMensual);

        lblInteresTotal = new JLabel("Interés total:");
        lblInteresTotal.setBounds(30, 150, 150, 25);
        add(lblInteresTotal);

        txtInteresTotal = new JTextField();
        txtInteresTotal.setBounds(180, 150, 150, 25);
        txtInteresTotal.setEnabled(false);
        add(txtInteresTotal);

        // Botón calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(140, 200, 100, 30);
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    // Lógica del botón
    public void actionPerformed(ActionEvent e) {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            int cuotas;

            // Número de cuotas según monto
            if (monto <= 5000) {
                cuotas = 2;
            } else if (monto <= 10000) {
                cuotas = 4;
            } else if (monto <= 15000) {
                cuotas = 6;
            } else {
                cuotas = 10;
            }

            // Interés mensual
            double tasaInteres = (monto > 10000) ? 0.03 : 0.05;

            // Cálculos
            double interesTotal = monto * tasaInteres * cuotas;
            double montoTotal = monto + interesTotal;
            double cuotaMensual = montoTotal / cuotas;

            // Mostrar en cajas de texto
            txtCuotas.setText(String.valueOf(cuotas));
            txtCuotaMensual.setText(String.format("%.2f", cuotaMensual));
            txtInteresTotal.setText(String.format("%.2f", interesTotal));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: Ingrese un monto válido.",
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main
    public static void main(String[] args) {
       PrestamoCuotas ventana = new PrestamoCuotas();
        ventana.setVisible(true);
    }
}


