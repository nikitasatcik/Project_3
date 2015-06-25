import constants.XMLTags;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadXMLWithDom {
    private List<Weapon> weaponList = new ArrayList<>();

    public void readXML(String filePath) {
        SAXBuilder builder = new SAXBuilder();
        try {
            Namespace namespace = Namespace.getNamespace("myspace", "http://www.weapon.com/Weapon");
            Document document = builder.build(filePath);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren(XMLTags.GUN, namespace);

            System.out.println("Dom parsing started...");

            for (Object aList : list) {
                Element node = (Element) aList;
                Weapon weapon = new Weapon();
                weapon.setModelName(node.getAttributeValue(XMLTags.MODEL_NAME));
                weapon.setSerialModel(node.getChild(XMLTags.MODEL, namespace).getAttributeValue(XMLTags.SERIAL_MODEL));
                weapon.setOrigin(node.getChildText(XMLTags.ORIGIN, namespace));
                weapon.setHandy(Integer.parseInt(node.getChildText(XMLTags.HANDY, namespace)));

                weapon.ttc.setDeadRange(Integer.parseInt(node.getChild(XMLTags.TTC, namespace).
                        getChild(XMLTags.RANGE, namespace).getAttributeValue(XMLTags.DEAD_RANGE)));

                weapon.ttc.setMaxRange(Integer.parseInt(node.getChild(XMLTags.TTC, namespace).
                        getChild(XMLTags.RANGE, namespace).getAttributeValue(XMLTags.MAX_RANGE)));

                weapon.ttc.setMagazine(Boolean.parseBoolean(node.getChild(XMLTags.TTC, namespace).
                        getChildText(XMLTags.MAGAZINE, namespace)));

                weapon.ttc.setOptic(Boolean.parseBoolean(node.getChild(XMLTags.TTC, namespace).
                        getChildText(XMLTags.OPTIC, namespace)));

                weaponList.add(weapon);
            }
            Collections.sort(weaponList, (o1, o2) -> o1.getOrigin().compareTo(o2.getOrigin()));
            weaponList.forEach(System.out::println);

        } catch (IOException | JDOMException e) {
            System.out.println(e.getMessage());
        }
    }
}
