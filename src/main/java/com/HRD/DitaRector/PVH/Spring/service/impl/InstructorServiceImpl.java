package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.repository.InstructorRespository;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;

public class InstructorServiceImpl implements InstructorService {
    private final InstructorRespository instructorRespository;

    public InstructorServiceImpl(InstructorRespository instructorRespository){
        this.instructorRespository = instructorRespository;
    }



}
