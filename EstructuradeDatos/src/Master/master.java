package Master;
import estructuradatos.Arbol;
import estructuradatos.ArbolGrafico;
import javax.swing.*;
import java.awt.*;

public class master extends JFrame {

    private Arbol arbol;
    private ArbolGrafico arbolGrafico;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JButton agregar, eliminar, inOrden, preOrden, postOrden, actualizar;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;

    public master() {
        arbol = new Arbol();
        initComponents();
        arbolGrafico = new ArbolGrafico(arbol);
        arbolGrafico.setPreferredSize(new Dimension(444, 300)); // Establece un tamaño preferido
        jPanel1.setLayout(new BorderLayout()); // Establece el layout del jPanel1
        jPanel1.add(arbolGrafico, BorderLayout.CENTER); // Añade arbolGrafico al centro de jPanel1
        jPanel1.validate(); // Valida el panel después de añadir el componente
        jPanel1.repaint(); // Repinta el panel para asegurar que se muestre el contenido
    }

    private void initComponents() {
        jTextField1 = new JTextField();
        agregar = new JButton("Agregar");
        eliminar = new JButton("Eliminar");
        inOrden = new JButton("InOrden");
        preOrden = new JButton("PreOrden");
        postOrden = new JButton("PostOrden");
        actualizar = new JButton("Actualizar");
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel1 = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        agregar.addActionListener(evt -> agregarActionPerformed(evt));
        eliminar.addActionListener(evt -> eliminarActionPerformed(evt));
        inOrden.addActionListener(evt -> inOrdenActionPerformed(evt));
        preOrden.addActionListener(evt -> preOrdenActionPerformed(evt));
        postOrden.addActionListener(evt -> postOrdenActionPerformed(evt));
        actualizar.addActionListener(evt -> actualizarActionPerformed(evt));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        layoutComponents();
    }

    private void layoutComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar)
                        .addComponent(eliminar))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(inOrden)
                        .addComponent(preOrden)
                        .addComponent(postOrden)
                        .addComponent(actualizar))
                .addComponent(jScrollPane1)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar)
                        .addComponent(eliminar))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(inOrden)
                        .addComponent(preOrden)
                        .addComponent(postOrden)
                        .addComponent(actualizar))
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }


    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int value = Integer.parseInt(jTextField1.getText());
            arbol.agregar(value);
            jTextField1.setText("");
            arbolGrafico.repaint();
        } catch (NumberFormatException e) {
            // Manejar la entrada no válida
            jTextField1.setText("");
            jTextArea1.setText("Error: Ingrese un número válido.");
        }
    }

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int value = Integer.parseInt(jTextField1.getText());
            boolean eliminado = arbol.eliminar(value);
            if (eliminado) {
                jTextField1.setText("");
                arbolGrafico.repaint();
            } else {
                jTextArea1.setText("Error: El valor no existe en el árbol.");
            }
        } catch (NumberFormatException e) {
            // Manejar la entrada no válida
            jTextField1.setText("");
            jTextArea1.setText("Error: Ingrese un número válido.");
        }
    }

    private void inOrdenActionPerformed(java.awt.event.ActionEvent evt) {
        jTextArea1.setText("");
        arbol.inOrden(jTextArea1);
    }

    private void preOrdenActionPerformed(java.awt.event.ActionEvent evt) {
        jTextArea1.setText("");
        arbol.preOrden(jTextArea1);
    }

    private void postOrdenActionPerformed(java.awt.event.ActionEvent evt) {
        jTextArea1.setText("");
        arbol.postOrden(jTextArea1);
    }

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {
        arbolGrafico.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master().setVisible(true);
            }
        });
    }


}
