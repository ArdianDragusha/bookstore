package hh.backend.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
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
			// Create categories
			Category fiction = new Category("Fiction");
			Category science = new Category("Science");
			categoryRepository.save(fiction);
			categoryRepository.save(science);

			// Create books with category references
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "978-1234567890", 10.99, fiction));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "978-2345678901", 8.99, fiction));
			bookRepository.save(new Book("The Selfish Gene", "Richard Dawkins", 1976, "978-3456789012", 15.99, science));

			System.out.println("Categories and books inserted successfully!");
		};
	}
}
