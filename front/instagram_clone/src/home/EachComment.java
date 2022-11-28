package home;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EachComment extends JPanel {

    ImageIcon commentLikeImg = new ImageIcon("front/instagram_clone/image/icon_comment_like.png");
    ImageIcon commentLikeFillImg = new ImageIcon("front/instagram_clone/image/icon_comment_like_fill.png");

    String id;
    String text;

    Boolean isCommentLike = false;

    public EachComment(String id, String text) {
        this.id = id;
        this.text = text;

        setBackground(Color.WHITE);
        setEachComment();
    }

    private void setEachComment() {
        setPreferredSize(new Dimension(472, 20));
        setLayout(new BorderLayout());

        JLabel commentLikeLabel = new JLabel(setImageSize(commentLikeImg, 12,12));
        Border commentLikeMargin = new EmptyBorder(0,5,0,5);
        commentLikeLabel.setBorder(new CompoundBorder(commentLikeLabel.getBorder(), commentLikeMargin));
        commentLikeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(commentLikeLabel, BorderLayout.EAST);

        commentLikeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isCommentLike) {
                    commentLikeLabel.setIcon(setImageSize(commentLikeImg, 12,12));
                } else {
                    commentLikeLabel.setIcon(setImageSize(commentLikeFillImg, 12,12));
                }
                isCommentLike = !isCommentLike;
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

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBackground(Color.WHITE);
        JLabel idLabel = new JLabel(id);
        JLabel textLabel = new JLabel(text);
        contentPanel.add(idLabel);
        contentPanel.add(textLabel);
        add(contentPanel, BorderLayout.WEST);
    }

    private ImageIcon setImageSize(ImageIcon imgIcon, int width, int height) {
        Image img = imgIcon.getImage();
        Image updateImg = img.getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon updateIcon = new ImageIcon(updateImg);

        return updateIcon;
    }
}
