package com.funtl.itoken.service.admin.service.impl;

import com.funtl.itoken.service.admin.domain.User;
import com.funtl.itoken.service.admin.mapper.UserMapper;
import com.funtl.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User login(String accountId, String name) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("accountId",accountId).andEqualTo("name",name);
        User user = userMapper.selectOneByExample(example);
        if(user!=null){
            return user;
        }
        return null;
    }
}
