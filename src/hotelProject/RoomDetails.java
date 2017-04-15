package hotelProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class RoomDetails extends Frame implements ActionListener{
	private JLabel messageL;
	
	public RoomDetails(){
		messageL=new JLabel("Select which room you want the details");
		
		GridLayout s=new GridLayout(5,2);
		getFrame().setLayout(s);
		
		getFrame().add(messageL);
		getFrame().add(getRoomL());
		getFrame().add(getRoom());
		getFrame().add(getSubmit());
		getFrame().add(getBack());
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
	             if(e.getSource()==getSubmit()){
	            	 
	         		Person [] persons = new Person [30];
	            	 try{
	            		 File f = new File("data.txt");
	         			Scanner x = new Scanner(f);
	         			int index = 0;
	         			
	         			while(x.hasNextLine()){
	         				String nameF = x.nextLine();
	         				String nidF = x.nextLine();
	         				String addressF = x.nextLine();
	         				String phoneF = x.nextLine();
	         				String roomF = x.nextLine();
	         				String daysToRentF = x.nextLine();
	         				String daysF = x.nextLine();
	         				int c = Integer.parseInt(daysF);
	         				String totalCoastF = x.nextLine();
	         				double d = Double.parseDouble(totalCoastF);

	         				Person temp = new Person(nameF,nidF,addressF,phoneF,roomF,daysToRentF,c,d);
	         				persons[index] = temp;
	         				index++;
	         			}
	            	 }catch(Exception e1){
	            		 System.out.println(e1.getMessage());
	            	 }
	            	// print retrieved data to make sure you have the data back
	         		for(int i = 0; i <persons.length; i++){
	         			if(persons[i] != null){ // object is not null
	         				System.out.println(persons[i]);
	         			}
	         		}
	         	// search for a particular record
	         		Scanner s=new Scanner(System.in);
	        		System.out.println("Enter search key which you would like to use for searching:");
	        		String key = s.nextLine();
	        		for(int i = 0; i <persons.length; i++){
	        			if(persons[i] != null && persons[i].getNameF().equals(key) || persons[i].getRoomF().equals(key)){
	        				System.out.println("Record found!");
	        				System.out.println(persons[i]);
	        			}
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
