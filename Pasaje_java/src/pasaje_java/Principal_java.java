package pasaje_java;

import javax.swing.*;
import java.awt.event.*;

public class Principal_java extends JFrame implements ActionListener {

    JButton btnProcesar;
    JTextArea txtSalida;

    public Principal_java() {
        setTitle("Control de Pasaje");
        setSize(400, 300);
        setLayout(null);

        btnProcesar = new JButton("Procesar");
        btnProcesar.setBounds(130, 20, 120, 30);
        btnProcesar.addActionListener(this);
        add(btnProcesar);

        txtSalida = new JTextArea();
        txtSalida.setBounds(30, 70, 330, 160);
        add(txtSalida);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pasaje_java p = new Pasaje_java("V001", 10, 150.0);

        txtSalida.setText("=== DATOS INICIALES ===\n" + listadoPasaje(p));

        p.setCantidadPasajes(p.getCantidadPasajes() + 8);
        p.setPrecioPasaje(p.getPrecioPasaje() * (1 - 0.038));

        txtSalida.append("\n=== DATOS ACTUALIZADOS ===\n" + listadoPasaje(p));
    }

    public String listadoPasaje(Pasaje_java p) {
        return "Nro Venta: " + p.getNroVenta() +
               "\nCantidad: " + p.getCantidadPasajes() +
               "\nPrecio: S/ " + String.format("%.2f", p.getPrecioPasaje()) +
               "\nPago: S/ " + String.format("%.2f", p.calcularPago()) +
               "\nIncremento: S/ " + String.format("%.2f", p.calcularIncrementoFiestas()) +
               "\nTotal: S/ " + String.format("%.2f", p.calcularTotalPagar()) + "\n";
    }

    public static void main(String[] args) {
        new Principal_java();
    }
}
