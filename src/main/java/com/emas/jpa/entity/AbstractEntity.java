package com.emas.jpa.entity;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class AbstractEntity<I> implements IEntity<I> {

	/**
	 * http://stackoverflow.com/questions/6033905/create-the-perfect-jpa-entity
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public final boolean identityEquals(IEntity<?> other) {
		if (getId() == null) {
			return false;
		}
		return getId().equals(other.getId());
	}

	@Override
	public final int identityHashCode() {
		return new HashCodeBuilder().append(this.getId()).toHashCode();
	}

	@Override
	public final int hashCode() {
		return identityHashCode();
	}

	@Override
	public final boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}

		return identityEquals((IEntity<?>) o);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + identityHashCode();
		// OR 
		// return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
