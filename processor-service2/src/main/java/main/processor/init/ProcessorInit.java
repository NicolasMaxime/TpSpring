package main.processor.init;

import main.processor.ProcessorApplication;
import main.processor.dao.ProcessorDAO;
import main.processor.entity.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProcessorInit implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(ProcessorApplication.class);
    private ProcessorDAO processorDAO;

    @Autowired
    public ProcessorInit(ProcessorDAO processorDAO){
        this.processorDAO = processorDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        processorDAO.save(new Processor("AMD Ryzen 3 3100", 4, 8));
        processorDAO.save(new Processor("AMD Ryzen 5 3400", 4, 8));
        processorDAO.save(new Processor("Intel Core i9 10850K", 10, 20));

        for (Processor p : processorDAO.findAll()){
            log.info(p.toString());
        }
    }
}
