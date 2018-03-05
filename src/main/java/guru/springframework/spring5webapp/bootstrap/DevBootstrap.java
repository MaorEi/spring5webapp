package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.BookCategory;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookCategoryRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private BookCategoryRepository bookCategoryRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    private void initData() {
        //Drama category
        BookCategory dramaCategory = new BookCategory("Drama");

        //Zappa
        Publisher zappa = new Publisher("Zappa publishers", "Tel-Aviv");

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", zappa, dramaCategory);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        dramaCategory.getBooks().add(ddd);

        bookCategoryRepository.save(dramaCategory);
        publisherRepository.save(zappa);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Harper
        Publisher harper = new Publisher("Harper Collins", "New York");
        //Rob
        Author rob = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", harper, dramaCategory);
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(eric);
        dramaCategory.getBooks().add(noEJB);

        publisherRepository.save(harper);
        authorRepository.save(rob);
        bookRepository.save(noEJB);
        bookCategoryRepository.save(dramaCategory);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
