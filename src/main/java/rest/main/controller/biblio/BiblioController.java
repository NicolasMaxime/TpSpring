package rest.main.controller.biblio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BiblioController {

    @Autowired
    private IBibliotheque bibliotheque;

    @GetMapping(value="/Livres")
    public List<Livre> getAllLivre(){
        return bibliotheque.findAll();
    }

    @GetMapping(value = "/Livres/{isbn}")
    public Livre getLivre(@PathVariable String isbn){
        return bibliotheque.findByISBN(isbn);
    }

    @PostMapping(value="/Livres/")
    public void addBook(@RequestBody Livre l){
        bibliotheque.addLivre(l);
    }

    @DeleteMapping(value="/Livres/{isbn}")
    public void deleteBook(@PathVariable String isbn){
        bibliotheque.removeLivre(isbn);
    }

    @PutMapping(value="/Livres/")
    public void updateBook(@RequestBody Livre l){
        bibliotheque.updateLivre(l);
    }
}
