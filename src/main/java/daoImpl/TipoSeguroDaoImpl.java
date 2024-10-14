package daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.TipoSeguroDao;
import dominio.TipoSeguro;

public class TipoSeguroDaoImpl implements TipoSeguroDao {

	private Conexion conn =  null;
	
	@Override
	public TipoSeguro getTipoSeguroPorId(int id){
		String query = "SELECT idTipo, descripcion FROM tiposeguros WHERE idTipo = " + id;
		TipoSeguro ts = null;
		try {
			Conexion conn = Conexion.getConexion();
			Statement st = conn.getSQLConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				ts = new TipoSeguro();
				ts.setId(rs.getInt("idTipo"));
				ts.setDescripcion(rs.getString("descripcion"));				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return ts;
	}

	@Override
	public ArrayList<TipoSeguro> getTipoSeguro() {
		TipoSeguro ts = null;
		String query = "SELECT idTipo, descripcion FROM tiposeguros";
		ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
		try {
			conn = Conexion.getConexion();
			Statement st = conn.getSQLConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				ts = new TipoSeguro();
				ts.setId(rs.getInt("idTipo"));
				ts.setDescripcion(rs.getString("descripcion"));	
				listaTipos.add(ts);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return listaTipos;
	}

}
