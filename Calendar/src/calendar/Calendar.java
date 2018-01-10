package calendar;

public class Calendar {

    public static void main(String[] args) {
        calendario2018();
    }

    private static void calendario2018() {
        /**
         * Este método sirve como base para comenzar la anillación de todos los
         * demás. Crea una String con todos los meses de nuestro calendario.
         * Imprime la cabecera de 2018 Llama al método formato4x3
         */
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        System.out.println("                                      ----------" + 2018 + "----------");
        System.out.print("\n" + "\n");
        formato4x3(meses);
    }

    private static void formato4x3(String[] filaMeses) {
        /**
         * Este método da el formato del calendario con 4 filas de 3 meses cada
         * una Primero imprime los nombres de los meses separados para que
         * encaje con el formato Después da un salto de línea y va insertando
         * las letras que corresponden a los dias de la semana en cada mes y por
         * ultimo gracias a diversas tecnicas de iteracion y llamada a otros
         * metodos va imprimiendo todos los dias en un formato adecuado
         *
         * @filaMeses es el array de Strings que contiene los nombres de los
         * meses
         */

        String[] dias = {"L", "M", "X", "J", "V", "S", "D"};
        String hola = "hola";
        int lim = 3;
        int ultdia = 0;
        int controlmes = 0;

        for (; lim < 13; controlmes += 3, lim += 3) {
            if (controlmes != 0) {
                ultdia = getUltdia(filaMeses, controlmes - 1);
            }
            for (int zero = controlmes; zero < lim; zero++) {
                if (filaMeses[zero].length() < 5) {
                    System.out.print("               ");
                } else {
                    System.out.print("            ");
                }
                System.out.print("-" + filaMeses[zero] + "-");
                if (filaMeses[zero].length() < 6) {
                    System.out.print("               ");
                } else {
                    System.out.print("           ");
                }
            }
            System.out.print("\n" + "\n");

            for (int rep = 0; rep < 3; rep++) {
                System.out.print("     ");
                for (int y = 0; y < dias.length; y++) {
                    System.out.print(dias[y] + "   ");
                }
            }
            System.out.println();

            for (int fil = 0; fil < 6; fil++) {
                for (int mes = controlmes; mes < lim; mes++) {
                    System.out.print("    ");
                    for (int col = 0; col < 7; col++) {

                        if (mesS(ultdia, filaMeses[mes])[fil][col] < 10) {
                            System.out.print(" ");
                        }
                        if (mesS(ultdia, filaMeses[mes])[fil][col] != 0) {
                            System.out.print(mesS(ultdia, filaMeses[mes])[fil][col]);
                        } else {
                            System.out.print(" ");

                        }
                        if (col != 6) {
                            System.out.print("  ");
                        }
                    }
                    ultdia = getUltdia(filaMeses, mes);
                    System.out.print("   ");
                }
                if (controlmes != 0) {
                    ultdia = getUltdia(filaMeses, controlmes - 1);
                } else {
                    ultdia = 0;
                }
                System.out.println();
            }

            System.out.println();
        }

    }

    private static int getUltdia(String[] meses, int n) {
        /**
         * La función de este método es devolver un número que referencia el
         * ultimo dia de la semana en el que acaba el mes indicado
         *
         * @meses es el array de Strings con los nombres de los meses del año
         * @n es el numero que hace referencia al mes del cual se desea conocer
         * el ultimo dia de la semana, ej n = 1, meses[n]=febrero
         */

        int ultdia = 0;

        for (int x = 0; x <= n; x++) {
            int[][] mes = mesS(ultdia, meses[x]);
            for (int i = 2; i < mes.length; i++) {
                for (int j = 0; j < mes[i].length && mes[i][j] != 0; j++) {
                    ultdia = j + 1;
                }
            }
        }
        return ultdia;
    }

    private static int[][] mesS(int ultdia, String mes) {
        /**
         * Este método devuelve un array rellenada en orden con los dias de un
         * mes en concreto
         *
         * @ultdia es el numero que referencia al dia de la semana en el que
         * debe empezar el mes, por lo tanto, en cual columna de la primera fila
         * del array
         * @mes es el nombre del mes que solicita que el array sea rellenado.
         */

        int lim;
        int[][] dias = new int[6][7];
        int dia = 1;

        switch (mes) {
            case "Febrero":
                lim = 28;
                break;
            case "Abril":
            case "Junio":
            case "Septiembre":
            case "Noviembre":
                lim = 30;
                break;
            default:
                lim = 31;
        }
        for (int i = 0; i < dias.length; i++) {
            for (int posdia = ultdia; posdia < 7 && ultdia < 7; posdia++, dia++) {
                dias[i][posdia] = dia;
                if (posdia == 6) {
                    i++;
                    ultdia = 7;
                }
            }
            for (int j = 0; j < dias[i].length && dia <= lim; j++, dia++) {
                dias[i][j] = dia;
            }
        }
        return dias;
    }
}
