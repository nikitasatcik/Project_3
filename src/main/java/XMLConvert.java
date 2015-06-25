
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLConvert {
    public void convertXML(String xmlPath, String htmlPath, String xslPath) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslPath));
            transformer.transform(new StreamSource(xmlPath), new StreamResult(htmlPath));
        } catch (Exception e) {
            System.out.println("Cannot convert XML");
        }
    }
}
