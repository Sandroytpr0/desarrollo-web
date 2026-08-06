 
public class Pasaje {
    private String nroventa;
    private int cantidadPasajes;
    private double precioPasaje;

    public Pasaje(String nroventa, int cantidadPasajes, double precioPasaje) {
        this.nroventa = nroventa;
        this.cantidadPasajes = cantidadPasajes;
        this.precioPasaje = precioPasaje;
    }

    public String getNroventa() { 
        return nroventa; 
    }

    public void setNroventa(String nroventa) { 
        this.nroventa = nroventa; 
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

    public double pago() {
        return precioPasaje * cantidadPasajes;
    }

    public double incrementoFiestasPatrias() {
        return 0.25 * pago();
    }

    public double totalPagar() {
        return pago() + incrementoFiestasPatrias();
    }
}


