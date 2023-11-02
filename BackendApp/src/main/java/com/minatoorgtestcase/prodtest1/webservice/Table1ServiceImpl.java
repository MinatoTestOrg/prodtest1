package com.minatoorgtestcase.prodtest1.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import com.eva.base.factory.InstanceFactory;

import com.minatoorgtestcase.prodtest1.base.webservice.Table1ServiceBaseImpl;
import com.minatoorgtestcase.prodtest1.logic.ITable1BL;
import com.minatoorgtestcase.prodtest1.logic.Table1BLImpl;
import com.minatoorgtestcase.prodtest1.model.Table1;

@Produces(MediaType.APPLICATION_JSON)
@Path("table1s")
public class Table1ServiceImpl extends Table1ServiceBaseImpl<ITable1BL<Table1>, Table1> {
	private static XLogger LOGGER = XLoggerFactory.getXLogger(Table1ServiceImpl.class);
	public Table1ServiceImpl() {
		super(InstanceFactory.getProxy(new Table1BLImpl()));
	}
}
