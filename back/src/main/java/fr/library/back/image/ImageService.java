package fr.library.back.image;

import fr.library.back.book.BookEntity;
import fr.library.back.book.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageDao imageDao;

    public ImageEntity createImage(ImageDto imageDto){
      return imageDao.save(ImageMapper.map(imageDto));
    }


}
