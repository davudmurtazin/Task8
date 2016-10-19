package by.epam.task8.parser.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class StAXParserController {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream inputStream = new FileInputStream("src/by/epam/task8/xml/xmlCars.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
        StAXParser stAXParser = new StAXParser();
        System.out.println("------Start parsing------");
        stAXParser.parse(reader);
        stAXParser.getCars();
        System.out.println("------Parsing ended------");
    }
}
