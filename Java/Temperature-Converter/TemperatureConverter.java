/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureconverter;

/**
 *
 * @author Rian Khan
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemperatureConverter {
    /**
     * @param args the command line arguments
     */
    
    public TemperatureConverter(){
        JLabel Title = new JLabel("Fahrenheit to Celsius Converter");
        Title.setForeground(Color.red);
        Title.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel FPrompt = new JLabel("Fahrenheit temperature: ");
        
        JTextField Temperature = new JTextField("", 8);
        
        JLabel CTemp = new JLabel("Celsius Temperature");
        
        JButton Convert = new JButton("Convert");
        Convert.addActionListener(new ActionListener(){
          
            @Override
            public void actionPerformed(ActionEvent event){
                double nctemp = 5.0/9.0*(Double.parseDouble(Temperature.getText()) - 32.0);
                CTemp.setText(String.format("%.1f", nctemp )+ " degrees Celsius");
            }
        });
        
        JFrame newFrame = new JFrame("Fahrenheit to Celsius Converter");
        newFrame.setSize(350,110);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.add(BorderLayout.NORTH,Title);
        newFrame.add(BorderLayout.WEST, FPrompt);
        newFrame.add(BorderLayout.CENTER, Temperature);
        newFrame.add(BorderLayout.EAST, CTemp);
        newFrame.add(BorderLayout.SOUTH, Convert);
        newFrame.setVisible(true);
    }
    public static void main(String[] args) {        
        new TemperatureConverter();       
    }  
}
