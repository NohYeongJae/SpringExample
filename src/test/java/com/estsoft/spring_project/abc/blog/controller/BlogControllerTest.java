package com.estsoft.spring_project.abc.blog.controller;

import com.estsoft.spring_project.abc.blog.Article;
import com.estsoft.spring_project.abc.blog.dto.AddArticleRequest;
import com.estsoft.spring_project.abc.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        blogRepository.deleteAll();
    }

    @Test
    void saveArticle() throws Exception {
        // given:   Object -> json (ObjectMapper 사용해서 직렬화)
        AddArticleRequest request = new AddArticleRequest("제목", "내용");
        String requestBody = objectMapper.writeValueAsString(request);  // 직렬화
//        System.out.println("requestBody: " + requestBody);

        // when:  POST /api/articles (API 요청)
        ResultActions resultActions = mockMvc.perform(post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        // then:
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(request.getTitle()))
                .andExpect(jsonPath("$.content").value(request.getContent()));
    }

    // 전체 목록조회 API 테스트 코드
    @Test
    public void findAllArticles() throws Exception {
//        given: article 값 저장
        Article savedArticle = Article.builder()
                .title("저장하려는 제목")
                .content("저장하려는 내용")
                .build();
        blogRepository.save(savedArticle);

//        when: GET /api/articles API 호출
        ResultActions resultActions = mockMvc.perform(get("/api/articles"));

//        then:
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(savedArticle.getTitle()))
                .andExpect(jsonPath("$[0].content").value(savedArticle.getContent()));
    }

    @Test
    public void findArticle() throws Exception {
        // given
        Article article = blogRepository.save(new Article("제목123", "내용123"));
        Long id = article.getId();

        // when
        ResultActions resultActions = mockMvc.perform(get("/api/articles/{id}", 2));

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(article.getTitle()))
                .andExpect(jsonPath("$.content").value(article.getContent()));
    }
}