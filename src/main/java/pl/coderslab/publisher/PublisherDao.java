package pl.coderslab.book;
import org.springframework.stereotype.Repository;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void saveBook(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public List<Publisher> findAll(){
        Query query = entityManager.createQuery("select b from Publisher b");
        return query.getResultList();
    }
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }
}
