package com.richard.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "sequences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequenceEntity {

    @Transient
    public static final String SEQUENCE_NAME = "sequence_type-";

    @Id
    private ObjectId id;
    private long type;
    private int seq;

}
