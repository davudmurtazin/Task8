package by.epam.task8.parser.dom;

import by.epam.task8.entity.Car;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class DOMController {
    public static void main(String[] args) throws IOException, SAXException {
        DOMParserUtil domParser = new DOMParserUtil();
        List<Car> cars = domParser.parseXML();
        domParser.printCars(cars);

    }
}
