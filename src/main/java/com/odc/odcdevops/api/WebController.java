package com.odc.odcdevops.api;

import com.odc.odcdevops.entites.Student;
import com.odc.odcdevops.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping("")
    public String getStudents() {
        return "home.html";
    }
}
