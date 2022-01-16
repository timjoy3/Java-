package HuffmanTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeCodeAndEncode {
    /**
     * 根据哈夫曼树对文本进行哈夫曼编码
     * @param list 哈夫曼树的结点数组
     * @param text 文本
     * @return 进行哈夫曼编码后的字符串
     */
    public String HuffmanEncode (ArrayList<DrawNode> list,String text){
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            for (DrawNode node : list) {
                if (text.charAt(i) == node.getData().charAt(0)) {
                    code.append(node.getCode());
                }
            }
        }
        return code.toString();
    }   
    
    /**
     * 将哈夫曼编码进行解码
     * @param list 哈夫曼树的结点数组
     * @param codeAll 初始的哈夫曼编码
     * @return 返回解码完成后的字符串
     */
    public String HuffmanDecode (ArrayList<DrawNode> list,String codeAll){
        StringBuilder text = new StringBuilder();
        Map <String,String> map = new HashMap<>();//建立编码与字符之间的键值对，方便使用
        for (DrawNode node : list) {
            if (!node.getData().equals(" "))
                map.put(node.getCode(), node.getData());
        }

        while(codeAll.length() > 2){
            for(Map.Entry<String,String> e: map.entrySet()){//判断编码字符串是以哪一个编码开头的
                String code = e.getKey();
                if(codeAll.startsWith(code)){
                    text.append(e.getValue());
                    codeAll = codeAll.substring(code.length());
                }
            }
        }
        return text.toString();
    }
}
