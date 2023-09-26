package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private static List<double[]> calculatePoints(double swLat, double swLong, double neLat, double neLong) {

        List<double[]> points = new ArrayList<>();

        double latStep = (neLat - swLat) / 4;
        double longStep = (neLong - swLong) / 4;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                double[] point = new double[2];
                point[0] = swLat + (i * latStep);
                point[1] = swLong + (j * longStep);
                points.add(point);
            }
        }

        return points;
    }

    public static void createKMLFile(List<double[]> points, String filename) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.newDocument();

        Element kml = doc.createElementNS("https://earth.google.com/kml/2.2", "kml");
        Element docuElement = doc.createElement("Document");

        for (double[] point : points) {
            Element placeMark = doc.createElement("Placemark");
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("Point " + points.indexOf(point)));
            Element description = doc.createElement("description");
            description.appendChild(doc.createTextNode("Hier ist ein Punkt."));
            Element pointElement = doc.createElement("Point");
            Element coordinates = doc.createElement("coordinates");
            coordinates.appendChild(doc.createTextNode(point[1] + "," + point[0]));

            pointElement.appendChild(coordinates);
            placeMark.appendChild(name);
            placeMark.appendChild(description);
            placeMark.appendChild(pointElement);
            docuElement.appendChild(placeMark);
        }

        kml.appendChild(docuElement);
        doc.appendChild(kml);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

        System.out.println("File saved!");

    }


    public static void main(String[] args) throws Exception {

        // Ersetzen Sie sie durch Ihre tatsächlichen Koordinaten.
        double swLat = 48.504155;
        double swLong = 9.203798;
        double neLat = 43.504155;
        double neLong = 11.203798;

        List<double[]> points = calculatePoints(swLat, swLong, neLat, neLong);

        createKMLFile(points, "resources/grid.kml");
    }
}
