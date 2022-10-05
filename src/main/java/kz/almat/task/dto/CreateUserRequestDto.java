package kz.almat.task.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserRequestDto {

    private Long perNum;

    private String fio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private String role;

    private String password;
}
