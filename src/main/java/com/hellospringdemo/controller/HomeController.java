package com.hellospringdemo.controller;

import com.hellospringdemo.dao.*;
import com.hellospringdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LabDetailDao labDetailDao;
    @Autowired
    private _6017Dao    _6017dao;
    @Autowired
    private BookLabDao bookLabDao;

    @Autowired
    private _6018Dao _6018dao;

    @Autowired
    private _6019Dao _6019dao;

    @Autowired
    private ApprovalDao approvalDao;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("lab_resources")
    public String lab5(Model model) {
        List<LabDetail> labDetails = labDetailDao.getLabDetails();
        model.addAttribute("labDetails", labDetails);
        return "lab_resources";
    }

    @RequestMapping("all_requests")
    public ModelAndView  allreq(Model model) {
        List<BookLab> labRequests = bookLabDao.getLabDetails();
        model.addAttribute("labrequests", labRequests);
        return new ModelAndView("all_requests","approve",new Approval());
    }

    @RequestMapping(value="/approve_request",method = RequestMethod.POST)
    public String approve(@ModelAttribute("approve") Approval approval,Model model)
    {
        System.out.println(approval.getBookID());
        if(!approvalDao.approveClash(approval))
        {
            approvalDao.sendEmail(approval);
            approvalDao.approveBooking(approval);
            return "/approval_complete";
        }
        else {

            return "/approval_incomplete";
        }
    }

    @RequestMapping("6017")
    public ModelAndView  date(Model model)
    {
        return new ModelAndView("6017","date",  new Datewise_details());
    }

    @RequestMapping(value ="/6017_schedule",method = RequestMethod.POST)
    public String get6017Schedule(@ModelAttribute("date")Datewise_details details, Model model) throws ParseException {
        int invalid_date = 1;
        List<_6017> Schedule_6017 = _6017dao.getLabSchedule();
        _6017 found = new _6017();
        String ddate = details.getDate();
        System.out.println(ddate);
        String[] new_date = new String[]{""};
        new_date = ddate.split("-");

        String date = "";
        date = new_date[2]+new_date[1]+new_date[0];

        for(_6017 i : Schedule_6017)
        {
            if(i.getDate().equals(date))
            {
                found = i;
                invalid_date = 0;
                break;
            }
        }
        if(invalid_date==0)
        {

            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            String formatted_date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
            System.out.println(formatted_date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
            Date myDate = sdf.parse(formatted_date);
            sdf.applyPattern("EEE, d MMM yyyy");
            String sMyDate = sdf.format(myDate);

            String subject_and_time = "";
            subject_and_time = found.getLab_Name_And_Time();
            String[] arr = subject_and_time.split(";");
            for (String j : arr)
            {
                Datewise_details datewise_details = new Datewise_details();
                datewise_details.setDate(sMyDate);
                String[] s = new String[]{""};
                s = j.split(",");
                datewise_details.setSubject(s[0]);
                datewise_details.setStart_time(s[1]);
                datewise_details.setEnd_time(s[2]);
                details_arr.add(datewise_details);
            }


            for(Datewise_details d : details_arr)
            {
                System.out.println(d.getSubject());
                System.out.println(d.getDate());
                System.out.println(d.getStart_time());
                System.out.println(d.getEnd_time());
            }


            System.out.println("\n\n");

            model.addAttribute("Schedule_6017", details_arr);
        }
        else
        {
            Datewise_details datewise_details = new Datewise_details();
            datewise_details.setDate("No data found ! Select Date");
            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            details_arr.add(datewise_details);
            model.addAttribute("Schedule_6017", details_arr);
        }
        return "/6017";
    }

    @RequestMapping("6018")
    public ModelAndView  date6018(Model model)
    {
        return new ModelAndView("6018","date6018",  new Datewise_details());
    }


    @RequestMapping(value ="/6018_schedule",method = RequestMethod.POST)
    public String get6018Schedule(@ModelAttribute("date6018")Datewise_details details, Model model) throws ParseException {
        int invalid_date = 1;
        List<_6018> Schedule_6018 = _6018dao.getLabSchedule();
        _6018 found = new _6018();
        String ddate = details.getDate();
        System.out.println(ddate);
        String[] new_date = new String[]{""};
        new_date = ddate.split("-");

        String date = "";
        date = new_date[2]+new_date[1]+new_date[0];

        for(_6018 i : Schedule_6018)
        {
            if(i.getDate().equals(date))
            {
                found = i;
                invalid_date = 0;
                break;
            }
        }
        if(invalid_date==0)
        {

            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            String formatted_date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
            System.out.println(formatted_date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
            Date myDate = sdf.parse(formatted_date);
            sdf.applyPattern("EEE, d MMM yyyy");
            String sMyDate = sdf.format(myDate);

            String subject_and_time = "";
            subject_and_time = found.getLab_Name_And_Time();
            String[] arr = subject_and_time.split(";");
            for (String j : arr)
            {
                Datewise_details datewise_details = new Datewise_details();
                datewise_details.setDate(sMyDate);
                String[] s = new String[]{""};
                s = j.split(",");
                datewise_details.setSubject(s[0]);
                datewise_details.setStart_time(s[1]);
                datewise_details.setEnd_time(s[2]);
                details_arr.add(datewise_details);
            }


            for(Datewise_details d : details_arr)
            {
                System.out.println(d.getSubject());
                System.out.println(d.getDate());
                System.out.println(d.getStart_time());
                System.out.println(d.getEnd_time());
            }


            System.out.println("\n\n");

            model.addAttribute("Schedule_6018", details_arr);
        }
        else
        {
            Datewise_details datewise_details = new Datewise_details();
            datewise_details.setDate("No data found ! Select Date");
            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            details_arr.add(datewise_details);
            model.addAttribute("Schedule_6018", details_arr);
        }
        return "/6018";
    }

    @RequestMapping("6019")
    public ModelAndView  date6019(Model model)
    {
        return new ModelAndView("6019","date6019",  new Datewise_details());
    }


    @RequestMapping(value ="/6019_schedule",method = RequestMethod.POST)
    public String get6019Schedule(@ModelAttribute("date6019")Datewise_details details, Model model) throws ParseException {
        int invalid_date = 1;
        List<_6019> Schedule_6019 = _6019dao.getLabSchedule();
        _6019 found = new _6019();
        String ddate = details.getDate();
        System.out.println(ddate);
        String[] new_date = new String[]{""};
        new_date = ddate.split("-");

        String date = "";
        date = new_date[2]+new_date[1]+new_date[0];

        for(_6019 i : Schedule_6019)
        {
            if(i.getDate().equals(date))
            {
                found = i;
                invalid_date = 0;
                break;
            }
        }
        if(invalid_date==0)
        {

            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            String formatted_date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
            System.out.println(formatted_date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
            Date myDate = sdf.parse(formatted_date);
            sdf.applyPattern("EEE, d MMM yyyy");
            String sMyDate = sdf.format(myDate);

            String subject_and_time = "";
            subject_and_time = found.getLab_Name_And_Time();
            String[] arr = subject_and_time.split(";");
            for (String j : arr)
            {
                Datewise_details datewise_details = new Datewise_details();
                datewise_details.setDate(sMyDate);
                String[] s = new String[]{""};
                s = j.split(",");
                datewise_details.setSubject(s[0]);
                datewise_details.setStart_time(s[1]);
                datewise_details.setEnd_time(s[2]);
                details_arr.add(datewise_details);
            }


            for(Datewise_details d : details_arr)
            {
                System.out.println(d.getSubject());
                System.out.println(d.getDate());
                System.out.println(d.getStart_time());
                System.out.println(d.getEnd_time());
            }


            System.out.println("\n\n");

            model.addAttribute("Schedule_6019", details_arr);
        }
        else
        {
            Datewise_details datewise_details = new Datewise_details();
            datewise_details.setDate("No data found ! Select Date");
            ArrayList<Datewise_details> details_arr = new ArrayList<>();
            details_arr.add(datewise_details);
            model.addAttribute("Schedule_6019", details_arr);
        }
        return "/6019";
    }

    @RequestMapping("AddLabResources")
    public ModelAndView showlabform(Model model)
    {
        ArrayList<String> labs = new ArrayList<>();
        ArrayList<String> ram = new ArrayList<>();
        ArrayList<String> processor = new ArrayList<>();

        labs.add("6017");
        labs.add("6018");
        labs.add("6019");

        ram.add("4GB");
        ram.add("8GB");
        ram.add("16GB");
        ram.add("32GB");

        processor.add("Intel Core i3");
        processor.add("Intel Core i5");
        processor.add("Intel Core i7");

        model.addAttribute("labs", labs);
        model.addAttribute("ram",ram);
        model.addAttribute("processor",processor);

        //command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("AddLabResources","labresources",new LabDetail());
    }

    @RequestMapping(value="/update_lab",method = RequestMethod.POST)
    public String save(@ModelAttribute("labresources") LabDetail labDetail,Model model)
    {
        labDetailDao.setLabDetails(labDetail);
        return "details_added";
    }

    @RequestMapping("/details_added")
    public String added_completion(){
        return "details_added";
    }

        @RequestMapping("BookLab")
    public ModelAndView showform(Model model)
    {
        ArrayList<String> timings = new ArrayList<>();
        for(int i=8;i<24;i++)
        {
            timings.add(Integer.toString(i));
        }
        model.addAttribute("timings", timings);
        //command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("BookLab","command",new BookLab());
    }

    @RequestMapping(value="/book_request",method = RequestMethod.POST)
    public String save(@ModelAttribute("book") BookLab bookLab,Model model)
    {
        BookLab lab_data = new BookLab();
        String[] date = new String[]{""};
        date = bookLab.getDate().split("-");
        String formatted_date = date[2]+date[1]+date[0];

        lab_data.setLabNumber(bookLab.getLabNumber());
        lab_data.setPurpose(bookLab.getPurpose());
        lab_data.setFaculty_Name(bookLab.getFaculty_Name());
        lab_data.setSubject(bookLab.getSubject());
        lab_data.setDate(formatted_date);
        lab_data.setEnd_Time(bookLab.getEnd_Time());
        lab_data.setStart_Time(bookLab.getStart_Time());
        lab_data.setEmailID(bookLab.getEmailID());

        if(bookLab.getEmailID().startsWith("h2"))
        {
            return "book_request_incomplete";
        }
        if(bookLabDao.timeClash(lab_data))
        {
            System.out.println("Time Clash");
            return "book_request_incomplete";
        }
        else
        {
            System.out.println("No time clash");
            bookLabDao.storeBookingDetails(lab_data);
            return "book_request_complete";

        }
    }

    @RequestMapping("/book_request_complete")
    public String request_completion(){
        return "book_request_complete";
    }

    @RequestMapping("/book_request_incomplete")
    public String request_incompletion(){
        return "book_request_incomplete";
    }

}
