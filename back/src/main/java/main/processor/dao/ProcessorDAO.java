package main.processor.dao;

import main.processor.entity.Processor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessorDAO extends CrudRepository<Processor, Integer> {

    List<Processor> findByNom(String nom);
    void deleteById(int id);
    Processor findById(int id);
}
