package com.wzy.repository;

import com.wzy.entity.Student;

import java.util.Collection;


/**
 * @author Clarence1
 */
public interface StudentRepository {

    public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);

}
