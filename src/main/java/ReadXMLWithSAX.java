import constants.XMLTags;

import java.util.List;

public class ReadXMLWithSAX {
    public  void readXML(String filePath)  {
        SAXHandler saxHandler = new SAXHandler();
        List<Weapon> weaponList = saxHandler.readDataFromXML(filePath);
        System.out.println("Amount of weapon: " + weaponList.size());
        weaponList.forEach(System.out::println);
    }
}
