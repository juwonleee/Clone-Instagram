package front.home;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintTextField extends JTextField {
    String hint;

    public HintTextField(String hint) {
        this.hint = hint;

        setText(hint);
        setForeground(Color.GRAY);
        setBorder(new EmptyBorder(0,0,0,0));

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");;
                } else {
                    setText(getText());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0) {
                    setText(hint);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setForeground(Color.BLACK);
                }
            }
        });
    }
}
