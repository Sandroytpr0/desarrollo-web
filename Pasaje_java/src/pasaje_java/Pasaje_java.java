package pasaje_java;

public class Pasaje_java {
    // Atributos privados
    private String nroVenta;
    private int cantidadPasajes;
    private double precioPasaje;

    // Constructor
    public Pasaje_java(String nroVenta, int cantidadPasajes, double precioPasaje) {
        this.nroVenta = nroVenta;
        this.cantidadPasajes = cantidadPasajes;
        this.precioPasaje = precioPasaje;
    }

    // Métodos get y set
    public String getNroVenta() { return nroVenta; }
    public void setNroVenta(String nroVenta) { this.nroVenta = nroVenta; }

    public int getCantidadPasajes() { return cantidadPasajes; }
    public void setCantidadPasajes(int cantidadPasajes) { this.cantidadPasajes = cantidadPasajes; }

    public double getPrecioPasaje() { return precioPasaje; }
    public void setPrecioPasaje(double precioPasaje) { this.precioPasaje = precioPasaje; }

    // Cálculos
    public double calcularPago() { return precioPasaje * cantidadPasajes; }

    public double calcularIncrementoFiestas() { return 0.25 * calcularPago(); }

    public double calcularTotalPagar() { return calcularPago() + calcularIncrementoFiestas(); }

    // Método main para probar (opcional, si no tienes clase Principal)
    public static void main(String[] args) {
        Pasaje_java p = new Pasaje_java("V001", 10, 150.0);

        System.out.println("=== DATOS INICIALES ===");
        listadoPasaje(p);

        p.setCantidadPasajes(p.getCantidadPasajes() + 8);
        p.setPrecioPasaje(p.getPrecioPasaje() * (1 - 0.038));

        System.out.println("\n=== DATOS ACTUALIZADOS ===");
        listadoPasaje(p);
    }

    // Método de listado
    public static void listadoPasaje(Pasaje_java pasaje) {
        System.out.println("Nro Venta: " + pasaje.getNroVenta());
        System.out.println("Cantidad de Pasajes: " + pasaje.getCantidadPasajes());
        System.out.println("Precio por Pasaje: S/ " + String.format("%.2f", pasaje.getPrecioPasaje()));
        System.out.println("Pago: S/ " + String.format("%.2f", pasaje.calcularPago()));
        System.out.println("Incremento por Fiestas Patrias: S/ " + String.format("%.2f", pasaje.calcularIncrementoFiestas()));
        System.out.println("Total a Pagar: S/ " + String.format("%.2f", pasaje.calcularTotalPagar()));
    }
}
