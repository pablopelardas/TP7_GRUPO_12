package negocioImpl;

import java.util.ArrayList;

import dao.ISeguroDao;
import daoImpl.SeguroDaoImpl;
import dominio.Seguro;
import negocio.ISeguroNegocio;

public class SeguroNegocioImpl implements ISeguroNegocio{


	ISeguroDao sdao = new SeguroDaoImpl();
	
	@Override
	public boolean insert(Seguro seguro) {
		
		boolean estado=false;
		if(seguro.getDescripcion().trim().length()>0 && seguro.getDescripcion().trim().length()>0 && seguro.getIdTipo() != 0 && seguro.getCostoContratacion() != 0 && seguro.getCostoMAsegurado() != 0)
		{
			estado=sdao.insert(seguro);
		}
		return estado;
	}

	@Override
	public boolean delete(Seguro seguro) {
		boolean estado=false;
		if(seguro.getIdSeguro()>0 ) 
		{
			estado=sdao.delete(seguro);
		}
		return estado;
	}

	@Override
	public ArrayList<Seguro> readAll() {
		return sdao.readAll();
	}
	public int calcularSiguienteId() {
		return sdao.calcularSiguienteId();
	}
}
