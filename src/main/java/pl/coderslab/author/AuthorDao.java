package pl.coderslab.author;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Author author){
         entityManager.persist(author);
    }
    public Author read(Long id){
        return entityManager.find(Author.class, id);
    }
    public List<Author> findAll(){
        Query query = entityManager.createQuery("select b from Author b");
        return query.getResultList();
    }

    public void update(Author author){
        entityManager.merge(author);
    }
    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }
}
