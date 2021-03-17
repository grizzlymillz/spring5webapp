package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookrepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookrepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookrepository = bookrepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher shane = new Publisher("Shane Publishing","472 April Dr", "Grants Pass", "OR", "97532");


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        shane.getBooks().add(ddd);

        authorRepository.save(eric);
        bookrepository.save(ddd);
        publisherRepository.save(shane);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        Publisher jasonllc = new Publisher("Jason Publishing", "473 april dr", "Grants Pass", "OR", "97532");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        jasonllc.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookrepository.save(noEJB);
        publisherRepository.save(jasonllc);



        System.out.println("Number of Books: " +bookrepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());
        System.out.println("Number of books for publisher shane: "+shane.getBooks().size());

    }
}
