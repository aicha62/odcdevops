/*package com.odc.odcdevops.services;

import com.odc.odcdevops.entites.Student;
import com.odc.odcdevops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServices {
    @Autowired
    private StudentRepository sRepository;
    //c
    public  Student createStudent(Student st){
        return sRepository.save(st);
    }
    //R
    public List<Student> findStudent(){
        return sRepository.findAll();
    }

    //U

    public  Student updateStudent(Student student){
        return null;
    }
    // D
    public String deleteStudentById(){
    return "";
    }
}*/
package com.odc.odcdevops.services;

import com.odc.odcdevops.entites.Student;
import com.odc.odcdevops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository sRepository;

    // C : création
    public Student createStudent(Student st) {
        Date now = new Date();
        st.setCreateDate(now);
        st.setUpdateDate(now);
        return sRepository.save(st);
    }

    // R : lecture de tous les étudiants
    public List<Student> findStudent() {
        return sRepository.findAll();
    }

    // R : lecture d'un étudiant par son matricule
    public Student findStudentById(Long id) {
        return sRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Etudiant introuvable : " + id));
    }

    // U : mise à jour
    public Student updateStudent(Long id, Student student) {
        Student existing = findStudentById(id);
        existing.setPrenom(student.getPrenom());
        existing.setNom(student.getNom());
        existing.setAdresse(student.getAdresse());
        existing.setDatNaissance(student.getDatNaissance());
        existing.setUpdateDate(new Date());
        return sRepository.save(existing);
    }

    // D : suppression
    public String deleteStudentById(Long id) {
        Student existing = findStudentById(id);
        sRepository.delete(existing);
        return "Etudiant " + id + " supprimé avec succès";
    }
}

