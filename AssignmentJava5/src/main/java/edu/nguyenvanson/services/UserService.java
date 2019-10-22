package edu.nguyenvanson.services;

import edu.nguyenvanson.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UserService {

    long count();

    <S extends User> long count(Example<S> exmpl);

    void delete(User t);

    void deleteAll();

    void deleteAll(Iterable<? extends User> itrbl);

    void deleteAllInBatch();

    void deleteById(String id);

    void deleteInBatch(Iterable<User> itrbl);

    <S extends User> boolean exists(Example<S> exmpl);

    boolean existsById(String id);

    List<User> findAll();

    <S extends User> List<S> findAll(Example<S> exmpl);

    <S extends User> Page<S> findAll(Example<S> exmpl, Pageable pgbl);

    <S extends User> List<S> findAll(Example<S> exmpl, Sort sort);

    Page<User> findAll(Pageable pgbl);

    List<User> findAll(Sort sort);

    List<User> findAllById(Iterable<String> itrbl);

    Optional<User> findById(String id);

    <S extends User> Optional<S> findOne(Example<S> exmpl);

    void flush();

    User getOne(String id);

    <S extends User> S save(S s);

    <S extends User> List<S> saveAll(Iterable<S> itrbl);

    <S extends User> S saveAndFlush(S s);

}
