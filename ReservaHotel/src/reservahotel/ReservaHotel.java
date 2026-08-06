package reservahotel;


import java.util.*;

public class ReservaHotel {
    private static int contador = 1000; 
    private String codReserva;
    private String nombreCliente;
    private String apellidoCliente;
    private int numeroNoches;
    private double precioNoche;

    // Constructor
    public ReservaHotel(String nombreCliente, String apellidoCliente, int numeroNoches, double precioNoche) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.numeroNoches = numeroNoches;
        this.precioNoche = precioNoche;
        contador++;
        this.codReserva = generarCodigo();
    }

    
    private String generarCodigo() {
        String iniciales = "";
        if (nombreCliente.length() > 0) iniciales += nombreCliente.charAt(0);
        if (apellidoCliente.length() > 0) iniciales += apellidoCliente.charAt(0);
        return iniciales.toUpperCase() + contador;
    }

   
    public String getCodReserva() { return codReserva; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getApellidoCliente() { return apellidoCliente; }
    public void setApellidoCliente(String apellidoCliente) { this.apellidoCliente = apellidoCliente; }
    public int getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(int numeroNoches) { this.numeroNoches = numeroNoches; }
    public double getPrecioNoche() { return precioNoche; }
    public void setPrecioNoche(double precioNoche) { this.precioNoche = precioNoche; }

  
    public String primerosCaracteres(int n) {
        return codReserva.substring(0, Math.min(n, codReserva.length()));
    }

    public String ultimosCaracteres(int n) {
        return codReserva.substring(Math.max(0, codReserva.length() - n));
    }

    public double totalEstadia() {
        return numeroNoches * precioNoche;
    }

    public double incrementoTemporadaAlta() {
        return totalEstadia() * 0.20;
    }

    public double totalConIncremento() {
        return totalEstadia() + incrementoTemporadaAlta();
    }

    public void resumen() {
        System.out.println("Código completo: " + codReserva);
        System.out.println("Primeros caracteres: " + primerosCaracteres(2));
        System.out.println("Últimos caracteres: " + ultimosCaracteres(4));
        System.out.println("Cliente: " + nombreCliente + " " + apellidoCliente);
        System.out.println("Costo base: $" + totalEstadia());
        System.out.println("Incremento 20%: $" + incrementoTemporadaAlta());
        System.out.println("Total con incremento: $" + totalConIncremento());
        System.out.println("--------------------------------");
    }
}
