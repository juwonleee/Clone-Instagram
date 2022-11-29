package front.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Signup extends JFrame {

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    int allHeight = screenSize.height - 100;

    private Image background=new ImageIcon("instagram_clone/src/front/image/signup_bg.png").getImage();

    ImageIcon signupImg = new ImageIcon("instagram_clone/src/front/image/signup_signup.png");

    ImageIcon signupBackImg = new ImageIcon("instagram_clone/src/front/image/signup_login.png");

    JPanel signupMainPanel = new JPanel();

    JFrame signupframe = new JFrame();

    JTextField userEmailField;
    JTextField userNameField;
    JTextField userNickNameField;
    JTextField userPwdField;

    JButton bt_signupsignup;

    JButton bt_signuplogin;

    public void paint(Graphics g) { //그리는 함수

        g.drawImage(background, 0, 0, null); // background를 그려줌
    }

    public Signup(){
//        Loginframe();

//        setIconImage(ICON.getImage());
//        setResizable(false);

        setSignupMainPanel();

    }

    public void Signupframe() {
        setTitle("Instagram"); //타이틀
        setSize(new Dimension(1265, allHeight));
        setResizable(false); //창의 크기를 변경하지 못하게
        setLayout(null); //레이아웃을 내맘대로 설정가능하게

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게

        // 계정이 있으신가요? 로그인 버튼
        bt_signuplogin = new JButton(signupBackImg);
        bt_signuplogin.setBorderPainted(false);
        bt_signuplogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
               new Login();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt_signuplogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        bt_signuplogin.setBounds(487,621,260,34);
        add(bt_signuplogin);

        // 로그인 파란 색 버튼
        bt_signupsignup = new JButton(signupImg);
        bt_signupsignup.setBorderPainted(false);
        bt_signupsignup.addMouseListener(new MouseListener() {
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
                bt_signupsignup.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        bt_signupsignup.setBounds(487,521,260,34);
        add(bt_signupsignup);







        // 이메일 입력
        userEmailField = new HintTextField("휴대폰 번호 또는 이메일 주소");
        userEmailField.setBounds(488,275,250,30);
        Color color = new Color(250, 250, 250);
        userEmailField.setOpaque(true);
        userEmailField.setBackground(color);
        userEmailField.setForeground(Color.BLACK);
        add(userEmailField);

        // 이름 입력
        userNameField = new HintTextField("이름");
        userNameField.setBounds(488,322,250,30);
        userNameField.setOpaque(true);
        userNameField.setBackground(color);
        userNameField.setForeground(Color.BLACK);
        add(userNameField);


        userNickNameField = new HintTextField("사용자 이름");
        userNickNameField.setBounds(488,364,250,30);
        userNickNameField.setOpaque(true);
        userNickNameField.setBackground(color);
        userNickNameField.setForeground(Color.BLACK);
        add(userNickNameField);

        // 비밀번호 입력
        userPwdField = new HintTextField("비밀번호");
        userPwdField.setBounds(488,410,250,30);
        userPwdField.setOpaque(true);
        userPwdField.setBackground(color);
        userPwdField.setForeground(Color.BLACK);
        add(userPwdField);


        setVisible(true);//창이 보이게


    }

    private void setSignupMainPanel(){
        Signupframe();
        signupMainPanel.add(signupframe);
    }
}
