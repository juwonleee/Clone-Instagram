package home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home extends JFrame {

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    private static ImageIcon ICON = new ImageIcon("front/instagram_clone/image/instagram_circle.png");
    int allHeight = screenSize.height - 100;

    JPanel menuPanel = new JPanel(new BorderLayout());
    JPanel mainPanel = new JPanel(new BorderLayout());

    //left menu
    JPanel menuLogoPanel = new JPanel(new BorderLayout());
    JPanel menuMainPanel = new JPanel();
    JPanel menuMorePanel = new JPanel(new BorderLayout());

    ImageIcon menuLogo = new ImageIcon("front/instagram_clone/image/menu_logo.png");
    ImageIcon menuHome = new ImageIcon("front/instagram_clone/image/menu_home.png");
    ImageIcon menuSearch = new ImageIcon("front/instagram_clone/image/menu_search.png");
    ImageIcon menuDiscover = new ImageIcon("front/instagram_clone/image/menu_discover.png");
    ImageIcon menuMessage = new ImageIcon("front/instagram_clone/image/menu_message.png");
    ImageIcon menuNotice = new ImageIcon("front/instagram_clone/image/menu_notice.png");
    ImageIcon menuUpload = new ImageIcon("front/instagram_clone/image/menu_upload.png");
    ImageIcon menuProfil = new ImageIcon("front/instagram_clone/image/harry_potter_profil_circle.png");
    ImageIcon menuMore = new ImageIcon("front/instagram_clone/image/menu_more.png");

    ImageIcon menuGrayHome = new ImageIcon("front/instagram_clone/image/menu_gray_home.png");
    ImageIcon menuGraySearch = new ImageIcon("front/instagram_clone/image/menu_gray_search.png");
    ImageIcon menuGrayDiscover = new ImageIcon("front/instagram_clone/image/menu_gray_discover.png");
    ImageIcon menuGrayMessage = new ImageIcon("front/instagram_clone/image/menu_gray_message.png");
    ImageIcon menuGrayNotice = new ImageIcon("front/instagram_clone/image/menu_gray_notice.png");
    ImageIcon menuGrayUpload = new ImageIcon("front/instagram_clone/image/menu_gray_upload.png");
    ImageIcon menuGrayMore = new ImageIcon("front/instagram_clone/image/menu_gray_more.png");

    JButton bt_menuLogo;
    JButton bt_menuHome;
    JButton bt_menuSearch;
    JButton bt_menuDiscover;
    JButton bt_menuMessage;
    JButton bt_menuNotice;
    JButton bt_menuUpload;
    JPanel panel_menuProfil = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton bt_menuMore;

    //main panel
    JScrollPane mainScroll;

    JPanel tempWest;
    JPanel tempEast;
    JPanel center;

    public Home() {
        setLayout(new BorderLayout());
        setSize(new Dimension(1265, allHeight));
        setIconImage(ICON.getImage());
        setResizable(false);

        //여기서 함수 실행
        setMenuPanel();
        setMainPanel();

        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void setMainPanel() {
        mainPanel.setPreferredSize(new Dimension(980, allHeight));
        mainPanel.setBackground(Color.BLACK);

        tempWest = new JPanel(new BorderLayout());
        tempEast = new JPanel(new BorderLayout());
        center = new JPanel();

        tempWest.setPreferredSize(new Dimension(250, allHeight));
        tempEast.setPreferredSize(new Dimension(250, allHeight));

        center.setBackground(Color.WHITE);

        getArticle();

        mainScroll = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setBorder(new EmptyBorder(0,0,0,0));
        mainScroll.getVerticalScrollBar().setUI(new MyScrollBarUI());

        mainPanel.add(tempWest, BorderLayout.WEST);
        mainPanel.add(tempEast, BorderLayout.EAST);
        mainPanel.add(mainScroll, BorderLayout.CENTER);
    }

    private void getArticle() {
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        center.add(new EachArticle());
        center.add(new Line());
        center.add(new EachArticle());
        center.add(new Line());
        center.add(new EachArticle());
    }

    private void setMenuPanel(){
        menuPanel.setPreferredSize(new Dimension(245, allHeight));
        menuPanel.setBackground(Color.WHITE);
        Border menuPanelPadding = new EmptyBorder(8,12,20,12);
        menuPanel.setBorder(new CompoundBorder(menuPanel.getBorder(), menuPanelPadding));

        getMenuBtn();

        menuLogoPanel.setPreferredSize(new Dimension(220, 92));
        menuLogoPanel.setBackground(Color.white);
        menuLogoPanel.add(bt_menuLogo, BorderLayout.CENTER);
        JPanel logoBorderTemp = new JPanel();
        logoBorderTemp.setBackground(Color.GRAY);
        logoBorderTemp.setPreferredSize(new Dimension(1, 92));
        menuLogoPanel.add(logoBorderTemp, BorderLayout.EAST);

        menuMainPanel.setLayout(new GridLayout(7,1,0,10));
        menuMainPanel.setBackground(Color.white);
        menuMainPanel.setPreferredSize(new Dimension(220, 450));
        menuMainPanel.add(bt_menuHome);
        menuMainPanel.add(bt_menuSearch);
        menuMainPanel.add(bt_menuDiscover);
        menuMainPanel.add(bt_menuMessage);
        menuMainPanel.add(bt_menuNotice);
        menuMainPanel.add(bt_menuUpload);
        menuMainPanel.add(panel_menuProfil);

        JPanel temp = new JPanel();
        temp.add(menuMainPanel);
        temp.setBackground(Color.white);

        menuMorePanel.setPreferredSize(new Dimension(220, 64));
        menuMorePanel.setBackground(Color.white);
        menuMorePanel.add(bt_menuMore, BorderLayout.CENTER);
        JPanel moreBorderTemp = new JPanel();
        moreBorderTemp.setBackground(Color.GRAY);
        moreBorderTemp.setPreferredSize(new Dimension(1, 64));
        menuMorePanel.add(moreBorderTemp, BorderLayout.EAST);

        JPanel borderTemp = new JPanel();
        borderTemp.setBackground(Color.GRAY);
        borderTemp.setPreferredSize(new Dimension(1, allHeight));

        menuPanel.add(menuLogoPanel, BorderLayout.NORTH);
        menuPanel.add(temp, BorderLayout.CENTER);
        menuPanel.add(menuMorePanel, BorderLayout.SOUTH);
        menuPanel.add(borderTemp, BorderLayout.EAST);
    }

    private ImageIcon setMenuBtnSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_AREA_AVERAGING);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }

    private void getMenuBtn() {
        bt_menuLogo = new JButton(setMenuBtnSize(menuLogo, 220, 92));
        bt_menuLogo.setBorderPainted(false);
        bt_menuLogo.setContentAreaFilled(false);
        bt_menuLogo.setFocusPainted(false);
        bt_menuHome = new JButton(setMenuBtnSize(menuHome, 220, 48));
        bt_menuHome.setBorderPainted(false);
        bt_menuHome.setContentAreaFilled(false);
        bt_menuHome.setFocusPainted(false);
        bt_menuSearch = new JButton(setMenuBtnSize(menuSearch, 220, 48));
        bt_menuSearch.setBorderPainted(false);
        bt_menuSearch.setContentAreaFilled(false);
        bt_menuSearch.setFocusPainted(false);
        bt_menuDiscover = new JButton(setMenuBtnSize(menuDiscover, 220, 48));
        bt_menuDiscover.setBorderPainted(false);
        bt_menuDiscover.setContentAreaFilled(false);
        bt_menuDiscover.setFocusPainted(false);
        bt_menuMessage = new JButton(setMenuBtnSize(menuMessage, 220, 48));
        bt_menuMessage.setBorderPainted(false);
        bt_menuMessage.setContentAreaFilled(false);
        bt_menuMessage.setFocusPainted(false);
        bt_menuNotice = new JButton(setMenuBtnSize(menuNotice, 220, 48));
        bt_menuNotice.setBorderPainted(false);
        bt_menuNotice.setContentAreaFilled(false);
        bt_menuNotice.setFocusPainted(false);
        bt_menuUpload = new JButton(setMenuBtnSize(menuUpload, 220, 48));
        bt_menuUpload.setBorderPainted(false);
        bt_menuUpload.setContentAreaFilled(false);
        bt_menuUpload.setFocusPainted(false);
        bt_menuMore = new JButton(setMenuBtnSize(menuMore, 220, 48));
        bt_menuMore.setBorderPainted(false);
        bt_menuMore.setContentAreaFilled(false);
        bt_menuMore.setFocusPainted(false);

        JLabel profilImgLabel = new JLabel(setMenuBtnSize(menuProfil, 24, 24));
        JLabel profilTextLabel = new JLabel("프로필");
        profilTextLabel.setFont(new Font(profilTextLabel.getFont().getName(), Font.BOLD, 15));
        Border profilTextMargin = new EmptyBorder(0,12,0,0);
        profilTextLabel.setBorder(new CompoundBorder(profilTextLabel.getBorder(), profilTextMargin));
        Border menuProfilMargin = new EmptyBorder(0,20,0,0);
        panel_menuProfil.setBorder(new CompoundBorder(panel_menuProfil.getBorder(), menuProfilMargin));
        panel_menuProfil.setBackground(Color.WHITE);
        panel_menuProfil.add(profilImgLabel);
        panel_menuProfil.add(profilTextLabel);

        setMenuButtonListener();
    }



    private void setMenuButtonListener() {

        bt_menuLogo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getContentPane().removeAll();
                getContentPane().add(menuPanel, BorderLayout.WEST);
                getContentPane().add(mainPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt_menuLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuLogo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        bt_menuHome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getContentPane().removeAll();
                getContentPane().add(menuPanel, BorderLayout.WEST);
                getContentPane().add(mainPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt_menuHome.setIcon(setMenuBtnSize(menuGrayHome, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuHome.setIcon(setMenuBtnSize(menuHome, 220, 48));
            }
        });

        bt_menuSearch.addMouseListener(new MouseListener() {
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
                bt_menuSearch.setIcon(setMenuBtnSize(menuGraySearch, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuSearch.setIcon(setMenuBtnSize(menuSearch, 220, 48));
            }
        });

        bt_menuDiscover.addMouseListener(new MouseListener() {
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
                bt_menuDiscover.setIcon(setMenuBtnSize(menuGrayDiscover, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuDiscover.setIcon(setMenuBtnSize(menuDiscover, 220, 48));
            }
        });

        bt_menuMessage.addMouseListener(new MouseListener() {
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
                bt_menuMessage.setIcon(setMenuBtnSize(menuGrayMessage, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuMessage.setIcon(setMenuBtnSize(menuMessage, 220, 48));
            }
        });

        bt_menuNotice.addMouseListener(new MouseListener() {
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
                bt_menuNotice.setIcon(setMenuBtnSize(menuGrayNotice, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuNotice.setIcon(setMenuBtnSize(menuNotice, 220, 48));
            }
        });

        bt_menuUpload.addMouseListener(new MouseListener() {
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
                bt_menuUpload.setIcon(setMenuBtnSize(menuGrayUpload, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuUpload.setIcon(setMenuBtnSize(menuUpload, 220, 48));
            }
        });

        panel_menuProfil.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getContentPane().removeAll();
                getContentPane().add(menuPanel, BorderLayout.WEST);
                getContentPane().add(new EachUserBoard(1), BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_menuProfil.setBackground(new Color(224,224,224));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_menuProfil.setBackground(Color.WHITE);
            }
        });

        bt_menuMore.addMouseListener(new MouseListener() {
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
                bt_menuMore.setIcon(setMenuBtnSize(menuGrayMore, 220, 48));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt_menuMore.setIcon(setMenuBtnSize(menuMore, 220, 48));
            }
        });
    }
}
