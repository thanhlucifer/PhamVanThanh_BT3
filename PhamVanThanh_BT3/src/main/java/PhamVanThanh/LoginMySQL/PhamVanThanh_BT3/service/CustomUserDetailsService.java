package PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.service;

import PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.model.CustomUserDetails;
import PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.model.User;
import PhamVanThanh.LoginMySQL.PhamVanThanh_BT3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}
