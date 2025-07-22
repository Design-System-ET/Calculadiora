package com.design_system.calculadora.logica;

import javax.swing.JTextField;

public class Logica {
    
    //variables para operandos y resultado
    private double num_1;
    private double num_2;
    private double result;
    
    //variable operador aritmetico
    private char opera;
    
    //proceso comandos de botones y display
    public void processCommand(String comm, JTextField display){
        
        //0 es que toma el primer argumento del metodo, osea comm
        if(comm.charAt(0) >= '0' && comm.charAt(0) <= '9' || comm.equals(".")){
        
            //evaluo si el pupnto ya fue agregado al numero
            if (comm.equals(".") && display.getText().contains(".")) {
                return; // No agregar otro punto si ya hay uno
            }
            
            //se anade el numero al display
            display.setText(display.getText() + comm);
            
        }else if(comm.equals("+") || comm.equals("-") || comm.equals("*") || comm.equals("/")){
            //guardamos el 1er numero
            num_1 = Double.parseDouble(display.getText());
            //guardamos el operador
            opera = comm.charAt(0);
            
            //limpiamos el display
            display.setText("");
            
        }else if(comm.equals("=")){
            
            //guardo el segundo numero
            num_2 = Double.parseDouble(display.getText());
            
            
            //realizo la operacion
            switch(opera){
                case '+':
                    result = num_1 + num_2;
                    break;
                case '-':
                    result = num_1 - num_2;
                    break;
                case '*':
                    result = num_1 * num_2;
                    break;
                case '/':
                    result = num_1 / num_2;
                    break;
            }
            
            display.setText(String.valueOf(result));
        
        }else if(comm.equals("%")){
        
            if (!display.getText().isEmpty()) {
                num_1 = Double.parseDouble(display.getText());
                result = num_1 / 100;
                display.setText(String.valueOf(result));
            }
            
        }else if(comm.equals("C")){
            
            //limpiamos el display
            display.setText("");
            num_1 = 0;
            num_2 = 0;
        }
    }
}
