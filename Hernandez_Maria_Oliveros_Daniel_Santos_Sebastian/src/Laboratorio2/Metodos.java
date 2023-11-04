package Laboratorio2;

/**
 *
 * @author sdsantos
 */
public class Metodos {

    /**
     * Función que valida que una cadena sea un numero entero positivo
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
     * Función que cuenta los puntos en un string
     *
     * @param num es el string del que cuenta los puntos
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
     * Función que valida que la nota esté bien escrita
     *
     * @param nota nota a validar
     * @return verdadero si la nota tiene el tamaño (3-4) y está dentro del
     * intervalo [0.0-5.0]
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
     * Función que valida que el semestre esté bien escrito
     *
     * @param sem es el semestre a validar
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
     * Función que valida que los nombres y apellidos esten bien escritos
     *
     * @param nombres es el nombre o apellido a validar
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
            if (c >= 48 & c <= 57) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Función que valida que el codigo del estudiante esté bien escrito
     *
     * @param codigo es el codigo del estudiante a validar
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

    /**
     * Función que devuelve el tamaño minimo entre dos cadenas
     *
     * @param cad1
     * @param cad2
     * @return menor tamaño de las dos cadenas
     */
    public int tamMinimo(String cad1, String cad2) {
        int tam1 = cad1.length();
        int tam2 = cad2.length();
        if (tam1 < tam2) {
            return tam1;
        } else {
            return tam2;
        }
    }

    /**
     * Función que compara dos cadenas y dice si se deben intercambiar
     *
     * @param cad1
     * @param cad2
     * @return 1 si se no se intercambian, 2 si se tienen que intercambiar
     */
    public int compararCadenas(String cad1, String cad2) {
        int n = tamMinimo(cad1, cad2);
        int i = 0;
        char c1, c2;
        while (i < n) {
            c1 = cad1.charAt(i);
            c2 = cad2.charAt(i);
            if (c2 < c1) {
                return 2;
            } else {
                if (c1 < c2) {
                    return 1;
                }
            }
            i++;
        }
        if (cad1.length() > cad2.length()) {
            return 2;
        }
        return 1;
    }

    /**
     * Función que realiza el ordenamiento de la matriz
     * @param M Matriz
     * @param n filas de la matriz
     * @param m columnas de la matriz
     */
    public void ordenamientoMatriz(String[][] M, int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (compararCadenas(M[j][1], M[j + 1][1]) == 2) {
                    for (int k = 0; k < m; k++) {
                        String t = M[j][k];
                        M[j][k] = M[j + 1][k];
                        M[j + 1][k] = t;
                    }
                }
            }
        }
    }
}
