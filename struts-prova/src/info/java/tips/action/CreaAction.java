package info.java.tips.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import info.java.tips.dao.AppuntamentoFormDao;
import info.java.tips.form.AppuntamentoForm;

public class CreaAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AppuntamentoForm app = (AppuntamentoForm) form;
		ActionForward fw = mapping.getInputForward();
		String ora = app.getOra();
        String data = app.getData();
        String descrizione = app.getDescrizione();
		return fw;
	}
	
}
