package info.java.tips.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class ListaAppuntamenti extends ActionForm{
	private List<AppuntamentoForm> ListaAppuntamento = new ArrayList<>();

	public List<AppuntamentoForm> getListaAppuntamento() {
		return ListaAppuntamento;
	}

	public void setListaAppuntamento(List<AppuntamentoForm> listaAppuntamento) {
		ListaAppuntamento = listaAppuntamento;
	}
	
}
