package ex_002_insert_and_update;

import ex_002_insert_and_update.entity.Author;
import ex_002_insert_and_update.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

/**
 * Created by maxim on 11.04.2021.
 */
public class BookHelper {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;

    public void updateBookById(long id, String name){
        session = sessionFactory.openSession();
        Book tempBook = session.get(Book.class, id);
        tempBook.setName(name);
        session.beginTransaction();
        session.save(tempBook);
        session.getTransaction().commit();
        session.close();
    }
    public void addBook(Book book){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        Selection[] selections = { root.get("name"), root.get("authorId") };
        cq.select( cb.construct(Book.class, selections) );
        Query query = session.createQuery(cq);
        List<Book> authorList = query.getResultList();
        session.close();

        return authorList;
    }
    public Author getAuthorName(String bookName){
        session = sessionFactory.openSession();
        List<Book> books = getBookList();
        Book tempBook = null;
        for (Book book : books) {
            if(book.getName().equals(bookName)){
                tempBook = book;
            }
        }
        long authorId = tempBook.getAuthorId();
        AuthorHelper ah = new AuthorHelper();
        Author author = ah.getAuthorById(authorId);
        return author;
    }

}
