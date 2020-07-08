package com.company;

import javax.swing.*;
import java.awt.event.*;

public class LogicForWindow {
    public static class MyAdjustmentListener implements AdjustmentListener {
        int verticalLastValue = 0;
        JPanel studentPanel;

        MyAdjustmentListener(JPanel studentPanel) {
            this.studentPanel = studentPanel;
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            for (int j = 0; j < studentPanel.getComponents().length; j++) {
                studentPanel.getComponent(j).setLocation(
                        studentPanel.getComponent(j).getX(),
                        (e.getValue() - verticalLastValue > 0) ?
                                studentPanel.getComponent(j).getY() - Math.abs(e.getValue() - verticalLastValue) :
                                studentPanel.getComponent(j).getY() + Math.abs(e.getValue() - verticalLastValue));
            }
            verticalLastValue = e.getValue();
        }
    }
}
