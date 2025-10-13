package ir.project.weblog.service.category;

import ir.project.weblog.customeException.RuleException;
import ir.project.weblog.dto.category.CategoryDto;
import ir.project.weblog.dto.category.CategorySaveDto;
import ir.project.weblog.model.Category;
import ir.project.weblog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategorySaveDto categorysaveDto) {
        Category category = categorysaveDto.ConvertToCategory();
        categoryRepository.save(category);
        return CategoryDto.ConvertToDto(category);
    }

    @Override
    public CategoryDto update(int id, CategorySaveDto categorySaveDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.is.not.found"));
        category.setName(categorySaveDto.getName());
        categoryRepository.save(category);
        return CategoryDto.ConvertToDto(category);

    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.is.not.found"));
    categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::ConvertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.is.not.found"));
        return CategoryDto.ConvertToDto(category);
    }

    @Override
    public Optional<Category> findEntityById(int id) {
        return categoryRepository.findById(id);
    }
}
