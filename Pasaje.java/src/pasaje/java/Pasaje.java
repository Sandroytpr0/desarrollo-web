
package pasaje.java;

public class Pasaje {
    // Atributos privados
    private String nroVenta;
    private int cantidadPasajes;
    private double precioPasaje;

    // Constructor con parámetros (usando los mismos nombres)
    public Pasaje(String nroVenta, int cantidadPasajes, double precioPasaje) {
        this.nroVenta = nroVenta;
        this.cantidadPasajes = cantidadPasajes;
        this.precioPasaje = precioPasaje;
    }

    // Métodos get y set
    public String getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(String nroVenta) {
        this.nroVenta = nroVenta;
    }

    public int getCantidadPasajes() {
        return cantidadPasajes;
    }

    public void setCantidadPasajes(int cantidadPasajes) {
        this.cantidadPasajes = cantidadPasajes;
    }

    public double getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(double precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    // Método que calcula el pago total (precioPasaje * cantidadPasajes)
    public double calcularPago() {
        return precioPasaje * cantidadPasajes;
    }

    // Método que calcula el incremento por Fiestas Patrias (25% del pago)
    public double calcularIncrementoFiestas() {
        return 0.25 * calcularPago();
    }

    // Método que calcula el total a pagar (pago + incremento)
    public double calcularTotalPagar() {
        return calcularPago() + calcularIncrementoFiestas();
    }
}

