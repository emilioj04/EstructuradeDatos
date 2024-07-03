/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradatos;

public class Nodo {
    private int valor;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getValor() {
        return valor;
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

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public boolean agregar(int valor) {
        if (valor < this.valor) {
            if (izquierda == null) {
                izquierda = new Nodo(valor);
                return true;
            } else {
                return izquierda.agregar(valor);
            }
        } else if (valor > this.valor) {
            if (derecha == null) {
                derecha = new Nodo(valor);
                return true;
            } else {
                return derecha.agregar(valor);
            }
        } else {
            return false; // El valor ya existe
        }
    }

    public boolean eliminar(int valor, Nodo padre) {
        if (valor < this.valor) {
            return izquierda != null && izquierda.eliminar(valor, this);
        } else if (valor > this.valor) {
            return derecha != null && derecha.eliminar(valor, this);
        } else {
            if (izquierda != null && derecha != null) {
                this.valor = derecha.minValor();
                return derecha.eliminar(this.valor, this);
            } else if (padre.izquierda == this) {
                padre.izquierda = (izquierda != null) ? izquierda : derecha;
            } else if (padre.derecha == this) {
                padre.derecha = (izquierda != null) ? izquierda : derecha;
            }
            return true;
        }
    }

    public int minValor() {
        if (izquierda == null) {
            return valor;
        } else {
            return izquierda.minValor();
        }
    }
}
