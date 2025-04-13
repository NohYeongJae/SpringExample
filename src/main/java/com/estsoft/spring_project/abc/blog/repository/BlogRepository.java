package com.estsoft.spring_project.abc.blog.repository;

import com.estsoft.spring_project.abc.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository  extends JpaRepository<Article, Long> {
}
