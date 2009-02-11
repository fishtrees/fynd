/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yinpsoft.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yinpsoft.BaseDAO;
import com.yinpsoft.beans.Customertype;
import com.yinpsoft.daos.CustomerTypeDAO;
import com.yinpsoft.struts.form.CustomerTypeForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-15-2009
 * 
 * XDoclet definition:
 * @struts.action path="/customerTypeEdit" name="customerTypeEdit" input="/views/customers/customerTypeEdit.jsp" parameter="action" scope="request" validate="true"
 * @struts.action-forward name="customerTypeEdit" path="/views/customers/customerTypeEdit.jsp"
 */
public class CustomerTypeEditAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private static Log logger = (Log) LogFactory.getLog(CustomerTypeEditAction.class);

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		logger.debug(this.clazz.getName()+".edit Begin...............................................");
		
		String id = request.getParameter("customerTypeId");
		CustomerTypeForm customerTypeForm = (CustomerTypeForm)form;
		CustomerTypeDAO customerTypeDao = new CustomerTypeDAO();
		
		try{
			Customertype customerType = customerTypeDao.findById(id);
			
			customerTypeForm.setCustomerTypeCode(customerType.getCustomertypecode());			
			customerTypeForm.setCustomerTypeName(customerType.getCustomertypename());
			
			BaseDAO.Commit();
		} catch (Exception e){
			logger.debug("|||||||||||||||"+e.getMessage());
			BaseDAO.Rollback();
		}
		
		logger.debug(this.clazz.getName()+".edit End.........." +
				"...."+customerTypeForm.getCustomerTypeCode()+"" +
						"    "+customerTypeForm.getCustomerTypeName()+".................................");
		
		return mapping.findForward("customerTypeEdit");
	}
	
}