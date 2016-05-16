package proyectovideoclub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author galle
 */
public class Paneles implements ActionListener{
    
    JFrame ventana1;
    JFrame ventana2;
    JButton boton1;
    JButton boton2;
    JLabel etiqueta1;
    JTextField texto1;
    JTextField texto2;
    
    public void ventanaLogeo (){
        
        ventana1 = new JFrame ("Videoclub Pirata");
        ventana1.setSize(285, 200);
        ventana1.setLocation(300, 100);
        ventana1.setLayout(null);
        ventana1.setResizable(false);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        etiqueta1 = new JLabel ();
        etiqueta1.setLocation(50, 20);
        etiqueta1.setSize(185, 20);
        etiqueta1.setText("Pantalla de logueo");
        ventana1.add(etiqueta1);
        
        texto1 = new JTextField ();
        texto1.setLocation(50, 60);
        texto1.setSize(185, 20);
        ventana1.add(texto1);
        
        texto2 = new JTextField ();
        texto2.setLocation(50, 85);
        texto2.setSize(185, 20);
        ventana1.add(texto2);
        
        boton1 = new JButton("Login");
        boton1.setLocation(50, 130);
        boton1.setSize(85, 20);
        boton1.addActionListener(this);
        ventana1.add(boton1);
        
        boton2 = new JButton("Salir");
        boton2.setLocation(150, 130);
        boton2.setSize(85, 20);
        boton2.addActionListener(this);
        ventana1.add(boton2);
        
        ventana1.setVisible(true);
        
    }
    
    public void ventanaPrincipal (){
        
        ventana2 = new JFrame ("Videoclub Pirata");
        ventana2.setSize(285, 200);
        ventana2.setLocation(300, 100);
        ventana2.setLayout(null);
        ventana2.setResizable(false);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object aux = ae.getSource();
        if (aux==boton1){
        ventanaPrincipal();
        ventana1.setVisible(false);
        }
        if(aux==boton2) {
        System.exit(0);
        }
    }
}
