package ir.project.weblog.dto.category;

import ir.project.weblog.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategorySaveDto {

    private final String name;

    public CategorySaveDto(String name) {
        this.name = name;
    }

    @NotBlank(message = "categoryName.is.blank")
    public String getName() {
        return name;
    }

    public Category ConvertToCategory() {
        Category category = new Category();
        category.setName(name);
        return category;
    }


}
