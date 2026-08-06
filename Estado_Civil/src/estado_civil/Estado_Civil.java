
package estado_civil;

import javax.swing.*;

public class Estado_Civil {
    public static void main(String[] args) {
        // Pedimos número en una ventana
        String input = JOptionPane.showInputDialog(
                null,
                "Ingrese un número (1-4) para el estado civil:\n" +
                "1 = Soltero\n" +
                "2 = Casado\n" +
                "3 = Viudo\n" +
                "4 = Divorciado",
                "Estado Civil",
                JOptionPane.QUESTION_MESSAGE
        );

        try {
            int numero = Integer.parseInt(input);
            String estado;

            // Estructura condicional (igual que en consola)
            if (numero == 1) {
                estado = "Soltero";
            } else if (numero == 2) {
                estado = "Casado";
            } else if (numero == 3) {
                estado = "Viudo";
            } else if (numero == 4) {
                estado = "Divorciado";
            } else {
                estado = "Error: número fuera del rango (1-4).";
            }

            // Mostramos resultado en ventana
            JOptionPane.showMessageDialog(
                    null,
                    "Resultado: " + estado,
                    "Estado Civil",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: Debe ingresar un número entero válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
