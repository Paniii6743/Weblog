package ir.project.weblog.service.category;

import ir.project.weblog.dto.category.CategoryDto;
import ir.project.weblog.dto.category.CategorySaveDto;
import ir.project.weblog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    CategoryDto save(CategorySaveDto categorysaveDto);

    CategoryDto update(int id, CategorySaveDto categorySaveDto);

    void delete(int id);

    List<CategoryDto> findAll();

    CategoryDto findById(int id);

    Optional<Category> findEntityById(int id);
}
