package com.springdata.elasticsearch.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "kisiler")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kisi {

    @Id
    private String id;
    @Field(name = "ad", type = FieldType.Text)
    private String name;
    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;

}
