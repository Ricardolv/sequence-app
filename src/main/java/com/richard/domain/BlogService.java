package com.richard.domain;

import com.richard.infrastructure.persistence.entities.BlogEntity;
import com.richard.infrastructure.persistence.entities.BlogEntityPK;
import com.richard.infrastructure.persistence.repositories.BlogEntityRepository;
import com.richard.infrastructure.resources.dto.Blog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BlogService {

    private final BlogEntityRepository repository;
    private final SequenceGeneratorService service;

    public BlogService(BlogEntityRepository repository, SequenceGeneratorService service) {
        this.repository = repository;
        this.service = service;
    }

    public int apply(Blog blog) {

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setPublished(blog.isPublished());
        blogEntity.setTitle(blog.getTitle());
        blogEntity.setDescription(blog.getDescription());

        final int sequenceNumber = service.getSequenceNumber(blog.getType());
        blogEntity.setPk(new BlogEntityPK(sequenceNumber, blog.getType()));
        repository.save(blogEntity);

        log.info("register: {}", blogEntity);

        return sequenceNumber;
    }

    public List<BlogEntity> findAll() {
        return repository.findAll();
    }

    public Blog update(Blog blog) {
        Optional<BlogEntity> blogEntityOptional = repository.findByPk(new BlogEntityPK(blog.getCode(), blog.getType()));


        blogEntityOptional.ifPresent((blogEntity) -> {
            blogEntity.setTitle(blog.getTitle());
            blogEntity.setDescription(blog.getDescription());
            repository.save(blogEntity);
        });

        return blog;
    }
}
