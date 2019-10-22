package edu.nguyenvanson.services.impl;

import edu.nguyenvanson.models.Staff;
import edu.nguyenvanson.repositories.StaffRepository;
import edu.nguyenvanson.services.StaffService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public List<Staff> findAll(Sort sort) {
        return staffRepository.findAll(sort);
    }

    public List<Staff> findAllById(Iterable<String> itrbl) {
        return staffRepository.findAllById(itrbl);
    }

    public <S extends Staff> List<S> saveAll(Iterable<S> itrbl) {
        return staffRepository.saveAll(itrbl);
    }

    public void flush() {
        staffRepository.flush();
    }

    public <S extends Staff> S saveAndFlush(S s) {
        return staffRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Staff> itrbl) {
        staffRepository.deleteInBatch(itrbl);
    }

    public void deleteAllInBatch() {
        staffRepository.deleteAllInBatch();
    }

    public Staff getOne(String id) {
        return staffRepository.getOne(id);
    }

    public <S extends Staff> List<S> findAll(Example<S> exmpl) {
        return staffRepository.findAll(exmpl);
    }

    public <S extends Staff> List<S> findAll(Example<S> exmpl, Sort sort) {
        return staffRepository.findAll(exmpl, sort);
    }

    public Page<Staff> findAll(Pageable pgbl) {
        return staffRepository.findAll(pgbl);
    }

    public <S extends Staff> S save(S s) {
        return staffRepository.save(s);
    }

    public Optional<Staff> findById(String id) {
        return staffRepository.findById(id);
    }

    public boolean existsById(String id) {
        return staffRepository.existsById(id);
    }

    public long count() {
        return staffRepository.count();
    }

    public void deleteById(String id) {
        staffRepository.deleteById(id);
    }

    public void delete(Staff t) {
        staffRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends Staff> itrbl) {
        staffRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }

    public <S extends Staff> Optional<S> findOne(Example<S> exmpl) {
        return staffRepository.findOne(exmpl);
    }

    public <S extends Staff> Page<S> findAll(Example<S> exmpl, Pageable pgbl) {
        return staffRepository.findAll(exmpl, pgbl);
    }

    public <S extends Staff> long count(Example<S> exmpl) {
        return staffRepository.count(exmpl);
    }

    public <S extends Staff> boolean exists(Example<S> exmpl) {
        return staffRepository.exists(exmpl);
    }
    
    
}
