package cursoonline;

   public class CursoOnline {

    private String codCurso;
    private String nombreCurso;
    private String categoria;
    private int horasDuracion;
    private double precioBase; 
    
    private static int contador = 101 ; 
    
    
    


public CursoOnline (String nombreCurso, String categoria, int horasDuracion, double precioBase){
     
 this.nombreCurso = nombreCurso;
 this.categoria = categoria;
 this.horasDuracion = horasDuracion;
 this.precioBase = precioBase;
 
this.codCurso = generarCodigo(nombreCurso);

}

private String generarCodigo(String nombreCurso) {
  String[] palabras = nombreCurso.split("");
  String iniciales = ""; 
  
  for (String p : palabras){
    iniciales += p.toUpperCase().charAt(0);
      
  }
  return iniciales + (contador++);

}

public int getHorasDuracion(){
  return horasDuracion;

}

public void setHorasDuracion(int horasDuracion) {
 this.horasDuracion = horasDuracion;
}

public double getPrecioBase() {

  return precioBase;

}

public void setPrecioBase(double precioBase) {

    this.precioBase = precioBase;
    
}

public String primerosCaracteres(int n){
return codCurso.substring(0, n);


}

public String ultimosCaracteres(int n) {
return codCurso.substring(codCurso.length() - n);

}
public double costoPorHora(){
  return precioBase / horasDuracion; 

}

public double incrementoCertificacion() {
  return precioBase * 0.15;

}

public double totalConCertificacion(){
  return precioBase + incrementoCertificacion (); 

}

public String resumen() {

return "=== resumen del curso ===/n" +
 "codigo: " + codCurso + "/n" +         
"Primeros caracteres:" + primerosCaracteres(2) + "/n" + 
"Ultimos caracteres: " + ultimosCaracteres(3) + "/n" +
"Curso: " + nombreCurso + "\n" +
"Categoria:" + categoria + "\n" +
 "Precio base: S/ " + precioBase +  "/n" +
 "Incremento certificacion: S/" + incrementoCertificacion() + "/n" + 
 "Total final: S/ " + totalConCertificacion();       
        

}



}





