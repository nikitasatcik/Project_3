import constants.XMLTags;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {

    public List<Weapon> getDataFromXML(String filePath) throws Exception {

        List<Weapon> weaponList = new ArrayList<>();
        Weapon weapon = null;

        InputStream in = new FileInputStream(new File(filePath));
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(in);


        int eventType;

        while (reader.hasNext()) {
            eventType = reader.next();

            if (eventType == XMLEvent.START_ELEMENT) {
                String elementName = reader.getName().toString();


                switch (elementName) {
                    case XMLTags.GUN:
                        weapon = new Weapon();
                        weapon.setModelName((reader.getAttributeValue("http://www.weapon.com/Weapon", XMLTags.MODEL_NAME)));
                        weaponList.add(weapon);
                        break;

                    case XMLTags.ORIGIN:
                        assert weapon != null;
                        weapon.setOrigin(reader.getElementText());
                        break;

                    case XMLTags.HANDY:
                        assert weapon != null;
                        weapon.setHandy(Integer.parseInt(reader.getElementText()));
                        break;

                    case XMLTags.MODEL:
                        assert weapon != null;
                        weapon.setSerialModel(reader.getAttributeValue("http://www.weapon.com/Weapon", XMLTags.SERIAL_MODEL));
                        break;

                    case XMLTags.MAGAZINE:
                        assert weapon != null;
                        weapon.ttc.setMagazine(Boolean.parseBoolean(reader.getElementText()));
                        break;

                    case XMLTags.OPTIC:
                        assert weapon != null;
                        weapon.ttc.setOptic(Boolean.parseBoolean(reader.getElementText()));
                        break;

                    case XMLTags.RANGE:
                        assert weapon != null;
                        weapon.ttc.setMaxRange(Integer.parseInt(reader.getAttributeValue("http://www.weapon.com/Weapon", XMLTags.MAX_RANGE)));
                        weapon.ttc.setDeadRange(Integer.parseInt(reader.getAttributeValue("http://www.weapon.com/Weapon", XMLTags.DEAD_RANGE)));
                        break;

                    default:
                        break;
                }
            }
        }
        return weaponList;
    }
}
