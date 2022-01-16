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

public class FrameEncode extends JFrame implements ActionListener{
    private JButton jbSee = new JButton("查看编码文本");
    private TextArea TaData = new TextArea("需要编码的文本为:\n",10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private JButton jbEncode = new JButton("查看编码结果");
    private TextArea TaCode = new TextArea("编码后的文本为:\n",10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private ArrayList<DrawNode> list;//存放从文件中读取的哈夫曼树的结点
    private String text;//存放要编码的文本

    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,300,50);

    public FrameEncode(){
        jbSee.setPreferredSize(new Dimension(400,30));
        jbEncode.setPreferredSize(new Dimension(400,30));
        this.setLayout(new FlowLayout());
        this.add(jbSee);
        this.add(TaData);
        this.add(jbEncode);
        this.add(TaCode);

        this.setSize(600, 500);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jbSee.addActionListener(this);
        jbEncode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jbSee){
            System.out.println("查看文本");
            TreeToFile myTreeToFile = new TreeToFile();
            String filepath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/hfmTree.txt";
            try {
                this.list = myTreeToFile.huffmanTreeInput(filepath);//从文件中读取哈夫曼树
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
            //从文件中读取文本
            CodeToFile myCodeToFile = new CodeToFile();
            String textPath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/ToBeTran.txt";
            try {
                this.text = myCodeToFile.TextFromFile(textPath);
                this.TaData.setEditable(false);
                this.TaData.append(this.text);
                // this.jlTextData.setText(this.text);
                System.out.println("文本:"+this.text);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == jbEncode){
            //对文本进行编码并将编码存入文件
            System.out.println("查看编码");
            CodeToFile myCodeToFile = new CodeToFile();
            String codePath = "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodeFile.txt";
            DeCodeAndEncode myDeCodeAndEncode = new DeCodeAndEncode();
            String code = myDeCodeAndEncode.HuffmanEncode(list, text);
            this.TaCode.setEditable(false);
            this.TaCode.append(code);
            try {
                myCodeToFile.HuffmanCodeToFile(code, codePath);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FrameEncode();
    }
}
