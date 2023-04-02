package student;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	@WebServlet("/log")
		public class Login extends HttpServlet {
		Connection con;
		
		@Override
		public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fcc?user=root&password=sql@123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetch the data from html
		String adhar=req.getParameter("adharno");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(adhar);
		System.out.println(username);
		System.out.println(password);
		
		//parsing
		int adharno=Integer.parseInt(adhar);
					
		PreparedStatement pstmt = null;
		
		String query="insert into login_info values(?,?,?)";
		
		try{
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, adharno);
			pstmt.setString(2,username);
			pstmt.setString(3, password);
	
			
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+"LOGIN SUCCESSFULL</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	

}
