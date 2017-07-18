/**
 *    Copyright 2009-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.guice.session;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SqlSessionManagerProviderTest {
  private SqlSessionManagerProvider sqlSessionManagerProvider;
  @Mock
  private SqlSessionFactory sqlSessionFactory;
  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Before
  public void beforeTest() {
    sqlSessionManagerProvider = new SqlSessionManagerProvider();
    sqlSessionManagerProvider.createNewSqlSessionManager(sqlSessionFactory);
  }

  @Test
  public void get() {
    SqlSessionManager sqlSessionManager = sqlSessionManagerProvider.get();

    assertNotNull(sqlSessionManager);
    sqlSessionManager.openSession();
    verify(sqlSessionFactory).openSession();
  }
}
