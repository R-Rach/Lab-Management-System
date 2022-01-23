package com.hellospringdemo.dao.impl;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.hellospringdemo.dao.ApprovalDao;
import com.hellospringdemo.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class ApprovalDaoImpl implements ApprovalDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void approveBooking(Approval approval)
    {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BookLab");
        List<BookLab> bookLabs = query.list();
        session.flush();

        int booking_id = 0,index = 0,not_exist=1;
        for(BookLab labs: bookLabs)
        {
            if(Integer.parseInt(labs.getBookId())== Integer.parseInt(approval.getBookID()))
            {
                booking_id = index;
                not_exist=0;
            }
            index++;
        }

        String formatted_labnumber = "";
        formatted_labnumber = "_"+bookLabs.get(booking_id).getLabNumber();

        Approval store_this = new Approval();

        System.out.println(bookLabs.get(booking_id).getDate());

        store_this.setDate(bookLabs.get(booking_id).getDate());
        store_this.setSubject(bookLabs.get(booking_id).getSubject());
        store_this.setStart_time(bookLabs.get(booking_id).getStart_Time());
        store_this.setEnd_time(bookLabs.get(booking_id).getEnd_Time());
        store_this.setFaculty(bookLabs.get(booking_id).getFaculty_Name());



        if(formatted_labnumber.equals("_6017")) {
            Session session2 = sessionFactory.getCurrentSession();
            Query query2 = session2.createQuery("from " + formatted_labnumber);
            List<_6017> _6017 = query2.list();
            session.flush();



            int update_required = 0;
            for(_6017 data : _6017)
            {
                if(data.getDate().equals(bookLabs.get(booking_id).getDate()))
                {
                    update_required=1;
                    Session session3 = sessionFactory.getCurrentSession();
                    data.setDate(data.getDate());
                    data.setLab_Name_And_Time(data.getLab_Name_And_Time()+store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                    session3.update(data);
                    session3.flush();
                }
            }
            if(update_required==0)
            {
                com.hellospringdemo.model._6017 new_data = new _6017();

                System.out.println(bookLabs.get(booking_id).getDate());
                Session session4 = sessionFactory.getCurrentSession();
                new_data.setDate(bookLabs.get(booking_id).getDate());
                new_data.setLab_Name_And_Time(store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                session4.save(new_data);
                session4.flush();
            }
            if(not_exist==0)
            {
                Session session5 = sessionFactory.getCurrentSession();
                System.out.println(booking_id);
                session5.delete(bookLabs.get(booking_id));
                session5.flush();
            }
        }
        else if(formatted_labnumber.equals("_6018")) {
            Session session2 = sessionFactory.getCurrentSession();
            Query query2 = session2.createQuery("from " + formatted_labnumber);
            List<_6018> _6018 = query2.list();
            session.flush();



            int update_required = 0;
            for(_6018 data : _6018)
            {
                if(data.getDate().equals(bookLabs.get(booking_id).getDate()))
                {
                    update_required=1;
                    Session session3 = sessionFactory.getCurrentSession();
                    data.setDate(data.getDate());
                    data.setLab_Name_And_Time(data.getLab_Name_And_Time()+store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                    session3.update(data);
                    session3.flush();
                }
            }
            if(update_required==0)
            {
                com.hellospringdemo.model._6018 new_data = new _6018();

                System.out.println(bookLabs.get(booking_id).getDate());
                Session session4 = sessionFactory.getCurrentSession();
                new_data.setDate(bookLabs.get(booking_id).getDate());
                new_data.setLab_Name_And_Time(store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                session4.save(new_data);
                session4.flush();
            }
            if(not_exist==0)
            {
                Session session5 = sessionFactory.getCurrentSession();
                System.out.println(booking_id);
                session5.delete(bookLabs.get(booking_id));
                session5.flush();
            }
        }
        else if(formatted_labnumber.equals("_6019")) {
            Session session2 = sessionFactory.getCurrentSession();
            Query query2 = session2.createQuery("from " + formatted_labnumber);
            List<_6019> _6019 = query2.list();
            session.flush();



            int update_required = 0;
            for(_6019 data : _6019)
            {
                if(data.getDate().equals(bookLabs.get(booking_id).getDate()))
                {
                    update_required=1;
                    Session session3 = sessionFactory.getCurrentSession();
                    data.setDate(data.getDate());
                    data.setLab_Name_And_Time(data.getLab_Name_And_Time()+store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                    session3.update(data);
                    session3.flush();
                }
            }
            if(update_required==0)
            {
                com.hellospringdemo.model._6019 new_data = new _6019();

                System.out.println(bookLabs.get(booking_id).getDate());
                Session session4 = sessionFactory.getCurrentSession();
                new_data.setDate(bookLabs.get(booking_id).getDate());
                new_data.setLab_Name_And_Time(store_this.getSubject()+" ( "+store_this.getFaculty()+" ) "+","+store_this.getStart_time()+":00"+","+store_this.getEnd_time()+":00"+";");
                session4.save(new_data);
                session4.flush();
            }
            if(not_exist==0)
            {
                Session session5 = sessionFactory.getCurrentSession();
                System.out.println(booking_id);
                session5.delete(bookLabs.get(booking_id));
                session5.flush();
            }
        }
    }

    @Override
    public boolean approveClash(Approval approval)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BookLab");
        List<BookLab> bookLabs = query.list();
        session.flush();

        int booking_id = 0,index = 0,not_exist=1;
        for(BookLab labs: bookLabs)
        {
            if(Integer.parseInt(labs.getBookId())== Integer.parseInt(approval.getBookID()))
            {
                booking_id = index;
                not_exist=0;
            }
            index++;
        }


        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();

        String formatted_labnumber = "";
        formatted_labnumber = "_"+bookLabs.get(booking_id).getLabNumber();

        Query query2 = session1.createQuery("from "+formatted_labnumber);


        if(formatted_labnumber.equals("_6017")) {
            List<_6017> labDetails = query2.list();
            for (_6017 details : labDetails) {
                if (details.getDate().equals(bookLabs.get(booking_id).getDate())) {
                    String subject_and_time = "";
                    subject_and_time = details.getLab_Name_And_Time();
                    String[] arr = subject_and_time.split(";");
                    for (String j : arr) {
                        String[] s = new String[]{""};
                        s = j.split(",");
                        if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLabs.get(booking_id).getStart_Time()) || Integer.parseInt(bookLabs.get(booking_id).getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                            Session session5 = sessionFactory.getCurrentSession();
                            System.out.println(booking_id);
                            session5.delete(bookLabs.get(booking_id));
                            session5.flush();
                            return true;
                        }
                    }
                }
            }
        }
        else if(formatted_labnumber.equals("_6018"))
        {
        List<_6018> labDetails = query2.list();
        for (_6018 details : labDetails) {
            if (details.getDate().equals(bookLabs.get(booking_id).getDate())) {
                String subject_and_time = "";
                subject_and_time = details.getLab_Name_And_Time();
                String[] arr = subject_and_time.split(";");
                for (String j : arr) {
                    String[] s = new String[]{""};
                    s = j.split(",");
                    if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLabs.get(booking_id).getStart_Time()) || Integer.parseInt(bookLabs.get(booking_id).getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                        Session session5 = sessionFactory.getCurrentSession();
                        System.out.println(booking_id);
                        session5.delete(bookLabs.get(booking_id));
                        session5.flush();
                        return true;
                    }
                }
            }
        }
    }
        else if(formatted_labnumber.equals("_6019"))
        {
            List<_6019> labDetails = query2.list();
            for (_6019 details : labDetails) {
                if (details.getDate().equals(bookLabs.get(booking_id).getDate())) {
                    String subject_and_time = "";
                    subject_and_time = details.getLab_Name_And_Time();
                    String[] arr = subject_and_time.split(";");
                    for (String j : arr) {
                        String[] s = new String[]{""};
                        s = j.split(",");
                        if (!(Integer.parseInt(s[2].split(":")[0]) <= Integer.parseInt(bookLabs.get(booking_id).getStart_Time()) || Integer.parseInt(bookLabs.get(booking_id).getEnd_Time()) <= Integer.parseInt(s[1].split(":")[0]))) {
                            Session session5 = sessionFactory.getCurrentSession();
                            System.out.println(booking_id);
                            session5.delete(bookLabs.get(booking_id));
                            session5.flush();
                            return true;
                        }
                    }
                }
            }
        }

        session2.flush();
        return false;
    }

    @Override
    public void sendEmail(Approval approval)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BookLab");
        List<BookLab> bookLabs = query.list();
        session.flush();

        int booking_id = 0,index = 0,not_exist=1;
        for(BookLab labs: bookLabs)
        {
            if(Integer.parseInt(labs.getBookId())== Integer.parseInt(approval.getBookID()))
            {
                booking_id = index;
                not_exist=0;
            }
            index++;
        }

        String host="smtp.gmail.com";
        final String user="ipclabbooking@gmail.com";//change accordingly
        final String password="HOPEhope1!";//change accordingly

        System.out.println(bookLabs.get(booking_id).getEmailID());

        String to=bookLabs.get(booking_id).getEmailID();//change accordingly

        if(!to.isEmpty()) {//Get the session object
            Properties props = new Properties();

            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.debug", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            javax.mail.Session sess = javax.mail.Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(user, password);
                        }
                    });

            //Compose the message
            try {
                MimeMessage message = new MimeMessage(sess);
                message.setFrom(new InternetAddress(user));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("IPC Lab Booking Confirmation");
                String date = "";
                date  = bookLabs.get(booking_id).getDate();
                String formatted_date = "";
                formatted_date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);

                String formatted_start_time = "";
                if(Integer.parseInt(bookLabs.get(booking_id).getStart_Time())>12)
                {
                    formatted_start_time = Integer.toString(Integer.parseInt(bookLabs.get(booking_id).getStart_Time())-12)+"PM";
                }
                else
                {
                    formatted_start_time = Integer.toString(Integer.parseInt(bookLabs.get(booking_id).getStart_Time()))+"AM";
                }

                String formatted_end_time = "";
                if(Integer.parseInt(bookLabs.get(booking_id).getEnd_Time())>12)
                {
                    formatted_end_time = Integer.toString(Integer.parseInt(bookLabs.get(booking_id).getEnd_Time())-12)+"PM";
                }
                else
                {
                    formatted_end_time = Integer.toString(Integer.parseInt(bookLabs.get(booking_id).getEnd_Time()))+"AM";
                }

                message.setText("Hello "+bookLabs.get(booking_id).getFaculty_Name()+"\n\n"+"Your booking for "+bookLabs.get(booking_id).getSubject()+" in Lab "+bookLabs.get(booking_id).getLabNumber()+" from "+formatted_start_time+" to "+formatted_end_time+" on "+formatted_date+" has been confirmed. "+"\n Thank You");

                //send the message
                Transport.send(message);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}
