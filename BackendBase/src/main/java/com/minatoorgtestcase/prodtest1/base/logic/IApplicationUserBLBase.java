package com.minatoorgtestcase.prodtest1.base.logic;

import com.eva.base.authentication.IAppUserPrivilegeBL;
import com.minatoorgtestcase.prodtest1.base.model.ApplicationUserBase;
import com.eva.base.mail.model.EmailAddress;
import java.util.List;
import com.eva.base.model.wrapper.UserPrivilegePerimeter;


public interface IApplicationUserBLBase<T extends ApplicationUserBase> extends IAppUserPrivilegeBL<T> {
	public T getBy();


	public List<EmailAddress> getUsersByRole(UserPrivilegePerimeter rolePerimeterInfo, Integer page, Integer pageSize);

}