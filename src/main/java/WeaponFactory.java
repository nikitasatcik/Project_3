import constants.XMLTags;

public class WeaponFactory {
    private enum ParsersType {
        SAX, STAX, DOM
    }

    public void createWeapon(String parser) {
        ParsersType type = ParsersType.valueOf(parser.toUpperCase());
        XMLValidator validator = new XMLValidator();
        switch (type) {
            case SAX:
                validator.validate(XMLTags.XSD_PATH, XMLTags.XML_PATH);
                new ReadXMLWithSAX().readXML(XMLTags.XML_PATH);
                new XMLConvert().convertXML(XMLTags.XML_PATH, XMLTags.HTML_PATH, XMLTags.XSL_PATH);
                break;

            case DOM:
                validator.validate(XMLTags.XSD_PATH, XMLTags.XML_PATH);
                new ReadXMLWithDom().readXML(XMLTags.XML_PATH);
                new XMLConvert().convertXML(XMLTags.XML_PATH, XMLTags.HTML_PATH, XMLTags.XSL_PATH);
                break;

            case STAX:
                validator.validate(XMLTags.XSD_PATH, XMLTags.XML_PATH);
                new ReadXMLWithStAX().readXML(XMLTags.XML_PATH);
                new XMLConvert().convertXML(XMLTags.XML_PATH, XMLTags.HTML_PATH, XMLTags.XSL_PATH);
                break;

            default:
                break;
        }
    }
}
