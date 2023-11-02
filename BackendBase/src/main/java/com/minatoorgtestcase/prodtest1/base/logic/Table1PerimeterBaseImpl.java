package com.minatoorgtestcase.prodtest1.base.logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.eva.base.dal.providers.PersistenceType;
import com.eva.base.acl.AllowedFields;
import com.eva.base.authentication.logic.AppUserPrivilegeCache;
import com.eva.base.acl.IPerimeterManager;
import com.minatoorgtestcase.prodtest1.model.Roles;
import org.apache.commons.lang3.BooleanUtils;
import com.eva.base.authentication.logic.IAppUserPrivilegeCache;
import com.eva.base.cache.CacheManager;
import com.minatoorgtestcase.prodtest1.base.model.Table1Base;
import com.minatoorgtestcase.prodtest1.base.model.ApplicationUserBase;

import java.util.Collections;
public abstract class Table1PerimeterBaseImpl<T extends Table1Base> implements IPerimeterManager<T> {
	
	protected AppUserPrivilegeCache userCache = CacheManager.getInstance().getCache(IAppUserPrivilegeCache.NAME);
	@Override
	public boolean canCreate(T model) {
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		if (userBase != null) {
			if(userBase.getUserRoles()!=null) {
				for (String role : userBase.getUserRoles()) {
					Roles roleName = Roles.getRoleNameEnum(role);
					if (roleName != null) {
						switch (roleName) {
							case DEVADMIN:
								return true;
							
							default:
								break;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canUpdate(T model) {
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		if (userBase != null) {
			if(userBase.getUserRoles()!=null) {
				for (String role : userBase.getUserRoles()) {
					Roles roleName = Roles.getRoleNameEnum(role);
					if (roleName != null) {
						switch (roleName) {
							case DEVADMIN:
								return true;
							
							default:
								break;
						}
					}	
				}
			}
		}
		return false;
	}

	@Override
	public boolean canDelete(T model) {
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		if (userBase != null) {
			if(userBase.getUserRoles()!=null) {
				for (String role : userBase.getUserRoles()) {
					Roles roleName = Roles.getRoleNameEnum(role);
					if (roleName != null) {
						switch (roleName) {
							case DEVADMIN:
								return true;
							
							default:
								break;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean canRead(T model) {
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		if (userBase != null) {
			if(userBase.getUserRoles()!=null) {
				for (String role : userBase.getUserRoles()) {
					Roles roleName = Roles.getRoleNameEnum(role);
					if (roleName != null) {
						switch (roleName) {
							case DEVADMIN:
								return true;
							
							default:
								break;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public String getAccessQuery(PersistenceType type) {
		return null;
	}

	@Override
	public AllowedFields getSelectFields(PersistenceType type) {
		AllowedFields allowedFields = new AllowedFields();
		ApplicationUserBase userBase = (ApplicationUserBase) userCache.getCurrentUser();
		setReadFields(userBase, allowedFields);
		setWriteFields(userBase, allowedFields);
		return allowedFields;
	}
	
	protected void setReadFields(ApplicationUserBase userBase, AllowedFields allowedFields) {
		List<String> allowedAccessFields = new ArrayList<>();
		allowedAccessFields.addAll(getTechnicalFields());
		if(userBase == null) {
			List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
			allowedFields.setAllowedReadFields(allowedAccessFieldList);
			return;
		}
		if(BooleanUtils.isTrue(userBase.isDevAdmin())) {
			allowedAccessFields.add("*");
			allowedFields.setAllowedReadFields(allowedAccessFields);
			return;
		}
		
		allowedFields.setAllowedReadFields(allowedAccessFields);
	}
	protected void setWriteFields(ApplicationUserBase userBase, AllowedFields allowedFields) {
		List<String> allowedAccessFields = new ArrayList<>();
		allowedAccessFields.addAll(getTechnicalFields());
		if(userBase == null) {
			List<String> allowedAccessFieldList = new ArrayList<>(allowedAccessFields);
			allowedFields.setAllowedWriteFields(allowedAccessFieldList);
			return;
		}
		if(BooleanUtils.isTrue(userBase.isDevAdmin())) {
			allowedAccessFields.add("*");
			allowedFields.setAllowedWriteFields(allowedAccessFields);
			return;
		}
		
		allowedFields.setAllowedWriteFields(allowedAccessFields);
	}
	protected List<String> getTechnicalFields() {
		String[] technicalFields = {"sid", "createdBy", "createdDate", "modifiedBy", "modifiedDate", "recDeleted"};
		List<String> technicalFieldList =  new ArrayList<>();
		Collections.addAll(technicalFieldList, technicalFields);
		return technicalFieldList;
	}
	
	
}
