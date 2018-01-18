package com.lin.lcchat.service;


import com.lin.lcchat.pojo.User;

import java.util.List;

/**
 * @author: chong.lin
 * @date: 2018/1/17 下午2:33
 * @company: 易宝支付(YeePay)
 * TODO   :
 */
public interface IUserService {
    List<User> selectAll(int page, int pageSize);
    User selectUserByUserid(String userid);
    int selectCount(int pageSize);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);
}
