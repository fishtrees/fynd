/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yinpsoft.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-12-2009
 * 
 * XDoclet definition:
 * @struts.form name="customerForm"
 */
public class CustomerForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** sex property */
	private Boolean sex;

	/** customerName property */
	private String customerName;

	/** customerTypeId property */
	private String customerTypeId;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the sex.
	 * @return Boolean
	 */
	public Boolean getSex() {
		return sex;
	}

	/** 
	 * Set the sex.
	 * @param sex The sex to set
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/** 
	 * Returns the customerName.
	 * @return String
	 */
	public String getCustomerName() {
		return customerName;
	}

	/** 
	 * Set the customerName.
	 * @param customerName The customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/** 
	 * Returns the customerTypeId.
	 * @return String
	 */
	public String getCustomerTypeId() {
		return customerTypeId;
	}

	/** 
	 * Set the customerTypeId.
	 * @param customerTypeId The customerTypeId to set
	 */
	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
}