package PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.repository;

import PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email =?1")
    User findByEmail(String email);
}
