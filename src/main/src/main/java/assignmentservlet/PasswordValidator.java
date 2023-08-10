package assignmentservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PasswordValidator
 */
public class PasswordValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Password Validation</h2>");
        out.println("<form method='post' action='PasswordValidator'>");
        out.println("Enter password: <input type='password' name='p1'><br>");
        out.println("<input type='submit' value='Validate'>");
        out.println("</form>");
        out.println("</body></html>");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String p=request.getParameter("p1");
		String filepath="/home/sowmyab/eclipse-workspace/assignmentservlet/src/main/java/notallowed.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line;
		boolean b=true;
		while((line=reader.readLine())!=null) {
			if(line.equals(p)) {
				b=true;
				break;
			}
			else {
				b=false;
			}
		}
		if(b) {
			out.println("not allowed");
			
		}
		else {
			out.println("allowed");
		}
		 
	}

}
