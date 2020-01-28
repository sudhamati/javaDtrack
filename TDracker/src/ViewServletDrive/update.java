package ViewServletDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import CreateDriveData.CreateDrive;
import DBconnectiom.DatabaseCon;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hi i am post");
		BufferedReader br = request.getReader();
		String s = br.readLine();
		System.out.println("angular data "+s);
		ObjectMapper mp=new ObjectMapper();
		CreateDrive rp=mp.readValue(s,CreateDrive.class );
		System.out.println("Java Object="+rp);
		
			
			Connection con;
			try {
				con = DatabaseCon.getDBConnection();
				PreparedStatement ps = con.prepareStatement("update drive  set  COMPANY_NAME=?, NO_OF_RSRES=?, EXP_REQ=?, CTC=?, JOINT_CRT=?, BOND=?, POSITION=?, FOLLOW_UP_DATE=?, EDU_CRT=? WHERE DID=?");
				ps.setObject(1, rp.getCompanyName());
			    ps.setObject(2, rp.getResources());
				ps.setObject(3, rp.getExprequired());
	     		ps.setObject(4, rp.getCtc());
				ps.setObject(5, rp.getJoiningcriteria());
				ps.setObject(6, rp.getBond());
				ps.setObject(7, rp.getPosition());
				ps.setObject(8, rp.getFollow());
	     		ps.setObject(9, rp.getEducriteria());
	     		ps.setObject(10,rp.getId());
	     		
				int status = ps.executeUpdate();

				Map<String, String> m = new HashMap<>();

				if (status == 1) 
				{
					m.put("Data", "succesfully updated");
				} 
				else 
				{
					m.put("Data", "error");
				}
				System.out.println("map object=" + m);
				
				String jsonstr=mp.writeValueAsString(m);
				
				System.out.println("json string="+jsonstr);
				
				PrintWriter pw=response.getWriter();
				
				pw.write(jsonstr);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 
			}

	
		
	}

}
