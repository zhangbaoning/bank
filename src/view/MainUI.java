package view;

import dao.AcountDAOImpl;
import entity.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangbaoning on 2016/11/30.
 */
public class MainUI {
    private JPanel panel1;
    private JTextField numberTF;
    private JTextField passwordTF;
    private JButton loginButton;
    private JLabel numberLabel;
    private JLabel pwdLabel;
    private JLabel tip;
    private JButton reset;
    static JFrame frame = new JFrame("MainUI");

    public void run() {
        frame.setContentPane(new MainUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(520, 400);
    }

    public static void main(String[] args) {
        new MainUI().run();
    }

    public MainUI() {
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberTF.setText(null);
                passwordTF.setText(null);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean haveNumber = false;
                Account account;
                Iterator it = new AcountDAOImpl().getAll().iterator();
                String number = numberTF.getText();
                String password = passwordTF.getText();
                while (it.hasNext()) {
                    account = (Account) it.next();
                    if (account.getNumber().equals(number)) {
                        haveNumber = true;
                    }
                }
                if (haveNumber == false) {
                    tip.setText("没有此账号");
                } else {
                    account = new AcountDAOImpl().get(number);
                    if (password.equals(account.getPassword())) {
                        frame.dispose();
                        new Switch(account).run();
                    } else {
                        tip.setText("密码错误，请查证后再试");
                    }
                }
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
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel1.add(panel2, BorderLayout.CENTER);
        numberTF = new JTextField();
        numberTF.setText("");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 300;
        gbc.ipady = 1;
        panel2.add(numberTF, gbc);
        pwdLabel = new JLabel();
        pwdLabel.setText("密码");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(pwdLabel, gbc);
        numberLabel = new JLabel();
        numberLabel.setText("账号");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(numberLabel, gbc);
        passwordTF = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(passwordTF, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel1.add(panel3, BorderLayout.WEST);
        loginButton = new JButton();
        loginButton.setText("登录");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(loginButton, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        panel1.add(panel4, BorderLayout.SOUTH);
        tip = new JLabel();
        tip.setText("");
        panel4.add(tip, BorderLayout.WEST);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        panel1.add(panel5, BorderLayout.EAST);
        reset = new JButton();
        reset.setText("重置");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(reset, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
