package test;

import dao.AccountDAO;
import dao.AcountDAOImpl;
import entity.Account;
import org.junit.Test;
import view.index;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangbaoning on 2016/11/28.
 */
public class testSQL {
    @Test
    public void getAll(){
        AccountDAO dao = new AcountDAOImpl();
        List list = dao.getAll();
        Iterator it = list.iterator();
        while (it.hasNext()){
            Account account = (Account) it.next();
            System.out.println(account.toString());
        }

    }
    @Test
    public void save(){
        Account account1 = new Account("2014021095","张咪","123456",1000.0);
        Account account2 = new Account("2014021097","梁咪","123456",5.0);
        Account account3 = new Account("2014021096","郝栓琴","123456",800.0);
        AcountDAOImpl dao = new AcountDAOImpl();
        dao.save(account1);
        dao.save(account2);
        dao.save(account3);
        dao.getTransaction().commit();
    }
    @Test
    public void getByID(){
        AccountDAO dao = new AcountDAOImpl();
        Account account=dao.get("2014021095");
        System.out.println(account.toString());
    }

    public static void main(String[] args) {
        JPanel panel = (JPanel) new index().$$$getRootComponent$$$();
        new index();
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void disDrawal(){

    }
}
