package com.hellospringdemo.dao;
import com.hellospringdemo.model.BookLab;
import com.hellospringdemo.model.Datewise_details;


import java.util.List;

public interface BookLabDao {
    List<BookLab> getLabDetails();
    void storeBookingDetails(BookLab bookLab);
    boolean timeClash(BookLab bookLab);
}
