

package View;





import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.scene.input.KeyCode.F;
import javax.swing.*;

   
public class TrainerPage extends JFrame{
   JLabel PackageSearch; 
    JComboBox  PackageSchedule;
    JPanel p2;
   
 
    // End of variables declaration    
    
    
   
    
    public TrainerPage() {
        
        JFrame F=new JFrame("TrainerPage");
        
         p2 = new JPanel();
         PackageSearch= new JLabel();
        
         PackageSchedule = new JComboBox();
        
         
         
         F.setSize(600,600);
         F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 F.getContentPane().setLayout(null);
         F.getContentPane().add(p2);
        
     
        p2.setBackground(new java.awt.Color(51, 0, 51));
        p2.setBounds(0,0,600,600);
        p2.setLayout(null);
        
      
        
        
           PackageSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
          PackageSearch.setForeground(Color.GRAY);
          PackageSearch.setText("Search");
          PackageSearch.setBackground(new java.awt.Color(240,240,240));
          p2.add(PackageSearch);
          PackageSearch.setBounds(100, 50, 350, 30);
         PackageSchedule.setEditable(true);
        
        
        
        
         // PackageSchedule.addItem("Select  ");
          PackageSchedule.addItem("Schedule");
          PackageSchedule.addItem("Schedule2Days");
          PackageSchedule.addItem("Schedule3Days");
           PackageSchedule.addItem("Scheduleeverydays");
          PackageSchedule.setBounds(120,100,320, 50);
          PackageSchedule.setForeground(Color.BLACK);
          PackageSchedule.setBackground(Color.WHITE);
          PackageSchedule.setFont(new java.awt.Font("Tahoma", 1, 14));
           PackageSchedule.setEditable(true);
          p2.add(PackageSchedule);
          F.getContentPane().add(p2);
          p2.setBounds(0, 0, 600, 600);
          //
        // Create an ActionListener for the JComboBox component.
        //
        PackageSchedule.addActionListener(new ActionListener() {
           // private Object Schedule3Days;
            //private Object Scheduleeverydays;
            public void actionPerformed(ActionEvent event) {
              
                
               
                JComboBox PackageSchedule = (JComboBox) event.getSource();
                 //Scheduleeverydays s=new Scheduleeverydays();
                 //Schedule2Days s2=new Schedule2Days();
                 //Schedule3Days s3=new Schedule3Days();
                 Object s2=PackageSchedule.getSelectedItem();
                 //s3=(Schedule3Days)PackageSchedule.getSelectedItem();
                 //s=(Scheduleeverydays)PackageSchedule.getSelectedItem();
              
                 if(s2.toString().equals("Schedule2Days")){
                     TrainerPage.this.setVisible(false);
                     Schedule2day s2d=new Schedule2day();
                     //s2d.setVisible(true);
                     //F.setResizable(false);
                 // TrainerServiceRequest tsr=new TrainerServiceRequest();
                 }
                 else if(s2.toString().equals("Schedule3Days")){
                 
                 TrainerPage.this.setVisible(false);
                 Schedule3day s3d=new Schedule3day();
                // s3d.setVisible(true);
                 
                 }
                   else if(s2.toString().equals("Scheduleeverydays")){
                 
                 TrainerPage.this.setVisible(false);
                 Scheduleeverydays sall=new Scheduleeverydays();
                 sall.setVisible(true);
                 
                 }
                   else{
                   
                   TrainerPage.this.setVisible(true);
                   
                   }
                 
                
            
           }} );
           
        F.getContentPane().add(p2);
       p2.setBounds(0, 0, 600, 600);
        F.setResizable(false);
       F.setVisible(true);
        
        
                }
        
}
            /*Object selected = PackageSchedule.getSelectedItem();
             if(selected.toString().equals("PackageSchedule1"))
                //field.setText("30");
                else if(selected.toString().equals("PackageSchedule2"))
                    field.setText("40");*/

            
           
                  /*   Schedule3Days s3=new Schedule3Days();
                     s3=(Schedule3Days) PackageSchedule.getSelectedItem();
                     else if(s3.toString().equals("Schedule3Days")){
                TrainerPage.this.setVisible(false);
                //s3.setVisible(true);
                
            }
                } });
      */
        
       // F.getContentPane().add(p2);
       // p2.setBounds(0, 0, 600, 600);
        //F.setResizable(false);
      //  F.setVisible(true);

    
       // }

  

    





    

