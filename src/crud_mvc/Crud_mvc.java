/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_mvc;

import Controlador.ControladorProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.formularioProducto;

/**
 *
 * @author Rodrigo
 */
public class Crud_mvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        formularioProducto form = new formularioProducto();
        ControladorProducto ctrl = new ControladorProducto(mod, modC, form);
        ctrl.iniciar();
        form.setVisible(true);
    }
    
}
