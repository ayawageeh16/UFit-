package View;
 
import  java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DataBaseConnection;

	public class Scheduleeverydays extends JFrame{
		
		  
	        JFrame frame = new JFrame();
	        JTable Scheduleeverydays = new JTable(); 
	        
	        JTextField textWeek = new JTextField();
	        JTextField textSaturday = new JTextField();
	        JTextField textSunday = new JTextField();
	        JTextField textMonday= new JTextField();
	        JTextField textTuesday = new JTextField();
	        JTextField textWednesday = new JTextField();
	        JTextField textThursday= new JTextField();
	        DataBaseConnection dbc = new DataBaseConnection();
	        PreparedStatement pst=null;
	        
	        public Scheduleeverydays(){
	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");
	        JButton insert = new JButton("insert");

	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"Week","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        Scheduleeverydays.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	      Scheduleeverydays.setBackground(Color.LIGHT_GRAY);
	       Scheduleeverydays.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        Scheduleeverydays.setFont(font);
	        Scheduleeverydays.setRowHeight(30);
	        
	        // create JTextFields     
	        
	          textWeek.setBounds(20, 220, 100, 25);
	          textSaturday.setBounds(20, 250, 100, 25);
	          textSunday.setBounds(20, 280, 100, 25);
	          textMonday.setBounds(20, 310, 100, 25);
	          textTuesday.setBounds(20, 340, 100, 25);
	          textWednesday.setBounds(20, 370, 100, 25);
	          textThursday.setBounds(20, 400, 100, 25);

	        btnAdd.setBounds(150, 230, 100, 25);
	        btnUpdate.setBounds(150, 285, 100, 25);
	        btnDelete.setBounds(150, 330, 100, 25);
	        insert.setBounds(400, 265, 100,50);
	        
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(Scheduleeverydays);
	        pane.setBounds(0, 0, 880, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        // add JTextFields to the jframe
	        frame.add(textWeek);
	        frame.add(textSaturday);
	        frame.add(textSunday);
	        frame.add(textMonday);
	        frame.add(textTuesday);
	        frame.add(textWednesday);
	        frame.add(textThursday);
	    
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        frame.add(insert);
	        // create an array of objects to set the row data
	        Object[] row = new Object[7];
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textWeek.getText();
	                row[1] = textSaturday.getText();
	                row[2] = textSunday.getText();
	                row[3] = textMonday.getText();
	                row[4] = textTuesday.getText();
	                row[5] = textWednesday.getText();
	                row[6] = textThursday.getText();
	                // add row to the model
	                model.addRow(row);
	            }
	        });
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                // i = the index of the selected row
	                int i = Scheduleeverydays.getSelectedRow();
	                if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
	            }
	        });
	        
	        // get selected row data From table to textfields 
	        Scheduleeverydays.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = Scheduleeverydays.getSelectedRow();
	            
	            textWeek.setText(model.getValueAt(i, 0).toString());
	            textSaturday.setText(model.getValueAt(i, 1).toString());
	            textSunday.setText(model.getValueAt(i, 2).toString());
	            textMonday.setText(model.getValueAt(i, 3).toString());
	            textTuesday.setText(model.getValueAt(i, 4).toString());
	            textWednesday.setText(model.getValueAt(i, 5).toString());
	            textThursday.setText(model.getValueAt(i, 6).toString());
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = Scheduleeverydays.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textWeek.getText(), i, 0);
	                   model.setValueAt(textSaturday.getText(), i, 1);
	                   model.setValueAt(textSunday.getText(), i, 2);
	                   model.setValueAt(textMonday.getText(), i, 3);
	                   model.setValueAt(textTuesday.getText(), i, 4);
	                   model.setValueAt(textWednesday.getText(), i, 5);
	                   model.setValueAt(textThursday.getText(), i, 6);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        
	        
	        
	         insert.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	               try{

	     int rows=Scheduleeverydays.getRowCount();
          dbc.con.setAutoCommit(false);
	String queryco = "Insert into scheduleeverydays(Week,saturday,sunday,monday,tuesday,wednesday,thursday) values (?,?,?,?,?,?,?)";
	      PreparedStatement   pst =  dbc.con.prepareStatement(queryco);
	for(int row = 0; row<rows; row++)
	{
	    String  Week3= (String)Scheduleeverydays.getValueAt(row, 0);
	    String Saturday3 = (String)Scheduleeverydays.getValueAt(row, 1);
	    String Sunday3 = (String)Scheduleeverydays.getValueAt(row, 2);
	    String Monday3 = (String)Scheduleeverydays.getValueAt(row, 3);
	    String Tuesday3 = (String)Scheduleeverydays.getValueAt(row, 4);
	    String Wednesday3 = (String)Scheduleeverydays.getValueAt(row, 5);
	    String Thursday3 = (String)Scheduleeverydays.getValueAt(row, 6);

	    pst.setString(1, Week3);
	    pst.setString(2, Saturday3);
	    pst.setString(3, Sunday3);
	    pst.setString(4, Monday3);
	    pst.setString(5, Tuesday3);
	    pst.setString(6, Wednesday3);
	    pst.setString(7, Thursday3);
	    pst.addBatch();
	   }
	    pst.executeBatch();
	    JOptionPane.showMessageDialog(null, "data inserted");
	        dbc.con.commit();
	           }
	                catch(Exception ex){
	                    JOptionPane.showMessageDialog(frame,ex.getMessage());
	}
	            }
	        });
	        
	        
	        frame.setSize(900, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	    }
	}


 
