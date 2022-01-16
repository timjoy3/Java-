package HuffmanTree.frame;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import HuffmanTree.CodeToFile;
import HuffmanTree.DeCodeAndEncode;
import HuffmanTree.DrawNode;
import HuffmanTree.TreeToFile;

public class FrameDecode extends JFrame implements ActionListener{
    private JButton jbSee = new JButton("查看解码文本");
    private TextArea TaCode = new TextArea("需要解码的文本为:\n",10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private JButton jbDncode = new JButton("查看解码结果");
    private TextArea TaData = new TextArea("解码后的文本为:\n",10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private ArrayList<DrawNode> list;//存放从文件中读取的哈夫曼树的结点
    private String codeAll;//存放要编码的文本

    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,300,50);

    public FrameDecode(){
        jbSee.setPreferredSize(new Dimension(400,30));
        jbDncode.setPreferredSize(new Dimension(400,30));
        this.setLayout(new FlowLayout());
        this.add(jbSee);
        this.add(TaCode);
        this.add(jbDncode);
        this.add(TaData);

        this.setSize(600, 500);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jbSee.addActionListener(this);
        jbDncode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jbSee){
            System.out.println("查看文本");
            //从文件中读取哈夫曼树
            TreeToFile myTreeToFile = new TreeToFile();
            String filepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
            try {
                this.list = myTreeToFile.huffmanTreeInput(filepath);//从文件中读取哈夫曼树
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
            //获取哈夫曼编码
            CodeToFile myCodeToFile = new CodeToFile();
            String codePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodeFile.txt";
            try {
                this.codeAll = myCodeToFile.TextFromFile(codePath);
                System.out.println("codeAll:"+codeAll);
                this.TaCode.setEditable(false);
                this.TaCode.append(this.codeAll);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == jbDncode){
            //进行译码
            CodeToFile myCodeToFile = new CodeToFile();
            DeCodeAndEncode myDeCodeAndEncode = new DeCodeAndEncode();
            String TextDecode = myDeCodeAndEncode.HuffmanDecode(list, codeAll);
            System.out.println("TextAll:"+TextDecode);
            this.TaData.setEditable(false);
            this.TaData.append(TextDecode);
            String codepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodePrint.txt";
            try {
                myCodeToFile.HuffmanCodeToFile(TextDecode, codepath);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }    
    }

    public static void main(String[] args) {
        new FrameDecode();
    }
}