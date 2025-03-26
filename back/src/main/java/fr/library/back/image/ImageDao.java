package fr.library.back.image;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao  extends JpaRepository<ImageEntity, Integer> {
}
