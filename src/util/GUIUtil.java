package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUtil {
    public static String ImageFolder = "E:/IDEA_java/how2j-study/hutubill/hutubill_study/img";

    public static void setImageIcon(JButton b ,String fileName,String tip ) {
        ImageIcon i = new ImageIcon(new File(ImageFolder,fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61,81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void setColor(Color color, JComponent...cs){
        for (JComponent c:cs) {
            //设置前置背景
            c.setForeground(color);
        }
    }


    /**
     *
     * @param p
     * @param strechRate 拉伸比例1表示满屏幕
     */

    public static void showPanel(JPanel p,double strechRate) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    public static void showPanel(JPanel p){
        showPanel(p,0.85);
    }

    public static boolean checkNumber(JTextField tf, String input){
        if(!checkEmpty(tf,input))
            return false;
       String text =tf.getText().trim();
       try {
           Integer.parseInt(text);
           return true;
       }catch (NumberFormatException e1){
           JOptionPane.showMessageDialog(null,input+"需要是整数");
           tf.grabFocus();
           return false;
       }
    }

    public static boolean checkZero(JTextField tf,String input) {

        if(!checkNumber(tf,input))        //原代码里面是!checkNumber()
            return false;
        String text =tf.getText().trim();
        if(0==Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null,input+"不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkEmpty(JTextField tf,String input) {
        String text =tf.getText().trim();
        if(0==text.length()){
            JOptionPane.showMessageDialog(null,input+"不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static int getInt(JTextField tf){
        return Integer.parseInt(tf.getText());
    }
    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
