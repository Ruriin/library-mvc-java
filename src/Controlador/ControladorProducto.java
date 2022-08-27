/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.formularioProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ControladorProducto implements ActionListener {

    private Producto mod;
    private ConsultasProducto modC;
    private formularioProducto form;

    public ControladorProducto(Producto mod, ConsultasProducto modC, formularioProducto form) {
        this.mod = mod;
        this.modC = modC;
        this.form = form;

        this.form.btnGuardar.addActionListener(this);
        this.form.btnModificar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);
        this.form.btnLimpiar.addActionListener(this);
        this.form.btnBuscar.addActionListener(this);

    }

    public void iniciar() {
        form.setTitle("Productos");
        form.setLocationRelativeTo(null);
        form.txtBoxID.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form.btnGuardar) {
            mod.setCodigo(form.txtBoxCodigo.getText());
            mod.setNombre(form.txtBoxNombre.getText());
            mod.setPrecio(Double.parseDouble(form.txtBoxPrecio.getText()));
            mod.setCantidad(Integer.parseInt(form.txtBoxCantidad.getText()));
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();

            }
        }
        if (e.getSource() == form.btnModificar) {
            mod.setId(Integer.parseInt(form.txtBoxID.getText()));
            mod.setCodigo(form.txtBoxCodigo.getText());
            mod.setNombre(form.txtBoxNombre.getText());
            mod.setPrecio(Double.parseDouble(form.txtBoxPrecio.getText()));
            mod.setCantidad(Integer.parseInt(form.txtBoxCantidad.getText()));
            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();

            }
        }
        if (e.getSource() == form.btnEliminar) {
            mod.setId(Integer.parseInt(form.txtBoxID.getText()));
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();

            }
        }
        if (e.getSource() == form.btnBuscar) {
            mod.setCodigo(form.txtBoxCodigo.getText());
            if (modC.buscar(mod)) {
                form.txtBoxID.setText(String.valueOf(mod.getId()));
                form.txtBoxCodigo.setText(mod.getCodigo());
                form.txtBoxNombre.setText(mod.getNombre());
                form.txtBoxPrecio.setText(String.valueOf(mod.getPrecio()));
                form.txtBoxCantidad.setText(String.valueOf(mod.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();

            }
        }
        if (e.getSource() == form.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        form.txtBoxCodigo.setText(null);
        form.txtBoxNombre.setText(null);
        form.txtBoxPrecio.setText(null);
        form.txtBoxCantidad.setText(null);
        form.txtBoxID.setText(null);

    }

}
