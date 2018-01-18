package com.lin.lcchat.serviceImpl;

import com.lin.lcchat.dao.IUserDao;
import com.lin.lcchat.pojo.User;
import com.lin.lcchat.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: chong.lin
 * @date: 2018/1/17 下午2:33
 * @company: 易宝支付(YeePay)
 * TODO   :
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource private IUserDao userDao;

    @Override
    public List<User> selectAll(int page, int pageSize) {
        return userDao.selectAll(page, pageSize);
    }

    @Override
    public User selectUserByUserid(String userid) {
        return userDao.selectUserByUserid(userid);
    }

    @Override
    public int selectCount(int pageSize) {
        int pageCount = Integer.parseInt(userDao.selectCount().getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(String userid) {
        return userDao.delete(userid);
    }
}
