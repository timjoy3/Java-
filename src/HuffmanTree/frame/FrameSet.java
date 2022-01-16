package HuffmanTree.frame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import HuffmanTree.DrawNode;
import HuffmanTree.HuffmanTree;
import HuffmanTree.TreeToFile;

import javax.swing.JDialog;


public class FrameSet extends JFrame implements ActionListener{

    private JLabel jlData = new JLabel("数据");
    private JTextField tfData = new JTextField(10);
    private JLabel jlWeight = new JLabel("权值");
    private JTextField tfWeight = new JTextField(5);
    private JButton btnSetNode = new JButton("确定");
    private JButton btnDefine = new JButton("创建");
    private String data;
    private int weight;
    private StringBuilder dataMsgAll = new StringBuilder();
    ArrayList<DrawNode> nodes = new ArrayList<>();//建立结点数组
    JLabel jlDataMsg = new JLabel();   // 实例化标签对象
    JDialog dlg = new JDialog(this,"确认",true);
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,300,50);

    public FrameSet(){
        this.setLayout(new FlowLayout());
        this.add(jlData);
        this.add(tfData);
        this.add(jlWeight);
        this.add(tfWeight);
        this.add(btnSetNode);
        this.add(btnDefine);
        this.add(jlDataMsg);

        this.setSize(400, 300);
        this.setLocation(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tfData.addActionListener(this);
        tfWeight.addActionListener(this);
        btnSetNode.addActionListener(this);
        btnDefine.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == btnSetNode){
            System.out.println("创建新结点");
            this.data = tfData.getText();
            this.weight = Integer.parseInt(tfWeight.getText());
            // System.out.println("Data:"+this.data+"\tWeight:"+this.weight);
            String dataMsg = "Data:"+this.data+"\tWeight:"+this.weight+"<br>";
            this.dataMsgAll.append(dataMsg);
            DrawNode node = new DrawNode(this.data, this.weight);
            this.nodes.add(node);//将结点信息存入结点数组
            this.jlDataMsg.setText("<html>"+this.dataMsgAll.toString()+"</html>");
            System.out.println(this.dataMsgAll.toString());
            //清空输入框
            this.tfData.setText("");
            this.tfWeight.setText("");
        }
        if (e.getSource() == btnDefine) {
            //创建哈夫曼树
            HuffmanTree myHuffmanTree = new HuffmanTree();
            myHuffmanTree.createHuffmanTree(this.nodes);  
            //利用广度优先遍历进行哈夫曼编码
            ArrayList<DrawNode> list = myHuffmanTree.breadthFirst();

            //画哈夫曼树
            String runPath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/";
            String dotPath = "C:/Program Files (x86)/Graphviz/bin/dot.exe";
            ArrayList<String> messageList = myHuffmanTree.drawHuffmanTree(list);
            myHuffmanTree.displayHuffmanTree(messageList,runPath,dotPath);

            //将哈夫曼树存入文件中
            TreeToFile myTreeToFile = new TreeToFile();
            String filePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
            myTreeToFile.huffmanTreeOutput(list, filePath);
            JOptionPane.showMessageDialog(this, "哈夫曼树创建完成");
            this.dispose();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FrameSet();
    }
}
