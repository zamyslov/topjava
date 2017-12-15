package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.repository.JpaUtil;

public abstract class AbstractJpaUserServiceTest extends AbstractUserServiceTest{
    @Autowired
    protected JpaUtil jpaUtil;

    @Before
    public void setUpHibernateCache() throws Exception {
        jpaUtil.clear2ndLevelHibernateCache();
    }

}
