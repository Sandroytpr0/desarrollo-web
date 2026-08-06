package alquilerdeautos;

import javax.swing.*;
import java.awt.event.*;

public class AlquilerAutosSandro extends JFrame implements ActionListener {

    private JLabel lblDias, lblImporte, lblObsequio;
    private JTextField txtDias, txtImporte, txtObsequio;
    private JButton btnCalcular;

    public AlquilerAutosSandro() {
     
        setSize(400, 250);
        setTitle("Cálculo de Alquiler de Autos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

     lblDias = new JLabel("Dias de alquiler:");
     lblDias.setBounds(30,30,120,25);
     add(lblDias);
     txtDias=new JTextField();
     txtDias.setBounds(160,30,150,25);
     add(txtDias);
     
     lblImporte =new JLabel("Neto total:");
     lblImporte.setBounds(30,70,120,25);
     add(lblImporte);
     
     txtImporte = new JTextField();
     txtImporte.setBounds(160,70,150,25);
     txtImporte.setEnabled(false);
     add(txtImporte);
     
      lblObsequio = new JLabel("Obsequio:");
        lblObsequio.setBounds(30, 110, 120, 25);
        add(lblObsequio);

        txtObsequio = new JTextField();
        txtObsequio.setBounds(160, 110, 150, 25);
        txtObsequio.setEnabled(false); 
        add(txtObsequio);

   
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(140, 160, 100, 30);
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }         
       
    /*@override*/
    public void actionPerformed(ActionEvent e){
    try{
        int dias = Integer.parseInt(txtDias.getText());
       
        double precioPorDia;

            if (dias == 1) {
                precioPorDia = 50;
            } else if (dias == 2) {
                precioPorDia = 45;
            } else if (dias >= 3 && dias <= 5) {
                precioPorDia = 40;
            } else if (dias >= 6 && dias <= 10) {
                precioPorDia = 35;
            } else {
                precioPorDia = 30;
            }

          
            double importe = dias * precioPorDia;
            String obsequio = (dias > 10) ? "Agenda" : "Cuaderno";

          
            txtImporte.setText(String.format("%.2f", importe));
            txtObsequio.setText(obsequio);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido de días.",
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        AlquilerAutosSandro ventana = new AlquilerAutosSandro();
        ventana.setVisible(true);
    }
}
    
    
    
     
     
     
    