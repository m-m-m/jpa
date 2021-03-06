/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.jpa.base.query.statement.jpql;

import javax.persistence.Entity;

import net.sf.mmm.query.api.path.EntityAlias;
import net.sf.mmm.query.base.path.Alias;

/**
 * Helper class with {@link JpqlDialect JPQL} specific functions.
 *
 * @author hohwille
 * @since 1.0.0
 */
public final class Jpql {

  private Jpql() {}

  /**
   * @param <E> the generic type of the {@link Entity} {@link Class}.
   * @param entityClass the {@link Entity} {@link Class}.
   * @return the corresponding {@link EntityAlias}.
   */
  public static <E> EntityAlias<E> alias(Class<E> entityClass) {

    String entityName = getEntityName(entityClass);
    return new Alias<>(entityName, null, entityClass);
  }

  /**
   * @param <T> the generic type of the common {@link net.sf.mmm.util.data.api.entity.Entity} interface.
   * @param <E> the generic type of the JPA {@link Entity} {@link Class}.
   * @param <B> the generic type of the {@link net.sf.mmm.bean.api.entity.EntityBean} interface.
   * @param entityClass the {@link Entity} {@link Class}.
   * @param beanPrototype the {@link net.sf.mmm.bean.api.Bean}
   *        {@link net.sf.mmm.bean.api.BeanFactory#createPrototype(Class) prototype}.
   * @return the corresponding {@link EntityAlias}.
   */
  public static <T, E extends T, B extends T> EntityAlias<B> alias(Class<E> entityClass, B beanPrototype) {

    String entityName = getEntityName(entityClass);
    return new Alias<>(entityName, null, entityClass, beanPrototype, null);
  }

  /**
   * @param <T> the generic type of the common {@link net.sf.mmm.util.data.api.entity.Entity} interface.
   * @param <E> the generic type of the JPA {@link Entity} {@link Class}.
   * @param <B> the generic type of the {@link net.sf.mmm.bean.api.entity.EntityBean} interface.
   * @param entityInterface the {@link net.sf.mmm.util.data.api.entity.Entity} interface.
   * @param entityClass the {@link Entity} {@link Class}.
   * @param beanPrototype the {@link net.sf.mmm.bean.api.Bean}
   *        {@link net.sf.mmm.bean.api.BeanFactory#createPrototype(Class) prototype}.
   * @return the corresponding {@link EntityAlias}.
   */
  public static <T, E extends T, B extends T> EntityAlias<T> alias(Class<T> entityInterface, Class<E> entityClass, B beanPrototype) {

    String entityName = getEntityName(entityClass);
    return new Alias<>(entityName, null, entityClass, beanPrototype, entityInterface);
  }

  private static String getEntityName(Class<?> entityClass) {

    String entityName = entityClass.getSimpleName();
    Entity entity = entityClass.getAnnotation(Entity.class);
    if (entity != null) {
      String name = entity.name();
      if (!name.isEmpty()) {
        entityName = name;
      }
    }
    return entityName;
  }

}
