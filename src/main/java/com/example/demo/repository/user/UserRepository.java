package classy.classyapp.BackendApi.repository.user;

import java.util.List;


import jakarta.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import classy.classyapp.BackendApi.model.user.Role;
import classy.classyapp.BackendApi.model.user.User;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
@Mapper
public interface UserRepository {
    User findByEmail(@Param("email") String email);
    User findByUserName(@Param("userName") String userName);
    void insert(User user);
    void update(User user);
    void deleteById(String id);
    List<User> findAll();
}
