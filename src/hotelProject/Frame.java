package hotelProject;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Frame implements ActionListener{
    private JFrame frame;
     
    private JLabel roomL;
    
    private JComboBox room;
   
    private JButton submit;
    private JButton back;
     
    public Frame(){
    	//initialize component
        frame = new JFrame();
         
        roomL= new JLabel("Room No");
         
        String[]options = {"201","202","203","204","205","206","207","208","209","210"};
        room= new JComboBox(options);
         
        submit = new JButton("Submit");
        submit.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
         
         //no need GridLayout
        //no need add component
        
        frame.setSize(640, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Ashik & Ruhul Hotel");       
    }
     
    public  JLabel getRoomL()
    {
        return roomL;
    }
    public JComboBox getRoom()
    {
        return room;
    }
    public JButton getSubmit()
    {
        return submit;
    }
    public JButton getBack()
    {
        return back;
    }
     
    public JFrame getFrame()
    {
        return frame;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource()==getSubmit()){
            	 getFrame().setVisible(false);
            	 //JOptionPane.showMessageDialog(null, e);
            	 new Menu();
             }
             else if(e.getSource()==getBack()){
            	 getFrame().setVisible(false);
            	 //JOptionPane.showMessageDialog(null,e);
            	 new Menu();
             }
    }
}