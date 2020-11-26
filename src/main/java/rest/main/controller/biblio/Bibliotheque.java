package rest.main.controller.biblio;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Bibliotheque implements IBibliotheque{
    List<Livre> livres;


    public Bibliotheque(){
        livres = new ArrayList<Livre>();
        livres.add(new Livre("9782809801439", "Le livre des choses perdues", "John Conolly"));
        livres.add(new Livre("9782298037883", "Elle s'appelait Sarah", "Tatiana de Rosnay"));
        livres.add(new Livre("9782355840708", "Je ne suis pas un sérial killer", "Dan Wells"));
    }

    @Override
    public List<Livre> findAll() {
        return livres;
    }

    private Livre findBook(String isbn){
        Livre ret = null;
        for (Livre l : livres){
            if (l.isIsbn(isbn)){
                ret = l;
            }
        }
        return ret;
    }

    @Override
    public Livre findByISBN(String isbn) {
        return  findBook(isbn);
    }

    @Override
    public void removeLivre(String isbn) {
        Livre ret = findBook(isbn);
        if (ret != null){
            livres.remove(ret);
        }
    }

    @Override
    public void addLivre(Livre livre) {
        this.livres.add(new Livre(livre));
    }

    @Override
    public void updateLivre(Livre l) {

        Livre ret = findBook(l.getIsbn());
        if (ret != null){
            ret.assign(l);
        }
    }
}
