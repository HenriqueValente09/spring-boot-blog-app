package com.example.springbootblogapp.config;

import com.example.springbootblogapp.models.Account;
import com.example.springbootblogapp.models.Post;
import com.example.springbootblogapp.services.AccountService;
import com.example.springbootblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {




        List<Post> posts = postService.getAll();


        if (posts.size() == 0) {

            Account account1 = new Account();
            account1.setName("João");

            accountService.save(account1);

            Post post1 = new Post();
            post1.setAccount(account1);
            post1.setTitle("Post 1 title");
            post1.setBody("Post 1 body");

            Post post2 = new Post();
            post2.setAccount(account1);
            post2.setTitle("Post 2 title");
            post2.setBody("Post 2 body");

            postService.save(post1);
            postService.save(post2);
        }
    }
}
