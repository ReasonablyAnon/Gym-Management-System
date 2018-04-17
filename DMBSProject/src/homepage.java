
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
		mainbox.setSize(720,500);
		
		JLabel banner = new JLabel("Khokhar GymKhana");
		banner.setFont(new Font("JokerMan",3,25));
		banner.setVisible( true );
		banner.setBounds(100,7,280,50);
		
		JRadioButton op1 =new JRadioButton("Display All Customer Info - (SIMPLE) ");    
		JRadioButton op2 =new JRadioButton("Display All Customer Info. Who Live In Rohini - (SIMPLE) "); 
		JRadioButton op3 =new JRadioButton("Display All Staff Info - (SIMPLE) ");
		JRadioButton op4 =new JRadioButton("Staff Name with Salary > 20000 && Work Hours > 3 hours/week - (SIMPLE) ");
		JRadioButton op5 =new JRadioButton("Display Brand Name where total products >= 3 - (SIMPLE) ");
		JRadioButton op6 =new JRadioButton("Display Customer Names whose Membership Plan is 'VIP' - (COMPLEX) ");
		JRadioButton op7 =new JRadioButton("Display Customer Names whose Trainer's Salary > 4000 - (COMPLEX) ");
		JRadioButton op8 =new JRadioButton("Display Brand Names with average prices of their equipment - (COMPLEX) ");
		JRadioButton op9 =new JRadioButton("Display Staff IDs with average age of their customers - (COMPLEX) ");
		JRadioButton op10 =new JRadioButton("Display Equipment Names whose Weights > 30 and Color = 'RED' - (SIMPLE) ");
		JRadioButton op11 =new JRadioButton("Display Customer IDs whose Membership Plan is 'Regular' with Duration Left(in months) - (SIMPLE) ");
		JRadioButton op12 =new JRadioButton("Display Brand Names whose equipment's color = 'RED' and has total products > 3 - (COMPLEX) ");
		op1.setBounds(25,50,400,30);    
		op2.setBounds(25,80,400,30);
		op3.setBounds(25,110,400,30);
		op4.setBounds(25,140,600,30);
		op5.setBounds(25,170,530,30);
		op6.setBounds(25,200,550,30);
		op7.setBounds(25,230,550,30);
		op8.setBounds(25,260,550,30);
		op9.setBounds(25,290,530,30);
		op10.setBounds(25,320,570,30);
		op11.setBounds(25,350,610,30);
		op12.setBounds(25,380,590,30);
		
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
	      	            	query7 q7 = new query7();
	      	            	q7.create();
	      	            }
	      	            else if ( disy == 260 )
	      	            {
	      	            	query8 q8 = new query8();
	      	            	q8.create();
	      	            }
	      	            else if ( disy == 290 )
	      	            {
	      	            	query9 q9 = new query9();
	      	            	q9.create();
	      	            }	
	      	            else if ( disy == 320 )
	      	            {
	      	            	query10 q10 = new query10();
	      	            	q10.create();
	      	            }
	      	            else if ( disy == 350 )
	      	            {
	      	            	query11 q11 = new query11();
	      	            	q11.create();
	      	            }
	      	            else if ( disy == 380 )
	      	            {
	      	            	query12 q12 = new query12();
	      	            	q12.create();
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
