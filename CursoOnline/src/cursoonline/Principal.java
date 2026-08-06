package cursoonline;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

 
        ArrayList<CursoOnline> cursos = new ArrayList<>();

        cursos.add(new CursoOnline("Java Basico", "Programación", 20, 300.0));
        cursos.add(new CursoOnline("Python Intermedio", "Programación", 25, 350.0));
        cursos.add(new CursoOnline("Marketing Digital", "Negocios", 30, 400.0));

  
        for (CursoOnline curso : cursos) {

       
            curso.setHorasDuracion(curso.getHorasDuracion() + 4);

      
            double nuevoPrecio = curso.getPrecioBase() * 0.90;
            curso.setPrecioBase(nuevoPrecio);

  
            System.out.println(curso.resumen());
            System.out.println("----------------------------");
        }
    }
}
