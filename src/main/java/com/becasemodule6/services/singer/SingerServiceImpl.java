package com.becasemodule6.services.singer;

import com.becasemodule6.models.Singer;
import com.becasemodule6.repositories.SingerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements ISingerService {
    @Autowired
    SingerRepo singerRepo;

    @Override
    public List<Singer> findAll() {
        return (List<Singer>) singerRepo.findAll();
    }

    @Override
    public void save(Singer singer) {
        singerRepo.save(singer);
    }

    @Override
    public void delete(Long id) {
        singerRepo.deleteById(id);
    }

    @Override
    public Singer findById(Long id) {
        return singerRepo.findById(id).get();
    }

    @Override
    public Singer findSingerBySinger_name(String singer_name){
     return singerRepo.findSingerBySinger_name(singer_name);
    }


//    Hoành thêm


    public List<Singer> find5Singer ( ){
        return singerRepo.find5Singer();
    }


}
