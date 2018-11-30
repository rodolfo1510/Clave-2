/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


import Menus.Consola;
import funcion.*;
/**
 *
 * @author Alexis
 */
public class RungeKutta extends Base{
    
    public RungeKutta() {

        this.espaciado = 0;

        this.decimales = 5;

    }



    /**

     * El metodo orden4 encuentra la solucion de la ecuacion diferencial en un

     * punto.

     *

     * @param funcion funcion de la ecuacion diferencial

     * @param x0 valor en x anterior

     * @param y0 valor en y anterior

     * @param h incremento

     * @return valor de la ecuacion en el punto (y(x+h))

     */

    public double orden4(Funcion funcion, double x0, double y0, double h) {

        double F1 = funcion.evaluar(x0, y0);

        double F2 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F1);

        double F3 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F2);

        double F4 = funcion.evaluar(x0 + h, y0 + h * F3);

        //System.out.println(+F1);

        //System.out.println(+F2);

        //System.out.println(+F3);

        //System.out.println(+F4);



        System.out.println("" + this.redondear(y0) + " + (" + this.redondear(h) + " * (" + this.redondear(F1) + " + 2 * (" + this.redondear(F2) + " + " + this.redondear(F3) + ") + " + this.redondear(F4) + ")) / 6 = " + this.redondear(y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6));

        return y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6.0;

    }



    /**

     * El metodo evaluar guarda en una tabla los puntos solucion de la

     * ecuacion.

     *

     * @param funcion funcion de la ecuacion diferencial

     * @param x0 valor x inicial

     * @param y0 valor y inicial

     * @param xn valor x final

     * @param n cantidad de iteraciones

     * @return tabla con los valores de la funcion

     */

    public double[] evaluar(Funcion funcion, double x0, double y0, double xn, int n) {



        System.out.println("x0: " + x0);

        System.out.println("y0: " + y0);

        System.out.println("xn: " + xn);

        System.out.println(" n: " + n);

        System.out.println();



        double[] Y = new double[n + 1];

        double[] X = new double[n + 1];



        this.inicializar(X, x0);

        double h = (xn - x0) / n;

        Y[0] = y0;

        X[0] = x0;

        for (int i = 0; i < n; i++) {

            System.out.println("I=" + i);

            y0 = this.orden4(funcion, x0, y0, h);

            x0 += h;

            X[i + 1] = x0;

            Y[i + 1] = y0;

        }



        System.out.println("");

        System.out.println("Resultado:");

        this.reportarcoordenadas(X, Y);







        return Y;

    }



    public void consola() {



        Consola consola = new Consola();

        String funcion_cadena = consola.getCadena("Ingresa la Funcion");

        double x0 = consola.getNumero("Ingresa el Valor inicial de X");

        double y0 = consola.getNumero("Ingresa el Valor inicial de Y");

        double xn = consola.getNumero("Ingresa el Valor final de X");

        int n = consola.getEntero("Ingresa el Numero de Iteraciones", 4);

        boolean fraccion = consola.getBoolean("Quieres usar Fraccciones?");

        int decimales = consola.getEntero("cuantos decimales queres usar para el reporte?", 6);

        this.fraccion = fraccion;

        this.decimales = decimales;

        consola.limpiarPantalla();

        Funcion funcion = new Funcion(funcion_cadena);

        this.evaluar(funcion, x0, y0, xn, n);

    }
    
}
