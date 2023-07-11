package de.dhbwka.java.exercise.xml;
import java.net.*;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;
public class Gazetteer2 {
    public static void main(String[] args) throws Exception{

        URL url = new URL("https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(con.getInputStream());

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();

        String formattedAddress = (String) xpath.evaluate("GeocodeResponse/result/formatted_address", doc, XPathConstants.STRING);
        String longName = (String) xpath.evaluate("GeocodeResponse/result/address_component[1]/long_name", doc, XPathConstants.STRING);
        String latitude = (String) xpath.evaluate("GeocodeResponse/result/geometry/location/lat", doc, XPathConstants.STRING);
        String longitude = (String) xpath.evaluate("GeocodeResponse/result/geometry/location/lng", doc, XPathConstants.STRING);

        String south= (String) xpath.evaluate("GeocodeResponse/result/geometry/bounds/southwest/lat", doc, XPathConstants.STRING);
        String west = (String) xpath.evaluate("GeocodeResponse/result/geometry/bounds/southwest/lng", doc, XPathConstants.STRING);
        String north= (String) xpath.evaluate("GeocodeResponse/result/geometry/bounds/northeast/lat", doc, XPathConstants.STRING);
        String east = (String) xpath.evaluate("GeocodeResponse/result/geometry/bounds/northeast/lng", doc, XPathConstants.STRING);

        System.out.println("Adresse: " + formattedAddress);
        System.out.println("Long Name: " + longName);
        System.out.println("Location: (latitude="+latitude+", longitude="+longitude+")");
        System.out.println("Bounds: (east="+east+", north="+north+", west="+west+", south="+south+")");
    }
}
