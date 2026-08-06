
package reservahotel;


import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<ReservaHotel> reservas = new ArrayList<>();

 
        reservas.add(new ReservaHotel("Juan", "Pérez", 3, 100));
        reservas.add(new ReservaHotel("Ana", "Gómez", 2, 150));
        reservas.add(new ReservaHotel("Luis", "Martínez", 5, 80));

       
        for (ReservaHotel r : reservas) {
       
            r.setNumeroNoches(r.getNumeroNoches() + 2);
          
            r.setPrecioNoche(r.getPrecioNoche() * 0.95);
      
            r.resumen();
        }
    }
}
