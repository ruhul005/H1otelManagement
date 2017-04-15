package hotelProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ExtendsDays extends Frame implements ActionListener{
	private JLabel DaysToExtendsL;
	private JTextField DaysToExtends;
	
	public ExtendsDays(){
		DaysToExtendsL=new JLabel("How much days you want to extends?");
		DaysToExtends=new JTextField();
		
		GridLayout s=new GridLayout(5,2);
		getFrame().setLayout(s);
		
		getFrame().add(getRoomL());
		getFrame().add(getRoom());
		getFrame().add(DaysToExtendsL);
		getFrame().add(DaysToExtends);
		getFrame().add(getSubmit());
		getFrame().add(getBack());
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
	             if(e.getSource()==getSubmit()){
	            	 Person [] persons = new Person[5];      		            	 
	            	 try{
	            		 Scanner s=new Scanner(System.in);
	            		 System.out.println("How many day you wantto extends:");
	            		 int x=s.nextInt();
	            		 
	            		 FileWriter fw = new FileWriter("data.txt", true);
	            		 
	            		 for(int i = 0; i < persons.length; i++){
	            			 System.out.println("Enter a key(Name or Nid) which persons want to  extends days:");
	            			 String key=s.nextLine();
	            			if(persons[i] != null && persons[i].getNameF().equals(key) || persons[i].getNidF().equals(key)){
	    	            		 x=x+getDaysF();
	    	            		 persons[i].setDaysF(x);
	    	            		 persons[i].setDaysToRentF("x");
	    	            		 x=x*600;
	    	            		 persons[i].setTotalCoastF(x);
	            		
	            			  }
	            		}
	            		 for(int i = 0; i < persons.length; i++){
	         				fw.write(persons[i].getNameF() + "\n");
	         				fw.write(persons[i].getNidF() + "\n");
	         				fw.write(persons[i].getAddressF() + "\n");
	         				fw.write(persons[i].getPhoneF() + "\n");
	         				fw.write(persons[i].getRoomF() + "\n");
	         				fw.write(persons[i].getDaysF() + "\n");
	         				fw.write(persons[i].getDaysToRentF() + "\n");
	         				fw.write(persons[i].getTotalCoastF() + "\n");
	            		 }	           
	            		 fw.close();
	            	 }catch(Exception e1){
	            		 System.out.println(e1.getMessage());
	            		 }  	 	            	 	   
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
