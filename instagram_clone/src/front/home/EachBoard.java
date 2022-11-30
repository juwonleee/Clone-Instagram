package front.home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.PrimitiveIterator;

public class EachBoard extends JPanel {
    Color bgColor = new Color(250,250,250);

    private int eachBoardWidth = getWidth();
    private int eachBoardHeight = getHeight();

    private ImageIcon image;
    private int boardNum;
    private String userId;
    private String userMessage;
    private String timeAgoText;

    ImageIcon profilImg = new ImageIcon("front/instagram_clone/image/harry_potter_profil_circle.png");
    ImageIcon likeImg = new ImageIcon("front/instagram_clone/image/icon_like.png");
    ImageIcon likeFillImg = new ImageIcon("front/instagram_clone/image/icon_like_fill.png");
    ImageIcon commentImg = new ImageIcon("front/instagram_clone/image/icon_comment.png");
    ImageIcon messageImg = new ImageIcon("front/instagram_clone/image/icon_dm.png");
    ImageIcon bookmarkImg = new ImageIcon("front/instagram_clone/image/icon_bookmark.png");
    ImageIcon profilEmptyImg = new ImageIcon("front/instagram_clone/image/profil_empty.jpg");


    JLabel profilLabel;
    JLabel moreLabel;
    JLabel mainLabel;
    JLabel likeLabel;
    JLabel commentLabel;
    JLabel messageLabel;
    JLabel bookmarkLabel;
    JLabel profilEmptyLabel;
    JTextField typeCommentField;

    JLabel pictureLabel;
    JPanel contentPanel;

    JPanel contentTopPanel;
    JPanel contentCenterPanel;
    JPanel contentBottomPanel;

    JLabel profilPic;
    JLabel userIdLabel;

    JPanel commentPanel = new JPanel();
    JPanel myTextPanel;
    JLabel myTextProfilLabel;
    JScrollPane commentScroll;

    JPanel iconPanel = new JPanel(new BorderLayout());
    JPanel likeCntPanel;


    public EachBoard(ImageIcon image, int boardNum) {
        this.image = image;
        this.boardNum = boardNum;

        userId = "harry_potter";
        userMessage = "호그와트 가고싶다";
        timeAgoText = "21주";

        setLayout(new BorderLayout());

        getPictureLabel();
        getBoardPanel();

    }

    private void getPictureLabel() {
        pictureLabel = new JLabel(setImageSize(image, 600, 600));

        add(pictureLabel, BorderLayout.WEST);
    }

    private void getBoardPanel() {
        contentPanel = new JPanel(new BorderLayout());

        getContentTopPanel();
        getContentCenterPanel();
        getContentBottomPanel();

        add(contentPanel, BorderLayout.EAST);
    }

    private void getContentTopPanel() {
        Border border14 = new EmptyBorder(14,14,14,14);
        Border borderLeft16 = new EmptyBorder(0,16,0,0);
        contentTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentTopPanel.setPreferredSize(new Dimension(400,70));
        contentTopPanel.setBorder(new CompoundBorder(contentTopPanel.getBorder(), border14));
        contentTopPanel.setBackground(bgColor);

        getMyProfilImg();

        userIdLabel = new JLabel(userId);
        userIdLabel.setFont(new Font(userIdLabel.getFont().getName(), Font.BOLD, 16));
        userIdLabel.setBorder(new CompoundBorder(userIdLabel.getBorder(), borderLeft16));

        contentTopPanel.add(profilPic);
        contentTopPanel.add(userIdLabel);

        contentPanel.add(contentTopPanel, BorderLayout.NORTH);
    }

    private void getContentCenterPanel() {
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));

        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.add(new Comment("hungry","I am hungry", "21시간 전"));
        commentPanel.setBackground(bgColor);

        commentScroll = new JScrollPane(commentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        commentScroll.setPreferredSize(new Dimension(302,353));
        commentScroll.setBackground(bgColor);

        getContentBottomPanel();


        contentPanel.add(commentScroll, BorderLayout.CENTER);
    }

    private void getContentBottomPanel() {
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
        topIconPanel.setPreferredSize(new Dimension(302, 40));
        topIconPanel.add(likeLabel);
        topIconPanel.add(commentLabel);
        topIconPanel.add(messageLabel);

        iconPanel.setBackground(Color.WHITE);
        iconPanel.add(topIconPanel, BorderLayout.CENTER);

        bookmarkLabel = new JLabel(setImageSize(bookmarkImg, 24,24));
        Border bookmarkLabelBorder= bookmarkLabel.getBorder();
        bookmarkLabel.setBorder(new CompoundBorder(bookmarkLabelBorder, bottomIconMargin));
        iconPanel.add(bookmarkLabel, BorderLayout.EAST);

        typeCommentField = new HintTextField("댓글 달기...");
        typeCommentField.setPreferredSize(new Dimension(282, 40));
        typeCommentField.setBorder(new CompoundBorder(typeCommentField.getBorder(), bottomIconMargin));

        JLabel typeCommentSend = new JLabel("게시");
        typeCommentSend.setForeground(Color.blue);
        typeCommentSend.setFont(new Font(typeCommentSend.getFont().getName(), Font.BOLD, 14));
        typeCommentSend.setBackground(Color.WHITE);
        typeCommentSend.setBorder(new CompoundBorder(typeCommentSend.getBorder(), bottomIconMargin));

        JPanel tempTypeComment = new JPanel(new BorderLayout());
        tempTypeComment.add(typeCommentField, BorderLayout.CENTER);
        tempTypeComment.add(typeCommentSend, BorderLayout.EAST);
        tempTypeComment.setBackground(Color.WHITE);

        contentBottomPanel = new JPanel(new BorderLayout());
        contentBottomPanel.add(iconPanel, BorderLayout.CENTER);
        contentBottomPanel.add(tempTypeComment, BorderLayout.SOUTH);
        contentPanel.add(contentBottomPanel, BorderLayout.SOUTH);

    }

    private void getMyProfilImg() {
        Border border5 = new EmptyBorder(5,5,5,5);

        profilPic = new JLabel(setImageSize(profilImg, 42,42));
        profilPic.setBorder(new CompoundBorder(profilPic.getBorder(), border5));
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }
}
