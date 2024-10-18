package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import negocioImpl.SeguroNegocioImpl;

/**
 * Servlet implementation class ServletListarSeguros
 */
@WebServlet("/ServletListarSeguros")
public class ServletListarSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Seguro> seguroLista;
	private SeguroNegocioImpl seguroNegocioTemp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarSeguros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		seguroNegocioTemp = new SeguroNegocioImpl();
		seguroLista = new ArrayList<Seguro>();
		seguroLista = seguroNegocioTemp.readAll();
		if(request.getParameter("tipo-seguro").equals("hogar")) {
		    Iterator<Seguro> iterator = seguroLista.iterator();
		    while (iterator.hasNext()) {
		        Seguro seguro = iterator.next();
		        if (seguro.getTipoSeguro().getId() != 1) {
		            iterator.remove();
		        }
		    }
		}else if (request.getParameter("tipo-seguro").equals("moto")) {
	        Iterator<Seguro> iterator = seguroLista.iterator();
	        while (iterator.hasNext()) {
	            Seguro seguro = iterator.next();
	            if (seguro.getTipoSeguro().getId() != 2) {
	                iterator.remove();
	            }
	        }
	    } else if (request.getParameter("tipo-seguro").equals("vida")) {
	        Iterator<Seguro> iterator = seguroLista.iterator();
	        while (iterator.hasNext()) {
	            Seguro seguro = iterator.next();
	            if (seguro.getTipoSeguro().getId() != 3) {
	                iterator.remove();
	            }
	        }
	    }
		
		request.setAttribute("seguroLista", seguroLista);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
