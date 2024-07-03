import estructura.Estructura;
import estructura.Arbol;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estructura arbol = new Arbol();
        JTextArea textArea = new JTextArea();

        ((Arbol) arbol).postOrden(textArea);
        ((Arbol) arbol).preOrden(textArea);
        ((Arbol) arbol).inOrden(textArea);

    }
}