/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *
 * @author Alexis
 */
public class MenuItem {
    
    private MenuCallback funcion;
    private String texto;
    private boolean menu=false;



    public boolean isMenu() {

        return menu;

    }



    public MenuItem setMenu(boolean menu) {

        this.menu = menu;

        return this;

    }



   /**

    * agrega un item al menu

    * 

    * @param texto texto del menu

    * @param funcion funcion del menu

    */

    public MenuItem(String texto, MenuCallback funcion) {

        this.funcion = funcion;

        this.texto = texto;

    }



    

    public MenuCallback getMenuCallback() {

        return this.funcion;

    }



    public String getTexto() {

        return this.texto;

    }
    
}
