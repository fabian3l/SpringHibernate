package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;

    public void createAuthor(Author author){
        authorDao.create(author);
    }
    public Author read(Long id){
        return authorDao.read(id);
    }
    public List<Author> getAll(){
        return authorDao.findAll();
    }
    public void update(Author author){
        authorDao.update(author);
    }
    public void delete(Author author){
        authorDao.delete(author);
    }
}
