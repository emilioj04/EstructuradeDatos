package estructuradatos;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ArbolGrafico extends JPanel {
    private Arbol arbol;

    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el árbol
        dibujarArbol(g2, getWidth() / 2, 30, arbol.getRaiz(), getWidth() / 4);

        g2.dispose();
    }

    private void dibujarArbol(Graphics2D g, int x, int y, Nodo nodo, int offset) {
        if (nodo == null) {
            System.out.println("Nodo es null");
            return;
        }
        System.out.println("Dibujando nodo: " + nodo.getValor() + " en x: " + x + ", y: " + y);

        // Define el tamaño y la posición del nodo
        int nodoWidth = 40;
        int nodoHeight = 30;
        int xNodo = x - nodoWidth / 2;
        int yNodo = y;

        // Dibuja un rectángulo redondeado para el nodo
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(xNodo, yNodo, nodoWidth, nodoHeight, 20, 20);
        g.fill(roundedRectangle);

        // Dibuja líneas hacia los hijos y dibuja recursivamente los hijos
        if (nodo.getIzquierda() != null) {
            g.drawLine(x, y + nodoHeight / 2, x - offset + nodoWidth / 2, y + 50);
            dibujarArbol(g, x - offset, y + 50, nodo.getIzquierda(), offset / 2);
        }
        if (nodo.getDerecha() != null) {
            g.drawLine(x, y + nodoHeight / 2, x + offset - nodoWidth / 2, y + 50);
            dibujarArbol(g, x + offset, y + 50, nodo.getDerecha(), offset / 2);
        }
    }
}
