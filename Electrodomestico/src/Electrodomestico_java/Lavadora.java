package electrodomestico_java;


public class Lavadora extends Electrodomestico_java {


    private double carga;
    private final static double CARGA_DEF = 5; // constante de carga por defecto

   
    public Lavadora() {
       
        super();
        this.carga = CARGA_DEF;
    }

 
    public Lavadora(double precioBase, double peso) {
     
        super(precioBase, peso);
        this.carga = CARGA_DEF;
    }


    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
      
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

   
    public double getCarga() {
        return carga;
    }

   
    @Override
    public double precioFinal() {
       
        double precio = super.precioFinal();

      
        if (carga > 30) {
            precio += 500;
        }

        return precio;
    }
}
