package apj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Przelicznik
 */
@WebServlet(description = "Przelicznik temperatur Fahrenheit/Celsjusz", urlPatterns = { "/Przelicznik" })
public class Przelicznik extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double value1=Double.parseDouble(request.getParameter("value1"));
		String oper=request.getParameter("oper");
		double wynik=przelicz(value1,oper);
		request.setAttribute("result",new Double(wynik));
		request.setAttribute("wybor",new String(oper));
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("res.jsp");
		requestDispatcher.forward(request,response);
	}
	public double przelicz(double x, String oper) {
		double wynik = 0;
		if (oper.equalsIgnoreCase("CF")){
			return wynik =(x*9/5)+32;
		}
		if (oper.equalsIgnoreCase("FC")){
			return wynik = (x-32)*5/9;
		} 
		return 0;
	}
}
