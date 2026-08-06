

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        
        ArrayList<Pasaje> lista = new ArrayList<>();
        
        lista.add(new Pasaje("V001", 2, 50.0));
        lista.add(new Pasaje("V002", 3, 75.0));
        lista.add(new Pasaje("V003", 1, 120.0));

        System.out.println("=== LISTA ORIGINAL ===");
        listarPasajes(lista);

        for (Pasaje p : lista) {
            p.setCantidadPasajes(p.getCantidadPasajes() + 8);
            p.setPrecioPasaje(p.getPrecioPasaje() * 0.962); // -3.8%
        }

        System.out.println("\n=== LISTA ACTUALIZADA ===");
        listarPasajes(lista);
    }

    public static void listarPasajes(ArrayList<Pasaje> lista) {
        for (Pasaje p : lista) {
            System.out.println(
                "Venta: " + p.getNroventa() +
                " | Cantidad: " + p.getCantidadPasajes() +
                " | Precio: " + String.format("%.2f", p.getPrecioPasaje()) +
                " | Pago: " + String.format("%.2f", p.pago()) +
                " | Incremento: " + String.format("%.2f", p.incrementoFiestasPatrias()) +
                " | Total: " + String.format("%.2f", p.totalPagar())
            );
        }
    }
}
