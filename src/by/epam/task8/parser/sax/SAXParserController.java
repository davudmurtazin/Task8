package by.epam.task8.parser.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class SAXParserController {
    public static void main(String[] args) throws SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParserUtil saxParser = new SAXParserUtil();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(new File("src/by/epam/task8/xml/xmlCars.xml"), saxParser);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        saxParser.getCars();
    }
}
