package com.design_system.calculadora;

import com.design_system.calculadora.GUI.CalculadoraGUI;
import javax.swing.SwingUtilities;

public class Calculadora {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() ->{
        
            CalculadoraGUI init = new CalculadoraGUI();
            init.setVisible(true);
        });
    }
}
