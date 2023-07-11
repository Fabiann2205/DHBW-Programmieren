package de.dhbwka.java.exercise.xml;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Gazetteer3 {
    public static void main(String[] args) {
        String address = "karlsruhe"; // Ihre Suchadresse hier eintragen
        String url = "https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new URL(url).openStream());

            document.getDocumentElement().normalize();
            String status = document.getElementsByTagName("status").item(0).getTextContent();

            if (status.equals("OK")) {
                NodeList results = document.getElementsByTagName("result");

                for (int i = 0; i < results.getLength(); i++) {
                    Node result = results.item(i);

                    if (result.getNodeType() == Node.ELEMENT_NODE) {
                        Element resultElement = (Element) result;
                        String formattedAddress = resultElement.getElementsByTagName("formatted_address").item(0).getTextContent();

                        System.out.println("Adresse: " + formattedAddress);

                        NodeList addressComponents = resultElement.getElementsByTagName("address_component");

                        for (int j = 0; j < addressComponents.getLength(); j++) {
                            Node addressComponent = addressComponents.item(j);

                            if (addressComponent.getNodeType() == Node.ELEMENT_NODE) {
                                Element addressComponentElement = (Element) addressComponent;
                                String type = addressComponentElement.getElementsByTagName("type").item(0).getTextContent();

                                if (type.equals("locality")) {
                                    String longName = addressComponentElement.getElementsByTagName("long_name").item(0).getTextContent();
                                    System.out.println("Long Name: " + longName);
                                }
                            }
                        }

                        Element geometry = (Element) resultElement.getElementsByTagName("geometry").item(0);
                        Element location = (Element) geometry.getElementsByTagName("location").item(0);
                        String latitude = location.getElementsByTagName("lat").item(0).getTextContent();
                        String longitude = location.getElementsByTagName("lng").item(0).getTextContent();

                        System.out.println("Location: (latitude=" + latitude + ", longitude=" + longitude + ")");

                        Element bounds = (Element) geometry.getElementsByTagName("bounds").item(0);
                        Element southwest = (Element) bounds.getElementsByTagName("southwest").item(0);
                        Element northeast = (Element) bounds.getElementsByTagName("northeast").item(0);
                        String east = northeast.getElementsByTagName("lng").item(0).getTextContent();
                        String north = northeast.getElementsByTagName("lat").item(0).getTextContent();
                        String west = southwest.getElementsByTagName("lng").item(0).getTextContent();
                        String south = southwest.getElementsByTagName("lat").item(0).getTextContent();

                        System.out.println("Bounds: (east=" + east + ", north=" + north + ", west=" + west + ", south=" + south + ")");
                    }
                }
            } else {
                System.out.println("Die Anfrage war nicht erfolgreich. Status: " + status);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
