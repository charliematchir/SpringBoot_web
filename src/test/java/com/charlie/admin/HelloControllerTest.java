package com.charlie.admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// SpringRunner is spring executor. It links springboot test and junit.
// annotation for web
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HelloControllerTest {
    // inject spring controlled bean
    // bean is reusable software component controlled by spring container


    //used for web API test
    // can test HTTP get post api with this class
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        String hello = "hello";
        //  http get request to url /hello
        mvc.perform(get("/hello"))
                // only checks 200 404 500 (here, 200)
                .andExpect(status().isOk())
                // check if result is same
                .andExpect(content().string(hello));
    }

    @Test
    public void hellodto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                // param()은 API test시 사용할 param을 설정하고 string 값만 받는다.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
    // jsonPath 는 Json 응답값을 필드별로 검증할 수 있게함
    // $ 기준으로 필드명 기재
}
