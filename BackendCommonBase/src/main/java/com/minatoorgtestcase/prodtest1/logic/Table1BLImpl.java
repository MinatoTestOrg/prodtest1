package com.minatoorgtestcase.prodtest1.logic;

import com.eva.base.acl.IPerimeterManager;
import com.minatoorgtestcase.prodtest1.base.logic.Table1BLBaseImpl;
import com.minatoorgtestcase.prodtest1.model.Table1;
import com.minatoorgtestcase.prodtest1.logic.Table1PerimeterImpl;


public class Table1BLImpl extends Table1BLBaseImpl<Table1> implements ITable1BL<Table1>{

	public Table1BLImpl() {
		super(Table1.class);	
		setChangelogBL(new ChangelogBLImpl()); 
	}
	

	
	protected IPerimeterManager<Table1> getPerimeterManager() {
		return new Table1PerimeterImpl();
	}
}