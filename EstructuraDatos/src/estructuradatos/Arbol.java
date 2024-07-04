package estructuradatos;

import javax.swing.JTextArea;
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

    public List<Nodo> getInOrdenNodos() {
        List<Nodo> nodos = new ArrayList<>();
        getInOrdenNodosRec(raiz, nodos);
        return nodos;
    }

    private void getInOrdenNodosRec(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            getInOrdenNodosRec(nodo.getIzquierda(), nodos);
            nodos.add(nodo);
            getInOrdenNodosRec(nodo.getDerecha(), nodos);
        }
    }

    public List<Nodo> getPreOrdenNodos() {
        List<Nodo> nodos = new ArrayList<>();
        getPreOrdenNodosRec(raiz, nodos);
        return nodos;
    }

    private void getPreOrdenNodosRec(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            nodos.add(nodo);
            getPreOrdenNodosRec(nodo.getIzquierda(), nodos);
            getPreOrdenNodosRec(nodo.getDerecha(), nodos);
        }
    }

    public List<Nodo> getPostOrdenNodos() {
        List<Nodo> nodos = new ArrayList<>();
        getPostOrdenNodosRec(raiz, nodos);
        return nodos;
    }

    private void getPostOrdenNodosRec(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            getPostOrdenNodosRec(nodo.getIzquierda(), nodos);
            getPostOrdenNodosRec(nodo.getDerecha(), nodos);
            nodos.add(nodo);
        }
    }
}
