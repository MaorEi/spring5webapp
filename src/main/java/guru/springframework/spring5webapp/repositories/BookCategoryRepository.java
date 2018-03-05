package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.BookCategory;
import org.springframework.data.repository.CrudRepository;

public interface BookCategoryRepository extends CrudRepository<BookCategory, Long> {
}
