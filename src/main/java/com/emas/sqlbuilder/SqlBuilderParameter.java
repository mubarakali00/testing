package com.emas.sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class SqlBuilderParameter 
{
	
	public List<WhereStruct> whereFieldList;
	public String schema;
	public String tableName;
	
	public SqlBuilderParameter()
	{
		this.whereFieldList = new ArrayList<WhereStruct>();
		this.tableName = "";
		this.schema = "";
	}	
	
}
