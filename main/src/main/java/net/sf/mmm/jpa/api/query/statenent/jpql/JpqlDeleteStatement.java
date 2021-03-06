/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.jpa.api.query.statenent.jpql;

import net.sf.mmm.query.api.statement.DeleteStatement;

/**
 * Extension of a regular {@link DeleteStatement} for {@link net.sf.mmm.jpa.base.query.statement.jpql.Jpql JPQL}.
 *
 * @param <E> the generic type of the queried object (an {@link javax.persistence.Entity}).
 *
 * @author hohwille
 * @since 1.0.0
 */
public interface JpqlDeleteStatement<E> extends DeleteStatement<E, JpqlDeleteStatement<E>> {

}
