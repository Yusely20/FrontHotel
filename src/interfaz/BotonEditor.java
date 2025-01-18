/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author zapat
 */
class BotonEditor extends DefaultCellEditor {
    private JButton boton;
    private String label;
    private boolean clicked;
    private int fila;
    private JTable  tabla;

    public BotonEditor(JTable tabla, String label) {
        super(new JCheckBox());
        this.tabla = tabla;
        boton = new JButton();
        boton.setOpaque(true);
        this.label = label;
        
        boton.setPreferredSize(new Dimension(120, 30));
        

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        boton.setText(label);
        clicked = true;
        fila = row;
        return boton;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            if (label.equals("Eliminar")) {
                // Lógica para eliminar la fila
                ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                JOptionPane.showMessageDialog(boton, "Se eliminó la fila " + (fila + 1));
            } else if (label.equals("Modificar")) {
                // Lógica para modificar la fila
                JOptionPane.showMessageDialog(boton, "Se va a modificar la fila " + (fila + 1));
            }
        }
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
