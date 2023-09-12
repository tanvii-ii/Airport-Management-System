import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
public class Airport extends JFrame implements ActionListener{
	
	private static Scanner scan;
	private static final long serialVersionUID = 1L;
	
	Connection con;
	Statement st;
	ResultSet rs,rs2;
	
	JFrame main;
	JDialog jairplane, jpassenger, jemployee;
	JDialog jviewplane, jsearchplane, jaddplane, jdeleteplane;
	JDialog jviewpger, jsearchpger, jaddpger, jdeletepger;
	JDialog jviewemp, jsearchemp, jaddemp, jdeleteemp;
	JDialog searchemp1;
	
	JButton bairplane, bpassenger, bemployee;
	JButton bviewplane, bsearchplane, baddplane, bdeleteplane;
	JButton bviewpger, bsearchpger, baddpger, bdeletepger;
	JButton bviewemp, bsearchemp, baddemp, bdeleteemp;

	JButton addflight, addpger, addemp;
	JButton deleteflight, deletepger, deleteemp;
	JButton searchflight, searchpger, searchemp;

	JButton backf, backp, backe;
	JButton backf1, backf2, backf3, backf4;
	JButton backp1, backp2, backp3, backp4;
	JButton backe1, backe2, backe3, backe4;
	JButton viewCodes, viewPlanes, viewPlanese, viewPlanesdf, viewPger, viewEmp;
	JButton SPviewPlanes, SEviewPlanes ;
	JDialog code;

	JLabel Title, errormsg;
	JTextField name, origin, dest, dep, arriv, type, cost, maxseats;	
	JTextField pname, pdob, pgender, pairid, pphone, pseatno;
	JTextField ename, eairid, edob, egender,  epost, esal;
	JTextField deletef, deletep, deletee;
	JTextField tairname, airfrom, airto;
	JTextField pgername, pgerairid;
	JTextField empname, empairid;
	

	
	public Airport()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","SwaraL","goa010997");
			st=con.createStatement();

		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		
		//==================main frame=============================
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(null);
		
		main = new JFrame("Airport Management System");
		main.setBounds(0, 0, 700, 700);
		main.setLayout(null);
		
		Title=new JLabel("Airport Management System");
		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(240,0,500,140);
		main.add(Title);
		
		bairplane = new JButton("Airplane");
		bairplane.setBounds(250, 150, 200, 50);
		bairplane.addActionListener(this);
		main.add(bairplane);
		
		bpassenger = new JButton("Passenger");
		bpassenger.setBounds(250, 300, 200, 50);
		bpassenger.addActionListener(this);
		main.add(bpassenger);
		
		bemployee= new JButton("Employee");
		bemployee.setBounds(250, 450, 200, 50);
		bemployee.addActionListener(this);
		main.add(bemployee);
		
