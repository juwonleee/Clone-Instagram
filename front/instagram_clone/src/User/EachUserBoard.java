package User;

import home.MyScrollBarUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EachUserBoard extends JPanel {

    private int userId = 0;

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel tempLeftPanel = new JPanel(new BorderLayout());
    JPanel tempRightPanel = new JPanel(new BorderLayout());

    JPanel headerPanel = new JPanel(new BorderLayout());
    JPanel headerTopPanel = new JPanel(new BorderLayout());
    JPanel headerBottomPanel = new JPanel(new BorderLayout());
    JPanel contentPanel = new JPanel(new BorderLayout());

    JLabel profilImgLabel = new JLabel();

    JPanel profilInfoPanel = new JPanel(new BorderLayout());
    JPanel profilInfoTopPanel = new JPanel(new BorderLayout());
    JPanel profilInfoCenterPanel = new JPanel(new BorderLayout());
    JPanel profilInfoBottomPanel = new JPanel(new BorderLayout());

    JScrollPane profilScroll;

    ImageIcon profilImg = new ImageIcon("front/instagram_clone/image/harry_potter_profil_circle.png");

    //975

    public EachUserBoard(int id) {
        this.userId = id;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1020, screenSize.height));
        setBackground(new Color(250,250,250));

        profilScroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        profilScroll.setBorder(new EmptyBorder(0,0,0,0));
        profilScroll.getVerticalScrollBar().setUI(new MyScrollBarUI());
        tempLeftPanel.setPreferredSize(new Dimension(22, screenSize.height));
        tempRightPanel.setPreferredSize(new Dimension(23, screenSize.height));

        mainPanel.setBackground(new Color(250,250,250));
        tempLeftPanel.setBackground(new Color(250,250,250));
        tempRightPanel.setBackground(new Color(250,250,250));

        Border mainPadding = new EmptyBorder(30,20,30,20);
        mainPanel.setBorder(new CompoundBorder(mainPanel.getBorder(), mainPadding));

        makeHeader();

        add(profilScroll, BorderLayout.CENTER);
        add(tempLeftPanel, BorderLayout.WEST);
        add(tempRightPanel, BorderLayout.EAST);

    }

    private void makeHeader() {
        headerTopPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 283));
        headerTopPanel.setBackground(Color.WHITE);

        Border headerMargin = new EmptyBorder(0,0,44,0);
        headerTopPanel.setBorder(new CompoundBorder(headerPanel.getBorder(), headerMargin));

        headerBottomPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 174));
        headerBottomPanel.setBackground(Color.green);
        headerBottomPanel.setBorder(new CompoundBorder(headerBottomPanel.getBorder(), headerMargin));

        headerPanel.add(headerTopPanel, BorderLayout.NORTH);
        headerPanel.add(headerBottomPanel, BorderLayout.SOUTH);

        getProfilImg();
        getProfilInfo();

        contentPanel.setBackground(Color.BLACK);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
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
        profilInfoPanel.setBackground(Color.CYAN);

        profilInfoTopPanel.setPreferredSize(new Dimension(profilInfoWidth, 68));
        profilInfoTopPanel.setBorder(new CompoundBorder(profilInfoTopPanel.getBorder(), profilPadding20));
        profilInfoTopPanel.setBackground(Color.pink);

        profilInfoCenterPanel.setPreferredSize(new Dimension(profilInfoWidth, 44));
        profilInfoCenterPanel.setBorder(new CompoundBorder(profilInfoCenterPanel.getBorder(), profilPadding20));
        profilInfoCenterPanel.setBackground(Color.orange);

        profilInfoBottomPanel.setPreferredSize(new Dimension(profilInfoWidth, 97));
        profilInfoBottomPanel.setBackground(Color.BLUE);

        profilInfoPanel.add(profilInfoTopPanel, BorderLayout.NORTH);
        profilInfoPanel.add(profilInfoCenterPanel, BorderLayout.CENTER);
        profilInfoPanel.add(profilInfoBottomPanel, BorderLayout.SOUTH);

        headerTopPanel.add(profilInfoPanel, BorderLayout.CENTER);
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }
}
