package servletpractice9;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registration")
public class jdbcservlet extends HttpServlet 
{
	@Override
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{

		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("phonenumber");
		String yop=req.getParameter("yop");
		String degree=req.getParameter("degree");
		String stream=req.getParameter("stream");
		String password=req.getParameter("passout");
		int id1=Integer.parseInt(id);
		long phonenumber1=Long.parseLong(phonenumber);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspider","root","Divya@123");
			PreparedStatement ps=con.prepareStatement("insert into student(id,name,phonenumber,yop,degree,stream,passout) values(?,?,?,?,?,?,?)");

			ps.setInt(1, id1);
			ps.setString(2, name);
			ps.setLong(3, phonenumber1);
			ps.setString(4, yop);
			ps.setString(5, degree);
			ps.setString(6, stream);
			ps.setString(7, password);
			ps.execute();
			
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
