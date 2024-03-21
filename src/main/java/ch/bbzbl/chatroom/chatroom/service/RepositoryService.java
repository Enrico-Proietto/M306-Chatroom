package ch.bbzbl.chatroom.chatroom.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class RepositoryService<T> {
    private final JpaRepository<T, Long> repository;
    protected RepositoryService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    public List<T> findAll() {
        return repository.findAll();
    }
    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void save(T entity) {
        repository.save(entity);
    }
    public void delete(T entity) {
        repository.delete(entity);
    }

}
