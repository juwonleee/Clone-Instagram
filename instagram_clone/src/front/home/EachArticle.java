package front.home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EachArticle extends JPanel {

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel top_centerPanel = new JPanel(new GridBagLayout());
    JPanel top_realPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel midPanel = new JPanel(new BorderLayout());

    JPanel bottomPanel = new JPanel(new BorderLayout());
    JPanel bottom_topPanel = new JPanel(new BorderLayout());
    JPanel bottom_centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel bottom_bottomPanel = new JPanel();
    JPanel bottom_top_icon_panel = new JPanel(new BorderLayout());
    JPanel bottom_top_likeCnt_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    ImageIcon profilImg = new ImageIcon("instagram_clone/src/front/image/harry_potter_profil_circle.png");
    ImageIcon moreImg = new ImageIcon("instagram_clone/src/front/image/icon_board_more.png");
    ImageIcon mainImg = new ImageIcon("instagram_clone/src/front/image/harry_potter.png");
    ImageIcon likeImg = new ImageIcon("instagram_clone/src/front/image/icon_like.png");
    ImageIcon likeFillImg = new ImageIcon("instagram_clone/src/front/image/icon_like_fill.png");
    ImageIcon commentImg = new ImageIcon("instagram_clone/src/front/image/icon_comment.png");
    ImageIcon messageImg = new ImageIcon("instagram_clone/src/front/image/icon_dm.png");
    ImageIcon bookmarkImg = new ImageIcon("front/instagram_clone/src/front/image/icon_bookmark.png");
    ImageIcon profilEmptyImg = new ImageIcon("front/instagram_clone/src/front/image/profil_empty.jpg");
    ImageIcon commentEmojiImg = new ImageIcon("front/instagram_clone/src/front/image/icon_comment_emoji.png");

    JLabel profilLabel;
    JLabel moreLabel;
    JLabel mainLabel;
    JLabel likeLabel;
    JLabel commentLabel;
    JLabel messageLabel;
    JLabel bookmarkLabel;
    JLabel profilEmptyLabel;
    JTextField typeCommentField;

    String myId = "harry_potter";
    int commentCnt = 3;

    Boolean isLiked = false;

    public EachArticle() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        setTopPanel();
        setMidPanel();
        setBottomPanel();

        setArticleClickListener();

        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }

    private void setTopPanel() {
        topPanel.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(472,56));

        profilLabel = new JLabel(setImageSize(profilImg, 42,42));
        Border profilLabelBorder = profilLabel.getBorder();
        Border profilLabelMargin = new EmptyBorder(8,5,8,4);
        profilLabel.setBorder(new CompoundBorder(profilLabelBorder, profilLabelMargin));
        topPanel.add(profilLabel, BorderLayout.WEST);

        top_realPanel.setBackground(Color.WHITE);
        top_realPanel.setPreferredSize(new Dimension(382,28));
        top_realPanel.add(new JLabel(myId + " ·"));
        top_realPanel.add(new JLabel("3시간"));
        top_centerPanel.add(top_realPanel);
        top_centerPanel.setBackground(Color.WHITE);
        topPanel.add(top_centerPanel, BorderLayout.CENTER);

        moreLabel = new JLabel(setImageSize(moreImg, 24,24));
        Border moreLabelBorder = moreLabel.getBorder();
        Border moreLbaelMargin = new EmptyBorder(8,8,8,8);
        moreLabel.setBorder(new CompoundBorder(moreLabelBorder, moreLbaelMargin));
        topPanel.add(moreLabel, BorderLayout.EAST);
    }

    private void setMidPanel() {
        midPanel.setBackground(Color.WHITE);
        midPanel.setPreferredSize(new Dimension(472, 472));
        midPanel.add(new JLabel("MID PANEL"), BorderLayout.CENTER);
        mainLabel = new JLabel(setImageSize(mainImg, 472,472));
        midPanel.add(mainLabel, BorderLayout.CENTER);
    }

    private void setBottomPanel() {
        bottomPanel.setBackground(Color.white);
        bottomPanel.add(new JLabel("BOTTOM PANEL"), BorderLayout.CENTER);

        Border bottomIconMargin = new EmptyBorder(8,8,8,8);
        likeLabel = new JLabel(setImageSize(likeImg, 24,24));
        likeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Border likeLabelBorder = likeLabel.getBorder();
        likeLabel.setBorder(new CompoundBorder(likeLabelBorder, bottomIconMargin));
        commentLabel = new JLabel(setImageSize(commentImg, 24, 24));
        Border commentLabelBorder = commentLabel.getBorder();
        commentLabel.setBorder(new CompoundBorder(commentLabelBorder, bottomIconMargin));
        messageLabel = new JLabel(setImageSize(messageImg, 24,24));
        Border messageLabelBorder = messageLabel.getBorder();
        messageLabel.setBorder(new CompoundBorder(messageLabelBorder, bottomIconMargin));
        JPanel topIconPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topIconPanel.setBackground(Color.WHITE);
        topIconPanel.setPreferredSize(new Dimension(432, 40));
        topIconPanel.add(likeLabel);
        topIconPanel.add(commentLabel);
        topIconPanel.add(messageLabel);

        bottom_top_icon_panel.setBackground(Color.WHITE);
        bottom_top_icon_panel.add(topIconPanel, BorderLayout.CENTER);

        bookmarkLabel = new JLabel(setImageSize(bookmarkImg, 24,24));
        Border bookmarkLabelBorder= bookmarkLabel.getBorder();
        bookmarkLabel.setBorder(new CompoundBorder(bookmarkLabelBorder, bottomIconMargin));
        bottom_top_icon_panel.add(bookmarkLabel, BorderLayout.EAST);

        profilEmptyLabel = new JLabel(setImageSize(profilEmptyImg, 14,14));
        Border profilEmptyLabelBorder = profilEmptyLabel.getBorder();
        Border profilEmptyLabelMargin = new EmptyBorder(2,2,2,2);
        profilEmptyLabel.setBorder(new CompoundBorder(profilEmptyLabelBorder, profilEmptyLabelMargin));

        JLabel likeCntLabel = new JLabel("rohn__ 님 외 50명이 좋아합니다");

        bottom_top_likeCnt_panel.setBackground(Color.WHITE);
        bottom_top_likeCnt_panel.add(profilEmptyLabel);
        bottom_top_likeCnt_panel.add(likeCntLabel);

        bottom_topPanel.add(bottom_top_icon_panel, BorderLayout.NORTH);
        bottom_topPanel.add(bottom_top_likeCnt_panel, BorderLayout.CENTER);

        setMainArticle();
        setCommentSection();

        bottomPanel.add(bottom_topPanel, BorderLayout.NORTH);
        bottomPanel.add(bottom_centerPanel, BorderLayout.CENTER);
        bottomPanel.add(bottom_bottomPanel, BorderLayout.SOUTH);

        Border bottomMargin = new EmptyBorder(20,2,20,2);
        setBorder(new CompoundBorder(getBorder(), bottomMargin));
    }

    private void setMainArticle() {
        JLabel articleIdLabel = new JLabel(myId);
        JLabel articleTextLabel = new JLabel("시간을 돌리는 자");
        bottom_centerPanel.setBackground(Color.WHITE);
        bottom_centerPanel.add(articleIdLabel);
        bottom_centerPanel.add(articleTextLabel);
    }

    private void setCommentSection() {
        bottom_bottomPanel.setBackground(Color.WHITE);
        bottom_bottomPanel.setLayout(new BoxLayout(bottom_bottomPanel, BoxLayout.Y_AXIS));

        JLabel allCommentLabel = new JLabel("댓글 " + commentCnt + "개 모두 보기");
        allCommentLabel.setPreferredSize(new Dimension(472, 20));
        JPanel allCommentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        allCommentPanel.setBackground(Color.WHITE);
        allCommentPanel.add(allCommentLabel);
        bottom_bottomPanel.add(allCommentPanel);

        bottom_bottomPanel.add(new EachComment("herrr_ny", "너 뭐하니?"));
        bottom_bottomPanel.add(new EachComment("rohn__", "너 뭐해??"));

        JPanel writeCommentPanel = new JPanel(new BorderLayout());
        writeCommentPanel.setBackground(Color.WHITE);
        JLabel commentSmileLabel = new JLabel(setImageSize(commentEmojiImg, 14, 14));
        Border commentSmileMargin = new EmptyBorder(0,5,0,5);
        commentSmileLabel.setBorder(new CompoundBorder(commentSmileLabel.getBorder(), commentSmileMargin));

        writeCommentPanel.add(commentSmileLabel, BorderLayout.EAST);

        typeCommentField = new HintTextField("댓글 달기...");
        typeCommentField.setPreferredSize(new Dimension(440, 22));
        writeCommentPanel.add(typeCommentField, BorderLayout.CENTER);

        Border writeBorder = writeCommentPanel.getBorder();
        Border writeMargin = new EmptyBorder(8,0,0,0);
        writeCommentPanel.setBorder(new CompoundBorder(writeBorder, writeMargin));

        bottom_bottomPanel.add(writeCommentPanel);
    }

    private void setArticleClickListener() {
        likeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isLiked) {
                    likeLabel.setIcon(setImageSize(likeImg, 24,24));
                } else {
                    likeLabel.setIcon(setImageSize(likeFillImg, 24,24));
                }
                isLiked = !isLiked;
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

}
