package producto;

 

public class Producto {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidad;

  
    public Producto(String codigo, String nombre, double precioUnitario, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

 
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getCantidad() { return cantidad; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double subtotal() {
        return precioUnitario * cantidad;
    }

    public double igv() {
        return 0.18 * subtotal();
    }

    public double totalPagar() {
        return subtotal() + igv();
    }
}


