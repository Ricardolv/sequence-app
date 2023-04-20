package com.richard.infrastructure.persistence.repositories;

import com.richard.infrastructure.persistence.entities.BlogEntity;
import com.richard.infrastructure.persistence.entities.BlogEntityPK;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BlogEntityRepository extends MongoRepository<BlogEntity,Integer> {

    Optional<BlogEntity> findByPk(BlogEntityPK pk);
}
