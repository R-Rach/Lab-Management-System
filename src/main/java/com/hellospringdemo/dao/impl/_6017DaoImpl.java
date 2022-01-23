package com.hellospringdemo.dao.impl;

import com.hellospringdemo.dao.LabDetailDao;
import com.hellospringdemo.dao._6017Dao;
import com.hellospringdemo.model.LabDetail;
import com.hellospringdemo.model._6017;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
 @Repository
 @Transactional
 public class _6017DaoImpl implements _6017Dao {

     @Autowired
     private SessionFactory sessionFactory;

     @Override
     public List<_6017> getLabSchedule() {

         Session session = sessionFactory.getCurrentSession();
         Query query = session.createQuery("from _6017");
         List<_6017> _6017 = query.list();
         session.flush();

         return _6017;
     }
 }
