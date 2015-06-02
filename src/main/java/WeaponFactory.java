import constants.XMLTags;

public class WeaponFactory {
    private enum ParsersType {
        SAX, STAX, DOM
    }

    public void createWeapon(String parser)  {
        ParsersType type = ParsersType.valueOf(parser.toUpperCase());
        switch (type) {
            case SAX:
                new ReadXMLWithSAX().readXML(XMLTags.XML_PATH);
                break;

            case DOM:
                new ReadXMLWithDom().readXML(XMLTags.XML_PATH);
                break;

            case STAX:
                new ReadXMLWithStAX().readXML(XMLTags.XML_PATH);
                break;

            default:
                break;
        }
    }
}