		main.setVisible(true);
		add(main);
		
	}
	
	public static void main(String args[]) {
		Airport a=new Airport();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try
		{
			//=====================airplane==================
			if(e.getSource()==bairplane)
			{
				jairplane= new JDialog(main,"Flight Details");
				jairplane.setBounds(0, 0, 700, 700);
				jairplane.setLayout(null);
				
				Title=new JLabel("Manage Flights");
				Title.setFont(new Font("Serif", Font.PLAIN, 20));
				Title.setBounds(300,0,500,140);
				jairplane.add(Title);
				
				bviewplane = new JButton("View Flight Details");
				bviewplane .setBounds(250, 150, 200, 50);
				bviewplane .addActionListener(this);
				jairplane.add(bviewplane );
				
				bsearchplane = new JButton("Search Flights ");
				bsearchplane.setBounds(250, 350, 200, 50);
				bsearchplane.addActionListener(this);
				jairplane.add(bsearchplane);
				
				baddplane = new JButton("Add Flight");
				baddplane.setBounds(250, 250, 200, 50);
				baddplane.addActionListener(this);
				jairplane.add(baddplane);
				
				bdeleteplane  = new JButton("Delete Flight");
				bdeleteplane.setBounds(250, 450, 200, 50);
				bdeleteplane.addActionListener(this);
				jairplane.add(bdeleteplane);
				
				backf  = new JButton("Back");
				backf.setBounds(300, 550, 100, 50);
				backf.addActionListener(this);
				jairplane.add(backf);
				
				main.setVisible(false);
				jairplane.setVisible(true);
			}
			
			if(e.getSource()==backf)
			{
				jairplane.setVisible(false);
				main.setVisible(true);			
				
			}
			//===================passenger dialog===================
			if(e.getSource()==bpassenger)
			{
				jpassenger= new JDialog(main,"Passenger Details");
				jpassenger.setBounds(0, 0, 700, 700);
				jpassenger.setLayout(null);
				
				Title=new JLabel("Manage Passengers");
				Title.setFont(new Font("Serif", Font.PLAIN, 20));
				Title.setBounds(280,0,500,140);
				jpassenger.add(Title);
				
				bviewpger = new JButton("View Passenger Details");
				bviewpger .setBounds(250, 150, 200, 50);
				bviewpger .addActionListener(this);
				jpassenger.add(bviewpger);
				
				bsearchpger = new JButton("Search Passenger Details");
				bsearchpger.setBounds(250, 350, 200, 50);
				bsearchpger.addActionListener(this);
				jpassenger.add(bsearchpger);
				
				baddpger = new JButton("Add Passenger Details");
				baddpger.setBounds(250, 250, 200, 50);
				baddpger.addActionListener(this);
				jpassenger.add(baddpger);
				
				bdeletepger  = new JButton("Delete Passenger Details");
				bdeletepger.setBounds(250, 450, 200, 50);
				bdeletepger.addActionListener(this);
				jpassenger.add(bdeletepger);
				
				backp  = new JButton("Back");
				backp.setBounds(300, 550, 100, 50);
				backp.addActionListener(this);
				jpassenger.add(backp);				
				
				main.setVisible(false);
				jpassenger.setVisible(true);
			}
			
			if(e.getSource()==backp)
			{
				jpassenger.setVisible(false);
				main.setVisible(true);			
				
			}
		
			
			//==================================employee dialog======================
			if(e.getSource()==bemployee)
			{
				jemployee= new JDialog(main,"Employee Details");
				jemployee.setBounds(0, 0, 700, 700);
				jemployee.setLayout(null);
				
				Title=new JLabel("Manage Employees");
				Title.setFont(new Font("Serif", Font.PLAIN, 20));
				Title.setBounds(280,0,500,140);
				jemployee.add(Title);
				
				bviewemp = new JButton("View Employee Details");
				bviewemp .setBounds(250, 150, 200, 50);
				bviewemp .addActionListener(this);
				jemployee.add(bviewemp);
				
				bsearchemp = new JButton("Search Employee Details");
				bsearchemp.setBounds(250, 350, 200, 50);
				bsearchemp.addActionListener(this);
				jemployee.add(bsearchemp);
				
				baddemp = new JButton("Add Employee Details");
				baddemp.setBounds(250, 250, 200, 50);
				baddemp.addActionListener(this);
				jemployee.add(baddemp);
				
				bdeleteemp  = new JButton("Delete Employee Details");
				bdeleteemp.setBounds(250, 450, 200, 50);
				bdeleteemp.addActionListener(this);
				jemployee.add(bdeleteemp);
				
				backe  = new JButton("Back");
				backe.setBounds(300, 550, 100, 50);
				backe.addActionListener(this);
				jemployee.add(backe);
				
				main.setVisible(false);
				jemployee.setVisible(true);
				
			}
			
			if(e.getSource()==backe)
			{
				jemployee.setVisible(false);
				main.setVisible(true);
			}
			
			//===================view plane==================
			if(e.getSource()==bviewplane)
			{
				jviewplane=new JDialog(main,"Flight Details");
				jviewplane.setBounds(50, 50, 1000, 600);
				jviewplane.setLayout(null);
				
				backf1= new JButton("Back");
				backf1.setBounds(450, 500, 100, 50);
				backf1.addActionListener(this);
				jviewplane.add(backf1);
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from airplane");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "No records yet!");
				}
				else
				{
					rs.previous();
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,600);
					jviewplane.add(sp);
					jairplane.setVisible(false);
					jviewplane.setVisible(true);
				}
			}
	
			if(e.getSource()==backf1)
			{
				jviewplane.setVisible(false);
				jairplane.setVisible(true);			
			}
	
			
			//=========view passenger================
			if(e.getSource()==bviewpger)
			{
				jviewpger=new JDialog(main,"Passenger Details");
				jviewpger.setBounds(50, 50, 1000, 600);
				jviewpger.setLayout(null);
				
				backp1= new JButton("Back");
				backp1.setBounds(450, 500, 100, 50);
				backp1.addActionListener(this);
				jviewpger.add(backp1);
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from passengers");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "No passengers yet!");
				}
				else
				{
					rs.previous();
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,1000,600);
				jviewpger.add(sp);
				jpassenger.setVisible(false);
				jviewpger.setVisible(true);
				}
			}
			if(e.getSource()==backp1)
			{
				jviewpger.setVisible(false);
				jpassenger.setVisible(true);			
			}
		
			
			//========view employee================
			if(e.getSource()==bviewemp)
			{
				jviewemp=new JDialog(main,"Employee Details");
				jviewemp.setBounds(50, 50, 1000, 600);
				jviewemp.setLayout(null);
				
				backe1= new JButton("Back");
				backe1.setBounds(450, 500, 100, 50);
				backe1.addActionListener(this);
				jviewemp.add(backe1);
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from employee");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "No records yet!");
				}
				else
				{
					rs.previous();
				
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,600);
					jviewemp.add(sp);
					jemployee.setVisible(false);
					jviewemp.setVisible(true);
				}
			}
			
			if(e.getSource()==backe1)
			{
				jviewemp.setVisible(false);
				jemployee.setVisible(true);			
			}
			
			//==================add flight====================
				if(e.getSource()==baddplane)
				{
					// Date CreatedDate= new Date(System.currentTimeMillis());
					JLabel jname, jorigin, jdest, jdep, jarr,jtype, jcost, jmaxseats;
									
					jaddplane=new JDialog(main,"Add Flight");
					jaddplane.setBounds(0, 0, 1000, 700);
					jaddplane.setLayout(null);
					
					jname=new JLabel("Flight Name");
					jname.setBounds(200,100,150,50);
					jname.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jname);
					
					jorigin=new JLabel("Origin");
					jorigin.setBounds(200,150,150,50);
					jorigin.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jorigin);
					
					jdest=new JLabel("Destination");
					jdest.setBounds(200,200,150,50);
					jdest.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jdest);
					
					jdep=new JLabel("Departure");
					jdep.setBounds(200,250,150,50);
					jdep.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jdep);
					
					jarr=new JLabel("Arrival");
					jarr.setBounds(200,300,150,50);
					jarr.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jarr);
					
					jtype=new JLabel("Type");
					jtype.setBounds(200,350,150,50);
					jtype.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jtype);
					
					jcost=new JLabel("Cost");
					jcost.setBounds(200,400,150,50);
					jcost.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jcost);
					
					jmaxseats=new JLabel("Number Of Seats");
					jmaxseats.setBounds(200,450,150,50);
					jmaxseats.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddplane.add(jmaxseats);
					
					name=new JTextField("");
					name.setBounds(400, 100, 250, 40);
					name.addActionListener(this);
					jaddplane.add(name);	
					
					origin=new JTextField("");
					origin.setBounds(400, 150, 250, 40);
					origin.addActionListener(this);
					jaddplane.add(origin);	
										
					dest=new JTextField("");
					dest.setBounds(400, 200, 250, 40);
					dest.addActionListener(this);
					jaddplane.add(dest);
					
					dep=new JTextField("");
					dep.setBounds(400, 250, 250, 40);
					dep.addActionListener(this);
					jaddplane.add(dep);
					
					arriv=new JTextField("");
					arriv.setBounds(400, 300, 250, 40);
					arriv.addActionListener(this);
					jaddplane.add(arriv);
					
					type=new JTextField("");
					type.setBounds(400, 350, 250, 40);
					type.addActionListener(this);
					jaddplane.add(type);
					
					cost=new JTextField("");
					cost.setBounds(400, 400, 250, 40);
					cost.addActionListener(this);
					jaddplane.add(cost);
					
					maxseats=new JTextField("");
					maxseats.setBounds(400, 450, 250, 40);
					maxseats.addActionListener(this);
					jaddplane.add(maxseats);
					
					viewCodes= new JButton("View Codes");
					viewCodes.setBounds(700, 170, 150, 50);
					viewCodes.addActionListener(this);
					jaddplane.add(viewCodes);
					
					addflight= new JButton("Add Flight");
					addflight.setBounds(450, 550, 150, 50);
					addflight.addActionListener(this);
					jaddplane.add(addflight);
					
					backf2= new JButton("Back");
					backf2.setBounds(0, 0, 150, 50);
					backf2.addActionListener(this);
					jaddplane.add(backf2);
				
					jairplane.setVisible(false);
					jaddplane.setVisible(true);
				
				}
				
				if(e.getSource()==addflight)
				{
					jviewplane=new JDialog(main,"Flight Details");
					jviewplane.setBounds(600, 50, 1000, 600);
					jviewplane.setLayout(null);
					
					 String getname= name.getText();
					 String getorg= origin.getText();
					 String getdest= dest.getText();
					 String getdep= dep.getText();
					 String getarr= arriv.getText();
					 String gettype= type.getText();
					 String getcost= cost.getText();
					 String getseats= maxseats.getText();
								 
					PreparedStatement pst=con.prepareStatement("insert into airplane values(?,?,?,?,?,?,?,?,?,?);");
					pst.setString(1,null);
					pst.setString(2,getname);
					pst.setString(3,getorg);
					pst.setString(4,getdest);
					pst.setString(5,getdep);
					pst.setString(6,getarr);
					pst.setString(7,gettype);
					pst.setString(8,getcost);
					pst.setString(9,getseats);
					pst.setInt(10,0);
					
					pst.execute();
					pst.close();
					
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from airplane");
						
						
						
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,600);
					jviewplane.add(sp);
					
					jviewplane.setVisible(true);
				}
				
				if(e.getSource()==viewCodes)
				{
					code=new JDialog(main,"City Codes");
					code.setBounds(800, 50, 500, 500);
					code.setLayout(null);
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from codes");
						
						
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,500,500);
					code.add(sp);
					//jemployee.setVisible(false);
					code.setVisible(true);
				}
				
				if(e.getSource()==backf2)
				{
					jaddplane.setVisible(false);
					jairplane.setVisible(true);
					
					if(code.isVisible())
					{
						code.setVisible(false);
						
					}				
					
					if(jviewplane.isVisible())
					{
						jviewplane.setVisible(false);
					}	
					
				}
				
				//==================add passenger====================
				if(e.getSource()==baddpger)
				{
					// Date CreatedDate= new Date(System.currentTimeMillis());
					JLabel jname, jdob, jgender, jairid, jphone,jseatno;
									
					jaddpger=new JDialog(main,"Add Passenger");
					jaddpger.setBounds(0, 0, 1000, 700);
					jaddpger.setLayout(null);
					
					jname=new JLabel("Name");
					jname.setBounds(200,100,150,50);
					jname.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jname);
					
					jdob=new JLabel("Date Of Birth");
					jdob.setBounds(200,150,150,50);
					jdob.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jdob);
					
					jgender=new JLabel("Gender");
					jgender.setBounds(200,200,150,50);
					jgender.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jgender);
					
					jairid=new JLabel("Airplane id");
					jairid.setBounds(200,250,150,50);
					jairid.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jairid);
					
					jphone=new JLabel("Phone");
					jphone.setBounds(200,300,150,50);
					jphone.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jphone);
					
					jseatno=new JLabel("Seat Number");
					jseatno.setBounds(200,350,150,50);
					jseatno.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddpger.add(jseatno);
										
					pname=new JTextField("");
					pname.setBounds(400, 100, 250, 40);
					pname.addActionListener(this);
					jaddpger.add(pname);	
					
					pdob=new JTextField("");
					pdob.setBounds(400, 150, 250, 40);
					pdob.addActionListener(this);
					jaddpger.add(pdob);	
										
					pgender=new JTextField("");
					pgender.setBounds(400, 200, 250, 40);
					pgender.addActionListener(this);
					jaddpger.add(pgender);
					
					pairid=new JTextField("");
					pairid.setBounds(400, 250, 250, 40);
					pairid.addActionListener(this);
					jaddpger.add(pairid);
					
					pphone=new JTextField("");
					pphone.setBounds(400, 300, 250, 40);
					pphone.addActionListener(this);
					jaddpger.add(pphone);
					
					pseatno=new JTextField("");
					pseatno.setBounds(400, 350, 250, 40);
					pseatno.addActionListener(this);
					jaddpger.add(pseatno);
					
					viewPlanes= new JButton("View Airplanes");
					viewPlanes.setBounds(700, 250, 150, 40);
					viewPlanes.addActionListener(this);
					jaddpger.add(viewPlanes);
					
					addpger= new JButton("Add Passenger");
					addpger.setBounds(450, 500, 150, 50);
					addpger.addActionListener(this);
					jaddpger.add(addpger);
					
					backp2= new JButton("Back");
					backp2.setBounds(0, 0, 150, 50);
					backp2.addActionListener(this);
					jaddpger.add(backp2);
				
					jpassenger.setVisible(false);
					jaddpger.setVisible(true);
				
				}
				
				if(e.getSource()==addpger)
				{
					jviewpger=new JDialog(main,"Passenger Details");
					jviewpger.setBounds(600, 50, 1000, 600);
					jviewpger.setLayout(null);
					
					 String getname= pname.getText();
					 String getdob= pdob.getText();
					 String getgender= pgender.getText();
					 String getairid= pairid.getText();
					 String getphone= pphone.getText();
					 String getseatno= pseatno.getText();
					 								 
					PreparedStatement pst=con.prepareStatement("insert into passengers values(?,?,?,?,?,?,?);");
					pst.setString(1,null);
					pst.setString(2,getname);
					pst.setString(3,getdob);
					pst.setString(4,getgender);
					pst.setString(5,getairid);
					pst.setString(6,getphone);
					pst.setString(7,getseatno);
					
					pst.execute();
					pst.close();
					boolean res=false;
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from passengers");
						//res= st.execute("select * from passengers");
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//rs.previous();
						JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
						Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
						Flights.setFillsViewportHeight(true);
						
						JScrollPane sp=new JScrollPane(Flights);
						sp.setBounds(0,0,1000,600);
						jviewpger.add(sp);
						
						jviewpger.setVisible(true);
					
					
				}
				
				if(e.getSource()==viewPlanes)
				{
					code=new JDialog(main,"Flight Details");
					code.setBounds(600, 50, 750, 500);
					code.setLayout(null);
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from airplane");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,750,500);
					code.add(sp);
					//jemployee.setVisible(false);
					code.setVisible(true);
				}
				
				if(e.getSource()==backp2)
				{
					jaddpger.setVisible(false);
					jpassenger.setVisible(true);
					
					if(code.isVisible())
					{
						code.setVisible(false);
						
					}				
					
					if(jviewpger.isVisible())
					{
						jviewpger.setVisible(false);
					}	
				
				}	
				
		//======================add employee========================		
				if(e.getSource()==baddemp)
				{
					// Date CreatedDate= new Date(System.currentTimeMillis());
					JLabel jname, jairid, jdob, jgender, jpost, jsal;
					//JTextField ename, eairid, edob, egender,  epost, esal;

									
					jaddemp=new JDialog(main,"Add Employee");
					jaddemp.setBounds(0, 0, 1000, 700);
					jaddemp.setLayout(null);
					
		
					jname=new JLabel("Name");
					jname.setBounds(200,100,150,50);
					jname.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jname);
					
					jairid=new JLabel("Airplane id");
					jairid.setBounds(200,150,150,50);
					jairid.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jairid);
										
					jdob=new JLabel("Date Of Birth");
					jdob.setBounds(200,200,150,50);
					jdob.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jdob);
					
					jgender=new JLabel("Gender");
					jgender.setBounds(200,250,150,50);
					jgender.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jgender);
					
					
					jpost=new JLabel("Post");
					jpost.setBounds(200,300,150,50);
					jpost.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jpost);
					
					jsal=new JLabel("Salary");
					jsal.setBounds(200,350,150,50);
					jsal.setFont(new Font("Serif", Font.PLAIN, 20));
					jaddemp.add(jsal);
										
					ename=new JTextField("");
					ename.setBounds(400, 100, 250, 40);
					ename.addActionListener(this);
					jaddemp.add(ename);	
					
					eairid=new JTextField("");
					eairid.setBounds(400, 150, 250, 40);
					eairid.addActionListener(this);
					jaddemp.add(eairid);
					
					edob=new JTextField("");
					edob.setBounds(400, 200, 250, 40);
					edob.addActionListener(this);
					jaddemp.add(edob);	
										
					egender=new JTextField("");
					egender.setBounds(400, 250, 250, 40);
					egender.addActionListener(this);
					jaddemp.add(egender);
										
					epost=new JTextField("");
					epost.setBounds(400, 300, 250, 40);
					epost.addActionListener(this);
					jaddemp.add(epost);
					
					esal=new JTextField("");
					esal.setBounds(400, 350, 250, 40);
					esal.addActionListener(this);
					jaddemp.add(esal);
					
					viewPlanese= new JButton("View Airplanes");
					viewPlanese.setBounds(700, 150, 150, 40);
					viewPlanese.addActionListener(this);
					jaddemp.add(viewPlanese);
					
					addemp= new JButton("Add Employee");
					addemp.setBounds(450, 500, 150, 50);
					addemp.addActionListener(this);
					jaddemp.add(addemp);
					
					backe2= new JButton("Back");
					backe2.setBounds(0, 0, 150, 50);
					backe2.addActionListener(this);
					jaddemp.add(backe2);
				
					jemployee.setVisible(false);
					jaddemp.setVisible(true);
				
				}
				
				if(e.getSource()==addemp)
				{
					jviewemp=new JDialog(main,"Employee Details");
					jviewemp.setBounds(600, 50, 1000, 600);
					jviewemp.setLayout(null);
					
					 String getname= ename.getText();
					 String getdob= edob.getText();
					 String getgender= egender.getText();
					 String getairid= eairid.getText();
					 String getpost= epost.getText();
					 String getsal= esal.getText();
					 								 
					PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?);");
					pst.setString(1,null);
					pst.setString(2,getname);
					pst.setString(4,getdob);
					pst.setString(5,getgender);
					pst.setString(3,getairid);
					pst.setString(6,getpost);
					pst.setString(7,getsal);
					
					pst.execute();
					pst.close();
					
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from employee");
								
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,600);
					jviewemp.add(sp);
					
					jviewemp.setVisible(true);
				}
				
				if(e.getSource()==viewPlanese)
				{
					code=new JDialog(main,"Flight Details");
					code.setBounds(600, 50, 750, 500);
					code.setLayout(null);
					
					try {
						st= con.createStatement();
						rs=st.executeQuery("select * from airplane");
						
						
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
					
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,750,500);
					code.add(sp);
					//jemployee.setVisible(false);
					code.setVisible(true);
				}
				
				if(e.getSource()==backe2)
				{
					jaddemp.setVisible(false);
					jemployee.setVisible(true);
					
					if(code.isVisible())
					{
						code.setVisible(false);
						
					}				
					
					if(jviewemp.isVisible())
					{
						jviewemp.setVisible(false);
					}	
				
				}	
				
			//===================delete flight===================
			if(e.getSource()==bdeleteplane)
			{
				JLabel airid;
				
				jdeleteplane=new JDialog(main,"Delete Flight");
				jdeleteplane.setBounds(0, 0, 1000, 400);
				jdeleteplane.setLayout(null);
				
				Title=new JLabel("Enter Airplane id to delete");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jdeleteplane.add(Title);
	
				airid=new JLabel("Aiplane Id");
				airid.setBounds(150,150,150,50);
				airid.setFont(new Font("Serif", Font.PLAIN, 25));
				jdeleteplane.add(airid);
				
				deletef= new JTextField("");
				deletef.setBounds(280, 150, 250, 40);
				deletef.addActionListener(this);
				jdeleteplane.add(deletef);
				
				viewPlanesdf= new JButton("View Airplanes");
				viewPlanesdf.setBounds(550, 150, 200, 40);
				viewPlanesdf.addActionListener(this);
				jdeleteplane.add(viewPlanesdf);
				
				deleteflight=new JButton("Delete");
				deleteflight.setBounds(350, 250, 100, 50);
				deleteflight.addActionListener(this);
				jdeleteplane.add(deleteflight);
				
				backf4= new JButton("Back");
				backf4.setBounds(0, 0, 100, 50);
				backf4.addActionListener(this);
				jdeleteplane.add(backf4);
								
				jairplane.setVisible(false);
				jdeleteplane.setVisible(true);
			}
			
			
			
			if(e.getSource()==viewPlanesdf)
			{
				code=new JDialog(main,"Flight Details");
				code.setBounds(600, 50, 750, 500);
				code.setLayout(null);
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from airplane");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,1000,600);
				code.add(sp);
				//jemployee.setVisible(false);
				code.setVisible(true);
			}
			
			if(e.getSource()==backf4)
			{
				jdeleteplane.setVisible(false);
				jairplane.setVisible(true);
				
				if(code.isVisible())
				{
					code.setVisible(false);
					
				}				
				
				if(jviewplane.isVisible())
				{
					jviewplane.setVisible(false);
				}	
			}
			
			if(e.getSource()==deleteflight)
			{
							
				 String getid= deletef.getText();
								 								 
				PreparedStatement pst=con.prepareStatement("delete from airplane where air_id=?;");
				pst.setString(1,getid);
				
				pst.execute();
				pst.close();
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from airplane");
					JOptionPane.showMessageDialog(main, "Record deleted...");

							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
			
			//===================delete passenger===================
			if(e.getSource()==bdeletepger)
			{
				JLabel pid;
				
				jdeletepger=new JDialog(main,"Delete Passenger");
				jdeletepger.setBounds(0, 0, 1000, 400);
				jdeletepger.setLayout(null);
				
				Title=new JLabel("Enter Passenger Id to delete");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jdeletepger.add(Title);
	
				pid=new JLabel("Passenger Id");
				pid.setBounds(140,150,150,50);
				pid.setFont(new Font("Serif", Font.PLAIN, 25));
				jdeletepger.add(pid);
				
				deletep= new JTextField("");
				deletep.setBounds(280, 150, 250, 40);
				deletep.addActionListener(this);
				jdeletepger.add(deletep);
				
				viewPger= new JButton("View Passengers");
				viewPger.setBounds(550, 150, 200, 40);
				viewPger.addActionListener(this);
				jdeletepger.add(viewPger);
				
				deletepger=new JButton("Delete");
				deletepger.setBounds(350, 250, 100, 50);
				deletepger.addActionListener(this);
				jdeletepger.add(deletepger);
				
				backp4= new JButton("Back");
				backp4.setBounds(0, 0, 100, 50);
				backp4.addActionListener(this);
				jdeletepger.add(backp4);
								
				jpassenger.setVisible(false);
				jdeletepger.setVisible(true);
			}
			
			
			
			if(e.getSource()==viewPger)
			{
				code=new JDialog(main,"Passenger Details");
				code.setBounds(600, 50, 750, 500);
				code.setLayout(null);
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from passengers");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,750,500);
				code.add(sp);
				//jemployee.setVisible(false);
				code.setVisible(true);
			}
			
			if(e.getSource()==backp4)
			{
				jdeletepger.setVisible(false);
				jpassenger.setVisible(true);
				
				if(code.isVisible())
				{
					code.setVisible(false);
					
				}				
				
				if(jviewpger.isVisible())
				{
					jviewpger.setVisible(false);
				}	
			}
			
			if(e.getSource()==deletepger)
			{				
				 String getid= deletep.getText();
				
				 								 
				PreparedStatement pst=con.prepareStatement("delete from passengers where p_id=?;");
				pst.setString(1,getid);
				
				pst.execute();
				pst.close();
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from passengers");
					JOptionPane.showMessageDialog(main, "Record deleted...");

							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			//========================delete employee================================
			
			if(e.getSource()==bdeleteemp)
			{
				JLabel eid;
				
				jdeleteemp=new JDialog(main,"Delete Employee");
				jdeleteemp.setBounds(0, 0, 1000, 400);
				jdeleteemp.setLayout(null);
				
				Title=new JLabel("Enter Passenger Id to delete");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jdeleteemp.add(Title);
	
				eid=new JLabel("Passenger Id");
				eid.setBounds(140,150,150,50);
				eid.setFont(new Font("Serif", Font.PLAIN, 25));
				jdeleteemp.add(eid);
				
				deletee= new JTextField("");
				deletee.setBounds(280, 150, 250, 40);
				deletee.addActionListener(this);
				jdeleteemp.add(deletee);
				
				viewEmp= new JButton("View Employees");
				viewEmp.setBounds(550, 150, 200, 40);
				viewEmp.addActionListener(this);
				jdeleteemp.add(viewEmp);
				
				deleteemp=new JButton("Delete");
				deleteemp.setBounds(350, 250, 100, 50);
				deleteemp.addActionListener(this);
				jdeleteemp.add(deleteemp);
				
				backe4= new JButton("Back");
				backe4.setBounds(0, 0, 100, 50);
				backe4.addActionListener(this);
				jdeleteemp.add(backe4);
								
				jemployee.setVisible(false);
				jdeleteemp.setVisible(true);
			}
			
			
			
			if(e.getSource()==viewEmp)
			{
				code=new JDialog(main,"Employee Details");
				code.setBounds(600, 50, 750, 500);
				code.setLayout(null);
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from employee");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,750,500);
				code.add(sp);
				//jemployee.setVisible(false);
				code.setVisible(true);
			}
			
			if(e.getSource()==backe4)
			{
				jdeleteemp.setVisible(false);
				jemployee.setVisible(true);
				
				if(code.isVisible())
				{
					code.setVisible(false);
					
				}				
				
				if(jviewemp.isVisible())
				{
					jviewemp.setVisible(false);
				}	
			}
			
			if(e.getSource()==deleteemp)
			{
				
				 String getid= deletee.getText();
				
				 								 
				PreparedStatement pst=con.prepareStatement("delete from employee where e_id=?;");
				pst.setString(1,getid);
				
				pst.execute();
				pst.close();
				
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from employee");
					JOptionPane.showMessageDialog(main, "Record deleted...");
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			//=================search flight===============================
			
			if(e.getSource()==bsearchplane)
			{
				JLabel airname, from, to;
				
				jsearchplane=new JDialog(main,"Search Flight");
				jsearchplane.setBounds(0, 0, 1000, 600);
				jsearchplane.setLayout(null);
				
				Title=new JLabel("Search Flight");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jsearchplane.add(Title);
	
				to=new JLabel("Destination");
				to.setBounds(140,200,150,50);
				to.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchplane.add(to);
				
				from=new JLabel("Origin");
				from.setBounds(140,150,150,50);
				from.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchplane.add(from);
				
				/*airname=new JLabel("Flight Name");
				airname.setBounds(140,150,150,50);
				airname.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchplane.add(airname);
				
				/*tairname= new JTextField("");
				tairname.setBounds(280, 150, 250, 40);
				tairname.addActionListener(this);
				jsearchplane.add(tairname);*/
				
				airfrom= new JTextField("");
				airfrom.setBounds(280, 150, 250, 40);
				airfrom.addActionListener(this);
				jsearchplane.add(airfrom);
				
				airto= new JTextField("");
				airto.setBounds(280, 200, 250, 40);
				airto.addActionListener(this);
				jsearchplane.add(airto);
				
				
				errormsg= new JLabel("");
				errormsg.setBounds(280, 400, 250, 40);
				to.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchplane.add(errormsg);
				
				
				searchflight=new JButton("Search");
				searchflight.setBounds(350, 350, 100, 50);
				searchflight.addActionListener(this);
				jsearchplane.add(searchflight);
				
				backf3= new JButton("Back");
				backf3.setBounds(0, 0, 100, 50);
				backf3.addActionListener(this);
				jsearchplane.add(backf3);
								
				jairplane.setVisible(false);
				jsearchplane.setVisible(true);
			}
		
	
			if(e.getSource()==backf3)
			{
				jsearchplane.setVisible(false);
				jairplane.setVisible(true);
				
							
				
				if(jsearchplane.isVisible())
				{
					jsearchplane.setVisible(false);
				}	
			}
			
			
			if(e.getSource()==searchflight)
			{
				jsearchplane=new JDialog(main,"Your Flight");
				jsearchplane.setBounds(600, 50, 1000, 300);
				jsearchplane.setLayout(null);
				
				 String airname= tairname.getText();
				 String from= airfrom.getText();
				 String to= airto.getText();
					
				 								 
				PreparedStatement pst=con.prepareStatement("select *from airplane where air_name=? and origin=? and destination=?; ");
				
				
				pst.setString(1,airname);
				pst.setString(2,from);
				pst.setString(3,to);
							
				
				
				try {
					rs=pst.executeQuery();
					
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "Record not found!");
				}
				else
				{
					rs.previous();
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,100));
					Flights.setFillsViewportHeight(true);
				
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,300);
					jsearchplane.add(sp);
					
					jsearchplane.setVisible(true);
				
				}
				
		}		
			
