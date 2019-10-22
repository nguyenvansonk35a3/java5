package edu.nguyenvanson.services.impl;

import edu.nguyenvanson.models.Department;
import edu.nguyenvanson.repositories.DepartmentRepository;
import edu.nguyenvanson.services.DepartmentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public List<Department> findAll(Sort sort) {
        return departmentRepository.findAll(sort);
    }

    public List<Department> findAllById(Iterable<String> itrbl) {
        return departmentRepository.findAllById(itrbl);
    }

    public <S extends Department> List<S> saveAll(Iterable<S> itrbl) {
        return departmentRepository.saveAll(itrbl);
    }

    public void flush() {
        departmentRepository.flush();
    }

    public <S extends Department> S saveAndFlush(S s) {
        return departmentRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Department> itrbl) {
        departmentRepository.deleteInBatch(itrbl);
    }

    public void deleteAllInBatch() {
        departmentRepository.deleteAllInBatch();
    }

    public Department getOne(String id) {
        return departmentRepository.getOne(id);
    }

    public <S extends Department> List<S> findAll(Example<S> exmpl) {
        return departmentRepository.findAll(exmpl);
    }

    public <S extends Department> List<S> findAll(Example<S> exmpl, Sort sort) {
        return departmentRepository.findAll(exmpl, sort);
    }

    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    public <S extends Department> S save(S s) {
        return departmentRepository.save(s);
    }

    public Optional<Department> findById(String id) {
        return departmentRepository.findById(id);
    }

    public boolean existsById(String id) {
        return departmentRepository.existsById(id);
    }

    public long count() {
        return departmentRepository.count();
    }

    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

    public void delete(Department t) {
        departmentRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends Department> itrbl) {
        departmentRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        departmentRepository.deleteAll();
    }

    public <S extends Department> Optional<S> findOne(Example<S> example) {
        return departmentRepository.findOne(example);
    }

    public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
        return departmentRepository.findAll(example, pageable);
    }

    public <S extends Department> long count(Example<S> example) {
        return departmentRepository.count(example);
    }

    public <S extends Department> boolean exists(Example<S> example) {
        return departmentRepository.exists(example);
    }

    
    

}
