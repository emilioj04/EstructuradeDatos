/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Master;
import estructuradatos.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;;

/**
 *
 * @author Usuario
 */
public class master extends javax.swing.JFrame {

    private Arbol arbol;
    private List<int[]> recorridoCoords;
    private List<Nodo> recorridoNodos;
    private Timer timer;
    private int currentNodeIndex;
    private Color defaultNodeColor;
    
    public master() {
        arbol = new Arbol();
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        inOrden = new javax.swing.JButton();
        preOrden = new javax.swing.JButton();
        postOrden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new DrawingPanel();
        reiniciar = new javax.swing.JButton();
        resetear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregar.setLabel("Agregar");
        agregar.setName(""); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        eliminar.setLabel("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        inOrden.setLabel("InOrden");
        inOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inOrdenActionPerformed(evt);
            }
        });

        preOrden.setLabel("PreOrden");
        preOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preOrdenActionPerformed(evt);
            }
        });

        postOrden.setLabel("PostOrden");
        postOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postOrdenActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        reiniciar.setLabel("Reiniciar");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });

        resetear.setLabel("Resetear");
        resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(preOrden)
                                .addGap(116, 116, 116)
                                .addComponent(postOrden)
                                .addGap(12, 12, 12))
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(agregar)
                                .addGap(18, 18, 18)
                                .addComponent(eliminar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(resetear)
                                .addGap(18, 18, 18)
                                .addComponent(reiniciar)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar)
                    .addComponent(eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inOrden)
                    .addComponent(preOrden)
                    .addComponent(postOrden)
                    .addComponent(reiniciar)
                    .addComponent(resetear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        int valor = Integer.parseInt(jTextField1.getText());
        arbol.agregar(valor);
        ((DrawingPanel) jPanel1).actualizarArbol(arbol);
        jTextField1.setText("");
        jPanel1.repaint();
    }//GEN-LAST:event_AgregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int valor = Integer.parseInt(jTextField1.getText());
        arbol.eliminar(valor);
        ((DrawingPanel) jPanel1).actualizarArbol(arbol);
        jTextField1.setText("");
        jPanel1.repaint();
    }//GEN-LAST:event_eliminarActionPerformed

    private void inOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inOrdenActionPerformed
        arbol.inOrden(jTextArea1);
        iniciarAnimacion(arbol.getInOrdenNodos());
    }//GEN-LAST:event_inOrdenActionPerformed

    private void preOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preOrdenActionPerformed
        arbol.preOrden(jTextArea1);
        iniciarAnimacion(arbol.getPreOrdenNodos());
    }//GEN-LAST:event_preOrdenActionPerformed

    private void postOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postOrdenActionPerformed
        arbol.postOrden(jTextArea1);
        iniciarAnimacion(arbol.getPostOrdenNodos());
    }//GEN-LAST:event_postOrdenActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        if (timer != null) {
            timer.cancel();
        }
        currentNodeIndex = 0;
        ((DrawingPanel) jPanel1).resetColors();
        jPanel1.repaint();
    }//GEN-LAST:event_reiniciarActionPerformed

    private void resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearActionPerformed
        arbol = new Arbol();
        ((DrawingPanel) jPanel1).actualizarArbol(arbol);
        jTextArea1.setText("");
        jPanel1.repaint();
    }//GEN-LAST:event_resetearActionPerformed

    /**
     * @param args the command line arguments
     */
    private void iniciarAnimacion(List<Nodo> recorrido) {
        if (timer != null) {
            timer.cancel();
        }

        recorridoNodos = recorrido;
        currentNodeIndex = 0;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentNodeIndex < recorridoNodos.size()) {
                    Nodo nodo = recorridoNodos.get(currentNodeIndex);
                    ((DrawingPanel) jPanel1).highlightNode(nodo);
                    jPanel1.repaint();
                    currentNodeIndex++;
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new master().setVisible(true));
    }
    
    class DrawingPanel extends JPanel {
        private Arbol arbol;
        private Map<Nodo, Color> nodeColors;

        public DrawingPanel() {
            this.nodeColors = new HashMap<>();
        }

        public void actualizarArbol(Arbol arbol) {
            this.arbol = arbol;
            this.nodeColors.clear();
            for (Nodo nodo : arbol.getInOrdenNodos()) {
                nodeColors.put(nodo, Color.BLACK);
            }
        }

        public void highlightNode(Nodo nodo) {
            nodeColors.put(nodo, Color.RED);
        }

        public void resetColors() {
            for (Nodo nodo : nodeColors.keySet()) {
                nodeColors.put(nodo, Color.BLACK);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (arbol != null) {
                drawTree(g, getWidth() / 2, 30, arbol.getRaiz(), 40, 30);
            }
        }

        private void drawTree(Graphics g, int x, int y, Nodo nodo, int xOffset, int yOffset) {
            if (nodo != null) {
                g.setColor(nodeColors.getOrDefault(nodo, Color.BLACK));
                g.fillOval(x - 15, y - 15, 30, 30);
                g.setColor(Color.WHITE);
                g.drawString(String.valueOf(nodo.getValor()), x - 5, y + 5);

                if (nodo.getIzquierda() != null) {
                    g.setColor(Color.BLACK);
                    g.drawLine(x - 10, y + 10, x - xOffset + 10, y + yOffset - 10);
                    drawTree(g, x - xOffset, y + yOffset, nodo.getIzquierda(), xOffset / 2, yOffset);
                }

                if (nodo.getDerecha() != null) {
                    g.setColor(Color.BLACK);
                    g.drawLine(x + 10, y + 10, x + xOffset - 10, y + yOffset - 10);
                    drawTree(g, x + xOffset, y + yOffset, nodo.getDerecha(), xOffset / 2, yOffset);
                }
            }
        }
    }

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton inOrden;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton postOrden;
    private javax.swing.JButton preOrden;
    private javax.swing.JButton reiniciar;
    private javax.swing.JButton resetear;
    // End of variables declaration//GEN-END:variables
}
