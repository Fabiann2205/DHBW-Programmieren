package de.dhbwka.java.exercise.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class Gazetteer {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();

            String url = "https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml";
            Document doc = parser.parse(url);

            // Name des Wurzelelements ausgeben
            System.out.println("Wurzelelement: " + doc.getDocumentElement().getNodeName());

            // Element formatted_address ausgeben
            System.out.println("formatted_address: " + doc.getElementsByTagName("formatted_address").item(0).getTextContent());

            // Unterelement long_name des Elements address_component ausgeben
            System.out.println("Long_Name: " + doc.getElementsByTagName("address_component").item(0).getChildNodes().item(1).getTextContent());

            // Lat und Long ausgeben
            System.out.println("Lat: " + doc.getElementsByTagName("geometry").item(0).getChildNodes().item(1).getChildNodes().item(1).getTextContent());
            System.out.println("Long: " + doc.getElementsByTagName("geometry").item(0).getChildNodes().item(1).getChildNodes().item(3).getTextContent());

            // bounds ausgeben
            System.out.println("bounds southwest: " + doc.getElementsByTagName("bounds").item(0).getChildNodes().item(1).getTextContent());
            System.out.println("bounds northeast: " + doc.getElementsByTagName("bounds").item(0).getChildNodes().item(3).getTextContent());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
