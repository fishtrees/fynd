/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yinpsoft.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.yinpsoft.struts.form.CustomerForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-12-2009
 * 
 * XDoclet definition:
 * @struts.action path="/customer" name="customerForm" input="/customerEdit.jsp" parameter="action" scope="request" validate="true"
 */
public class CustomerAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;// TODO Auto-generated method stub
		return null;
	}
}