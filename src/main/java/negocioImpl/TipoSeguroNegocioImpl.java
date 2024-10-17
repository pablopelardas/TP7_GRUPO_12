package negocioImpl;

import java.util.ArrayList;

import dao.ITipoSeguroDao;
import daoImpl.TipoSeguroDaoImpl;
import dominio.TipoSeguro;
import negocio.ITipoSeguroNegocio;

public class TipoSeguroNegocioImpl implements ITipoSeguroNegocio{


	ITipoSeguroDao tsdao = new TipoSeguroDaoImpl();
	

	@Override
	public ArrayList<TipoSeguro> readAll() {
		return tsdao.getTipoSeguro();
	}
}
