package HuffmanTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CodeToFile {
    /**
     * 从文件中读取要进行编码的文本串
     * @param textPath 文本文件所在的路径
     * @return 返回读取的文本
     */
    public String TextFromFile (String textPath) throws IOException{
        // "D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/ToBeTran.txt"
        File file = new File(textPath); 
        FileInputStream fis = new FileInputStream(file); 
        byte[] data = new byte[(int)file.length()];
        fis.read(data);
        fis.close();
        return new String(data);
    }

    /**
     * 将对文本进行哈夫曼编码后的字符串编码写入文件
     * @param code 编码后的编码字符串
     * @param codePath 文件的路径
     */
    public void HuffmanCodeToFile (String code ,String codePath) throws FileNotFoundException{
        //"D:/学习/计算机/JAVA/Java课设/Java课程设计/Java课程设计/src/HuffmanTree/CodeFile.txt"
        File file = new File(codePath); 
        FileOutputStream fos = new FileOutputStream(file); 
        PrintStream ps = new PrintStream(fos);
        ps.println(code); 
        ps.close(); 
    }

}
