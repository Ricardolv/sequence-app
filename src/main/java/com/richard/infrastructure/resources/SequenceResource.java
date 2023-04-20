package com.richard.infrastructure.resources;

import com.richard.domain.BlogService;
import com.richard.infrastructure.persistence.entities.BlogEntity;
import com.richard.infrastructure.resources.dto.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/blogs")
public class SequenceResource {
    private final BlogService service;

    public SequenceResource(BlogService service) {
        this.service = service;
    }

    @PostMapping
    public int save(@RequestBody Blog blog) {
        return service.apply(blog);
    }

    @GetMapping
    public List<BlogEntity> getBlogs() {
        return service.findAll();
    }

    @PutMapping
    public Blog update(@RequestBody Blog blog) {
        return service.update(blog);
    }

}
