package org.example.request.category;


import javax.validation.constraints.NotNull;

public class CategoryCreateRequest {
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
