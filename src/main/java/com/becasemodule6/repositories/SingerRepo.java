package com.becasemodule6.repositories;

import com.becasemodule6.models.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SingerRepo extends PagingAndSortingRepository<Singer, Long> {
   @Query(nativeQuery = true, value = "SELECT * FROM singer WHERE singer_name = :singer_name")
   Singer findSingerBySinger_name(String singer_name);

//Hoành thêm
   @Query(nativeQuery = true, value = "SELECT * FROM blog_music.singer  LIMIT 5")
   List<Singer> find5Singer();

}





