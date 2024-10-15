package presentacion;

import java.io.IOException;
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

        // Recuperar los datos del formulario con validaciones para valores vacíos
        String descripcion = request.getParameter("descripcion");
        descripcion = (descripcion == null || descripcion.trim().isEmpty()) ? "Sin descripción" : descripcion;

        String tipoSeguro = request.getParameter("tipo-seguro");
        tipoSeguro = (tipoSeguro == null || tipoSeguro.trim().isEmpty()) ? "sin tipo" : tipoSeguro;

        String costoContratacionParam = request.getParameter("costo-contratacion");
        float costoContratacion = (costoContratacionParam == null || costoContratacionParam.trim().isEmpty()) 
            ? 0.0f : Float.parseFloat(costoContratacionParam);

        String costoMaximoParam = request.getParameter("costo-maximo");
        float costoMaximo = (costoMaximoParam == null || costoMaximoParam.trim().isEmpty()) 
            ? 0.0f : Float.parseFloat(costoMaximoParam);

        // Crear un objeto JSON manualmente
        String jsonResponse = "{"
                + "\"descripcion\": \"" + descripcion + "\","
                + "\"tipoSeguro\": \"" + tipoSeguro + "\","
                + "\"costoContratacion\": " + costoContratacion + ","
                + "\"costoMaximo\": " + costoMaximo
                + "}";

        // Devolver la respuesta en formato JSON
        response.getWriter().append(jsonResponse);
    }

}
