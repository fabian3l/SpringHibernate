package pl.coderslab.publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.book.PublisherDao;
import pl.coderslab.publisher.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherDao publisherDao;
    public Publisher findById(Long id) {
        return publisherDao.findById(id);
    }
    public void savePublisher(Publisher publisher) {
        publisherDao.saveBook(publisher);
    }
    public List<Publisher> getAll(){
        return publisherDao.findAll();
    }
    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }
    public void delete(Publisher publisher){
        publisherDao.delete(publisher);
    }
}