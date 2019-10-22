
package edu.nguyenvanson.services;

import edu.nguyenvanson.models.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



public interface DepartmentService {

    long count();

    <S extends Department> long count(Example<S> example);

    void delete(Department t);

    void deleteAll();

    void deleteAll(Iterable<? extends Department> itrbl);

    void deleteAllInBatch();

    void deleteById(String id);

    void deleteInBatch(Iterable<Department> itrbl);

    <S extends Department> boolean exists(Example<S> example);

    boolean existsById(String id);

    List<Department> findAll();

    <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Department> List<S> findAll(Example<S> exmpl);

    <S extends Department> List<S> findAll(Example<S> exmpl, Sort sort);

    Page<Department> findAll(Pageable pageable);

    List<Department> findAll(Sort sort);

    List<Department> findAllById(Iterable<String> itrbl);

    Optional<Department> findById(String id);

    <S extends Department> Optional<S> findOne(Example<S> example);

    void flush();

    Department getOne(String id);

    <S extends Department> S save(S s);

    <S extends Department> List<S> saveAll(Iterable<S> itrbl);

    <S extends Department> S saveAndFlush(S s);

    
}
