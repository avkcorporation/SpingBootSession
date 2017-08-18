package ua.avk.shopbuilder.service;

import ua.avk.shopbuilder.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
