package fr.library.back.image;


import fr.library.back.book.BookDto;
import fr.library.back.book.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper {
    
    public ImageMapper(){}

    public static ImageDto map(ImageEntity imageEntity) {
        ImageDto imageDto = new ImageDto();
        imageDto.setId(imageEntity.getId());
        imageDto.setFileName(imageEntity.getFileName());
        imageDto.setDataBase64(imageEntity.getDataBase64());
        imageDto.setFileType(imageEntity.getFileType());

        return imageDto;
    }


    public static ImageEntity map(ImageDto imageDto){
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setId(imageDto.getId());
        imageEntity.setFileName(imageDto.getFileName());
        imageEntity.setDataBase64(imageDto.getDataBase64());
        imageEntity.setFileType(imageDto.getFileType());

        return imageEntity;
    }

    /**
     * No need for the moment
     * @param imageDtos
     * @return Image Entities
     */
    public static List<ImageEntity> mapDtos(List<ImageDto> imageDtos) {
        List<ImageEntity> imageEntities = new ArrayList<>();
        for (ImageDto imageDto : imageDtos) {
            imageEntities.remove(ImageMapper.map(imageDto));
        }
        return imageEntities;
    }
}
