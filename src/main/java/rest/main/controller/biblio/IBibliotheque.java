package rest.main.controller.biblio;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBibliotheque {
    public List<Livre> findAll();
    public Livre findByISBN(String isbn);
    public void removeLivre(String isbn);
    public void addLivre(Livre livre);
    public void updateLivre(Livre l);
}
