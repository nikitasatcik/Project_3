import constants.XMLTags;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLWithDom {
    private List<Weapon> weaponList = new ArrayList<>();

    public  void readXML(String filePath) {
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(filePath);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren(XMLTags.GUN);

            System.out.println("Dom parsing started...");

            for (Object aList : list) {
                Element node = (Element) aList;
                Weapon weapon = new Weapon();
                weapon.setModelName(node.getAttributeValue(XMLTags.MODEL_NAME));
                weapon.setSerialModel(node.getChild("model").getAttributeValue(XMLTags.SERIAL_MODEL));
                weapon.setOrigin(node.getChildText(XMLTags.ORIGIN));
                weapon.setHandy(Integer.parseInt(node.getChildText(XMLTags.HANDY)));
                weapon.ttc.setDeadRange(Integer.parseInt(node.getChild(XMLTags.TTC).getChild(XMLTags.RANGE).getAttributeValue(XMLTags.DEAD_RANGE)));
                weapon.ttc.setMaxRange(Integer.parseInt(node.getChild(XMLTags.TTC).getChild(XMLTags.RANGE).getAttributeValue(XMLTags.MAX_RANGE)));
                weapon.ttc.setMagazine(Boolean.parseBoolean(node.getChild("ttc").getChildText(XMLTags.MAGAZINE)));
                weapon.ttc.setOptic(Boolean.parseBoolean(node.getChild("ttc").getChildText(XMLTags.OPTIC)));
                weaponList.add(weapon);
            }

            System.out.println("Amount of weapon: " + weaponList.size());
            weaponList.forEach(System.out::println);

        } catch (IOException | JDOMException e) {
            System.out.println(e.getMessage());
        }
    }
}