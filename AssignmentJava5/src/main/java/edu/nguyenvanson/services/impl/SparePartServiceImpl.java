/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nguyenvanson.services.impl;

import edu.nguyenvanson.models.SparePart;
import edu.nguyenvanson.repositories.SparePartRepository;
import edu.nguyenvanson.services.SparePartService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author son so
 */
@Service
public class SparePartServiceImpl implements SparePartService{
    
    @Autowired
    private SparePartRepository sparePartRepository;

    public List<SparePart> findAll() {
        return sparePartRepository.findAll();
    }

    public List<SparePart> findAll(Sort sort) {
        return sparePartRepository.findAll(sort);
    }

    public List<SparePart> findAllById(Iterable<String> itrbl) {
        return sparePartRepository.findAllById(itrbl);
    }

    public <S extends SparePart> List<S> saveAll(Iterable<S> itrbl) {
        return sparePartRepository.saveAll(itrbl);
    }

    public void flush() {
        sparePartRepository.flush();
    }

    public <S extends SparePart> S saveAndFlush(S s) {
        return sparePartRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<SparePart> itrbl) {
        sparePartRepository.deleteInBatch(itrbl);
    }

    public void deleteAllInBatch() {
        sparePartRepository.deleteAllInBatch();
    }

    public SparePart getOne(String id) {
        return sparePartRepository.getOne(id);
    }

    public <S extends SparePart> List<S> findAll(Example<S> exmpl) {
        return sparePartRepository.findAll(exmpl);
    }

    public <S extends SparePart> List<S> findAll(Example<S> exmpl, Sort sort) {
        return sparePartRepository.findAll(exmpl, sort);
    }

    public Page<SparePart> findAll(Pageable pageable) {
        return sparePartRepository.findAll(pageable);
    }

    public <S extends SparePart> S save(S s) {
        return sparePartRepository.save(s);
    }

    public Optional<SparePart> findById(String id) {
        return sparePartRepository.findById(id);
    }

    public boolean existsById(String id) {
        return sparePartRepository.existsById(id);
    }

    public long count() {
        return sparePartRepository.count();
    }

    public void deleteById(String id) {
        sparePartRepository.deleteById(id);
    }

    public void delete(SparePart t) {
        sparePartRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends SparePart> itrbl) {
        sparePartRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        sparePartRepository.deleteAll();
    }

    public <S extends SparePart> Optional<S> findOne(Example<S> example) {
        return sparePartRepository.findOne(example);
    }

    public <S extends SparePart> Page<S> findAll(Example<S> example, Pageable pageable) {
        return sparePartRepository.findAll(example, pageable);
    }

    public <S extends SparePart> long count(Example<S> example) {
        return sparePartRepository.count(example);
    }

    public <S extends SparePart> boolean exists(Example<S> example) {
        return sparePartRepository.exists(example);
    }
    
}
