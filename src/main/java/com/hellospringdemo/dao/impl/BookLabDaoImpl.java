package com.hellospringdemo.dao.impl;

import com.hellospringdemo.dao.BookLabDao;
import com.hellospringdemo.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookLabDaoImpl implements BookLabDao {
    @Autowired
    private SessionFactory sessionFactory;


    public List<BookLab> getLabDetails() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BookLab");
        List<BookLab> labDetails = query.list();
        session.flush();

        return labDetails;
    }

    public void storeBookingDetails(BookLab bookLab) {

        Session session = sessionFactory.getCurrentSession();
        BookLab store = new BookLab();
        store.setLabNumber(bookLab.getLabNumber());
        store.setFaculty_Name(bookLab.getFaculty_Name());
        store.setDate(bookLab.getDate());
        store.setSubject(bookLab.getSubject());
        store.setStart_Time(bookLab.getStart_Time());
        store.setEnd_Time(bookLab.getEnd_Time());
        store.setPurpose(bookLab.getPurpose());
        store.setEmailID(bookLab.getEmailID());
        session.save(store);
        session.flush();

    }

    @Override
    public boolean timeClash(BookLab bookLab)
    {
        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();

        String query_from = "";
        query_from = "_"+bookLab.getLabNumber();
        Query query2 = session1.createQuery("from "+query_from);

        if(query_from.equals("_6017")) {
            List<_6017> labDetails = query2.list();

            for (_6017 details : labDetails) {
                if (details.getDate().equals(bookLab.getDate())) {
                    if (details.getDate().equals(bookLab.getDate())) {
                        String subject_and_time = "";
                        subject_and_time = details.getLab_Name_And_Time();
                        String[] arr = subject_and_time.split(";");
                        for (String j : arr) {
                            String[] s = new String[]{""};
                            s = j.split(",");
                            if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLab.getStart_Time()) || Integer.parseInt(bookLab.getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        else if(query_from.equals("_6018")) {
            List<_6018> labDetails = query2.list();

            for (_6018 details : labDetails) {
                if (details.getDate().equals(bookLab.getDate())) {
                    if (details.getDate().equals(bookLab.getDate())) {
                        String subject_and_time = "";
                        subject_and_time = details.getLab_Name_And_Time();
                        String[] arr = subject_and_time.split(";");
                        for (String j : arr) {
                            String[] s = new String[]{""};
                            s = j.split(",");
                            if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLab.getStart_Time()) || Integer.parseInt(bookLab.getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        else if(query_from.equals("_6019")) {
            List<_6019> labDetails = query2.list();

            for (_6019 details : labDetails) {
                if (details.getDate().equals(bookLab.getDate())) {
                    if (details.getDate().equals(bookLab.getDate())) {
                        String subject_and_time = "";
                        subject_and_time = details.getLab_Name_And_Time();
                        String[] arr = subject_and_time.split(";");
                        for (String j : arr) {
                            String[] s = new String[]{""};
                            s = j.split(",");
                            if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLab.getStart_Time()) || Integer.parseInt(bookLab.getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        session2.flush();
        return false;
    }
}
