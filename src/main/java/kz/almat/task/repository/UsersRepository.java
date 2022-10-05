package kz.almat.task.repository;

import kz.almat.task.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users getByPerNum(Long perNum);
}
