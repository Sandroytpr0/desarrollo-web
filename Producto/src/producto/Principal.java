package producto;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        ArrayList<Producto> lista = new ArrayList<>();

        // 2. Crear productos y agregarlos a la lista
        lista.add(new Producto("P001", "Arroz", 4.50, 3));
        lista.add(new Producto("P002", "Azúcar", 5.20, 2));
        lista.add(new Producto("P003", "Leche", 3.80, 6));

        System.out.println("=== LISTA ORIGINAL ===");
        listarProductos(lista);

        // 4. Incrementar precio 5%
        for (Producto p : lista) {
            p.setPrecioUnitario(p.getPrecioUnitario() * 1.05);
        }

        System.out.println("\n=== LISTA ACTUALIZADA ===");
        listarProductos(lista);
    }

    // 3. Método para listar los productos
    public static void listarProductos(ArrayList<Producto> lista) {
        for (Producto p : lista) {
            System.out.println(
                "Código: " + p.getCodigo() +
                " | Nombre: " + p.getNombre() +
                " | Precio: " + String.format("%.2f", p.getPrecioUnitario()) +
                " | Cantidad: " + p.getCantidad() +
                " | Subtotal: " + String.format("%.2f", p.subtotal()) +
                " | IGV: " + String.format("%.2f", p.igv()) +
                " | Total: " + String.format("%.2f", p.totalPagar())
            );
        }
    }
}
