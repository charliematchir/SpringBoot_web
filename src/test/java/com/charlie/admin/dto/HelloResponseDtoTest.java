package com.charlie.admin.dto;

import com.charlie.admin.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void lombok_function_test() {
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
