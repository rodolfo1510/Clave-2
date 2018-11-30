/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import Menus.*;

import funcion.*;

import metodos.*;

import java.io.*;

/**
 *
 * @author Alexis
 */
public class MetodoRungeKutta {
    public static void main(String[] args) {

        final RungeKutta metodo = new RungeKutta();

        Menu menu = new Menu();

        menu.setTitulo("Metodo de Runge Kutta");

        Menu submenu = new Menu();

        submenu.agregar("Ejemplo 1", new MenuCallback() {

            public void ejecutar() {

                double x0 = 0;

                double y0 = 1;

                double xn = 2;

                int n = 4;

                Funcion funcion = new Funcion("y*x^2-1.2*y");

                metodo.evaluar(funcion, x0, y0, xn, n);
            }
        });


        menu.agregar("Ejercicios", submenu);

        menu.agregar("Ingresar Datos", new MenuCallback() {

            public void ejecutar() {

                metodo.consola();
            }
        });

        menu.mostrar();
    }
}
