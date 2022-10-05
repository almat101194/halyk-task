package kz.almat.task.service.impl;

import kz.almat.task.dto.CreateUserRequestDto;
import kz.almat.task.model.MyUserDetails;
import kz.almat.task.model.Users;
import kz.almat.task.repository.UsersRepository;
import kz.almat.task.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UsersRepository usersRepository;

    @Override
    public Object getByPerNum(Long perNum) {
        if (perNum != 0) {
            return usersRepository.getByPerNum(perNum);
        }
//        Users users = usersRepository.getByPerNum(perNum);
        return usersRepository.findAll();
    }

    @Override
    public void addUser(CreateUserRequestDto requestDto) {
        Users user = new Users();
        user.setPerNum(requestDto.getPerNum());
        user.setFio(requestDto.getFio());
        user.setBirthDate(requestDto.getBirth());
        user.setRole(requestDto.getRole());
        String encodedPassword = bCryptPasswordEncoder.encode(requestDto.getPassword());
        user.setPassword(encodedPassword);
        usersRepository.save(user);
    }

    @Override
    public void deleteByPerNum(Long perNum) {
        Users user = usersRepository.getByPerNum(perNum);
        usersRepository.delete(user);
    }

    @Override
    public void updateByPerNum(CreateUserRequestDto requestDto) {
        Users user = usersRepository.getByPerNum(requestDto.getPerNum());
        user.setFio(requestDto.getFio());
        user.setRole(requestDto.getRole());
        user.setBirthDate(requestDto.getBirth());
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.getByPerNum(Long.parseLong(username));

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new MyUserDetails(user);
    }
}
