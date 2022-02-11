package web.java.service;

import java.util.List;

import web.java.model.User;

public interface IUserService {
    List<User> findAll();
}
