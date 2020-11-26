package main.processor.controller;

import main.processor.dao.ProcessorDAO;
import main.processor.entity.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcessorController {
    @Autowired
    private ProcessorDAO processorDAO;

    @GetMapping(value = "/processors")
    public List<Processor> getAllprocessor(){
        return (List<Processor>) processorDAO.findAll();
    }

    @GetMapping(value = "/processors/{id}")
    public Processor getProcessor(@PathVariable int id){
        return processorDAO.findById(id);
    }


    @DeleteMapping(value = "/processors/{id}")
    public void deleteProcessor(@PathVariable int id){
        processorDAO.deleteById(id);
    }

    @PostMapping(value = "/processors/")
    public void addProcessor(@RequestBody Processor p){
        processorDAO.save(p);
    }

}
