package com.example.spring.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 게시글 등록
    public int create(PostsVo postsVo) {
        String query = "INSERT INTO POSTS (TITLE, CONTENT, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
        int result = -1;

        try {
            result = jdbcTemplate.update(query, postsVo.getTitle(), postsVo.getContent(), postsVo.getUsername(), postsVo.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
