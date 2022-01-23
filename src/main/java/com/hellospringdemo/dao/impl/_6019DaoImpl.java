package com.hellospringdemo.dao.impl;

import com.hellospringdemo.dao._6018Dao;
import com.hellospringdemo.dao._6019Dao;
import com.hellospringdemo.model._6018;
import com.hellospringdemo.model._6019;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class _6019DaoImpl implements _6019Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<_6019> getLabSchedule() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from _6019");
        List<_6019> _6019 = query.list();
        session.flush();

        return _6019;
    }
}