//=================SEARCH PASSENGER===============================
			
			if(e.getSource()==bsearchpger)
			{
				JLabel pname, airid;
				
				jsearchpger=new JDialog(main,"Search Passenger");
				jsearchpger.setBounds(0, 0, 1000, 600);
				jsearchpger.setLayout(null);
				
				Title=new JLabel("Search Passenger");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jsearchpger.add(Title);			
				
				airid=new JLabel("Airplane Id");
				airid.setBounds(140,200,200,50);
				airid.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchpger.add(airid);
				
				pname=new JLabel("Passenger Name");
				pname.setBounds(140,150,200,50);
				pname.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchpger.add(pname);
				
				pgername= new JTextField("");
				pgername.setBounds(350, 150, 250, 40);
				pgername.addActionListener(this);
				jsearchpger.add(pgername);
				
				pgerairid= new JTextField("");
				pgerairid.setBounds(350, 200, 250, 40);
				pgerairid.addActionListener(this);
				jsearchpger.add(pgerairid);
							
				errormsg= new JLabel("");
				errormsg.setBounds(280, 400, 250, 40);
				errormsg.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchpger.add(errormsg);
				
				SPviewPlanes= new JButton("View Airplanes");
				SPviewPlanes.setBounds(700, 200, 150, 40);
				SPviewPlanes.addActionListener(this);
				jsearchpger.add(SPviewPlanes);
				
				searchpger=new JButton("Search");
				searchpger.setBounds(350, 350, 100, 50);
				searchpger.addActionListener(this);
				jsearchpger.add(searchpger);
				
				backp3= new JButton("Back");
				backp3.setBounds(0, 0, 100, 50);
				backp3.addActionListener(this);
				jsearchpger.add(backp3);
								
				jpassenger.setVisible(false);
				jsearchpger.setVisible(true);
			}
		
			if(e.getSource()==SPviewPlanes)
			{
				code=new JDialog(main,"Flight Details");
				code.setBounds(600, 50, 750, 500);
				code.setLayout(null);
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from airplane");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,750,500);
				code.add(sp);
				//jemployee.setVisible(false);
				code.setVisible(true);
			}
			
			if(e.getSource()==backp3)
			{
				jsearchpger.setVisible(false);
				jpassenger.setVisible(true);
				
							
				if(jsearchpger.isVisible())
				{
					jsearchpger.setVisible(false);
				}	
				if(code.isVisible())
				{
					code.setVisible(false);
				}	
			}
			
			
			if(e.getSource()==searchpger)
			{
				jsearchpger=new JDialog(main,"Passenger Details");
				jsearchpger.setBounds(600, 50, 1000, 300);
				jsearchpger.setLayout(null);
				
				 			
				 								 
				PreparedStatement pst=con.prepareStatement("select *from passengers where p_name=? and air_id=?; ");
				
				
				pst.setString(1,pgername.getText());
				pst.setString(2,pgerairid.getText());

				
				try {
					rs=pst.executeQuery();
					
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "Record not found!");
				}
				else
				{
					rs.previous();
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
			
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,1000,600);
				jsearchpger.add(sp);
				
				jsearchpger.setVisible(true);	
				}
		}		

