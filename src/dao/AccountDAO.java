package dao;

import entity.Account;

import java.util.List;

/**
 * Created by zhangbaoning on 2016/11/28.
 */
public interface AccountDAO {
    public void save(Account account);
    public void del(Account account);
    public void update(Account account);
    public Account get(String id);
    public List getAll();
}
