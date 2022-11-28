package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame {


    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    int allHeight = screenSize.height - 100;

    //JLabel background = new JLabel(new ImageIcon("front/instagram_clone/image/login_bg.png"));
    private Image background=new ImageIcon("front/instagram_clone/image/login_bg.png").getImage();
    ImageIcon signupImg = new ImageIcon("front/instagram_clone/image/login_signup.png");
    ImageIcon loginImg = new ImageIcon("front/instagram_clone/image/login_login.png");
    private static ImageIcon ICON = new ImageIcon("front/instagram_clone/image/instagram_circle.png");

    JPanel loginMainPanel = new JPanel();

    JFrame loginframe = new JFrame();
    JButton bt_loginSignup;
    JButton bt_loginlogin;

    JTextField userEmailField;
    JTextField userPwdField;

    public void paint(Graphics g) {//그리는 함수
        g.drawImage(background, 0, 0, null);//background를 그려줌
    }

    public Login(){
//        Loginframe();

//        setIconImage(ICON.getImage());
//        setResizable(false);

        setLoginMainPanel();

    }


    public void Loginframe() {
        setTitle("Instagram");//타이틀
        setSize(new Dimension(1265, allHeight));
        setResizable(false);//창의 크기를 변경하지 못하게
        setLayout(null);//레이아웃을 내맘대로 설정가능하게 해줌.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게


        bt_loginlogin = new JButton(loginImg);
        bt_loginlogin.setBorderPainted(false);
        bt_loginlogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt_loginlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        bt_loginlogin.setBounds(650,365,220,34);
        add(bt_loginlogin);

        // 회원가입 버튼
        bt_loginSignup = new JButton(signupImg);
        bt_loginSignup.setBorderPainted(false);
        bt_loginSignup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt_loginSignup.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        bt_loginSignup.setVisible(true);
        bt_loginSignup.setBounds(624,520,270,40);

        add(bt_loginSignup);



        // 이메일 입력
        userEmailField = new HintTextField("전화번호, 사용자 이름 또는 이메일");
        userEmailField.setBounds(655,293,210,30);
        Color color = new Color(250, 250, 250);
        userEmailField.setOpaque(true);
        userEmailField.setBackground(color);
        userEmailField.setForeground(Color.BLACK);
        add(userEmailField);

        // 비밀번호 입력
        userPwdField = new HintTextField("비밀번호");
        userPwdField.setBounds(655,330,210,28);
        userPwdField.setOpaque(true);
        userPwdField.setBackground(color);
        userPwdField.setForeground(Color.BLACK);
        add(userPwdField);





        setVisible(true);//창이 보이게


    }

    private void setLoginMainPanel(){
        Loginframe();
        loginMainPanel.add(loginframe);


//        bt_loginSignup = new JButton(signupImg);
//        bt_loginSignup.setBorderPainted(false);
//        bt_loginSignup.setVisible(true);
//        bt_loginSignup.setLocation(600,500);
//        loginMainPanel.add(bt_loginSignup);
//        loginMainPanel.setVisible(true);
    }

//    private void setloginPanel(){
//
//        //loginMainPanel.setLocation(600,500);
//        bt_loginSignup = new JButton(signupImg);
//        bt_loginSignup.setBorderPainted(false);
//        bt_loginSignup.setVisible(true);
//        bt_loginSignup.setLocation(600,500);
//        loginMainPanel.add(bt_loginSignup);
//
////        JPanel temp = new JPanel();
////        temp.add(loginMainPanel);
//
//        add(loginMainPanel);
//
//
//
//    }

}


