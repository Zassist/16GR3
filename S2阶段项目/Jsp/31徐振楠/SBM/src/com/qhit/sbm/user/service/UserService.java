package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface UserService {
   public User doLogin(String userName,String passWord);
}
