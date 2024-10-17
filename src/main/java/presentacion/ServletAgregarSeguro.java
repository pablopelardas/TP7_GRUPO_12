package presentacion;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.TipoSeguro;
import negocioImpl.SeguroNegocioImpl;
import negocioImpl.TipoSeguroNegocioImpl;

/**
 * Servlet implementation class servletAgregarUsuario
 */
@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletAgregarSeguro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configurar el tipo de contenido de la respuesta a JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        SeguroNegocioImpl seguroNegocioImpl = new SeguroNegocioImpl();
        

        
        // Recuperar los datos del formulario con validaciones para valores vacíos
        int nuevoId = seguroNegocioImpl.calcularSiguienteId();
        String descripcion = request.getParameter("descripcion");
        descripcion = (descripcion == null || descripcion.trim().isEmpty()) ? "Sin descripción" : descripcion;

        String tipoSeguroParam = request.getParameter("tipo-seguro");
        int tipoSeguro = (int) (tipoSeguroParam == null || tipoSeguroParam.trim().isEmpty() 
        ? 0.0f : Integer.parseInt(tipoSeguroParam));


        String costoContratacionParam = request.getParameter("costo-contratacion");
        float costoContratacion = (costoContratacionParam == null || costoContratacionParam.trim().isEmpty()) 
            ? 0.0f : Float.parseFloat(costoContratacionParam);

        String costoMaximoParam = request.getParameter("costo-maximo");
        float costoMaximo = (costoMaximoParam == null || costoMaximoParam.trim().isEmpty()) 
            ? 0.0f : Float.parseFloat(costoMaximoParam);

        Seguro seguro = new Seguro(nuevoId, descripcion, tipoSeguro, costoContratacion, costoMaximo);
        
        seguroNegocioImpl.insert(seguro);
        
        nuevoId = seguroNegocioImpl.calcularSiguienteId();
        request.setAttribute("nuevoId", nuevoId);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
        rd.forward(request, response);  
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeguroNegocioImpl seguroNegocioImpl = new SeguroNegocioImpl();
        TipoSeguroNegocioImpl tipoSeguroNegocioImpl = new TipoSeguroNegocioImpl();
        
        int nuevoId = seguroNegocioImpl.calcularSiguienteId();
        List<TipoSeguro> tiposSeguros = tipoSeguroNegocioImpl.readAll();
        
        // Verificar si la lista es nula o vacía
        if (tiposSeguros == null) {
            tiposSeguros = new ArrayList<>();
        }
        
        request.setAttribute("nuevoId", nuevoId);
        request.setAttribute("tiposSeguros", tiposSeguros);
        request.getRequestDispatcher("/AgregarSeguro.jsp").forward(request, response);
    }

}
