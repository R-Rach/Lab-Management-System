package com.hellospringdemo.dao;

import com.hellospringdemo.model.LabDetail;
import java.util.List;

public interface LabDetailDao {

    List<LabDetail> getLabDetails();
    void setLabDetails(LabDetail labDetails);
}
