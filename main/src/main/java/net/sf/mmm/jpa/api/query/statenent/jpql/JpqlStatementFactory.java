/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.jpa.api.query.statenent.jpql;

import net.sf.mmm.property.api.path.PropertyPath;
import net.sf.mmm.query.api.feature.FeatureInsert;
import net.sf.mmm.query.api.path.EntityAlias;
import net.sf.mmm.query.api.statement.StatementFactory;
import net.sf.mmm.util.component.api.ComponentSpecification;

/**
 * This is the interface extends {@link StatementFactory} for
 * {@link net.sf.mmm.jpa.base.query.statement.jpql.Jpql}. There is no {@link FeatureInsert INSERT support} as
 * JPQL does not have insert statements.
 *
 * @author hohwille
 * @since 1.0.0
 */
@ComponentSpecification
public interface JpqlStatementFactory extends StatementFactory {

  @Override
  <E> JpqlSelectStatement<E> selectFrom(EntityAlias<E> alias);

  @Override
  JpqlSelectStatement<Object[]> selectFrom(EntityAlias<?> alias, PropertyPath<?>... paths);

  @Override
  <E> JpqlSelectStatement<E> selectFrom(EntityAlias<?> alias, Class<E> toClass, PropertyPath<?>... constructorArgs);

  @Override
  <E> JpqlDeleteStatement<E> deleteFrom(EntityAlias<E> alias);

  @Override
  <E> JpqlUpdateStatement<E> update(EntityAlias<E> alias);

}
