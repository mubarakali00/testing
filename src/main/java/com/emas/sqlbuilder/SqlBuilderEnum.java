package com.emas.sqlbuilder;

public class SqlBuilderEnum 
{
	
	public enum EnumLogicOperator
	{
		OR,
		AND
	}
	
	public enum EnumOperator
	{
		EQUAL,
		LESS_THAN,
		LESS_THAN_OR_EQUAL_TO,
		GREATER_THAN,
		GREATER_THAN_OR_EQUAL_TO,
		LIKE,
		ILIKE,
		IN,
		BETWEEN
	}
	
	public enum EnumSortType
	{
		ASC,
		DESC
	}
	
	public enum EnumDataType
	{
		STRING,
		INTEGER,
		BIG_DECIMAL,
		DATE,
		JSON
	}
	
}
