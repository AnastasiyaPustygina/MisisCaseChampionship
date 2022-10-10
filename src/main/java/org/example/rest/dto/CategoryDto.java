package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Category;

@Data
@Builder
public class CategoryDto {
    private final int id;
    private final String name;
    
    public static CategoryDto toDto(Category category){
        return CategoryDto.builder().id(category.getId())
                .name(category.getName()).build();
    }
    public static Category toDomainObject(CategoryDto dto){
        return Category.builder().id(dto.id).name(dto.getName()).build();
    }
}
