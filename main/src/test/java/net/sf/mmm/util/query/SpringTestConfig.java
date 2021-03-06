/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.util.query;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.sf.mmm.bean.impl.spring.BeanSpringConfig;
import net.sf.mmm.jpa.api.query.statenent.jpql.JpqlStatementFactory;
import net.sf.mmm.jpa.base.query.statement.jpql.UnquotedJpqlDialect;
import net.sf.mmm.jpa.impl.query.statement.jpql.JpqlStatementFactoryImpl;

/**
 * Spring {@link Configuration} for the tests.
 */
@Configuration
@Import(BeanSpringConfig.class)
@EntityScan
@SpringBootApplication
public class SpringTestConfig {

  @Bean
  public JpqlStatementFactory statementFactory() {

    return new JpqlStatementFactoryImpl(new UnquotedJpqlDialect());
  }

}
