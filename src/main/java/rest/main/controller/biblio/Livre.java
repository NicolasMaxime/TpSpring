package rest.main.controller.biblio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
    private String isbn;
    private String titre;
    private String author;
    private String id;

    protected Livre(){}

    public Livre(String isb, String titre, String author){
        this.isbn = isb;
        this.titre = titre;
        this.author = author;
    }

    public Livre(Livre livre) {
        this.isbn = livre.getIsbn();
        this.titre = livre.getTitre();
        this.author = livre.getAuthor();
    }

    public boolean isIsbn(String isbn){
        boolean ret = false;

        if (this.isbn.equals(isbn)){
            ret = true;
        }
        return ret;
    }

    public boolean equals(Livre livre){
        boolean ret = true;

        if (!livre.isIsbn(this.isbn)){
            ret = false;
        }
        if (!livre.getAuthor().equals(this.author)){
            ret = false;
        }
        if (!livre.getTitre().equals(this.titre)){
            ret = false;
        }
        return ret;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void assign(Livre l) {
        if (l.getTitre() != null)
            this.titre = l.getTitre();
        if (l.getAuthor() != null)
            this.author = l.getAuthor();
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
}
