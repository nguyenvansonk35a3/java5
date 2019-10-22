package edu.nguyenvanson.services;

import edu.nguyenvanson.models.Record;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface RecordService {

    long count();

    <S extends Record> long count(Example<S> example);

    void delete(Record t);

    void deleteAll();

    void deleteAll(Iterable<? extends Record> itrbl);

    void deleteAllInBatch();

    void deleteById(String id);

    void deleteInBatch(Iterable<Record> itrbl);

    <S extends Record> boolean exists(Example<S> example);

    boolean existsById(String id);

    List<Record> findAll();

    <S extends Record> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Record> List<S> findAll(Example<S> exmpl);

    <S extends Record> List<S> findAll(Example<S> exmpl, Sort sort);

    Page<Record> findAll(Pageable pageable);

    List<Record> findAll(Sort sort);

    List<Record> findAllById(Iterable<String> itrbl);

    Optional<Record> findById(String id);

    <S extends Record> Optional<S> findOne(Example<S> example);

    void flush();

    Record getOne(String id);

    <S extends Record> S save(S s);

    <S extends Record> List<S> saveAll(Iterable<S> itrbl);

    <S extends Record> S saveAndFlush(S s);

}
