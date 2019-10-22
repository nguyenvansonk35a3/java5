/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nguyenvanson.services;

import edu.nguyenvanson.models.SparePart;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author son so
 */
public interface SparePartService {

    long count();

    <S extends SparePart> long count(Example<S> example);

    void delete(SparePart t);

    void deleteAll();

    void deleteAll(Iterable<? extends SparePart> itrbl);

    void deleteAllInBatch();

    void deleteById(String id);

    void deleteInBatch(Iterable<SparePart> itrbl);

    <S extends SparePart> boolean exists(Example<S> example);

    boolean existsById(String id);

    List<SparePart> findAll();

    <S extends SparePart> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends SparePart> List<S> findAll(Example<S> exmpl);

    <S extends SparePart> List<S> findAll(Example<S> exmpl, Sort sort);

    Page<SparePart> findAll(Pageable pageable);

    List<SparePart> findAll(Sort sort);

    List<SparePart> findAllById(Iterable<String> itrbl);

    Optional<SparePart> findById(String id);

    <S extends SparePart> Optional<S> findOne(Example<S> example);

    void flush();

    SparePart getOne(String id);

    <S extends SparePart> S save(S s);

    <S extends SparePart> List<S> saveAll(Iterable<S> itrbl);

    <S extends SparePart> S saveAndFlush(S s);
    
}
