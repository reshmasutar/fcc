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

	@WebServlet("/registerlink")

	public class RegisterStudent extends HttpServlet {
		
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
		String name=req.getParameter("studentname");
		String class1=req.getParameter("class");
		String medium=req.getParameter("medium");
		String school=req.getParameter("schoolname");
		String subject1=req.getParameter("subject1");
		String subject2=req.getParameter("subject2");
		String subject3=req.getParameter("subject3");
		String subject4=req.getParameter("subject4");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String contact=req.getParameter("contact");
		String email=req.getParameter("email");
		String father=req.getParameter("father");
		String mother=req.getParameter("mother");
		String guardian=req.getParameter("guardian");		
		String address=req.getParameter("address");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		
		
		//parsing
		int adharNo=Integer.parseInt(adhar);
		int class2=Integer.parseInt(class1);
				
		PreparedStatement pstmt = null;
		
		String query="insert into registration_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
				pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, adharNo);	
			pstmt.setString(2, name);
			pstmt.setInt(3, class2);
			pstmt.setString(4, medium);
			pstmt.setString(5, school);
			pstmt.setString(6, subject1);
			pstmt.setString(7, subject2);
			pstmt.setString(8, subject3);
			pstmt.setString(9, subject4);
			pstmt.setString(10, dob);
			pstmt.setString(11, gender);
			pstmt.setString(12, contact);
			pstmt.setString(13, email);
			pstmt.setString(14, father);
			pstmt.setString(15, mother);
			pstmt.setString(16, guardian);
			pstmt.setString(17, address);
			pstmt.setString(18, username);
			pstmt.setString(19, password);
			
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+"REGISTRATION SUCCESSFULL</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
	}


