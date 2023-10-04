import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArregloUnidimensionalGUI extends JFrame implements ActionListener {
    private JTextField numeroField;
    private JTextField posicionField;
    private JTextArea resultadoArea;
    private int[] arreglo = new int[10];
    private int cantidadElementos = 0;

    public ArregloUnidimensionalGUI() {
        setTitle("Arreglo Unidimensional");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel numeroLabel = new JLabel("Número:");
        numeroField = new JTextField(10);
        JLabel posicionLabel = new JLabel("Posición:");
        posicionField = new JTextField(10);

        JButton agregarButton = new JButton("Agregar Dato");
        agregarButton.addActionListener(this);
        JButton borrarButton = new JButton("Borrar Dato");
        borrarButton.addActionListener(this);
        JButton limpiarButton = new JButton("Limpiar Arreglo");
        limpiarButton.addActionListener(this);
        JButton consultarButton = new JButton("Consultar Arreglo");
        consultarButton.addActionListener(this);
        JButton promedioButton = new JButton("Calcular Promedio");
        promedioButton.addActionListener(this);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        panel.add(numeroLabel);
        panel.add(numeroField);
        panel.add(posicionLabel);
        panel.add(posicionField);
        panel.add(agregarButton);
        panel.add(borrarButton);
        panel.add(limpiarButton);
        panel.add(consultarButton);
        panel.add(promedioButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Agregar Dato")) {
            int numero = Integer.parseInt(numeroField.getText());
            int posicion = Integer.parseInt(posicionField.getText());
            
            if (posicion >= 0 && posicion < 10) {
                arreglo[posicion] = numero;
                cantidadElementos++;
                resultadoArea.setText("Dato agregado en la posición " + posicion);
            } else {
                resultadoArea.setText("Posición fuera de rango (0-9).");
            }
        } else if (comando.equals("Borrar Dato")) {
            int posicion = Integer.parseInt(posicionField.getText());
            
            if (posicion >= 0 && posicion < 10) {
                arreglo[posicion] = 0;
                cantidadElementos--;
                resultadoArea.setText("Dato borrado en la posición " + posicion);
            } else {
                resultadoArea.setText("Posición fuera de rango (0-9).");
            }
        } else if (comando.equals("Limpiar Arreglo")) {
            for (int i = 0; i < 10; i++) {
                arreglo[i] = 0;
            }
            cantidadElementos = 0;
            resultadoArea.setText("Arreglo limpiado.");
        } else if (comando.equals("Consultar Arreglo")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Arreglo: [");
            for (int i = 0; i < 10; i++) {
                sb.append(arreglo[i]);
                if (i < 9) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            resultadoArea.setText(sb.toString());
        } else if (comando.equals("Calcular Promedio")) {
            int suma = 0;
            for (int i = 0; i < 10; i++) {
                suma += arreglo[i];
            }
            double promedio = (double) suma / cantidadElementos;
            resultadoArea.setText("Promedio: " + promedio);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArregloUnidimensionalGUI());
    }
}
