package com.kirinsoft.onlinestore.onlinestore.user.service;

import com.kirinsoft.onlinestore.onlinestore.user.repository.UserRepository;
import com.kirinsoft.onlinestore.onlinestore.user.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserVo getCurrentUser(String id) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userRepository.findById(id).get(), userVo);
        return userVo;
    }

    public UserVo getUser(String userName, String password) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userRepository.findByUserIdAndPassword(userName, password), userVo);
        return userVo;
    }
}
