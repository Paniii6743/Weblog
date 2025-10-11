package ir.project.weblog.dto.category;

import ir.project.weblog.model.Category;

public class CategoryDto {

    private final int id;
    private final String name;
    private final String description;

    public CategoryDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static CategoryDto ConvertToDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }
}
