package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel {

    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs =new ReportService().listThisMonthRecords();
        Image i =ChartUtil.getImage(rs,400, 300);
        ImageIcon icon= new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {
        List<Record> rs =new ReportService().listThisMonthRecords();
        Image i =ChartUtil.getImage(rs,350, 250);
        ImageIcon icon= new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}