package com.sayantan.action;

/**
 * Created by USER on 14-02-2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sayantan.model.StudentModel;
import com.sayantan.action.controller.StudentDAO;

public class AddStudentAction extends ActionSupport
        implements ModelDriven<StudentModel>{

    StudentModel student  = new StudentModel();
    List<StudentModel> students = new ArrayList<StudentModel>();
    StudentDAO dao = new StudentDAO();
    @Override
    public StudentModel getModel() {
        return student;
    }

    public String execute()
    {
        dao.addStudent(student);
        return "success";
    }

    public String listStudents()
    {
        students = dao.getStudents();
        return "success";
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

}