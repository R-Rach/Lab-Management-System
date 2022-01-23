package com.hellospringdemo.dao.impl;

import com.hellospringdemo.dao._6017Dao;
import com.hellospringdemo.dao._6018Dao;
import com.hellospringdemo.model._6017;
import com.hellospringdemo.model._6018;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class _6018DaoImpl implements _6018Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<_6018> getLabSchedule() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from _6018");
        List<_6018> _6018 = query.list();
        session.flush();

        return _6018;
    }
}
