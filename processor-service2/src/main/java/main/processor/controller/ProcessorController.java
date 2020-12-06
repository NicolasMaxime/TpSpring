package main.processor.controller;

import main.processor.dao.ProcessorDAO;
import main.processor.entity.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @RequestMapping(value= "/processors", produces ="application/json", method=RequestMethod.POST)
    public Processor addProcessor(@RequestBody Processor p){
        processorDAO.save(p);
        return p;
    }

    @RequestMapping(value= "/processors", produces ="application/json", method=RequestMethod.PUT)
    public Processor updateProcessor(@RequestBody Processor p){
        Processor tmp = processorDAO.findById(p.getId());
        tmp.setNom(p.getNom());
        tmp.setCore(p.getCore());
        tmp.setThread(p.getThread());
        processorDAO.save(tmp);
        return p;
    }

   @Value("${me}")
    private String me;

    @GetMapping(value="/Cestqui")
    public String getName(){
        return me;
    }
}
