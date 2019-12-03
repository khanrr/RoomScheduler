/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrawingApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Rian Khan
 */
public class DrawingApplication {
    /**
     * @param args the command line arguments
     */
    public DrawingApplication(){
        FlowLayout CurrentLayout = new FlowLayout();
        CurrentLayout.setAlignment(FlowLayout.TRAILING);
        
        String[] shapes = {"Line", "Oval", "Rectangle"};
        
        JButton Undo = new JButton("Undo");
        
        JButton Clear = new JButton("Clear");
        
        JLabel ShapePrompt = new JLabel("Shape: ");
        
        JComboBox ShapeChoice = new JComboBox(shapes);
        
        JCheckBox Fill = new JCheckBox("Filled");
        
        JPanel Controls = new JPanel(new FlowLayout());
        Controls.add(Undo);
        Controls.add(Clear);
        Controls.add(ShapePrompt);
        Controls.add(ShapeChoice);
        Controls.add(Fill);
        
        JCheckBox Gradient = new JCheckBox("Use Gradient");
                
        JColorChooser CC1 = new JColorChooser();
        
        JColorChooser CC2 = new JColorChooser();
        
        JButton Color1 = new JButton("1st Color...");
        Color1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                JColorChooser.showDialog(null, null, null);
            }
        });
        
        JButton Color2 = new JButton("2nd Color...");
        Color2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                JColorChooser.showDialog(null, null, null);
            }
        });
        
        JLabel LineWidth = new JLabel("Line Width: ");
        
        JTextField Width = new JTextField("", 2);
        
        JLabel DashLength = new JLabel("Dash Length: ");   
        
        JTextField DashWidth = new JTextField("", 2);
        
        JCheckBox Dash = new JCheckBox("Dashed");
        
        JPanel Controls2 = new JPanel();
        Controls2.add(Gradient);
        Controls2.add(Color1);
        Controls2.add(Color2);
        Controls2.add(LineWidth);
        Controls2.add(Width);
        Controls2.add(DashLength);
        Controls2.add(DashWidth);
        Controls2.add(Dash);
        
        JPanel DrawingPanel = new JPanel();
        DrawingPanel.setBackground(Color.white);
        
        JLabel Coordinates = new JLabel("Text here");
        
        JPanel outer = new JPanel(new BorderLayout());
        outer.add(BorderLayout.NORTH,Controls);
        
        
        JFrame AFrame = new JFrame("Java 2D Drawings");
        AFrame.setSize(650,500);
        AFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AFrame.setVisible(true);
        AFrame.add(BorderLayout.NORTH, outer);
        AFrame.add(BorderLayout.PAGE_START, DrawingPanel);
        AFrame.add(BorderLayout.SOUTH, Coordinates);
        
}
    public static void main(String[] args) {
        new DrawingApplication();
    }
    
}
