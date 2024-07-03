package estructura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Master {
    private JPanel panel1;
    private JTextField inputField;
    private JButton addButton;
    private JTextArea resultArea;
    private JButton inOrderButton;
    private JButton preOrderButton;
    private JButton postOrderButton;
    private Arbol arbol;

    private JButton deleteButton;
    private JPanel jPanel1;

    public Master() {
        arbol = new Arbol();  // Inicializa el árbol con un valor base

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                arbol.agregar(value);
                inputField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                arbol.eliminar(value);
                inputField.setText("");
            }
        });;

        inOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                arbol.inOrden(resultArea);
            }
        });

        preOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                arbol.preOrden(resultArea);
            }
        });

        postOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                arbol.postOrden(resultArea);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Master");
        frame.setContentPane(new Master().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
