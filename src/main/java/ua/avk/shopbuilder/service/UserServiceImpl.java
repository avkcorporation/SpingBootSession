package ua.avk.shopbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.avk.shopbuilder.dao.RoleRepository;
import ua.avk.shopbuilder.dao.UserRepository;
import ua.avk.shopbuilder.entity.User;
import ua.avk.shopbuilder.enums.EnumUserAccess;
import ua.avk.shopbuilder.enums.EnumUserStatus;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setAccess(EnumUserAccess.USER);
        user.setStatus(EnumUserStatus.ACTIVE);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
