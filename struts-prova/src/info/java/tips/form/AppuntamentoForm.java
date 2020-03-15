package info.java.tips.form;

import org.apache.struts.action.ActionForm;

public class AppuntamentoForm extends ActionForm{
	private Long id;
	private String ora;
	private String data;
	private String descrizione;
	
	public AppuntamentoForm(Long id, String ora, String data, String descrizione) {
		this.id=id;
		this.ora = ora;
		this.data = data;
		this.descrizione = descrizione;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
