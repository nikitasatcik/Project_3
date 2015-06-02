import constants.XMLTags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SAXHandler extends DefaultHandler {
    private List<Weapon> weaponList;
    private Weapon weapon;
    private String currentElement = "";
    private StringBuilder currentText;

    public SAXHandler() {
        weaponList = new ArrayList<>();
    }

    public List<Weapon> readDataFromXML(String filename) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(filename), this);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
        return weaponList;
    }


    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX parsing started...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {
            case XMLTags.WEAPON:
                break;

            case XMLTags.GUN:
                weapon = new Weapon();
                String mName = attributes.getValue(XMLTags.MODEL_NAME);
                weapon.setModelName(mName);
                weaponList.add(weapon);
                break;

            case XMLTags.MODEL:
                String sModel = attributes.getValue(XMLTags.SERIAL_MODEL);
                weapon.setSerialModel(sModel);
                break;

            case XMLTags.RANGE:
                String maxRange = attributes.getValue(XMLTags.MAX_RANGE);
                String deadRange = attributes.getValue(XMLTags.DEAD_RANGE);
                weapon.ttc.setMaxRange(Integer.parseInt(maxRange));
                weapon.ttc.setDeadRange(Integer.parseInt(deadRange));
                break;

            default:
                currentText = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (currentElement.equals(XMLTags.WEAPON) || currentElement.equals(XMLTags.GUN) || currentElement.equals(XMLTags.TTC) ||
                currentElement.equals(XMLTags.MODEL) || currentElement.equals(XMLTags.RANGE)) {
            return;
        }

        String content = currentText.toString();

        switch (currentElement) {

            case XMLTags.ORIGIN:
                weapon.setOrigin(content);
                break;

            case XMLTags.HANDY:
                weapon.setHandy(Integer.parseInt(content));
                break;

            case XMLTags.MAGAZINE:
                weapon.ttc.setMagazine(Boolean.parseBoolean(content));
                break;

            case XMLTags.OPTIC:
                weapon.ttc.setOptic(Boolean.parseBoolean(content));
                break;

            default:
                break;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (currentText != null) {
            currentText.append(ch, start, length);
        }
    }
}
