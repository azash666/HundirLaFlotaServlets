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
 * Servlet implementation class HundirFlotaServlet
 */
@WebServlet("/HundirFlotaServlet")
public class HundirFlotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMFILAS=8, NUMCOLUMNAS=8, NUMBARCOS=6;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HundirFlotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Partida partida = (Partida)session.getAttribute("Partida");
		int fila, columna;
		
		if(null == partida) {
			partida = new Partida(NUMFILAS, NUMCOLUMNAS, NUMBARCOS);
			request.setAttribute("nueva", true);
		}else {
			String[] casilla = request.getParameter("tablero").split("#");
			fila = Integer.parseInt(casilla[0]);
			columna = Integer.parseInt(casilla[1]);
			
			int devolver = partida.pruebaCasilla(fila, columna);

			request.setAttribute("nueva", false);
			request.setAttribute("fila", fila);
			request.setAttribute("columna", columna);
		}
		session.setAttribute("Partida", partida);

		request.setAttribute("Partida", partida);
		request.setAttribute("filas", NUMFILAS);
		request.setAttribute("columnas", NUMCOLUMNAS);
		request.setAttribute("barcos", NUMBARCOS);

		
		RequestDispatcher vista = request.getRequestDispatcher("TableroActual.jsp");
		vista.forward(request, response);
	}

}
