package ViewServletDrive;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import CreateDriveData.CreateDrive;
import CreateDriveData.UtilityJson;
import DBconnectiom.DatabaseCon;


@WebServlet("/ViewDriveServlet")
public class ViewDriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("In doGet ");
		
		
			try {
			Connection con= DatabaseCon.getDBConnection();
		  PreparedStatement ps=con.prepareStatement("select * from drive");
	       
	         ResultSet rs=ps.executeQuery();
	         ArrayList<CreateDrive> al=new ArrayList<>();
	         
	         while(rs.next())
	         {
	        	  CreateDrive c=new CreateDrive();
	        	  c.setId(rs.getInt(1));
	        	  c.setCompanyName(rs.getString(2));
	        	  c.setResources(rs.getInt(3));
	        	  c.setExprequired(rs.getInt(4));
	        	  c.setCtc(rs.getFloat(5));
	        	  c.setJoiningcriteria(rs.getInt(6));
	        	  c.setBond(rs.getFloat(7));
	        	  c.setPosition(rs.getInt(8));
	        	  c.setFollow(rs.getString(9));
	        	  c.setEducriteria(rs.getInt(10));
	        	  
	        	  System.out.println(c);
	        	  
	        	 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getFloat(5)+
	        			 " "+rs.getInt(6)+rs.getFloat(7)+rs.getInt(8)+rs.getString(9)+" "+rs.getInt(10));
	        	 
	             al.add(c);
	             
	         }
	         
             String s=UtilityJson.getJSONFromObject(al);
             System.out.println(s);
             
             PrintWriter pw=response.getWriter();
             
             pw.write(s);
             
             pw.flush();
	       
	
			}
			catch (ClassNotFoundException | SQLException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


}
