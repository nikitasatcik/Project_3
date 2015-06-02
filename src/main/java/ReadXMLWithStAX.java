
import java.util.List;

public class ReadXMLWithStAX {

    public void readXML(String filePath) {
        try {
            StAXReader reader = new StAXReader();
            List<Weapon> weaponList = reader.getDataFromXML(filePath);
            System.out.println("StAX parsing started...");
            System.out.println("Amount of weapon: " + weaponList.size());
            weaponList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
