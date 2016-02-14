package com.sayantan.action.controller;

/**
 * Created by USER on 14-02-2016.
 */

import java.util.ArrayList;
import java.util.List;

import com.sayantan.model.StudentModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class StudentDAO {

    @SessionTarget
    Session session;

    @TransactionTarget
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<StudentModel> getStudents()
    {
        List<StudentModel> students = new ArrayList<StudentModel>();
        try
        {
            students = session.createQuery("from StudentModel").list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(StudentModel student)
    {
        session.save(student);
    }
}