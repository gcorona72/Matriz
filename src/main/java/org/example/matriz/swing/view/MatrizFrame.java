package org.example.matriz.swing.view;

import org.example.matriz.swing.adapter.SwingToRestAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MatrizFrame extends JFrame {
    private final JTable table;
    private final DefaultTableModel model;
    private final SwingToRestAdapter adapter;

    public MatrizFrame() {
        super("Matriz Transpuesta");
        this.adapter = new SwingToRestAdapter("http://localhost:8080/api/matrices");

        // Modelo con 2x2 por defecto
        model = new DefaultTableModel(2, 2);
        table = new JTable(model);

        JButton btnTransponer = new JButton("Transponer");
        btnTransponer.addActionListener(this::onTransponer);

        // Layout
        setLayout(new BorderLayout(5,5));
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnTransponer, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void onTransponer(ActionEvent e) {
        int filas = model.getRowCount();
        int cols  = model.getColumnCount();
        int[][] datos = new int[filas][cols];

        // Leer datos de la tabla
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                Object val = model.getValueAt(i, j);
                datos[i][j] = (val instanceof Number)
                        ? ((Number) val).intValue()
                        : Integer.parseInt(val.toString());
            }
        }

        // Llamada al backend
        int[][] trans = adapter.transpose(datos);

        // Actualizar tabla con nueva dimensión
        model.setRowCount(trans.length);
        model.setColumnCount(trans[0].length);
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[0].length; j++) {
                model.setValueAt(trans[i][j], i, j);
            }
        }
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatrizFrame().setVisible(true));
    }
}