//=================SEARCH EMPLOYEE===============================
			
			if(e.getSource()==bsearchemp)
			{
				JLabel pname, airid;
				
				jsearchemp=new JDialog(main,"Search Employee");
				jsearchemp.setBounds(0, 0, 1000, 600);
				jsearchemp.setLayout(null);
				
				Title=new JLabel("Search Employee");
				Title.setFont(new Font("Serif", Font.PLAIN, 30));
				Title.setBounds(200,0,500,140);
				jsearchemp.add(Title);			
				
				airid=new JLabel("Airplane Id");
				airid.setBounds(140,200,200,50);
				airid.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchemp.add(airid);
				
				pname=new JLabel("Employee Name");
				pname.setBounds(140,150,200,50);
				pname.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchemp.add(pname);
				
				empname= new JTextField("");
				empname.setBounds(350, 150, 250, 40);
				empname.addActionListener(this);
				jsearchemp.add(empname);
				
				empairid= new JTextField("");
				empairid.setBounds(350, 200, 250, 40);
				empairid.addActionListener(this);
				jsearchemp.add(empairid);
							
				/*errormsg= new JLabel("");
				errormsg.setBounds(280, 400, 250, 40);
				errormsg.setFont(new Font("Serif", Font.PLAIN, 25));
				jsearchemp.add(errormsg);*/
				
				SEviewPlanes= new JButton("View Airplanes");
				SEviewPlanes.setBounds(700, 200, 150, 40);
				SEviewPlanes.addActionListener(this);
				jsearchemp.add(SEviewPlanes);
				
				searchemp=new JButton("Search");
				searchemp.setBounds(350, 350, 100, 50);
				searchemp.addActionListener(this);
				jsearchemp.add(searchemp);
				
				backe3= new JButton("Back");
				backe3.setBounds(0, 0, 100, 50);
				backe3.addActionListener(this);
				jsearchemp.add(backe3);
								
				jemployee.setVisible(false);
				jsearchemp.setVisible(true);
			}
		
			if(e.getSource()==SEviewPlanes)
			{
				code=new JDialog(main,"Flight Details");
				code.setBounds(600, 50, 750, 500);
				code.setLayout(null);
				
				try {
					st= con.createStatement();
					rs=st.executeQuery("select * from airplane");
					
					
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
				Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
				Flights.setFillsViewportHeight(true);
				
				JScrollPane sp=new JScrollPane(Flights);
				sp.setBounds(0,0,750,500);
				code.add(sp);
				//jemployee.setVisible(false);
				code.setVisible(true);
			}
			
			if(e.getSource()==backe3)
			{
				jsearchemp.setVisible(false);
				jemployee.setVisible(true);
				
							
				if(jsearchemp.isVisible())
				{
					jsearchemp.setVisible(false);
				}	
				if(code.isVisible())
				{
					code.setVisible(false);
				}	
			}
			
			
			if(e.getSource()==searchemp)
			{
				jsearchemp=new JDialog(main,"Passenger Details");
				jsearchemp.setBounds(600, 50, 1000, 300);
				jsearchemp.setLayout(null);
				
				 			
				 								 
				PreparedStatement pst=con.prepareStatement("select * from employee where e_name=? and air_id=?; ");
				
				
				pst.setString(1,empname.getText());
				pst.setString(2,empairid.getText());

				
				try {
					rs=null;
					rs=pst.executeQuery();
					
								
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(main, "Record not found!");
				}
				else
				{
					rs.previous();
					JTable Flights = new JTable(DbUtils.resultSetToTableModel(rs));
					Flights.setPreferredScrollableViewportSize(new Dimension(500,50));
					Flights.setFillsViewportHeight(true);
						
					JScrollPane sp=new JScrollPane(Flights);
					sp.setBounds(0,0,1000,600);
					jsearchemp.add(sp);
					
					jsearchemp.setVisible(true);
				}
											
		}	

		///////////////////////////////////////////////////////////////////		
		}catch(SQLException exc)
		{
			exc.printStackTrace();
		

		}	
				
	}
}


