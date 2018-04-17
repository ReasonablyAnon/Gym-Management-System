
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Enumeration;
import com.sun.glass.events.MouseEvent;

public class homepage 
{
	static JFrame mainbox;
	static ButtonGroup bg;
	static int disy = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(500,500);
		
		JLabel banner = new JLabel("Khokhar GymKhana");
		banner.setFont(new Font("JokerMan",3,25));
		banner.setVisible( true );
		banner.setBounds(100,7,280,50);
		
		JRadioButton op1 =new JRadioButton("Display All Customer Names - (SIMPLE) ");    
		JRadioButton op2 =new JRadioButton("Display All Customer Names Who Live In Rohini - (SIMPLE)"); 
		JRadioButton op3 =new JRadioButton("Query 3 - (SIMPLE)");
		JRadioButton op4 =new JRadioButton("Query 4 - (SIMPLE)");
		JRadioButton op5 =new JRadioButton("Query 5 - (SIMPLE)");
		JRadioButton op6 =new JRadioButton("Query 6 - (SIMPLE)");
		JRadioButton op7 =new JRadioButton("Query 7 - (SIMPLE)");
		JRadioButton op8 =new JRadioButton("Query 8 - (SIMPLE)");
		JRadioButton op9 =new JRadioButton("Query 9 - (SIMPLE)");
		JRadioButton op10 =new JRadioButton("Query 10 - (SIMPLE)");
		JRadioButton op11 =new JRadioButton("Query 11 - (SIMPLE)");
		JRadioButton op12 =new JRadioButton("Query 12 - (SIMPLE)");
		op1.setBounds(75,50,400,30);    
		op2.setBounds(75,80,400,30);
		op3.setBounds(75,110,400,30);
		op4.setBounds(75,140,400,30);
		op5.setBounds(75,170,400,30);
		op6.setBounds(75,200,400,30);
		op7.setBounds(75,230,400,30);
		op8.setBounds(75,260,400,30);
		op9.setBounds(75,290,400,30);
		op10.setBounds(75,320,400,30);
		op11.setBounds(75,350,400,30);
		op12.setBounds(75,380,400,30);
		
		bg = new ButtonGroup();    
		bg.add(op1);bg.add(op3);bg.add(op5);
		bg.add(op2);bg.add(op4);bg.add(op6); 
		bg.add(op7);bg.add(op9);bg.add(op11);
		bg.add(op8);bg.add(op10);bg.add(op12);
		
		JButton button = new JButton("Select");
		button.setBounds(45,410,200,30);
		
		mainbox.add(banner);
		mainbox.add(op1);mainbox.add(op3);mainbox.add(op5);
		mainbox.add(op2);mainbox.add(op4);mainbox.add(op6); 
		mainbox.add(op7);mainbox.add(op9);mainbox.add(op11);
		mainbox.add(op8);mainbox.add(op10);mainbox.add(op12);
		mainbox.add(button);
		mainbox.setLayout(null);
		mainbox.setVisible(true);
		
	    button.addActionListener(new ActionListener() 
	    {
	        @Override 
	        public void actionPerformed(ActionEvent arg0) 
	        {
	          ButtonModel buttonModel = bg.getSelection();
	          if (buttonModel == null) {
	            System.out.println("No radio button is selected");
	          }
	          else
	          {
	        	for (Enumeration buttons = bg.getElements(); buttons.hasMoreElements();) 
	      		{
	      	        AbstractButton button = (AbstractButton) buttons.nextElement();
	      	        if (button.isSelected()) 
	      	        {
	      	            System.out.println(button.getText());
	      	            disy = button.getY();
	      	            if ( disy == 50 )
	      	            {
	      	            	query1 q1 = new query1();
	      	            	q1.create();
	      	            }
	      	            else if ( disy == 80 )
	      	            {
	      	            	query2 q2 = new query2();
	      	            	q2.create();
	      	            }
	      	            else if ( disy == 110 )
	      	            {
	      	            	query3 q3 = new query3();
	      	            	q3.create();
	      	            }
	      	            else if ( disy == 140 )
	      	            {
	      	            	query4 q4 = new query4();
	      	            	q4.create();
	      	            }
	      	            else if ( disy == 170 )
	      	            {
	      	            	query5 q5 = new query5();
	      	            	q5.create();
	      	            }
	      	            else if ( disy == 200 )
	      	            {
	      	            	query6 q6 = new query6();
	      	            	q6.create();
	      	            }
	      	            else if ( disy == 230 )
	      	            {
	      				
	      	            }
	      	            else if ( disy == 260 )
	      	            {
	      				
	      	            }
	      	            else if ( disy == 290 )
	      	            {
	      				
	      	            }	
	      	            else if ( disy == 320 )
	      	            {
	      				
	      	            }
	      	            else if ( disy == 350 )
	      	            {
	      				
	      	            }
	      	            else if ( disy == 380 )
	      	            {
	      				
	      	            }
	      	            break;
	      	        }
	      	    }
	          }
	        }
	    });
	}
			    
	public static void main( String[] args )
	{
		create();
	}
}
