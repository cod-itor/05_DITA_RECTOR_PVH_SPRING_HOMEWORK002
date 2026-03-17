package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.repository.InstructorRespository;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }



}
