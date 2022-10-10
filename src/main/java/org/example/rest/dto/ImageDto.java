package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Image;

@Data
@Builder
public class ImageDto {
    private final int id;
    private final String path;
    
    public static ImageDto toDto(Image image){
        return ImageDto.builder().id(image.getId()).path(image.getPath()).build();
    }
    public static Image toDomainObject(ImageDto dto){
        return Image.builder().id(dto.getId()).path(dto.getPath()).build();
    }
}
