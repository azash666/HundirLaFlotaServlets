package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Partida;

/**
 * Servlet implementation class SolucionPartidaServlet
 */
@WebServlet("/SolucionPartidaServlet")
public class SolucionPartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolucionPartidaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Partida partida = (Partida)session.getAttribute("Partida");
		session.removeAttribute("Partida");
		

		request.setAttribute("Partida", partida);
		request.setAttribute("filas", HundirFlotaServlet.NUMFILAS);
		request.setAttribute("columnas", HundirFlotaServlet.NUMCOLUMNAS);
		request.setAttribute("barcos", HundirFlotaServlet.NUMBARCOS);
		
		RequestDispatcher vista = request.getRequestDispatcher("TableroSolucion.jsp");
		vista.forward(request, response);
	}

}
