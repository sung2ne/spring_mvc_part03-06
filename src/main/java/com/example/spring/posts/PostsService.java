package com.example.spring.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    
    @Autowired
    PostsDao postsDao;

    // 게시글 등록
    public boolean create(PostsVo postsVo) {
        int result = postsDao.create(postsVo);
        return result > 0;
    }
}
