package com.midea.xml.document;

import com.alibaba.fastjson.JSONObject;
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
public class TestXmlTODocument2 {
    public static void main(String[] args) throws Exception {
        //String xmlTo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        String xmlTo_startNode = "<startNode id=\"N1\" name=\"开始节点\" x=\"400\" y=\"60\"/>";
        String xmlTo_draftNode = "<draftNode id=\"N2\" name=\"起草节点\" x=\"400\" y=\"120\"/>";
        String xmlTo_reviewNode = "<reviewNode canModifyFlow=\"false\" canModifyMainDoc=\"false\" canModifyNotionPopedom=\"false\" dayOfNotify=\"0\" dayOfPass=\"0\" handlerIds=\"return $MDP.业务岗位$(&quot;EFS_WF&quot;,&quot;01&quot;,&quot;1&quot;,&quot;&quot;,&quot;事业部资金经理;8a90cafa638f9a270163b5353e7e33df&quot;,&quot;8a90a8ef642071ae01643592ee2079e3&quot;,$资金冻结.belongUnit$,&quot;&quot;,$fdId$)\" handlerNames=\"return $MDP.业务岗位$(&quot;EFS_WF&quot;,&quot;01&quot;,&quot;1&quot;,&quot;&quot;,&quot;事业部资金经理;8a90cafa638f9a270163b5353e7e33df&quot;,&quot;#机构属性#&quot;,$事业部编号$,&quot;&quot;,$ID$)\" handlerSelectType=\"formula\" id=\"N4\" ignoreOnHandlerEmpty=\"false\" ignoreOnHandlerSame=\"true\" name=\"资金管理经理\" optHandlerCalType=\"2\" optHandlerSelectType=\"org\" orgAttributes=\"optHandlerIds:optHandlerNames;otherCanViewCurNodeIds:otherCanViewCurNodeNames\" processType=\"1\" recalculateHandler=\"true\" tranNotifyDraft=\"0\" tranNotifyPrivate=\"0\" useOptHandlerOnly=\"false\" x=\"400\" y=\"180\">\n" +
                "<extAttributes>\n" +
                "<attribute name=\"fdSystemId\"/>\n" +
                "<attribute name=\"fdModuleId\"/>\n" +
                "<attribute name=\"fdFormTemplateUrl\"/>\n" +
                "<attribute name=\"fdFormTemplateId\"/>\n" +
                "<attribute name=\"fdFormTemplateName\"/>\n" +
                "<attribute name=\"extendParams\"/>\n" +
                "<attribute name=\"noallowMobileApproval\" value=\"false\"/>\n" +
                "<attribute name=\"approvalPersonNotNull\" value=\"false\"/>\n" +
                "<attribute name=\"approvalPersonNotNullErrMsg\"/>\n" +
                "<attribute name=\"noSameApproveStyle\" value=\"false\"/>\n" +
                "<attribute name=\"nodeExtend\" value=\" \"/>\n" +
                "<attribute name=\"emailPass\" value=\"true\"/>\n" +
                "<attribute name=\"emailRefuse\" value=\"true\"/>\n" +
                "</extAttributes>\n" +
                "<operations refId=\"13e3fce65553826746c16e54ef78f9a9\"/>\n" +
                "<events>\n" +
                "<event eventConfig=\"undefined\" id=\"369a40ff2baeda\" listenerConfig=\"{&quot;functionId&quot;:&quot;8a90a8ef64377b0a01643b30d0c8766f&quot;,&quot;functionName&quot;:&quot;callBack&quot;,&quot;functionDes&quot;:&quot;callBack&quot;,&quot;systemId&quot;:&quot;155fd749f0edb79b747dc1446c99a607&quot;,&quot;moduleId&quot;:&quot;gceb_sett&quot;,&quot;formTemplateId&quot;:&quot;1530001304644&quot;}\" listenerId=\"kmMiplbpmMdpEventListener\" name=\"callBack\" type=\"lbpmHandlerRefuseEvent\"/>\n" +
                "</events>\n" +
                "</reviewNode>";
        String xmlTo_endNode = "<endNode id=\"N3\" name=\"结束节点\" x=\"400\" y=\"380\">\n" +
                "<events>\n" +
                "<event id=\"369a3a95e23602\" listenerConfig=\"{&quot;functionId&quot;:&quot;8a90cafa636d7185016377279dea0173&quot;,&quot;functionName&quot;:&quot;callBack&quot;,&quot;functionDes&quot;:&quot;网银统一回调服务&quot;,&quot;systemId&quot;:&quot;155fd749f0edb79b747dc1446c99a607&quot;,&quot;moduleId&quot;:&quot;gceb_pay&quot;,&quot;formTemplateId&quot;:&quot;1526712329470&quot;}\" listenerId=\"kmMiplbpmMdpEventListener\" name=\"网银统一回调服务\" type=\"lbpmProcessFinishedEvent\"/>\n" +
                "</events>\n" +
                "</endNode>";
        Document document = DocumentHelper.parseText(xmlTo_reviewNode);
        // 根元素
        Element rootElement = document.getRootElement();
        String name = rootElement.getName();
        Object data = rootElement.getData();
        //System.out.println("rootName=" + name);
        //System.out.println("rootData=" + data);
        List attributes = rootElement.attributes();
        for(int i = 0 ; i < attributes.size() ; i++){
            DefaultAttribute o = (DefaultAttribute)attributes.get(i);
            //System.out.println(o.getName() + '=' + o.getData());
        }
        String documentName = document.getName();
        short nodeType = document.getNodeType();
        String nodeTypeName = document.getNodeTypeName();
        //System.out.println("documentName=" + documentName + ";nodeType=" + nodeType + ";nodeTypeName=" + nodeTypeName);
        // 子节点
        List elements = rootElement.elements();
        for(int i = 0 ; i < elements.size() ; i++){
            DefaultElement el = (DefaultElement)elements.get(i);
            //System.out.println("elements name= " + el.getName() + " el.Data" + el.getData() + " el.Text" + el.getText());
        }
        // 属性
        Attribute receiver = rootElement.attribute("handlerIds");
        String positionStr = receiver.getValue();
        if(positionStr.indexOf("return $MDP.业务岗位$(\"EFS_WF\"") != -1){
            System.out.println("<handlerIds>==" /*+ receiver.getData() + "=" */+ receiver.getValue());
            String newStr = positionStr.substring(positionStr.indexOf("(") + 1,positionStr.length() -1);
            System.out.println("newStr=" + newStr);
            String[] split = newStr.split(",");
            String pos = split[4].substring(1,split[4].length()-1);
            String s = pos.split(";")[1];
            System.out.println("posId=" + s);
        }
        Element voucher = rootElement.element("events");
        List<DefaultElement> eventList = voucher.elements("event");
        for(DefaultElement ev: eventList){
            Attribute listenerConfig = ev.attribute("listenerConfig");
            System.out.println("listenerConfig=" + listenerConfig.getValue());
            JSONObject jsonObject = JSONObject.parseObject(listenerConfig.getValue());
            String functionId = jsonObject.getString("functionId");
            System.out.println("functionId=" + functionId);
        }
        //String filename = "e:\\2018.xml";
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
