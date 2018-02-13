package View;

 import java.awt.*;
 import java.awt.event.*;
 import java.sql.*;
 import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DataBaseConnection;
  

	public class Schedule2day {
		DataBaseConnection dbc = new DataBaseConnection();

	    public Schedule2day(){
	        
	        // create JFrame and JTable
	        JFrame frame = new JFrame();
	        JTable table = new JTable(); 
	        
	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"week"," sunday"," wednesday" };
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        // create JTextFields
	        JTextField textweek = new JTextField();
	        JTextField textSunDay = new JTextField();
	        JTextField textWednesday= new JTextField();
	        
	        
	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        
	        textweek.setBounds(20, 220, 100, 25);
	        textSunDay.setBounds(20, 250, 100, 25);
	        textWednesday.setBounds(20, 280, 100, 25);
	       
	        
	        btnAdd.setBounds(150, 220, 100, 25);
	        btnUpdate.setBounds(150, 265, 100, 25);
	        btnDelete.setBounds(150, 310, 100, 25);
	        
	        JButton insert = new JButton(" insert");
			insert.setFont(new Font("Tahoma", Font.BOLD, 16));
			insert.setBounds(590, 235, 105, 33);
			frame.getContentPane().add(insert);
	        
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 880, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        // add JTextFields to the jframe
	        frame.add(textweek);
	        frame.add(textSunDay);
	        frame.add(textWednesday);
	         
	    
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[4];
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textweek.getText();
	                row[1] = textSunDay.getText();
	                row[2] = textWednesday.getText();
	                
	                
	                // add row to the model
	                model.addRow(row);
	            }
	        });
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
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
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textweek.setText(model.getValueAt(i, 0).toString());
	            textSunDay.setText(model.getValueAt(i, 1).toString());
	            textWednesday.setText(model.getValueAt(i, 2).toString());
	            
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textweek.getText(), i, 0);
	                   model.setValueAt(textSunDay.getText(), i, 1);
	                   model.setValueAt(textWednesday.getText(), i, 2);
	                   
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        //button insert in db
	        insert.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				  try{

						int rows= table.getRowCount();
						dbc.con.setAutoCommit(false);
						String queryco = "Insert into  schedule2days(Week,Sunday,Wednesday ) values (?,?,?)";
						PreparedStatement	pst = dbc.con.prepareStatement(queryco);
						for(int row = 0; row<rows; row++)
						{
						    String coitemname = (String)table.getValueAt(row, 0);
						    String cocateg = (String)table.getValueAt(row, 1);
						    String codesc = (String)table.getValueAt(row, 2);
						   
						    pst.setString(1, coitemname);
						    pst.setString(2, cocateg);
						    pst.setString(3, codesc);
						    

						    pst.addBatch();
						}
						pst.executeBatch();
						JOptionPane.showMessageDialog(null, "data inserted");
						dbc.con.commit();
						
						}
						catch(Exception ex){
						    JOptionPane.showMessageDialog(null,ex.getMessage());
						}
					
				}
			});
	        
	        frame.setSize(900,400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	    }
	}

