package HuffmanTree.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameVision extends JFrame implements ActionListener{

    private String imgPath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/dotGif.gif";
	private JLabel jlImage = new JLabel(new ImageIcon(imgPath));
    private JLabel jlText = new JLabel("创建的二叉树为:");
    private JButton jbExit = new JButton("返回");
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,300,50);
    
    public FrameVision(){
        this.setLayout(new FlowLayout());
        this.add(jlText);
        this.add(jlImage,BorderLayout.CENTER);
        this.add(jbExit);

        this.setSize(800, 600);
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jbExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jbExit){
            // System.exit(0);
            this.dispose();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FrameVision();
    }
}
