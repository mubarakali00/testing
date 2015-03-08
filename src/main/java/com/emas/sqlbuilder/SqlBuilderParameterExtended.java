package com.emas.sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class SqlBuilderParameterExtended extends SqlBuilderParameter 
{
	public  List<String> tableNames;
	
	public SqlBuilderParameterExtended()
	{
		super();
		this.tableNames = new ArrayList<String>();
	}
	
	
}
