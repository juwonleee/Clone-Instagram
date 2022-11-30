package home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Comment extends JPanel {
    Border border5 = new EmptyBorder(5,5,5,5);
    Border border14 = new EmptyBorder(14,14,14,14);
    private String userId;
    private String userMessage;
    private String timeAgoText;

    JPanel myTextPanel;
    JLabel myTextProfilLabel;
    JScrollPane commentScroll;

    ImageIcon profilImg = new ImageIcon("front/instagram_clone/image/harry_potter_profil_circle.png");

    public Comment(String id, String message, String time) {
        this.userId = id;
        this.userMessage = message;
        this.timeAgoText = time;

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(334,70));
        setBorder(new CompoundBorder(getBorder(), border14));
        setBackground(new Color(250,250,250));

        getComment();
    }

    private void getComment() {

        myTextProfilLabel = new JLabel(setImageSize(profilImg, 42,42));
        myTextProfilLabel.setBorder(new CompoundBorder(myTextProfilLabel.getBorder(), border5));

        JPanel textWrapper = new JPanel(new BorderLayout());

        JPanel myText = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel userIdInText = new JLabel(userId);
        userIdInText.setFont(new Font(userIdInText.getFont().getName(), Font.BOLD, 14));
        JLabel userText = new JLabel(userMessage);
        userText.setFont(new Font(userIdInText.getFont().getName(), Font.PLAIN, 14));
        myText.add(userIdInText);
        myText.add(userText);
        myText.setBackground(new Color(250,250,250));

        JLabel timeAgoLabel = new JLabel(timeAgoText);
        timeAgoLabel.setFont(new Font(timeAgoLabel.getFont().getName(), Font.PLAIN, 12));
        timeAgoLabel.setBackground(new Color(250,250,250));

        textWrapper.add(myText, BorderLayout.CENTER);
        textWrapper.add(timeAgoLabel, BorderLayout.SOUTH);
        textWrapper.setBackground(new Color(250,250,250));

        add(myTextProfilLabel);
        add(textWrapper);
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }
}
