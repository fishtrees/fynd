/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yinpsoft.struts.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 01-14-2009
 * 
 * XDoclet definition:
 * @struts.form name="customerTypeViewForm"
 */
public class CustomerTypeViewForm extends ActionForm {
	/*
	 * Generated Methods
	 */

	/** customerTypeName property */
	private String customerTypeName;

	/** customerTypeCode property */
	private String customerTypeCode;
	
	private String isvoid ;
	
	private Date created;
	
	/**
	 * @return the customerTypeName
	 */
	public String getCustomerTypeName() {
		return customerTypeName;
	}

	/**
	 * @param customerTypeName the customerTypeName to set
	 */
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	/**
	 * @return the customerTypeCode
	 */
	public String getCustomerTypeCode() {
		return customerTypeCode;
	}

	/**
	 * @param customerTypeCode the customerTypeCode to set
	 */
	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}

	/**
	 * @return the isvoid
	 */
	public String getIsvoid() {
		return isvoid;
	}

	/**
	 * @param isvoid the isvoid to set
	 */
	public void setIsvoid(String isvoid) {
		this.isvoid = isvoid;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
}