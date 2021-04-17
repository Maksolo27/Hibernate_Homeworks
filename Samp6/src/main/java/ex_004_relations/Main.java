package ex_004_relations;


import ex_004_relations.entity.Author;
import ex_004_relations.entity.Book;
import org.jboss.logging.Logger;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {


    public static void main(String[] args) {
/*       AuthorHelper ah = new AuthorHelper();
       Author author = ah.getAuthorById(1);*/
        BookHelper bookHelper = new BookHelper();
/*       List<Book> allBooks = author.getBooks();

       for (Book book : allBooks) {
           System.out.println(book.getName() + " " + book.getAuthor().getName()
                   + " " + book.getAuthor().getLastName());
       }*/

        List<Book> books = bookHelper.getBookList();
        for (Book book: books) {
            System.out.println(book.getName());
        }
        System.out.println("-----");
        bookHelper.deleteBookById(2);
        books = bookHelper.getBookList();
        for (Book book: books) {
            System.out.println(book.getName());
        }
       HibernateUtil.getSessionFactory().close();

    }

}
