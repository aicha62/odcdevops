/* package com.odc.odcdevops.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Students")

public class StudentApi {
}*/
package com.odc.odcdevops.api;

import com.odc.odcdevops.entites.Student;
import com.odc.odcdevops.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Students")
public class StudentApi {

    @Autowired
    private StudentServices studentServices;

    // POST /Students
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        return studentServices.createStudent(student);
    }

    // GET /Students
    @GetMapping
    public List<Student> findAll() {
        return studentServices.findStudent();
    }

    // GET /Students/{id}
    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentServices.findStudentById(id);
    }

    // PUT /Students/{id}
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentServices.updateStudent(id, student);
    }

    // DELETE /Students/{id}
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return studentServices.deleteStudentById(id);
    }
}
