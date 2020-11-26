package main.processor.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROCESSOR")
public class Processor {

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private int core;
    private int thread;

    protected Processor(){}

    public Processor(String name, int core, int thread) {
        this.nom = name;
        this.core = core;
        this.thread = thread;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }
}
