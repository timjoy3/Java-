package HuffmanTree.frame;

import java.awt.FlowLayout;
import java.awt.*;
// import java.awt.Dialog.ModalExclusionType;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener {
    /**
     * 定义控件
     */
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,300,50);
    Font font = new Font("楷体_GB2312",Font.BOLD,22);
    private JButton btnSet = new JButton("创建哈夫曼树");
    private JButton btnVision = new JButton("可视化哈夫曼树");
    private JButton btnEncode = new JButton("编码");
    private JButton btnDecode = new JButton("解码");
    private JButton btnExit = new JButton("退出");
    private Dimension preferredSize = new Dimension(200,50);
    // private JPanel jp = new JPanel();
    

    public Menu() {
        this.setLayout(flowLayout);
        btnSet.setPreferredSize(preferredSize);
        btnSet.setFont(font);
        btnVision.setPreferredSize(preferredSize);
        btnVision.setFont(font);
        btnEncode.setPreferredSize(preferredSize);
        btnEncode.setFont(font);
        btnDecode.setPreferredSize(preferredSize);
        btnDecode.setFont(font);
        btnExit.setPreferredSize(preferredSize);
        btnExit.setFont(font);
        this.add(btnSet);
        this.add(btnVision);
        this.add(btnEncode);
        this.add(btnDecode);
        this.add(btnExit);
        this.setSize(800, 600);
        this.setLocation(200, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //绑定事件
        btnSet.addActionListener(this);
        btnVision.addActionListener(this);
        btnEncode.addActionListener(this);
        btnDecode.addActionListener(this);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSet){
            System.out.println("创建");
            //设置禁用
            // this.setEnabled(false);
            //创建新的窗口
            new FrameSet();
        }
        if(e.getSource() == btnVision){
            System.out.println("可视化");
            new FrameVision();
        }
        if (e.getSource() == btnEncode){
            System.out.println("编码");
            new FrameEncode();
        }
        if (e.getSource() == btnDecode){
            System.out.println("解码");
            new FrameDecode();
        }
        if(e.getSource() == btnExit){
            System.out.println("退出");
            JOptionPane.showMessageDialog(this, "谢谢使用");
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        new Menu();
    }
}
