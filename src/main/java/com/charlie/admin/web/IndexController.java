package com.charlie.admin.web;

import com.charlie.admin.service.PostsService;
import com.charlie.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// mustache starter 가 문자열 반환시 앞 경로랑 뒤 파일 확장자 자동으로 지정함
// src/main/resources/templates 에 index 반환하므로 ~/index.mustache 로 전환됨
@RequiredArgsConstructor
@Controller
public class IndexController {


    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model) {
        // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        //  findAllDesc로 가져온 결과를 posts로 index.mustache로 전달함
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
