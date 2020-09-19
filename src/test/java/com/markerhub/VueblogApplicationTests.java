package com.markerhub;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.markerhub.common.dto.UpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VueblogApplicationTests {

    @Test
    void contextLoads() {
        UpdateDto dto = new UpdateDto();
        dto.setId(2L);
        dto.setUsername("admin");
        dto.setEmail("111@123.com");
        dto.setStatus(0);
        dto.setPassword("122222");
        System.out.println(JSON.toJSON(dto));

    }

}
