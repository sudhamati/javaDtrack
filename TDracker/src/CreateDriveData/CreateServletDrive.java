package CreateDriveData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import DBconnectiom.DatabaseCon;

@WebServlet("/Cd")
public class CreateServletDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In doPost ");
		
	BufferedReader br= request.getReader();
		String s=br.readLine();
		
		System.out.println("In angular"+s);
		System.out.println("*******");
		
		ObjectMapper mp=new ObjectMapper();
		CreateDrive rp=mp.readValue(s,CreateDrive.class );
		System.out.println("Java Object="+rp);
		
		

	
				try {
				
			Connection con= DatabaseCon.getDBConnection();
			 
			PreparedStatement ps= con.prepareStatement("insert into drive(COMPANY_NAME, NO_OF_RSRES, EXP_REQ, CTC, JOINT_CRT, BOND, POSITION, FOLLOW_UP_DATE, EDU_CRT ) values(?,?,?,?,?,?,?,?,?)");
        System.out.println(con);
       /*PreparedStatement ps=con.prepareStatement("select * from drive");
       System.out.println("hello");
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
        	 System.out.println("hii");
        	 System.out.println(rs.getInt(1)+" "+rs.getString(2));
         }*/
         
       //  PreparedStatement ps = con.prepareStatement("insert into drive(COMPANY_NAME,NO_OF_RSRES)values(?,?)");
         
         
			ps.setObject(1, rp.getCompanyName());
		    ps.setObject(2, rp.getResources());
			ps.setObject(3, rp.getExprequired());
     		ps.setObject(4, rp.getCtc());
			ps.setObject(5, rp.getJoiningcriteria());
			ps.setObject(6, rp.getBond());
			ps.setObject(7, rp.getPosition());
			ps.setObject(8, rp.getFollow());
     		ps.setObject(9, rp.getEducriteria());
		
			

			int status = ps.executeUpdate();
            System.out.println(status);
			Map<String, String> m = new HashMap<>();

			if (status == 1) 
			{
				m.put("msg", "succesfully register");
			} 
			else 
			{
				m.put("msg", "error");
			}
			System.out.println("map object=" + m);
			
			String jsonstr=mp.writeValueAsString(m);
			
			System.out.println("json string="+jsonstr);
			
		PrintWriter pw=response.getWriter();
			
			pw.write(jsonstr);
			System.out.println(jsonstr);
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
