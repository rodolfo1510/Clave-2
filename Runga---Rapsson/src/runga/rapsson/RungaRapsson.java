/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runga.rapsson;

import Menus.Menu;
import Menus.MenuCallback;
import metodos.NewtonRaphson;
import metodos.RungeKutta;

/**
 *
 * @author Alexis
 */
public class RungaRapsson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Menu menu = new Menu();

        menu.setTitulo("BIENVENIDOS");

        menu.agregar("Newton Raphson", new MenuCallback() {

            public void ejecutar() {

                NewtonRaphson metodo = new NewtonRaphson();

                metodo.consola();

            }

        });

        menu.agregar("Metodo de Runge Kutta", new MenuCallback() {

            public void ejecutar() {

                RungeKutta metodo = new RungeKutta();

                metodo.consola();

            }

        });

        menu.mostrar();

    }
    
}
