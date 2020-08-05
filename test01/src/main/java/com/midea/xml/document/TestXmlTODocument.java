package com.midea.xml.document;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2019/11/15 10:14
 */
public class TestXmlTODocument {
    public static void main(String[] args) throws Exception {
        //String xmlTo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        String xmlTo = "";

        xmlTo = xmlTo + "<ufinterface roottag=\"voucher\" billtype=\"gl\" replace=\"Y\" receiver=\"1112\" sender=\"01\" isexchange=\"Y\" proc=\"add\" operation=\"req\" filename=\"e:\\1.xml\">";
        xmlTo = xmlTo + "<voucher>";
        xmlTo = xmlTo + "<voucher_body>" + "body" + "</voucher_body>";
        xmlTo = xmlTo + "</voucher>" ;
        xmlTo = xmlTo + "</ufinterface>";

        Document document = DocumentHelper.parseText(xmlTo);
        // 根元素
        Element rootElement = document.getRootElement();
        String name = rootElement.getName();
        Object data = rootElement.getData();
        System.out.println("rootName=" + name);
        System.out.println("rootData=" + data);
        List attributes = rootElement.attributes();
        for(int i = 0 ; i < attributes.size() ; i++){
            DefaultAttribute o = (DefaultAttribute)attributes.get(i);
            System.out.println(o.getName() + '=' + o.getData());
        }
        String documentName = document.getName();
        short nodeType = document.getNodeType();
        String nodeTypeName = document.getNodeTypeName();
        System.out.println("documentName=" + documentName + ";nodeType=" + nodeType + ";nodeTypeName=" + nodeTypeName);
        // 子节点
        List elements = rootElement.elements();
        for(int i = 0 ; i < elements.size() ; i++){
            DefaultElement el = (DefaultElement)elements.get(i);
            System.out.println("elements name= " + el.getName() + " el.Data" + el.getData() + " el.Text" + el.getText());
        }
        // 属性
        Attribute receiver = rootElement.attribute("receiver");
        System.out.println("<receiver>==" + receiver.getData() + "=" + receiver.getValue());

        Element voucher = rootElement.element("voucher");
        Element elvb = voucher.element("voucher_body");
        System.out.println("voucher_body elements name= " + elvb.getName() + " el.Data=" + elvb.getData() + " el.Text=" + elvb.getText());

        String filename = "e:\\2018.xml";
        //OutputXml(document, filename);
    }

    public static void OutputXml(Document doc,String filename){
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("UTF-8");
        /** 将document中的内容写入文件中 */
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(new File(filename)), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
