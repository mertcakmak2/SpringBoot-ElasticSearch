package com.springdata.elasticsearch.controllers;

import com.springdata.elasticsearch.entities.Kisi;
import com.springdata.elasticsearch.repositories.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setName("mert");
        kisi.setSoyad("cakmak");
        kisiRepository.save(kisi);

        Kisi kisi2 = new Kisi();
        kisi2.setName("admin");
        kisi2.setSoyad("user");
        kisiRepository.save(kisi2);

        Kisi kisi3 = new Kisi();
        kisi3.setName("test");
        kisi3.setSoyad("user");
        kisiRepository.save(kisi3);
    }

    //Ad field değeri ile tam eşleşmeli Örn => user===user
    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }

    //Ad fieldi değerinin içinde geçmesi yeterli Örn => veri = "user" gelen deger = "us"
    @GetMapping("/contains/{search}")
    public ResponseEntity<List<Kisi>> getContainsKisi(@PathVariable String search){
        List<Kisi> kisiler = kisiRepository.findByNameContaining(search);
        return ResponseEntity.ok(kisiler);
    }
}
