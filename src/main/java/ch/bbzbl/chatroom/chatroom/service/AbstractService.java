package ch.bbzbl.chatroom.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class AbstractService<T> {
    private final JpaRepository<T, Long> repository;
    protected AbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    public List<T> findAll() {
        return repository.findAll();
    }
    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public T save(T entity) {
        return repository.save(entity);
    }
    public void delete(T entity) {
        repository.delete(entity);
    }
}
