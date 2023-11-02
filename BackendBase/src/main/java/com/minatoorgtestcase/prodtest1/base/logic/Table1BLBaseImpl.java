package com.minatoorgtestcase.prodtest1.base.logic;

import com.eva.base.dal.providers.SearchOptions;
import com.eva.base.dal.providers.PersistenceType;
import com.eva.base.logic.BaseBusinessLogic;
import com.eva.base.exception.ValidationError;
import com.eva.base.service.changelog.ChangelogBLBaseImpl;
import org.apache.commons.lang3.BooleanUtils;
import com.eva.base.util.Constants;
import com.minatoorgtestcase.prodtest1.base.model.Table1Base;
import com.minatoorgtestcase.prodtest1.base.logic.ITable1BLBase;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

import java.util.List;

import com.eva.base.dal.providers.DBOptions;

import com.eva.base.dal.providers.DeleteOptions;


public class Table1BLBaseImpl<T extends Table1Base> extends BaseBusinessLogic<T>
		implements ITable1BLBase<T> {
		
	private ChangelogBLBaseImpl changelogBL;
	
	public Table1BLBaseImpl(Class<T> modelClass) {
		super(modelClass);
		addPersistenceOption(DBOptions.DELETE_OPTION, DeleteOptions.MARK_AS_DELETE);
		addPersistenceOption(SearchOptions.SEARCH_INDEX_NAME, getTableName());
	}

	@Override
	public PersistenceType[] getOtherPersistenceTypes() {
		return new PersistenceType[] {PersistenceType.SEARCH};
	}
	@Override
	public final void onBeforeSave(PersistenceType type, T modelObj) {
		switch (type) {
			case DB:
				onBeforeSaveDB(modelObj);
				break;
						case SEARCH:
				onBeforeSaveSearch(modelObj);
				break;
			default:
				break;
		}
		super.onBeforeSave(type, modelObj);
	}

	public void onBeforeSaveDB(T modelObj) {
		isObjectExists(modelObj,false);

	}

	@Override
	public final void onBeforeUpdate(PersistenceType type, T modelObj) {
		switch (type) {
			case DB:
				onBeforeUpdateDB(modelObj);
				break;
			default:
				break;
		}
		super.onBeforeUpdate(type, modelObj);
	}

	public void onBeforeUpdateDB(T modelObj) {
		isObjectExists(modelObj,true);
	}
	
	
	protected void isObjectExists(T modelObj, boolean isUpdate) {
	}

	
	
	@Override
	public final void onAfterSave(PersistenceType type, Object modelObj) {
		super.onAfterSave(type, modelObj);
		switch (type) {
			case DB:
				onAfterSaveDB((T)modelObj);
				break;			
			default:
				break;
		}		
	}

	public void onAfterSaveDB(T modelObj) {
	  changelogBL.createChangeLog("Table1", modelObj.getSid(), Constants.SAVED, modelObj);
	}
	
	@Override
	public final void onAfterUpdate(PersistenceType type, Object modelObj) {		
		switch (type) {
			case DB:
				onAfterUpdateDB((T)modelObj);
				break;			
			default:
				break;
		}	
		super.onAfterUpdate(type, modelObj);	
	}

	public void onAfterUpdateDB(T modelObj) {
	  changelogBL.createChangeLog("Table1", modelObj.getSid(), Constants.UPDATED, modelObj);
	}
	
	@Override
	public final void onAfterDelete(PersistenceType type, Object modelObj) {		
		switch (type) {
			case DB:
				onAfterDeleteDB((T)modelObj);
				break;			
			default:
				break;
		}
		super.onAfterDelete(type, modelObj);		
	}

	public void onAfterDeleteDB(T modelObj) {
	  changelogBL.createChangeLog("Table1", modelObj.getSid(), Constants.DELETED, modelObj);
	}	
	
	@Override
	public List<String> onBeforeGeneratedValidation() {
		// TODO Auto-generated method stub
	return null;
	}
	@Override
	public void onAfterGeneratedValidation(List<ValidationError> validationErrors) {
		// TODO Auto-generated method stub
	}
		public void onBeforeSaveSearch(T modelObj) {}
	
	public void setChangelogBL(ChangelogBLBaseImpl changelogBL) {
		this.changelogBL=changelogBL;
	}

	
}