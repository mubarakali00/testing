package com.emas.sqlbuilder;

import java.util.List;

import com.emas.sqlbuilder.SqlBuilderEnum.EnumLogicOperator;
import com.emas.sqlbuilder.SqlBuilderEnum.EnumOperator;

public class CriteriaUtils 
{
	/**
	 * 
	 * @param columnName= column name of the table.
	 * @param parameters = list of parameters (Object datatype only) which are going to be set appropriately in controller. 
	 * @param operator = operator is the enum EnumOperator which contains EQUAL, IN, BETWEEN, LIKE, etc...
	 * @param logicalOperator = this is an enum as well. EnumLogicOperator contains only AND and OR.
	 * @return single WhereStruct class object.
	 */
	public WhereStruct GenerateWhereField( String columnName, List<Object> parameters, EnumOperator operator, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		switch( operator )
		{
		case EQUAL:
			where = GenerateWhereFieldEqualCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		case BETWEEN:
			where = GenerateWhereFieldBetweenCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		case GREATER_THAN:
			
			break;
		case GREATER_THAN_OR_EQUAL_TO:
			where = GenerateWhereFieldGreatherThanOrEqualToCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		case ILIKE:
			where = GenerateWhereFieldILikeCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		case IN:
			where = GenerateWhereFieldInCondition( columnName );
			where.colValueList = parameters;
			break;
		case LESS_THAN:
			break;
		case LESS_THAN_OR_EQUAL_TO:
			where = GenerateWhereFieldLessThanOrEqualToCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		case LIKE:
			where = GenerateWhereFieldLikeCondition( columnName, logicalOperator );
			where.colValueList = parameters;
			break;
		}
		return where;
	}

	private WhereStruct GenerateWhereFieldEqualCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.columnName = columnName;
		where.colOperator = EnumOperator.EQUAL;
		where.logicOperator = logicalOperator;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldInCondition( String columnName )
	{
		WhereStruct where = new WhereStruct();
		where.columnName = columnName;
		where.colOperator = EnumOperator.EQUAL;
		where.logicOperator = EnumLogicOperator.OR;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldBetweenCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.columnName = columnName;
		where.colOperator = EnumOperator.BETWEEN;
		where.logicOperator = logicalOperator;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldGreatherThanOrEqualToCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.colOperator = EnumOperator.GREATER_THAN_OR_EQUAL_TO;
		where.columnName = columnName;
		where.logicOperator = EnumLogicOperator.AND;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldLessThanOrEqualToCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.colOperator = EnumOperator.LESS_THAN_OR_EQUAL_TO;
		where.columnName = columnName;
		where.logicOperator = EnumLogicOperator.AND;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldILikeCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.columnName = columnName;
		where.colOperator = EnumOperator.ILIKE;
		where.logicOperator = logicalOperator;
		return where;
	}
	
	private WhereStruct GenerateWhereFieldLikeCondition( String columnName, EnumLogicOperator logicalOperator )
	{
		WhereStruct where = new WhereStruct();
		where.columnName = columnName;
		where.colOperator = EnumOperator.LIKE;
		where.logicOperator = logicalOperator;
		return where;
	}

}
