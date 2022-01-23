package com.hellospringdemo.dao;

import com.hellospringdemo.model.Approval;
import com.hellospringdemo.model.BookLab;

import java.util.List;

public interface ApprovalDao
{

    void approveBooking(Approval approval);
    boolean approveClash(Approval approval);
    void sendEmail(Approval approval);
}
