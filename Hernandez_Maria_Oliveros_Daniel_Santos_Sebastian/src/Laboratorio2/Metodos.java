package Laboratorio2;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
     *
     * @param Prin Matriz
     * @param n filas de la matriz
     * @param m columnas de la matriz
     */
    public void ordenamientoMatriz(String[][] Prin, int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (compararCadenas(Prin[j][1], Prin[j + 1][1]) == 2) {
                    for (int k = 0; k < m; k++) {
                        String t = Prin[j][k];
                        Prin[j][k] = Prin[j + 1][k];
                        Prin[j + 1][k] = t;
                    }
                }
            }
        }
    }

    /**
     * Función que copia la información de la matriz a una tabla y la muestra
     *
     * @param tabla la table en el frame donde se va a mostrar
     * @param Prin Matriz de donde se sacan los datos
     * @param n numero de filas que tiene la matriz de los datos
     * @param nombresColumnas vector con los nombres de las columnas que tienen
     * los datos
     */
    public void actualizarTabla(JTable tabla, String[][] Prin, int n, String[] nombresColumnas) {
        String Aux[][] = new String[n][nombresColumnas.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nombresColumnas.length; j++) {
                Aux[i][j] = Prin[i][j];
            }
        }
        DefaultTableModel table = new DefaultTableModel(Aux, nombresColumnas);
        tabla.setModel(table);
    }

    /*
     *
     * @param M Matriz Principal donde se guardaran las definitivas.
     * 
     * @param i Fila del estudiante a evuluar su definitiva.
     */
    public void definitivaEstudiantes(String M[][], int i) {
        double def = 0;
        for (int j = 4; j < 9; j++) {
            def += Double.parseDouble(M[i][j]);
        }
        def = def / 5;
        M[i][9] = String.valueOf(def);
    }

    /**
     *
     * @param Aux matriz auxiliar que almacena estudiantes con notas NOT de SOLO
     * de sus semestres.
     * @param Prin Matriz Principal
     * @param s Semestre a buscar, si no deseas utilizar este parametro como condicion ingrese 0.
     * @param n Dimension de filas de la matriz principal
     * @param not Nota minima para agregar a la matriz auxiliar.
     * @param Direc Si es true toma las notas mayores a la nota ingresada, si es false toma notas menores a la nota ingresada.
     */
    public void llenarMatrizAuxNotas(String Aux[][], String Prin[][], int s, int n, int not, boolean Direc) {
        double izq, der, Temp;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (Direc) {
                izq = Double.parseDouble(Prin[i][9]);
                der = not;
            } else {
                izq = not - 0.1;
                der = Double.parseDouble(Prin[i][9]);
            }
            if(s == 0){
            Temp = 0;
            }else{
            Temp = Double.parseDouble(Prin[i][3]);
            }
            if ( Temp == s && izq >= der) {
                for (int j = 0; j <= 3; j++) {
                    if (j != 3) {
                        Aux[k][j] = Prin[i][j];
                    } else {
                        Aux[k][3] = Prin[i][9];
                    }
                }
                k++;
            }
        }
    }

    /**
     *
     * @param Prin Matriz principal donde se buscaran las notas del sementre
     * ingresado
     * @param s Semestre al cual se le calculara la definitiva
     * @param n dimension de filas de la matriz principal
     * @return
     */
    public double definitivaSemestre(String Prin[][], int s, int n) {
        double def = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(Prin[i][3]) == s) {
                def += Double.parseDouble(Prin[i][9]);
                k++;
            }
        }
        def /= k;
        return def;
    }

    /**
     *
     * @param Prin Matriz principal de donde se sacaran las definitivas.
     * @param n dimension de las filas de la matriz.
     * @return
     */
    public double definitivaGlobal(String Prin[][], int n) {
        double def = 0, k = 0;
        for (int i = 0; i < n; i++) {
            def += Double.parseDouble(Prin[i][9]);
            k++;
        }
        def /= k;
        return def;
    }

}
