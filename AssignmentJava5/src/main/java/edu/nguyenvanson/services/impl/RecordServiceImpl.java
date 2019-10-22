
package edu.nguyenvanson.services.impl;

import edu.nguyenvanson.models.Record;
import edu.nguyenvanson.repositories.RecordRepository;
import edu.nguyenvanson.services.RecordService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService{
    
    @Autowired
    private RecordRepository recordRepository;

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public List<Record> findAll(Sort sort) {
        return recordRepository.findAll(sort);
    }

    public List<Record> findAllById(Iterable<String> itrbl) {
        return recordRepository.findAllById(itrbl);
    }

    public <S extends Record> List<S> saveAll(Iterable<S> itrbl) {
        return recordRepository.saveAll(itrbl);
    }

    public void flush() {
        recordRepository.flush();
    }

    public <S extends Record> S saveAndFlush(S s) {
        return recordRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Record> itrbl) {
        recordRepository.deleteInBatch(itrbl);
    }

    public void deleteAllInBatch() {
        recordRepository.deleteAllInBatch();
    }

    public Record getOne(String id) {
        return recordRepository.getOne(id);
    }

    public <S extends Record> List<S> findAll(Example<S> exmpl) {
        return recordRepository.findAll(exmpl);
    }

    public <S extends Record> List<S> findAll(Example<S> exmpl, Sort sort) {
        return recordRepository.findAll(exmpl, sort);
    }

    public Page<Record> findAll(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }

    public <S extends Record> S save(S s) {
        return recordRepository.save(s);
    }

    public Optional<Record> findById(String id) {
        return recordRepository.findById(id);
    }

    public boolean existsById(String id) {
        return recordRepository.existsById(id);
    }

    public long count() {
        return recordRepository.count();
    }

    public void deleteById(String id) {
        recordRepository.deleteById(id);
    }

    public void delete(Record t) {
        recordRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends Record> itrbl) {
        recordRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        recordRepository.deleteAll();
    }

    public <S extends Record> Optional<S> findOne(Example<S> example) {
        return recordRepository.findOne(example);
    }

    public <S extends Record> Page<S> findAll(Example<S> example, Pageable pageable) {
        return recordRepository.findAll(example, pageable);
    }

    public <S extends Record> long count(Example<S> example) {
        return recordRepository.count(example);
    }

    public <S extends Record> boolean exists(Example<S> example) {
        return recordRepository.exists(example);
    }
    
}
