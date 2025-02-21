package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return args -> {
			System.out.println("Save some sample categories");
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("Non-Fiction"));
			categoryRepository.save(new Category("Fantasy"));
			System.out.println("Fetch books");
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "978-1234567890", 10.99));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "978-2345678901", 8.99));
			bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-3456789012", 12.99));

			System.out.println("Sample books and categories inserted successfully!");
		};
	}
}
