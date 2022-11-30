package front.User;

import front.home.MyScrollBarUI;
import front.home.EachBoard;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EachUserBoard extends JPanel {

    Color bgColor = new Color(250,250,250);

    private int userIdx = 0;
    private String userId = "nothing";
    private int articleNum = 0;
    private int followNum = 0;
    private int followerNum = 0;
    private String  userName = "가나다";
    private String  userMessage = "라마바사";

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel tempLeftPanel = new JPanel(new BorderLayout());
    JPanel tempRightPanel = new JPanel(new BorderLayout());

    JPanel headerPanel = new JPanel(new BorderLayout());
    JPanel headerTopPanel = new JPanel(new BorderLayout());
    JPanel headerBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel contentPanel = new JPanel(new BorderLayout());
    JPanel articleGridPanel;

    JLabel profilImgLabel = new JLabel();

    JPanel profilInfoPanel = new JPanel(new BorderLayout());
    JPanel profilInfoTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel profilInfoCenterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel profilInfoBottomPanel = new JPanel(new BorderLayout());

    JScrollPane profilScroll;

    ImageIcon profilImg = new ImageIcon("front/instagram_clone/front.image/harry_potter_profil_circle.png");
    ImageIcon editProfilImg = new ImageIcon("front/instagram_clone/front.image/edit_profil.png");
    ImageIcon setupImg = new ImageIcon("front/instagram_clone/image/front.setup.png");
    ImageIcon newHighLightImg = new ImageIcon("front/instagram_clone/front.image/new_highlight.jpg");

    ImageIcon article1Img = new ImageIcon("front/instagram_clone/front.image/article_1.jpg");
    ImageIcon article2Img = new ImageIcon("front/instagram_clone/front.image/article_2.jpg");
    ImageIcon article3Img = new ImageIcon("front/instagram_clone/front.image/article_3.jpg");
    ImageIcon article4Img = new ImageIcon("front/instagram_clone/front.image/article_4.jpg");

    ArrayList<ImageIcon> boardImgs = new ArrayList<ImageIcon>();
    ArrayList<String> boardLabels = new ArrayList<String>();

    //프로필인포탑
    JLabel userIdLabel;
    JLabel editProfil;
    JLabel setup;

    //프로필인포센터
    JPanel articleNumPanel = new JPanel(new BorderLayout());
    JPanel followerNumPanel = new JPanel(new BorderLayout());
    JPanel followNumPanel = new JPanel(new BorderLayout());
    JLabel articleLabel;
    JLabel articleNumLabel;
    JLabel followerLabel;
    JLabel followerNumLabel;
    JLabel followLabel;
    JLabel followNumLabel;

    //프로필인포바텀
    JLabel userNameLabel;
    JLabel userMessageLabel;

    //게시물 클릭 시
    JPanel tempTop;
    JPanel tempBottom;
    JPanel tempCenter;

    //팔로우 팔로워
    JPanel followerPanel;
    JPanel followPanel;

    Boolean isFollow = false;

    public EachUserBoard(int id) {
        this.userIdx = id;
        userId = "harry_potter";
        articleNum = 4;
        followerNum = 160;
        followNum = 200;
        userName = "해리포터";
        userMessage = "Hogwarts 그리핀도르 1기 졸업생";

        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(1020, screenSize.height));
        setBackground(new Color(250,250,250));

        resourceList();

        tempLeftPanel.setPreferredSize(new Dimension(22, screenSize.height));
        tempRightPanel.setPreferredSize(new Dimension(23, screenSize.height));

        mainPanel.setBackground(new Color(250,250,250));
        tempLeftPanel.setBackground(new Color(250,250,250));
        tempRightPanel.setBackground(new Color(250,250,250));

        Border mainPadding = new EmptyBorder(30,20,30,20);
        mainPanel.setBorder(new CompoundBorder(mainPanel.getBorder(), mainPadding));

        makeHeader();
        makeContent();
        makeGrid();
        makeClick();

        profilScroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        profilScroll.setPreferredSize(new Dimension(975,screenSize.height - 100));
        profilScroll.setBorder(new EmptyBorder(0,0,0,0));
        profilScroll.getVerticalScrollBar().setUI(new MyScrollBarUI());
        profilScroll.getVerticalScrollBar().setUnitIncrement(16);

        add(profilScroll, BorderLayout.CENTER);
        add(tempLeftPanel, BorderLayout.WEST);
        add(tempRightPanel, BorderLayout.EAST);

    }

    private void resourceList() {
        boardImgs.add(article1Img);
        boardImgs.add(article2Img);
        boardImgs.add(article3Img);
        boardImgs.add(article4Img);

        boardLabels.add("1");
        boardLabels.add("2");
        boardLabels.add("3");
        boardLabels.add("4");
    }

    private void makeHeader() {
        headerTopPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 283));
        headerTopPanel.setBackground(bgColor);

        Border headerMargin = new EmptyBorder(0,0,44,0);
        headerTopPanel.setBorder(new CompoundBorder(headerPanel.getBorder(), headerMargin));

        headerBottomPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 174));
        headerBottomPanel.setBackground(bgColor);
        headerBottomPanel.setBorder(new CompoundBorder(headerBottomPanel.getBorder(), headerMargin));

        headerPanel.add(headerTopPanel, BorderLayout.NORTH);
        headerPanel.add(headerBottomPanel, BorderLayout.SOUTH);

        getHeaderPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
    }

    private void makeContent() {
        int contentPanelWidth = contentPanel.getWidth();
        contentPanel.setPreferredSize(new Dimension(contentPanelWidth, 54));
        contentPanel.setBackground(bgColor);

        JPanel linePanel = new JPanel(new FlowLayout());
        linePanel.setPreferredSize(new Dimension(contentPanelWidth, 1));
        linePanel.setBackground(Color.GRAY);
        contentPanel.add(linePanel, BorderLayout.NORTH);

        JPanel spacePanel = new JPanel(new FlowLayout());
        spacePanel.setPreferredSize(new Dimension(contentPanelWidth, 53));
        spacePanel.setBackground(bgColor);
        contentPanel.add(spacePanel, BorderLayout.CENTER);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    private void makeGrid() {
        JPanel tempGridPanel = new JPanel(new FlowLayout());
        Border bottom87 = new EmptyBorder(0,0,87,0);
        tempGridPanel.setBackground(bgColor);

        articleGridPanel = new JPanel(new GridLayout(0, 3, 28, 28));
        articleGridPanel.setBackground(bgColor);
        articleGridPanel.setBorder(new CompoundBorder(articleNumPanel.getBorder(), bottom87));
        getArticles();
        tempGridPanel.add(articleGridPanel);

        makeFollowPanel(1);

        mainPanel.add(tempGridPanel, BorderLayout.SOUTH);
    }

    private void getArticles() {
        for (int i=0;i< boardImgs.size();i++) {
            articleGridPanel.add(makeImgToGrid(boardImgs.get(i), boardLabels.get(i)));
        }
//        articleGridPanel.add(makeImgToGrid(boardImgs.get(0), boardLabels.get(0)));
//        articleGridPanel.add(makeImgToGrid(boardImgs.get(1), boardLabels.get(1)));
//        articleGridPanel.add(makeImgToGrid(boardImgs.get(2), boardLabels.get(2)));
//        articleGridPanel.add(makeImgToGrid(boardImgs.get(3), boardLabels.get(3)));
    }

    private JLabel makeImgToGrid(ImageIcon img, String label) {
        JLabel temp = new JLabel(setImageSize(img, 293,293));
        temp.addMouseListener(new BoardListener());
        temp.setToolTipText(label);
        return temp;
    }

    private void makeFollowPanel(int userIdx) {
        Border bottom87 = new EmptyBorder(0,0,87,0);

        followPanel = new JPanel(new BorderLayout());
        followPanel.setBorder(new CompoundBorder(followPanel.getBorder(), bottom87));

        JPanel tempLeft = new JPanel(new FlowLayout());
        tempLeft.setBackground(Color.BLUE);
        JPanel tempRight = new JPanel(new FlowLayout());
        tempRight.setBackground(Color.BLUE);
        JPanel tempCenter = new JPanel();
        tempCenter.setLayout(new BoxLayout(tempCenter, BoxLayout.Y_AXIS));
        tempCenter.setPreferredSize(new Dimension(300, 300));

        JLabel name1Label = new JLabel("론");
        JLabel name2Label = new JLabel("론");
        JLabel name3Label = new JLabel("론");
        JLabel name4Label = new JLabel("론");
        JLabel name5Label = new JLabel("론");
        JLabel name6Label = new JLabel("론");

        tempCenter.add(name1Label);
        tempCenter.add(name2Label);
        tempCenter.add(name3Label);
        tempCenter.add(name4Label);
        tempCenter.add(name5Label);
        tempCenter.add(name6Label);

        followPanel.add(tempLeft, BorderLayout.WEST);
        followPanel.add(tempRight, BorderLayout.EAST);
        followPanel.add(tempCenter, BorderLayout.CENTER);

    }

    private void getHeaderPanel() {
        getHeaderTopPanel();
        getHeaderBottomPanel();
    }

    private void getHeaderTopPanel() {
        getProfilImg();
        getProfilInfo();
    }

    private void getHeaderBottomPanel() {
        Border left20 = new EmptyBorder(0,20,0,0);
        JLabel highlightLabel = new JLabel(setImageSize(newHighLightImg, 115,130));
        highlightLabel.setBorder(new CompoundBorder(highlightLabel.getBorder(), left20));
        headerBottomPanel.add(highlightLabel);
    }

    private void getProfilImg() {
        profilImgLabel.setPreferredSize(new Dimension(291,209));
        Border profilPadding = new EmptyBorder(21,62,21,62);
        profilImgLabel.setBorder(new CompoundBorder(profilImgLabel.getBorder(), profilPadding));
        profilImgLabel.setIcon(setImageSize(profilImg, 168,168));

        headerTopPanel.add(profilImgLabel, BorderLayout.WEST);
    }

    private void getProfilInfo(){
        int profilInfoWidth = profilInfoPanel.getWidth();
        Border profilPadding20 = new EmptyBorder(0,0,20,0);
        Border profilPadding44 = new EmptyBorder(0,0,44,0);

        profilInfoPanel.setBackground(bgColor);

        //top
        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.setPreferredSize(new Dimension(profilInfoWidth, 68));
        topWrapper.setBackground(bgColor);
        JPanel tempTop = new JPanel(new FlowLayout());
        tempTop.setPreferredSize(new Dimension(profilInfoWidth, 20));
        tempTop.setBackground(bgColor);

        profilInfoTopPanel.setPreferredSize(new Dimension(profilInfoWidth, 68));
        profilInfoTopPanel.setBorder(new CompoundBorder(profilInfoTopPanel.getBorder(), profilPadding20));
        profilInfoTopPanel.setBackground(bgColor);
        getProfilInfoTop();

        topWrapper.add(tempTop, BorderLayout.NORTH);
        topWrapper.add(profilInfoTopPanel, BorderLayout.CENTER);

        //center
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setPreferredSize(new Dimension(profilInfoWidth, 44));
        centerWrapper.setBackground(bgColor);
        JPanel tempCenter = new JPanel(new FlowLayout());
        tempCenter.setPreferredSize(new Dimension(profilInfoWidth, 20));
        tempCenter.setBackground(bgColor);

        profilInfoCenterPanel.setPreferredSize(new Dimension(profilInfoWidth, 44));
        profilInfoCenterPanel.setBorder(new CompoundBorder(profilInfoCenterPanel.getBorder(), profilPadding20));
        profilInfoCenterPanel.setBackground(bgColor);
        getProfilInfoCenter();

        centerWrapper.add(tempCenter, BorderLayout.NORTH);
        centerWrapper.add(profilInfoCenterPanel, BorderLayout.CENTER);

        //bottom
        profilInfoBottomPanel.setPreferredSize(new Dimension(profilInfoWidth, 92));
        profilInfoBottomPanel.setBackground(bgColor);
        profilInfoBottomPanel.setBorder(new CompoundBorder(profilInfoBottomPanel.getBorder(), profilPadding44));
        getProfilInfoBottom();

        profilInfoPanel.add(topWrapper, BorderLayout.NORTH);
        profilInfoPanel.add(centerWrapper, BorderLayout.CENTER);
        profilInfoPanel.add(profilInfoBottomPanel, BorderLayout.SOUTH);

        headerTopPanel.add(profilInfoPanel, BorderLayout.CENTER);
    }

    private void getProfilInfoTop() {
        userIdLabel = new JLabel(userId);
        userIdLabel.setFont(new Font(userIdLabel.getFont().getName(), Font.PLAIN, 28));

        editProfil = new JLabel(setImageSize(editProfilImg, 94,30));
        Border leftMargin20 = new EmptyBorder(0,20,0,0);
        editProfil.setBorder(new CompoundBorder(editProfil.getBorder(), leftMargin20));

        setup = new JLabel(setImageSize(setupImg, 24,24));
        Border margin8 = new EmptyBorder(8,8,8,8);
        setup.setBorder(new CompoundBorder(setup.getBorder(), margin8));

        profilInfoTopPanel.add(userIdLabel);
        profilInfoTopPanel.add(editProfil);
        profilInfoTopPanel.add(setup);
    }

    private void getProfilInfoCenter() {
        Border right40 = new EmptyBorder(0,0,0,40);

        articleLabel = new JLabel("게시물 ");
        articleNumLabel = new JLabel(Integer.toString(articleNum));

        articleLabel.setFont(new Font(articleLabel.getFont().getName(), Font.PLAIN, 16));
        articleNumLabel.setFont(new Font(articleLabel.getFont().getName(), Font.PLAIN, 16));

        articleLabel.setBackground(bgColor);
        articleNumLabel.setBackground(bgColor);

        articleNumPanel.add(articleLabel, BorderLayout.CENTER);
        articleNumPanel.add(articleNumLabel, BorderLayout.EAST);
        articleNumPanel.setBackground(bgColor);
        articleNumPanel.setBorder(new CompoundBorder(articleNumPanel.getBorder(), right40));

        followerLabel = new JLabel("팔로워 ");
        followerNumLabel = new JLabel(Integer.toString(followerNum));

        followerLabel.setFont(new Font(followerLabel.getFont().getName(), Font.PLAIN, 16));
        followerNumLabel.setFont(new Font(followerNumLabel.getFont().getName(), Font.PLAIN, 16));

        followerLabel.setBackground(bgColor);
        followerNumLabel.setBackground(bgColor);

        followerNumPanel.add(followerLabel, BorderLayout.CENTER);
        followerNumPanel.add(followerNumLabel, BorderLayout.EAST);
        followerNumPanel.setBackground(bgColor);
        followerNumPanel.setBorder(new CompoundBorder(followerNumPanel.getBorder(), right40));

        followLabel = new JLabel("팔로워 ");
        followNumLabel = new JLabel(Integer.toString(followNum));

        followLabel.setFont(new Font(followLabel.getFont().getName(), Font.PLAIN, 16));
        followNumLabel.setFont(new Font(followNumLabel.getFont().getName(), Font.PLAIN, 16));

        followLabel.setBackground(bgColor);
        followNumLabel.setBackground(bgColor);

        followNumPanel.add(followLabel, BorderLayout.CENTER);
        followNumPanel.add(followNumLabel, BorderLayout.EAST);
        followNumPanel.setBackground(bgColor);
        followNumPanel.setBorder(new CompoundBorder(followNumPanel.getBorder(), right40));

        profilInfoCenterPanel.add(articleNumPanel);
        profilInfoCenterPanel.add(followerNumPanel);
        profilInfoCenterPanel.add(followNumPanel);
    }

    private void makeClick() {
        followNumPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isFollow) {
                    mainPanel.remove(articleGridPanel);
                    mainPanel.add(followPanel, BorderLayout.SOUTH);
                } else {
                    mainPanel.remove(followPanel);
                    mainPanel.add(articleGridPanel, BorderLayout.SOUTH);
                }
                isFollow = !isFollow;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void getProfilInfoBottom(){
        int profilInfoWidth = profilInfoBottomPanel.getWidth();

        JPanel tempTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel tempBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));

        tempTop.setPreferredSize(new Dimension(profilInfoWidth, 24));
        tempBottom.setPreferredSize(new Dimension(profilInfoWidth, 24));
        tempTop.setBackground(bgColor);
        tempBottom.setBackground(bgColor);

        userNameLabel = new JLabel(userName);
        userMessageLabel = new JLabel(userMessage);
        userNameLabel.setFont(new Font(userNameLabel.getFont().getName(), Font.BOLD, 16));
        userMessageLabel.setFont(new Font(userNameLabel.getFont().getName(), Font.PLAIN, 16));

        tempTop.add(userNameLabel);
        tempBottom.add(userMessageLabel);

        profilInfoBottomPanel.add(tempTop, BorderLayout.NORTH);
        profilInfoBottomPanel.add(tempBottom, BorderLayout.SOUTH);
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }

    private class BoardListener implements MouseListener {
        JLabel clicked;

        @Override
        public void mouseClicked(MouseEvent e) {
            clicked = (JLabel) e.getSource();

            remove(profilScroll);
            remove(tempRightPanel);
            remove(tempLeftPanel);

            tempTop = new JPanel(new BorderLayout());
            tempTop.setBackground(bgColor);
            tempTop.setPreferredSize(new Dimension(getWidth(), 200));
            tempTop.addMouseListener(new TempListener());

            tempBottom = new JPanel(new BorderLayout());
            tempBottom.setBackground(bgColor);
            tempBottom.setPreferredSize(new Dimension(getWidth(), 200));
            tempBottom.addMouseListener(new TempListener());

            tempCenter = new EachBoard((ImageIcon) clicked.getIcon(), Integer.parseInt(clicked.getToolTipText()));

            add(tempTop, BorderLayout.NORTH);
            add(tempBottom, BorderLayout.SOUTH);
            add(tempCenter, BorderLayout.CENTER);

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
            JLabel label = (JLabel) e.getSource();
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class TempListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            remove(tempTop);
            remove(tempBottom);
            remove(tempCenter);

            add(profilScroll, BorderLayout.CENTER);
            add(tempRightPanel, BorderLayout.EAST);
            add(tempLeftPanel, BorderLayout.WEST);

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

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

