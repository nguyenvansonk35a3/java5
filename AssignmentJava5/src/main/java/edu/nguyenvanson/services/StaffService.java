package edu.nguyenvanson.services;

import edu.nguyenvanson.models.Staff;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface StaffService {

    long count();

    <S extends Staff> long count(Example<S> exmpl);

    void delete(Staff t);

    void deleteAll();

    void deleteAll(Iterable<? extends Staff> itrbl);

    void deleteAllInBatch();

    void deleteById(String id);

    void deleteInBatch(Iterable<Staff> itrbl);

    <S extends Staff> boolean exists(Example<S> exmpl);

    boolean existsById(String id);

    List<Staff> findAll();

    <S extends Staff> List<S> findAll(Example<S> exmpl);

    <S extends Staff> Page<S> findAll(Example<S> exmpl, Pageable pgbl);

    <S extends Staff> List<S> findAll(Example<S> exmpl, Sort sort);

    Page<Staff> findAll(Pageable pgbl);

    List<Staff> findAll(Sort sort);

    List<Staff> findAllById(Iterable<String> itrbl);

    Optional<Staff> findById(String id);

    <S extends Staff> Optional<S> findOne(Example<S> exmpl);

    void flush();

    Staff getOne(String id);

    <S extends Staff> S save(S s);

    <S extends Staff> List<S> saveAll(Iterable<S> itrbl);

    <S extends Staff> S saveAndFlush(S s);
    
    
    
    
}
