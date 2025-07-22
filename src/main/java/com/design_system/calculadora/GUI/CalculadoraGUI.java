package com.design_system.calculadora.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import com.design_system.calculadora.logica.Logica;

public class CalculadoraGUI extends JFrame{
    
    private JTextField display;
    private JPanel panel;
    private JButton botones;
    
    //instancia de Logica
    Logica logica = new Logica();

    //contructor
    public CalculadoraGUI() {
        
        //ventana principal
        this.setTitle("Calculadora - by Design System");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //display
        display = new JTextField();
        display.setEnabled(false);
        display.setFont(new Font("Arial", Font.PLAIN, 50));   
        //muestro el display en el jframe
        this.add(display, BorderLayout.NORTH);
        
        
        //creo un panel para los botones
        panel = new JPanel();
        //defino el diseno del panel
        panel.setLayout(new GridLayout(5,4,5,5));
        //aplico un borde intenrno (un padding) al panel
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //agrego el panel al JFrame
        this.add(panel, BorderLayout.CENTER);
        
        
        //cremos arreglo de los textos de los botones
        String[] txt_botones = {
        "C","√","%","/",
        "7","8","9", "*",
        "4","5","6","-",
        "1","2","3","+",
        "-","0",".","="
        };
        
        //recorremos el arreglo para crear los botones y asignar los textos
        for(String text : txt_botones){
            
            //crea los botones con los textos de la variable
            botones = new JButton(text);
            
            //estilo de los botones
            botones.setFont(new Font("Arial", Font.ITALIC, 20));
            botones.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            
            //funcion para logica
            botones.addActionListener(new BotonClick());
            
            //agrego los botones al panel
            panel.add(botones);
        }
    }
 
    private class BotonClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //obtenemos el texto de los botones que se apretan
            String comm = e.getActionCommand();
            
            //Procesa el texto obtenido en comm hacia la logica
            logica.processCommand(comm, display);
        }
    }
}


/*
EXPLICACION


*/