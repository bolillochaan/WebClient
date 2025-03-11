package com.ipn.academico.crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ProgramaAcademicoGUI extends JFrame {
    private JTextField txtClave, txtNombre, txtDescripcion, txtFecha;
    private JTable table;
    private ProgramaAcademicoApp app;

    public ProgramaAcademicoGUI() {
        app = new ProgramaAcademicoApp();
        setTitle("Programas Académicos");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtClave = new JTextField(5);
        txtNombre = new JTextField(10);
        txtDescripcion = new JTextField(10);
        txtFecha = new JTextField(10);

        JButton btnNuevo = new JButton("Nuevo");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBuscar = new JButton("Buscar");

        table = new JTable();
        cargarDatosEnTabla();

        btnNuevo.addActionListener(e -> limpiarCampos());
        btnGuardar.addActionListener(e -> guardarPrograma());
        btnEliminar.addActionListener(e -> eliminarPrograma());
        btnActualizar.addActionListener(e -> actualizarPrograma());
        btnBuscar.addActionListener(e -> buscarPrograma());

        add(new JLabel("Clave:")); add(txtClave);
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Descripción:")); add(txtDescripcion);
        add(new JLabel("Fecha (YYYY-MM-DD):")); add(txtFecha);

        add(btnNuevo);
        add(btnGuardar);
        add(btnEliminar);
        add(btnActualizar);
        add(btnBuscar);
        add(new JScrollPane(table));

        setVisible(true);
    }

    private void limpiarCampos() {
        txtClave.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
    }

    private void cargarDatosEnTabla() {
        try {
            List<ProgramaAcademico> lista = app.readAll();
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Clave", "Nombre", "Descripción", "Fecha"}, 0);
            for (ProgramaAcademico pa : lista) {
                model.addRow(new Object[]{pa.getIdProgramaAcademico(), pa.getNombre(), pa.getDescripcion(), pa.getFecha()});
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }

    private void guardarPrograma() {
        try {
            ProgramaAcademico programa = new ProgramaAcademico();
            programa.setNombre(txtNombre.getText());
            programa.setDescripcion(txtDescripcion.getText());
            programa.setFecha(java.sql.Date.valueOf(txtFecha.getText()));

            app.create(programa);
            JOptionPane.showMessageDialog(this, "Programa guardado con éxito.");
            cargarDatosEnTabla();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Usa YYYY-MM-DD.");
        }
    }

    private void eliminarPrograma() {
        try {
            if (txtClave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una clave para eliminar.");
                return;
            }

            Long id = Long.parseLong(txtClave.getText());

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar el programa con clave " + id + "?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                app.delete(id);
                JOptionPane.showMessageDialog(this, "Programa eliminado con éxito.");
                cargarDatosEnTabla();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }

    private void actualizarPrograma() {
        try {
            if (txtClave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la clave del programa para actualizar.");
                return;
            }

            ProgramaAcademico programa = new ProgramaAcademico();
            programa.setIdProgramaAcademico(Long.parseLong(txtClave.getText()));
            programa.setNombre(txtNombre.getText());
            programa.setDescripcion(txtDescripcion.getText());
            programa.setFecha(java.sql.Date.valueOf(txtFecha.getText()));

            app.update(programa);
            JOptionPane.showMessageDialog(this, "Programa actualizado con éxito.");
            cargarDatosEnTabla();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Usa YYYY-MM-DD.");
        }
    }

    private void buscarPrograma() {
        try {
            if (txtClave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la clave para buscar.");
                return;
            }

            Long id = Long.parseLong(txtClave.getText());
            ProgramaAcademico programa = app.read(id);

            if (programa != null) {
                txtNombre.setText(programa.getNombre());
                txtDescripcion.setText(programa.getDescripcion());
                txtFecha.setText(programa.getFecha().toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el programa con clave: " + id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
        }
    }

    public static void main(String[] args) {
        new ProgramaAcademicoGUI();
    }
}
