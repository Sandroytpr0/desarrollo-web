package electrodomestico_java;

public class Electrodomestico_java {

    protected final static double PRECIO_BASE_DEF = 1000;
    protected final static String COLOR_DEF = "blanco";
    protected final static char CONSUMO_DEF = 'F';
    protected final static double PESO_DEF = 5;

  
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    
    public Electrodomestico_java() {
        this.precioBase = PRECIO_BASE_DEF;
        this.color = COLOR_DEF;
        this.consumoEnergetico = CONSUMO_DEF;
        this.peso = PESO_DEF;
    }

    public Electrodomestico_java(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = COLOR_DEF;
        this.consumoEnergetico = CONSUMO_DEF;
        this.peso = peso;
    }

    
    public Electrodomestico_java(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

 
    private char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return CONSUMO_DEF;
        }
    }

    private String comprobarColor(String color) {
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};
        color = color.toLowerCase();

        for (String c : coloresValidos) {
            if (c.equals(color)) {
                return c;
            }
        }
        return COLOR_DEF;
    }

  
    public double precioFinal() {
        double adicion = 0;


        switch (consumoEnergetico) {
            case 'A': adicion += 1000; break;
            case 'B': adicion += 800; break;
            case 'C': adicion += 600; break;
            case 'D': adicion += 500; break;
            case 'E': adicion += 300; break;
            case 'F': adicion += 100; break;
        }


        if (peso < 20) adicion += 100;
        else if (peso < 50) adicion += 500;
        else if (peso < 80) adicion += 800;
        else adicion += 1000;

        return precioBase + adicion;
    }
}
