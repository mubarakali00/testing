package com.emas.jpa.entity;

import java.io.Serializable;

public interface IEntity<I> extends Serializable {

	/** http://stackoverflow.com/questions/6033905/create-the-perfect-jpa-entity
	 * @return entity identity
	 */
	I getId();

	/**
	 * @return HashCode of entity identity
	 */
	int identityHashCode();

	/**
	 * @param other
	 *            Other entity
	 * @return true if identities of entities are equal
	 */
	boolean identityEquals(IEntity<?> other);
}
