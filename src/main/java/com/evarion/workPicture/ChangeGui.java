package com.evarion.workPicture;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGui extends JFrame {

    JPanel jPanelLeft = new JPanel();
    JPanel jPanelRight = new JPanel();

    JSlider jSliderR = new JSlider(0, 255, 0);
    JSlider jSliderG = new JSlider(0, 255, 0);
    JSlider jSliderB = new JSlider(0, 255, 0);


    public ChangeGui() {
        super("App");
        createGUI();
    }

    public void createGUI() {

        addPanel();
        setSliderRGB();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setLocation(200, 40);
        setMinimumSize(new Dimension(1600, 900));

    }

    public void addPanel() {

        add(jPanelLeft);
        add(jPanelRight);

        jPanelLeft.add(jSliderR);
        jPanelLeft.add(jSliderG);
        jPanelLeft.add(jSliderB);

        setPanel();
        addButtons();
    }

    public void setPanel() {
        jPanelLeft.setBackground(Color.LIGHT_GRAY);
        jPanelRight.setBackground(Color.YELLOW);
        jPanelLeft.setLayout(new GridLayout(1, 1));
    }

    public void addButtons() {

    }

    public void setSliderRGB() {
        jSliderR.addChangeListener(new ChangeListenerSlider());
        jSliderG.addChangeListener(new ChangeListenerSlider());
        jSliderB.addChangeListener(new ChangeListenerSlider());
    }

    class ChangeListenerSlider implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() == jSliderR){
                int tempR = jSliderR.getValue();
                System.out.println(tempR);
            }
            if (e.getSource()==jSliderG) {
                int tempG = jSliderG.getValue();
                System.out.println(tempG);
            }
            if (e.getSource()==jSliderB){
                int tempB = jSliderG.getValue();
                System.out.println(tempB);
            }
        }
    }
}
