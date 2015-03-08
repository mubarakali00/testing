package com.emas.sqlbuilder;

import java.util.ArrayList;
import java.util.List;

import com.emas.sqlbuilder.SqlBuilderEnum.EnumLogicOperator;
import com.emas.sqlbuilder.SqlBuilderEnum.EnumOperator;

public class WhereStruct 
{
	
	public String columnName;
	public List<Object> colValueList;
	public EnumOperator colOperator;
	public EnumLogicOperator logicOperator;
	
	// Below two fields are for JPA Dynamic queries as well.
	//public EnumOperator colOperator;
	//public EnumLogicOperator logicOperator;
	
	public WhereStruct()
	{
		this.colValueList = new ArrayList<Object>();
	}
}
