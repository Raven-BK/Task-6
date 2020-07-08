package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Window extends JFrame {
    private final ButtonGroup group = new ButtonGroup();
    private final ArrayList<JRadioButton> buttons = new ArrayList<>();

    Window() throws IOException {
        setTitle("Task6");
        setLocationRelativeTo(null);
        setSize(370, 410);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.add(table());
        panel.add(workPanel(panel));
        setVisible(true);
    }

    public JPanel workPanel(JPanel panel) throws IOException {
        JPanel workPanel = new MyConstructors.Panel(160, 350, 10, 10);
        JPanel studentPanel = studentPanel();
        workPanel.add(studentPanel);
        workPanel.add(verticalBar(studentPanel));
        workPanel.add(new MyConstructors.Label("Стандартная реализация:", 5, 10));
        workPanel.add(new MyConstructors.Button("Найти оценки", 140, 40, 10, 30, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String key = "";
                    for (JRadioButton v:buttons) {
                        if (v.isSelected()) {
                            key = v.getText();
                            break;
                        }
                    }
                    Map<String, Map<String, Integer>> data = FileWork.dataForJavaMap();
                    Map<String, Integer> dataOf = data.get(key);
                    int i = 0;
                    for (Map.Entry<String, Integer> v : dataOf.entrySet()) {
                        ((JTable) panel.getComponentAt(175, 10)).setValueAt(v.getKey(), i, 0);
                        ((JTable) panel.getComponentAt(175, 10)).setValueAt(v.getValue(), i++, 1);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }));
        workPanel.add(new MyConstructors.Label("Моя реализация:", 30, 80));
        workPanel.add(new MyConstructors.Button("Найти оценки", 140, 40, 10, 100, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String key = "";
                    for (JRadioButton v:buttons) {
                        if (v.isSelected()) {
                            key = v.getText();
                            break;
                        }
                    }
                    Map<String, Map<String, Integer>> data = FileWork.dataForMyMap();
                    Map<String, Integer> dataOf = data.get(key);
                    int i = 0;
                    for (Map.Entry<String, Integer> v : dataOf.entrySet()) {
                        ((JTable) panel.getComponentAt(175, 10)).setValueAt(v.getKey(), i, 0);
                        ((JTable) panel.getComponentAt(175, 10)).setValueAt(v.getValue(), i++, 1);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }));
        return workPanel;
    }

    public JPanel studentPanel() throws IOException {
        JPanel studentPanel = new MyConstructors.Panel(120, 190, 10, 150);
        Map<String, Map<String, Integer>> data = FileWork.dataForJavaMap();
        int i = 0;
        for (String v : data.keySet()) {
            JRadioButton button = new MyConstructors.RadioButton(v, v.length() * 10, i * 20 + 5, i++ == 0);
            studentPanel.add(button);
            buttons.add(button);
            group.add(button);
        }
        return studentPanel;
    }

    public JScrollBar verticalBar(JPanel studentPanel) {
        JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 0, studentPanel.getHeight(), 0, group.getButtonCount() * 20 + 5);
        verticalBar.setSize(20, studentPanel.getHeight());
        verticalBar.setLocation(130, 150);
        verticalBar.addAdjustmentListener(new LogicForWindow.MyAdjustmentListener(studentPanel));
        return verticalBar;
    }

    public JTable table() {
        JTable table = new JTable(7, 2);
        table.setTableHeader(null);
        table.setCellSelectionEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setBorder(new EtchedBorder());
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setMaxWidth(130);
        table.getColumnModel().getColumn(0).setMinWidth(130);
        table.getColumnModel().getColumn(1).setMaxWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(40);
        table.setBorder(new EtchedBorder());
        table.setSize(170, 350);
        table.setLocation(175, 10);
        return table;
    }
}
