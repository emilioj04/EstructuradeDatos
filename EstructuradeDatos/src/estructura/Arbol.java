package estructura;

import javax.swing.JTextArea;

public class Arbol implements Estructura {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
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

    public void inOrden(JTextArea textArea) {
        textArea.setText(inOrdenRec(raiz, ""));
    }

    private String inOrdenRec(Nodo raiz, String acc) {
        if (raiz != null) {
            acc = inOrdenRec(raiz.getIzquierda(), acc);
            acc += raiz.getValor() + " ";
            acc = inOrdenRec(raiz.getDerecha(), acc);
        }
        return acc;
    }

    public void preOrden(JTextArea textArea) {
        textArea.setText(preOrdenRec(raiz, ""));
    }

    private String preOrdenRec(Nodo raiz, String acc) {
        if (raiz != null) {
            acc += raiz.getValor() + " ";
            acc = preOrdenRec(raiz.getIzquierda(), acc);
            acc = preOrdenRec(raiz.getDerecha(), acc);
        }
        return acc;
    }

    public void postOrden(JTextArea textArea) {
        textArea.setText(postOrdenRec(raiz, ""));
    }

    private String postOrdenRec(Nodo raiz, String acc) {
        if (raiz != null) {
            acc = postOrdenRec(raiz.getIzquierda(), acc);
            acc = postOrdenRec(raiz.getDerecha(), acc);
            acc += raiz.getValor() + " ";
        }
        return acc;
    }
}



