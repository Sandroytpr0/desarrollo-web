/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboldecisionaforo;

public class ArbolDecisionAforo {

    // Misma clase Lugar usada en Estructuras Lineales Estáticas
    static class Lugar {
        int id;
        String nombre;
        String tipo;
        int aforoActual;

        public Lugar(int id, String nombre, String tipo, int aforoActual) {
            this.id = id;
            this.nombre = nombre;
            this.tipo = tipo;
            this.aforoActual = aforoActual;
        }
    }

    // Nodo del árbol de decisión
    static class NodoDecision {
        String pregunta;
        String resultado;
        NodoDecision siConVerdadero;
        NodoDecision siConFalso;

        // Nodo de decisión (pregunta)
        public NodoDecision(String pregunta, NodoDecision siConVerdadero, NodoDecision siConFalso) {
            this.pregunta = pregunta;
            this.siConVerdadero = siConVerdadero;
            this.siConFalso = siConFalso;
        }

        // Nodo hoja (resultado final)
        public NodoDecision(String resultado) {
            this.resultado = resultado;
        }

        boolean esHoja() {
            return resultado != null;
        }
    }

    /**
     * OPERACIÓN (ÁRBOL DE DECISIÓN): CLASIFICACIÓN Y RECOMENDACIÓN DE INGRESO
     * Construye el árbol que evalúa el aforo de un lugar y recomienda una acción.
     *
     *                  ¿aforo > 200?
     *                  /          \
     *               Sí            No
     *                |              \
     *          "Evitar zona"    ¿aforo > 100?
     *                            /          \
     *                         Sí            No
     *                          |              \
     *                  "Esperar unos      "Puede ingresar
     *                   minutos"           sin problema"
     */
    public static NodoDecision construirArbol() {
        NodoDecision hojaEvitar = new NodoDecision("Evitar zona: aforo muy alto");
        NodoDecision hojaEsperar = new NodoDecision("Esperar unos minutos antes de ingresar");
        NodoDecision hojaIngresar = new NodoDecision("Puede ingresar sin problema");

        NodoDecision nivelDos = new NodoDecision("¿aforo > 100?", hojaEsperar, hojaIngresar);
        NodoDecision raiz = new NodoDecision("¿aforo > 200?", hojaEvitar, nivelDos);

        return raiz;
    }

    /**
     * Recorre el árbol de decisión según el aforo de un lugar
     * y devuelve la recomendación final (clasificación).
     */
    public static String evaluarDecision(NodoDecision nodo, int aforo) {
        if (nodo.esHoja()) {
            return nodo.resultado;
        }

        if (nodo.pregunta.equals("¿aforo > 200?")) {
            return aforo > 200
                ? evaluarDecision(nodo.siConVerdadero, aforo)
                : evaluarDecision(nodo.siConFalso, aforo);
        } else {
            return aforo > 100
                ? evaluarDecision(nodo.siConVerdadero, aforo)
                : evaluarDecision(nodo.siConFalso, aforo);
        }
    }

    public static void main(String[] args) {
        // Mismos datos de lugares usados en Estructuras Lineales Estáticas
        Lugar[] locales = new Lugar[4];
        locales[0] = new Lugar(0, "Biblioteca Central", "Academico", 120);
        locales[1] = new Lugar(1, "Cafetería Ciencias", "Servicio", 85);
        locales[2] = new Lugar(2, "Auditorio Magno", "Evento", 210);
        locales[3] = new Lugar(3, "Laboratorio Química", "Academico", 15);

        NodoDecision arbol = construirArbol();

        System.out.println("--- A7: ÁRBOL DE DECISIÓN (RECOMENDACIÓN DE INGRESO) ---");
        for (Lugar l : locales) {
            String recomendacion = evaluarDecision(arbol, l.aforoActual);
            System.out.println(l.nombre + " (Aforo: " + l.aforoActual + ") -> " + recomendacion);
        }
        System.out.println("============================================================");
    }
}