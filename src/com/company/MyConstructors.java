package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyConstructors {
    public static class Button extends JButton {

        Button(String text, int width, int height, int x, int y, MouseListener listener) {
            super(text);
            setBorder(new EtchedBorder());
            setBackground(new Color(230, 230, 230));
            setSize(width, height);
            setLocation(x, y);
            setFocusPainted(false);
            addMouseListener(new Button.Listener());
            addMouseListener(listener);
        }

        public static class Listener extends MouseAdapter {

            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBorder(new BevelBorder(BevelBorder.RAISED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBorder(new EtchedBorder());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ((JButton) e.getSource()).setEnabled(false);
                ((JButton) e.getSource()).setBorder(new BevelBorder(BevelBorder.LOWERED));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ((JButton) e.getSource()).setEnabled(true);
                ((JButton) e.getSource()).setBorder(new EtchedBorder());
            }
        }
    }

    public static class Panel extends JPanel {
        Panel(int width, int height, int x, int y) {
            setSize(width, height);
            setLocation(x, y);
            setBorder(new EtchedBorder());
            setLayout(null);
        }
    }

    public static class RadioButton extends JRadioButton {
        RadioButton(String name, int width, int y, boolean select) {
            super(name, select);
            setSize(width, 15);
            setLocation(2, 5 + y);
            setFocusable(false);
            setBackground(null);
            setContentAreaFilled(false);
            setFont(new Font("Lol", Font.BOLD, 10));
        }
    }

    public static class Label extends JLabel {
        Label(String name, int x, int y) {
            super(name);
            setLocation(x, y);
            setSize(name.length() * 10, 15);
        }
    }
}
