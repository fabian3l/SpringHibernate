package pl.coderslab.book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findAllByRating(int rating) {
        return bookDao.findAllByRating(rating);
    }
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }
    public void update(Book book) {
        bookDao.update(book);
    }
    public void delete(Book book) {
        bookDao.delete(book);
    }
}