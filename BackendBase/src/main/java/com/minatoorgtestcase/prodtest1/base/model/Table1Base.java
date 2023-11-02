package com.minatoorgtestcase.prodtest1.base.model;
import com.eva.base.model.BaseModel;
import com.eva.base.annotations.Table;
import com.eva.base.annotations.Searchable;


@Table(name="Table1", keys={"sid"})
public class Table1Base extends BaseModel {

	@Searchable(index = true)
	private String field1;

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField1() {
		return field1;
	}



}