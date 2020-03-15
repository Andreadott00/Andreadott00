package info.java.tips.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import info.java.tips.dao.ProvaFormDao;
import info.java.tips.form.ProvaForm;

public class RegistrazioneAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProvaForm provaForm = (ProvaForm) form;
		ActionForward fw = mapping.getInputForward();
		String username = provaForm.getUsername();
        String password = provaForm.getPassword();
        String nome = provaForm.getNome();
        String cognome = provaForm.getCognome();
        String email = provaForm.getEmail();
        String telefono = provaForm.getTelefono();
	    if(ProvaFormDao.registrazione(username, password, nome, cognome, email, telefono)){
	    	fw = mapping.findForward("success");
	    }else {
	    	ActionErrors errs = new ActionErrors();
			errs.add("", new ActionMessage("registrazione.msg.err"));
			saveErrors(request, errs);
	    }
		return fw;
	}
}

