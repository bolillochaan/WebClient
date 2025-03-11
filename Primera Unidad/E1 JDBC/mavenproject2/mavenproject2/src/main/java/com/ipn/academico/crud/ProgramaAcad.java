package com.ipn.academico.crud;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class ProgramaAcad extends javax.swing.JFrame {

 
    private ProgramaAcademicoApp app;
    
    public ProgramaAcad() {
         initComponents();
            app = new ProgramaAcademicoApp();
            cargarDatosEnTabla();
            Guardar.setEnabled(false);
            Editar.setEnabled(false);
            Buscar.setEnabled(false);
            Cancelar.setEnabled(false);
            Clave.setEnabled(false);
            Nombre.setEnabled(false);
            Descripcion.setEnabled(false);
            Fecha.setEnabled(false);
            setTitle("Programas Académicos");
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Clave = new javax.swing.JTextField();
        Fecha = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Descripcion = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Informacion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveActionPerformed(evt);
            }
        });

        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripción");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Clave");

        jLabel4.setText("Fecha ");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Informacion.setAutoCreateRowSorter(true);
        Informacion.setBackground(new java.awt.Color(255, 231, 255));
        Informacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Informacion);

        jLabel2.setText("Nombre");

        jLabel5.setText("YYYY-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(202, 202, 202)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nuevo)
                            .addComponent(Guardar)
                            .addComponent(Editar)
                            .addComponent(Eliminar))
                        .addComponent(Buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(Guardar)
                        .addGap(18, 18, 18)
                        .addComponent(Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Editar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancelar)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

       Eliminar.setEnabled(true);
       Guardar.setEnabled(true);
       Editar.setEnabled(true);
       Buscar.setEnabled(true);
       Cancelar.setEnabled(true);
       
       guardarPrograma();
    }//GEN-LAST:event_GuardarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
       Nuevo.setEnabled(false);
       Eliminar.setEnabled(true);
       Guardar.setEnabled(true);
       Editar.setEnabled(true);
       Buscar.setEnabled(true);
       Cancelar.setEnabled(true);
       
       Clave.setEnabled(false);
            Nombre.setEnabled(true);
            Descripcion.setEnabled(true);
            Fecha.setEnabled(true);
       
    }//GEN-LAST:event_NuevoActionPerformed

    private void DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
       Eliminar.setEnabled(true);
       Guardar.setEnabled(false);
       Editar.setEnabled(false);
       Buscar.setEnabled(true);
       Cancelar.setEnabled(true);
       Clave.setEnabled(true);
       
       Clave.setEnabled(true);
            Nombre.setEnabled(false);
            Descripcion.setEnabled(false);
            Fecha.setEnabled(false);
       
        eliminarPrograma();
    }//GEN-LAST:event_EliminarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       Eliminar.setEnabled(true);
       Guardar.setEnabled(true);
       Editar.setEnabled(true);
       Buscar.setEnabled(true);
       Cancelar.setEnabled(true);
        Clave.setEnabled(true);
       
       
       actualizarPrograma();
    }//GEN-LAST:event_EditarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
       Clave.setEnabled(true);
        buscarPrograma();
       
    }//GEN-LAST:event_BuscarActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
    limpiarCampos();
    Nuevo.setEnabled(true);
     Guardar.setEnabled(false);
            Editar.setEnabled(false);
            Buscar.setEnabled(false);
            Cancelar.setEnabled(false);
            Clave.setEnabled(false);
            Nombre.setEnabled(false);
            Descripcion.setEnabled(false);
            Fecha.setEnabled(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveActionPerformed
       
    }//GEN-LAST:event_ClaveActionPerformed

    
   private void limpiarCampos() {
        Clave.setText("");
        Nombre.setText("");
        Descripcion.setText("");
        Fecha.setText("");
    }

    private void cargarDatosEnTabla() {
        try {
            List<ProgramaAcademico> lista = app.readAll();
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Clave", "Nombre", "Descripción", "Fecha"}, 0);
            for (ProgramaAcademico pa : lista) {
                model.addRow(new Object[]{pa.getIdProgramaAcademico(), pa.getNombre(), pa.getDescripcion(), pa.getFecha()});
            }
            Informacion.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }

    private void guardarPrograma() {
        try {
            ProgramaAcademico programa = new ProgramaAcademico();
            programa.setNombre(Nombre.getText());
            programa.setDescripcion(Descripcion.getText());
            programa.setFecha(java.sql.Date.valueOf(Fecha.getText()));
            

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
            if (Clave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una clave para eliminar.");
                return;
            }

            Long id = Long.parseLong(Clave.getText());

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
            if (Clave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la clave del programa para actualizar.");
                return;
            }
                        
            ProgramaAcademico programa = new ProgramaAcademico();
            programa.setIdProgramaAcademico(Long.parseLong(Clave.getText()));
            programa.setNombre(Nombre.getText());
            programa.setDescripcion(Descripcion.getText());
            programa.setFecha(java.sql.Date.valueOf(Fecha.getText()));
            

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
            if (Clave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la clave para buscar.");
                return;
            }
             
            Long id = Long.parseLong(Clave.getText());
            ProgramaAcademico programa = app.read(id);

            if (programa != null) {
                Nombre.setText(programa.getNombre());
                Descripcion.setText(programa.getDescripcion());
                Fecha.setText(programa.getFecha().toString());
                
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el programa con clave: " + id);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
        }
    }

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramaAcad().setVisible(true);
            }
        });
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Clave;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField Fecha;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable Informacion;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
