package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Image;
import org.example.domain.Product;

@Data
@Builder
public class ProductDto {

    private final int id;
    private final String name;
    private final int caloriesNumber;
    private final int glycemicIndex;
    private final int protein;
    private final int fat;
    private final int carbohydrate;
    private final ImageDto image;
    
    public static ProductDto toDto(Product product){
        ImageDto imageDto = ImageDto.toDto(product.getImage());
        return ProductDto.builder().id(product.getId()).name(product.getName()).caloriesNumber(
                product.getCaloriesNumber()).glycemicIndex(product.getGlycemicIndex())
                .protein(product.getProtein()).fat(product.getFat()).carbohydrate(product
                        .getCarbohydrate()).image(imageDto).build();
    }
    public static Product toDomainObject(ProductDto dto){
        Image image = ImageDto.toDomainObject(dto.getImage());
        return Product.builder().id(dto.getId()).name(dto.getName()).caloriesNumber(dto
                .getCaloriesNumber()).glycemicIndex(dto.getGlycemicIndex()).protein(dto.getProtein())
                .fat(dto.getFat()).carbohydrate(dto.getCarbohydrate()).image(image).build();
    }
    
}
