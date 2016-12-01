package view;

import dao.AccountDAO;
import dao.AcountDAOImpl;
import entity.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhangbaoning on 2016/11/29.
 */
public class Withdrawal {
    private JButton yibai;
    private JButton erbai;
    private JButton wubai;
    private JButton yiqian;
    private JButton liangqian;
    private JButton wuqian;
    private JTextField textField;
    private JButton input;
    private JPanel panel;
    private JLabel tip;
    private JButton back;
    private JButton exit;
    JFrame frame = new JFrame();

    public void run() {

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(520, 400);
    }


    public Withdrawal(Account account) {
        double banlance = account.getBalance();
        yibai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 100) {
                    account.setBalance(account.getBalance() - 100);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");
                } else {
                    tip.setText("余额不足");
                }
            }
        });
        erbai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 200) {
                    account.setBalance(account.getBalance() - 200);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");
                } else {
                    tip.setText("余额不足");
                }
            }
        });
        wubai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 500) {
                    account.setBalance(account.getBalance() - 500);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");

                } else {
                    tip.setText("余额不足");
                }

            }
        });
        yiqian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 1000) {
                    account.setBalance(account.getBalance() - 1000);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");

                } else {
                    tip.setText("余额不足");
                }

            }
        });
        liangqian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 2000) {
                    account.setBalance(account.getBalance() - 2000);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");
                } else {
                    tip.setText("余额不足");


                }

            }
        });
        wuqian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                if (banlance >= 5000) {
                    account.setBalance(account.getBalance() - 5000);
                    dao.update(account);
                    dao.getTransaction().commit();
                    tip.setText("请取钱，您还有" + account.getBalance() + "元");

                } else {
                    tip.setText("余额不足");
                }

            }
        });
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcountDAOImpl dao = new AcountDAOImpl();
                int input_money = Integer.parseInt(textField.getText());
                if (input_money % 100 == 0) {
                    if (input_money < banlance) {
                        account.setBalance(account.getBalance() - input_money);
                        dao.update(account);
                        dao.getTransaction().commit();
                        tip.setText("请取钱，您还有" + account.getBalance() + "元");
                    } else {
                        tip.setText("余额不足");
                    }
                } else {
                    tip.setText("请输入金额为100的倍数");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Switch(account).run();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainUI().run();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel.add(panel1, BorderLayout.EAST);
        yiqian = new JButton();
        yiqian.setText("1000");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(yiqian, gbc);
        liangqian = new JButton();
        liangqian.setText("2000");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(liangqian, gbc);
        wuqian = new JButton();
        wuqian.setText("5000");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(wuqian, gbc);
        exit = new JButton();
        exit.setText("退卡");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(exit, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel.add(panel2, BorderLayout.WEST);
        yibai = new JButton();
        yibai.setText("100");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(yibai, gbc);
        erbai = new JButton();
        erbai.setText("200");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(erbai, gbc);
        wubai = new JButton();
        wubai.setText("500");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(wubai, gbc);
        back = new JButton();
        back.setText("返回");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(back, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel.add(panel3, BorderLayout.CENTER);
        final JLabel label1 = new JLabel();
        label1.setText("请输入要取的金额");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 100;
        panel3.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel3.add(spacer2, gbc);
        textField = new JTextField();
        textField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(textField, gbc);
        input = new JButton();
        input.setText("取款");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(input, gbc);
        tip = new JLabel();
        tip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(tip, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}

