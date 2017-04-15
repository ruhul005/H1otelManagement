package hotelProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CheckOut extends Frame implements ActionListener{
	
	private JLabel messageL;
	
	public CheckOut(){
		messageL=new JLabel("Which room to check out");
		
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
            	 Person []data=new Person[10];
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
         				data[index] = temp;
         				index++;
         			}
            	 }catch(Exception e1){
            		 System.out.println(e1.getMessage());
            	 }
            	// print retrieved data to make sure you have the data back
         		for(int i = 0; i < data.length; i++){
         			if(data[i] != null){ // object is not null
         				System.out.println(data[i]);
         			}
         		}
         	// search for a particular record
         		Scanner s=new Scanner(System.in);
        		System.out.println("Enter search key which you would like to use for CheckOut:");
        		String key = s.nextLine();
        		for(int i = 0; i < data.length; i++){
        			if(data[i] != null && data[i].getNameF().equals(key) || data[i].getNidF().equals(key)){
        				System.out.println("Record found!");
        				System.out.println(data[i]);
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
