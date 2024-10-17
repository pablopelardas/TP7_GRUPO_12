package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ISeguroDao;
import dominio.Seguro;

public class SeguroDaoImpl implements ISeguroDao {
	private static final String insert = "INSERT INTO seguros(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM seguros WHERE idSeguro = ?";
	private static final String readall = "SELECT * FROM seguros";
	private static final String siguiente = "SELECT MAX(idSeguro) FROM seguros";
		
	public boolean insert(Seguro seguro)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getIdTipo());
			statement.setFloat(4, seguro.getCostoContratacion());
			statement.setFloat(5, seguro.getCostoMAsegurado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(Seguro seguro)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(seguro.getIdSeguro()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public ArrayList<Seguro> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return seguros;
	}
	
	private Seguro getSeguro(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int idTipo = resultSet.getInt("idTipo");
		float costoContratacion = resultSet.getFloat("costoContratacion");
		float costoAsegurado = resultSet.getFloat("costoAsegurado");
		return new Seguro(descripcion, idTipo, costoContratacion, costoAsegurado);
	}
	
    public int calcularSiguienteId() {
        int ultimoId = 0;
        Connection conexion = Conexion.getConexion().getSQLConexion();
        try {
        	PreparedStatement statement = conexion.prepareStatement(siguiente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ultimoId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ultimoId + 1;
    }
}
