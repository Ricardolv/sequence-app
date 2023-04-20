package com.richard.domain;

import com.richard.infrastructure.persistence.entities.DbSequenceEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    private final MongoOperations mongoOperations;

    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int getSequenceNumber(long type) {

        //get sequence no
        Query query = new Query(Criteria.where("type").is(type));

        //update the sequence no
        Update update = new Update().inc("seq", 1);

        //modify in document
        DbSequenceEntity counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceEntity.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
