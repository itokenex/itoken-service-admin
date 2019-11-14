package com.funtl.itoken.service.admin.service;

import com.funtl.itoken.service.admin.domain.User;

public interface AdminService {

    public void register(User user);

    public User login(String accountId,String name);
}
