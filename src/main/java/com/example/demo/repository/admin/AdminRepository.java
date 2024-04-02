package classy.classyapp.BackendApi.repository.admin;

import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Mapper
public interface AdminRepository extends JpaRepository<User, String> {
    List<User> findByStatus(@Param("status") AccountStatus status);
    List<User> findByUserRole(@Param("role") Role role);
}
