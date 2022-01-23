package com.hellospringdemo.dao.impl;
import com.hellospringdemo.dao.LabDetailDao;
import com.hellospringdemo.model.BookLab;
import com.hellospringdemo.model.LabDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LabDetailDaoImpl implements LabDetailDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<LabDetail> getLabDetails() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from LabDetail");
        List<LabDetail> labDetails = query.list();
        session.flush();
        return labDetails;
    }

    public void setLabDetails(LabDetail labDetails)
    {
        Session session = sessionFactory.getCurrentSession();
        LabDetail store = new LabDetail();
        store.setLab_Number(labDetails.getLab_Number());
        store.setLab_Name(labDetails.getLab_Name());
        store.setNumber_Of_Systems(labDetails.getNumber_Of_Systems());
        store.setProcessor(labDetails.getProcessor());
        store.setRam(labDetails.getRam());
        store.setSoftwares(labDetails.getSoftwares());
        session.saveOrUpdate(store);
        session.flush();
    }

}
