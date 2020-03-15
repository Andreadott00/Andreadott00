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

public class ProvaAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProvaForm provaForm = (ProvaForm) form;
		String username = provaForm.getUsername();
		String password = provaForm.getPassword();
		System.out.println(username);
		System.out.println(password);
		ActionForward fw = mapping.getInputForward();
		if(ProvaFormDao.login(username,password)){
			fw = mapping.findForward("success");
		}else{
			ActionErrors errs = new ActionErrors();
			errs.add("", new ActionMessage("prova.msg.err"));
			saveErrors(request, errs);
		}
		request.getSession().setAttribute("username", username);
		return fw;
	}

}
