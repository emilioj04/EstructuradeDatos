package estructuradatos;

import javax.swing.JTextArea;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Arbol implements Estructura {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }
    
    public Nodo getRaiz() {
        return this.raiz;
    }

    @Override
    public boolean agregar(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return true;
        } else {
            return raiz.agregar(valor);
        }
    }

    @Override
    public boolean eliminar(int valor) {
        if (raiz == null) {
            return false;
        } else {
            if (raiz.getValor() == valor) {
                Nodo auxRoot = new Nodo(0);
                auxRoot.setIzquierda(raiz);
                boolean result = raiz.eliminar(valor, auxRoot);
                raiz = auxRoot.getIzquierda();
                return result;
            } else {
                return raiz.eliminar(valor, null);
            }
        }
    }

    public void inOrden(JTextArea jTextArea1) {
        int[] posicion = {1};
        jTextArea1.setText(inOrdenRec(raiz, "", posicion));
    }

    private String inOrdenRec(Nodo raiz, String acc, int[] posicion) {
        if (raiz != null) {
            acc = inOrdenRec(raiz.getIzquierda(), acc, posicion);
            acc += "(" + posicion[0]++ + ") " + raiz.getValor() + " ";
            acc = inOrdenRec(raiz.getDerecha(), acc, posicion);
        }
        return acc;
    }

    public void preOrden(JTextArea textArea) {
        int[] posicion = {1};
        textArea.setText(preOrdenRec(raiz, "", posicion));
    }

    private String preOrdenRec(Nodo raiz, String acc, int[] posicion) {
        if (raiz != null) {
            acc += "(" + posicion[0]++ + ") " + raiz.getValor() + " ";
            acc = preOrdenRec(raiz.getIzquierda(), acc, posicion);
            acc = preOrdenRec(raiz.getDerecha(), acc, posicion);
        }
        return acc;
    }

public void postOrden(JTextArea textArea) {
    int[] posicion = {1};
    textArea.setText(postOrdenRec(raiz, "", posicion));
}

private String postOrdenRec(Nodo raiz, String acc, int[] posicion) {
    if (raiz != null) {
        acc = postOrdenRec(raiz.getIzquierda(), acc, posicion);
        acc = postOrdenRec(raiz.getDerecha(), acc, posicion);
        acc += "(" + posicion[0]++ + ") " + raiz.getValor() + " ";
    }
    return acc;
}

    
    private void dibujarArbol(Graphics2D g, int x, int y, Nodo nodo, int espacio) {
        if (nodo != null) {
            String nodoInfo = "(" + nodo.getPosicion() + ") " + nodo.getValor(); // Agregar posición aquí
            g.drawString(nodoInfo, x, y);
            if (nodo.getIzquierda() != null) {
                dibujarLinea(g, x - espacio, y + 50, x, y);
                dibujarArbol(g, x - espacio, y + 50, nodo.getIzquierda(), espacio / 2);
            }
            if (nodo.getDerecha() != null) {
                dibujarLinea(g, x + espacio, y + 50, x, y);
                dibujarArbol(g, x + espacio, y + 50, nodo.getDerecha(), espacio / 2);
            }
        }
    }
    
    private void dibujarNodo(Graphics2D g, Nodo nodo, int x, int y, int espacio, int nivel) {
        if (nodo != null) {
            g.drawString(Integer.toString(nodo.getValor()), x, y);
            if (nodo.getIzquierda() != null) {
                dibujarLinea(g, x - espacio, y + nivel, x, y);
                dibujarNodo(g, nodo.getIzquierda(), x - espacio, y + nivel, espacio / 2, nivel - espacio);
            }
            if (nodo.getDerecha() != null) {
                dibujarLinea(g, x + espacio, y + nivel, x, y);
                dibujarNodo(g, nodo.getDerecha(), x + espacio, y + nivel, espacio / 2, nivel - espacio);
            }
        }
    }
    
    private void dibujarLinea(Graphics2D g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    // Métodos para obtener las coordenadas del recorrido

    public List<int[]> getInOrdenCoords(int x, int y, int espacio, int nivel) {
        List<int[]> coords = new ArrayList<>();
        getInOrdenCoordsRec(raiz, x, y, espacio, nivel, coords);
        return coords;
    }

    private void getInOrdenCoordsRec(Nodo nodo, int x, int y, int espacio, int nivel, List<int[]> coords) {
        if (nodo != null) {
            getInOrdenCoordsRec(nodo.getIzquierda(), x - espacio, y + nivel, espacio / 2, nivel, coords);
            coords.add(new int[]{x, y});
            getInOrdenCoordsRec(nodo.getDerecha(), x + espacio, y + nivel, espacio / 2, nivel, coords);
        }
    }

    public List<int[]> getPreOrdenCoords(int x, int y, int espacio, int nivel) {
        List<int[]> coords = new ArrayList<>();
        getPreOrdenCoordsRec(raiz, x, y, espacio, nivel, coords);
        return coords;
    }

    private void getPreOrdenCoordsRec(Nodo nodo, int x, int y, int espacio, int nivel, List<int[]> coords) {
        if (nodo != null) {
            coords.add(new int[]{x, y});
            getPreOrdenCoordsRec(nodo.getIzquierda(), x - espacio, y + nivel, espacio / 2, nivel, coords);
            getPreOrdenCoordsRec(nodo.getDerecha(), x + espacio, y + nivel, espacio / 2, nivel, coords);
        }
    }

    public List<int[]> getPostOrdenCoords(int x, int y, int espacio, int nivel) {
        List<int[]> coords = new ArrayList<>();
        getPostOrdenCoordsRec(raiz, x, y, espacio, nivel, coords);
        return coords;
    }

    private void getPostOrdenCoordsRec(Nodo nodo, int x, int y, int espacio, int nivel, List<int[]> coords) {
        if (nodo != null) {
            getPostOrdenCoordsRec(nodo.getIzquierda(), x - espacio, y + nivel, espacio / 2, nivel, coords);
            getPostOrdenCoordsRec(nodo.getDerecha(), x + espacio, y + nivel, espacio / 2, nivel, coords);
            coords.add(new int[]{x, y});
        }
    }
}