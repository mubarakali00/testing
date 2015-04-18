package com.emas.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericRepositoryAbstract<T>
{
	private Class<T> classToBePassed;

	@PersistenceContext
	protected EntityManager entityManager;

	public final void setClassToBePassed(final Class<T> clazzToSet) 
	{
		this.classToBePassed = clazzToSet;
	}

	public T findById(final Integer id) 
	{
		return entityManager.find(classToBePassed, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() 
	{
		return entityManager.createQuery("from " + classToBePassed.getName()).getResultList();
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void create(final T entity) 
	{
		try
		{
			entityManager.persist(entity);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Transactional
	public T update(final T entity) 
	{
		return entityManager.merge(entity);
	}

	@Transactional
	public void delete(final T entity) 
	{
		entityManager.remove(entity);
	}

	@Transactional
	public void deleteById(final Integer entityId) 
	{
		final T entity = findById(entityId);
		delete(entity);
	}

	public List<T> findBy(final String column, final String value) 
    {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<T> q = cb.createQuery(classToBePassed);
    	Root<T> c = q.from(classToBePassed);
    	q.select(c);
    	
    	ParameterExpression<String> p = cb.parameter(String.class);
    	Predicate predicate = cb.equal(c.get(column), p);
    	
    	q.where(predicate);
    	
    	TypedQuery<T> returnValue = entityManager.createQuery(q);
    	returnValue.setParameter(p, value);
    	
    	return returnValue.getResultList();
    }
	
	public List<T> findBy(final String parameter) 
    {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<T> q = cb.createQuery(classToBePassed);
    	Root<T> c = q.from(classToBePassed);
    	q.select(c);
    	
//    	ParameterExpression<String> p = cb.parameter(String.class);
//    	Predicate predicate = cb.equal(c.get(column), p);
    	
//    	q.where(predicate);
    	
    	TypedQuery<T> returnValue = entityManager.createQuery(q);
//    	returnValue.setParameter(p, parameter);
    	
    	return returnValue.getResultList();
    }

	//[start] 100% working and tested generic query for JPA 2.
	/*
	public List<T> findBySqlBuilder(SqlBuilderParameter sqlBuilderParameter)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(classToBePassed);
		Root<T> cr = cq.from(classToBePassed);

		List<Predicate> predicateList = new ArrayList<Predicate>();
		List<Order> orderList = new ArrayList<Order>();
		
		if(sqlBuilderParameter.whereFieldList != null && sqlBuilderParameter.whereFieldList.isEmpty() == false)
		{

			Predicate likePredicate = null, equalPredicate, greaterThanPredicate, greaterThanOrEqualToPredicate, lessThanPredicate, lessThanOrEqualToPredicate,
					andPredicate, orPredicate, inPredicate, betweenPredicate;	

			// greater than 1 because in here I am setting the OR or AND conditions for where.
			if(sqlBuilderParameter.whereFieldList.size() > 1)
			{
				int i=0;

				for(WhereStruct where : sqlBuilderParameter.whereFieldList)
				{

					if(where.column.columnName != null)
					{
						switch(where.colOperator)
						{
						case EQUAL:
							if(where.colValueList.get(0) instanceof String)
							{
								equalPredicate = cb.equal(cr.get(where.column.columnName), (String)where.colValueList.get(0));
								predicateList.add(equalPredicate);
							}
							else if(where.colValueList.get(0) instanceof Integer)
							{
								equalPredicate = cb.equal(cr.get(where.column.columnName), (Integer)where.colValueList.get(0));
								predicateList.add(equalPredicate);
							}
							else if(where.colValueList.get(0) instanceof Double)
							{
								equalPredicate = cb.equal(cr.get(where.column.columnName), (Double)where.colValueList.get(0));
								predicateList.add(equalPredicate);
							}
							else if(where.colValueList.get(0) instanceof Date)
							{
								equalPredicate = cb.equal(cr.get(where.column.columnName), (Date)where.colValueList.get(0));
								predicateList.add(equalPredicate);
							}
							break;

						case GREATER_THAN:
							if(where.colValueList.get(0) instanceof Integer)
							{
								greaterThanPredicate = cb.greaterThan(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
								predicateList.add(greaterThanPredicate);
							}
							else if(where.colValueList.get(0) instanceof Double)
							{
								greaterThanPredicate = cb.greaterThan(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
								predicateList.add(greaterThanPredicate);
							}
							else if(where.colValueList.get(0) instanceof Date)
							{
								greaterThanPredicate = cb.greaterThan(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
								predicateList.add(greaterThanPredicate);
							}
							break;

						case GREATER_THAN_OR_EQUAL_TO:
							if(where.colValueList.get(0) instanceof Integer)
							{
								greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
								predicateList.add(greaterThanOrEqualToPredicate);
							}
							else if(where.colValueList.get(0) instanceof Double)
							{
								greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
								predicateList.add(greaterThanOrEqualToPredicate);
							}
							else if(where.colValueList.get(0) instanceof Date)
							{
								greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
								predicateList.add(greaterThanOrEqualToPredicate);
							}
							break;
						case LESS_THAN:
							if(where.colValueList.get(0) instanceof Integer)
							{
								lessThanPredicate = cb.lessThan(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
								predicateList.add(lessThanPredicate);
							}
							else if(where.colValueList.get(0) instanceof Double)
							{
								lessThanPredicate = cb.lessThan(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
								predicateList.add(lessThanPredicate);
							}
							else if(where.colValueList.get(0) instanceof Date)
							{
								lessThanPredicate = cb.lessThan(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
								predicateList.add(lessThanPredicate);
							}
							break;
						case LESS_THAN_OR_EQUAL_TO:
							if(where.colValueList.get(0) instanceof Integer)
							{
								lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
								predicateList.add(lessThanOrEqualToPredicate);
							}
							else if(where.colValueList.get(0) instanceof Double)
							{
								lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
								predicateList.add(lessThanOrEqualToPredicate);
							}
							else if(where.colValueList.get(0) instanceof Date)
							{
								lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
								predicateList.add(lessThanOrEqualToPredicate);
							}
							break;
						case LIKE:
							if(where.colValueList.get(0) instanceof String)
							{
								StringBuilder sb = new StringBuilder();
								sb.append("%");
								sb.append(((String) where.colValueList.get(0)).toLowerCase());
								sb.append("%");
								likePredicate = cb.like(cr.<String> get(where.column.columnName), sb.toString().toUpperCase());
								predicateList.add(likePredicate);
							}
							break;
						case BETWEEN:
							if(where.colValueList.size() == 2)
							{
								if((where.colValueList.get(0) instanceof Integer) && (where.colValueList.get(1) instanceof Integer))
								{
									betweenPredicate = cb.between(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0), (Integer)where.colValueList.get(1));
									predicateList.add(betweenPredicate);
								}
								else if((where.colValueList.get(0) instanceof Double) && (where.colValueList.get(1) instanceof Double))
								{
									betweenPredicate = cb.between(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0), (Double)where.colValueList.get(1));
									predicateList.add(betweenPredicate);
								}
								else if((where.colValueList.get(0) instanceof Date) && (where.colValueList.get(1) instanceof Date))
								{
									betweenPredicate = cb.between(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0), (Date)where.colValueList.get(1));
									predicateList.add(betweenPredicate);
								}
							}
							break;
						case IN:
							if(where.colValueList.get(0) instanceof List)
							{
								List<String> val = (List<String>) where.colValueList.get(0);								
								In<String> inList = cb.in(cr.<String> get(where.column.columnName));
								for(String invalue : val)
								{
									inList.value(invalue);
								}
								inPredicate = inList;
								predicateList.add(inPredicate);
							}
							break;

						}

						if(i != 0)
						{
							switch(where.logicOperator)
							{
							case AND:
								andPredicate = cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
								predicateList.clear();
								predicateList.add(andPredicate);
								break;
							case OR:
								orPredicate = cb.or(predicateList.toArray(new Predicate[predicateList.size()]));
								predicateList.clear();
								predicateList.add(orPredicate);
								break;

							}
						}

						if(sqlBuilderParameter.orderByFieldList != null && sqlBuilderParameter.orderByFieldList.isEmpty() == false)
						{

							for(OrderByStruct order : sqlBuilderParameter.orderByFieldList)
							{
								switch(order.sortType)
								{
								case ASC:
									Order orderAsc = cb.asc(cr.<String> get(order.column.columnName));
									orderList.add(orderAsc);
									break;
								case DESC:
									Order orderDesc = cb.desc(cr.<String> get(order.column.columnName));
									orderList.add(orderDesc);
									break;
								}
								break;
							}
						}

						i++;
					}
				}
			} 
			//[start] this if executed when the whereFieldList size is one and only one.
			else if(sqlBuilderParameter.whereFieldList.size() == 1)
			{
				WhereStruct where = sqlBuilderParameter.whereFieldList.get(0);
				switch(where.colOperator)
				{
				case EQUAL:
					if(where.colValueList.get(0) instanceof String)
					{
						equalPredicate = cb.equal(cr.get(where.column.columnName), (String)where.colValueList.get(0));
						predicateList.add(equalPredicate);
					}
					else if(where.colValueList.get(0) instanceof Integer)
					{
						equalPredicate = cb.equal(cr.get(where.column.columnName), (Integer)where.colValueList.get(0));
						predicateList.add(equalPredicate);
					}
					else if(where.colValueList.get(0) instanceof Double)
					{
						equalPredicate = cb.equal(cr.get(where.column.columnName), (Double)where.colValueList.get(0));
						predicateList.add(equalPredicate);
					}
					else if(where.colValueList.get(0) instanceof Date)
					{
						equalPredicate = cb.equal(cr.get(where.column.columnName), (Date)where.colValueList.get(0));
						predicateList.add(equalPredicate);
					}
					break;

				case GREATER_THAN:
					if(where.colValueList.get(0) instanceof Integer)
					{
						greaterThanPredicate = cb.greaterThan(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
						predicateList.add(greaterThanPredicate);
					}
					else if(where.colValueList.get(0) instanceof Double)
					{
						greaterThanPredicate = cb.greaterThan(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
						predicateList.add(greaterThanPredicate);
					}
					else if(where.colValueList.get(0) instanceof Date)
					{
						greaterThanPredicate = cb.greaterThan(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
						predicateList.add(greaterThanPredicate);
					}
					break;

				case GREATER_THAN_OR_EQUAL_TO:
					if(where.colValueList.get(0) instanceof Integer)
					{
						greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
						predicateList.add(greaterThanOrEqualToPredicate);
					}
					else if(where.colValueList.get(0) instanceof Double)
					{
						greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
						predicateList.add(greaterThanOrEqualToPredicate);
					}
					else if(where.colValueList.get(0) instanceof Date)
					{
						greaterThanOrEqualToPredicate = cb.greaterThanOrEqualTo(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
						predicateList.add(greaterThanOrEqualToPredicate);
					}
					break;
				case LESS_THAN:
					if(where.colValueList.get(0) instanceof Integer)
					{
						lessThanPredicate = cb.lessThan(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
						predicateList.add(lessThanPredicate);
					}
					else if(where.colValueList.get(0) instanceof Double)
					{
						lessThanPredicate = cb.lessThan(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
						predicateList.add(lessThanPredicate);
					}
					else if(where.colValueList.get(0) instanceof Date)
					{
						lessThanPredicate = cb.lessThan(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
						predicateList.add(lessThanPredicate);
					}
					break;
				case LESS_THAN_OR_EQUAL_TO:
					if(where.colValueList.get(0) instanceof Integer)
					{
						lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0));
						predicateList.add(lessThanOrEqualToPredicate);
					}
					else if(where.colValueList.get(0) instanceof Double)
					{
						lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0));
						predicateList.add(lessThanOrEqualToPredicate);
					}
					else if(where.colValueList.get(0) instanceof Date)
					{
						lessThanOrEqualToPredicate = cb.lessThanOrEqualTo(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0));
						predicateList.add(lessThanOrEqualToPredicate);
					}
					break;
				case LIKE:
					if(where.colValueList.get(0) instanceof String)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("%");
						sb.append(((String) where.colValueList.get(0)));
						sb.append("%");
						likePredicate = cb.like(cr.<String> get(where.column.columnName), cb.parameter(String.class, sb.toString().toUpperCase()));
						predicateList.add(likePredicate);
					}
					break;
				case BETWEEN:
					if(where.colValueList.size() == 2)
					{
						if((where.colValueList.get(0) instanceof Integer) && (where.colValueList.get(1) instanceof Integer))
						{
							betweenPredicate = cb.between(cr.<Integer> get(where.column.columnName), (Integer) where.colValueList.get(0), (Integer)where.colValueList.get(1));
							predicateList.add(betweenPredicate);
						}
						else if((where.colValueList.get(0) instanceof Double) && (where.colValueList.get(1) instanceof Double))
						{
							betweenPredicate = cb.between(cr.<Double> get(where.column.columnName), (Double) where.colValueList.get(0), (Double)where.colValueList.get(1));
							predicateList.add(betweenPredicate);
						}
						else if((where.colValueList.get(0) instanceof Date) && (where.colValueList.get(1) instanceof Date))
						{
							betweenPredicate = cb.between(cr.<Date> get(where.column.columnName), (Date) where.colValueList.get(0), (Date)where.colValueList.get(1));
							predicateList.add(betweenPredicate);
						}
					}
					break;
				case IN:
					if(where.colValueList.get(0) instanceof List)
					{
						List<String> val= (List<String>) where.colValueList.get(0);
						In<String> inList = cb.in(cr.<String> get(where.column.columnName));
						for(String invalue : val)
						{
							inList.value(invalue);
						}
						inPredicate = inList;
						predicateList.add(inPredicate);
					}
					break;
				}

				if(sqlBuilderParameter.orderByFieldList != null && sqlBuilderParameter.orderByFieldList.isEmpty() == false)
				{
					
					for(OrderByStruct order : sqlBuilderParameter.orderByFieldList)
					{
						switch(order.sortType)
						{
						case ASC:
							Order orderAsc = cb.asc(cr.<String> get(order.column.columnName));
							orderList.add(orderAsc);
							break;
						case DESC:
							Order orderDesc = cb.desc(cr.<String> get(order.column.columnName));
							orderList.add(orderDesc);
							break;
						}
						
					}
				}

			}
			//[end]
		}
		
		if(orderList.size() > 0)
		{
			cq.select(cr).where(predicateList.toArray(new Predicate[predicateList.size()])).orderBy(orderList);
		}
		else
		{
			cq.select(cr).where(predicateList.toArray(new Predicate[predicateList.size()]));
		}
		
		TypedQuery<T> qry = entityManager.createQuery(cq);
		if(qry != null)
		{
			return qry.getResultList();
		}
		else
		{
			return null;
		}
	}
	*/
	//[end]
	
	
}
