package Laboratorio2;

/**
 *
 * @author sdsantos
 */
public class Metodos {

    /**
     *
     * @param num la cadena que se quiere verificar que solo tiene numeros
     * @return falso o verdadero dependiendo si es o no numerica
     */
    public boolean validarEntero(String num) {
        int tam = num.length();
        int i = 0;
        char c;
        while (i < tam) {
            c = num.charAt(i);
            if (c < 48 | c > 57) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     *
     * @param num string del que cuenta los puntos
     * @return la cantidad de puntos que tiene el string
     */
    public int contPuntos(String num) {
        int tam = num.length();
        int i = 0, cont = 0;
        char c;
        while (i < tam) {
            c = num.charAt(i);
            if (c == '.') {
                cont++;
            }
            i++;
        }
        return cont;
    }

    /**
     *
     * @param nota nota a validar
     * @return si la nota tiene el tamaño (3-4) y está dentro del intervalo
     * [0.0-5.0]
     */
    public boolean validarNota(String nota) {
        int tam = nota.length();
        if (tam < 3 | tam > 4) {
            return false;
        }
        if (contPuntos(nota) != 1) {
            return false;
        }
        String izq = nota.substring(0, 1);
        String der = nota.substring(3);
        if (!validarEntero(izq) | !validarEntero(der)) {
            return false;
        }
        if (Double.parseDouble(nota) < 0.0 | Double.parseDouble(nota) > 5.0) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param sem semestre a validar
     * @return verdadero si el semestre es entero y es menor o igual a 12
     */
    public boolean validarSemestre(String sem) {
        int tam = sem.length();
        if (tam > 2) {
            return false;
        }
        if (!validarEntero(sem)) {
            return false;
        }
        if (Integer.parseInt(sem) > 12) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param nombres nombre o apellido a validar
     * @return verdadero si el nombre/apellido tiene mas de 3 caracteres y no
     * tiene numeros
     */
    public boolean validarNombres(String nombres) {
        int tam = nombres.length();
        if (tam < 3) {
            return false;
        }
        int i = 0;
        char c;
        while (i < tam) {
            c = nombres.charAt(i);
            if (c >=48 & c <= 57 ) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     *
     * @param codigo codigo del estudiante a validar
     * @return verdadero si el codigo es de 8 cifras y es entero positivo
     */
    public boolean validarCodigo(String codigo) {
        int tam = codigo.length();
        if (tam != 8) {
            return false;
        }
        if (!validarEntero(codigo)) {
            return false;
        }
        return true;

    }

}
