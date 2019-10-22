package edu.nguyenvanson.services.impl;

import edu.nguyenvanson.repositories.UserRepository;
import edu.nguyenvanson.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import edu.nguyenvanson.models.User;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    public List<User> findAllById(Iterable<String> itrbl) {
        return userRepository.findAllById(itrbl);
    }

    public <S extends User> List<S> saveAll(Iterable<S> itrbl) {
        return userRepository.saveAll(itrbl);
    }

    public void flush() {
        userRepository.flush();
    }

    public <S extends User> S saveAndFlush(S s) {
        return userRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<User> itrbl) {
        userRepository.deleteInBatch(itrbl);
    }

    public void deleteAllInBatch() {
        userRepository.deleteAllInBatch();
    }

    public User getOne(String id) {
        return userRepository.getOne(id);
    }

    public <S extends User> List<S> findAll(Example<S> exmpl) {
        return userRepository.findAll(exmpl);
    }

    public <S extends User> List<S> findAll(Example<S> exmpl, Sort sort) {
        return userRepository.findAll(exmpl, sort);
    }

    public Page<User> findAll(Pageable pgbl) {
        return userRepository.findAll(pgbl);
    }

    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public void delete(User t) {
        userRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends User> itrbl) {
        userRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public <S extends User> Optional<S> findOne(Example<S> exmpl) {
        return userRepository.findOne(exmpl);
    }

    public <S extends User> Page<S> findAll(Example<S> exmpl, Pageable pgbl) {
        return userRepository.findAll(exmpl, pgbl);
    }

    public <S extends User> long count(Example<S> exmpl) {
        return userRepository.count(exmpl);
    }

    public <S extends User> boolean exists(Example<S> exmpl) {
        return userRepository.exists(exmpl);
    }

}
