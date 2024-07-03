package estructura;

import javax.swing.*;

public class Nodo {
    private int valor;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public int minValor() {
        if (izquierda == null) {
            return valor;
        } else {
            return izquierda.minValor();
        }
    }


    public boolean agregar(int valor) {
        if (this.valor > valor) {
            if (this.izquierda == null) {
                this.izquierda = new Nodo(valor);
                return true;
            } else {
                return this.izquierda.agregar(valor);
            }
        } else if (this.valor < valor) {
            if (this.derecha == null) {
                this.derecha = new Nodo(valor);
                return true;
            } else {
                return this.derecha.agregar(valor);
            }
        } else {
            return false;
        }
    }

    public boolean eliminar(int valor, Nodo parent) {
        if (valor < this.valor) {
            if (izquierda != null) {
                return izquierda.eliminar(valor, this);
            } else {
                return false;
            }
        } else if (valor > this.valor) {
            if (derecha != null) {
                return derecha.eliminar(valor, this);
            } else {
                return false;
            }
        } else {
            if (izquierda != null && derecha != null) {
                this.valor = derecha.minValor();
                derecha.eliminar(this.valor, this);
            } else if (parent.izquierda == this) {
                parent.izquierda = (izquierda != null) ? izquierda : derecha;
            } else if (parent.derecha == this) {
                parent.derecha = (izquierda != null) ? izquierda : derecha;
            }
            return true;
        }
    }

    public void preOrden(JTextArea resultArea) {
        resultArea.append(this.valor + "\n");
        if (this.izquierda != null) {
            this.izquierda.preOrden(resultArea);
        }
        if (this.derecha != null) {
            this.derecha.preOrden(resultArea);
        }
    }

    public void inOrden(JTextArea resultArea) {
        if (this.izquierda != null) {
            this.izquierda.inOrden(resultArea);
        }
        resultArea.append(this.valor + "\n");
        if (this.derecha != null) {
            this.derecha.inOrden(resultArea);
        }
    }
}
