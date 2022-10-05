package kz.almat.task.service;

import kz.almat.task.dto.CreateUserRequestDto;
import kz.almat.task.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Objects;

public interface UsersService extends UserDetailsService {

    Object getByPerNum(Long perNum);

    void addUser(CreateUserRequestDto requestDto);

    void deleteByPerNum(Long perNum);

    void updateByPerNum(CreateUserRequestDto requestDto);
}
