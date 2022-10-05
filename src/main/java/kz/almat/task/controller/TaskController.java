package kz.almat.task.controller;

import kz.almat.task.dto.CreateUserRequestDto;
import kz.almat.task.model.Users;
import kz.almat.task.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final UsersService usersService;

    @GetMapping
    public Object getByPerNum(@RequestParam(value = "perNum") Long perNum) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return usersService.getByPerNum(perNum);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody CreateUserRequestDto requestDto) {
        usersService.addUser(requestDto);
        return ResponseEntity.ok().body("Запись добавлена");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteByPerNum(@RequestParam(value = "perNum") Long perNum) {
        usersService.deleteByPerNum(perNum);
        return ResponseEntity.ok().body(String.format("Запись удалена по табельному номеру %s", perNum));
    }

    @PutMapping
    public ResponseEntity<String> updateByPerNum(@RequestBody CreateUserRequestDto requestDto) {
        usersService.updateByPerNum(requestDto);
        return ResponseEntity.ok().body(String.format("Запись обновлена по табельному номеру %s", requestDto.getPerNum()));
    }
}

