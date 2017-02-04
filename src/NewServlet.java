import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		final String ad = request.getParameter("ad");
		final String soyad = request.getParameter("soyad");
		final PrintWriter pw = response.getWriter();
		pw.println("<html><head><body>");
		pw.println("Name : "+ad+"<br>");
		pw.println("Surname : "+soyad+"<br>");

		pw.println("</body></head></html>");
		pw.close();
		
		PersonCRUD personTableObject = new PersonCRUD();
		personTableObject.Access();
		
	    try {
	    	personTableObject.AddInfo(ad,soyad);
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		
		
		try {
			personTableObject.DeleteInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			personTableObject.UpdateInfo("burak","gor");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			personTableObject.CloseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
