package by.epam.task8.parser.dom;

import by.epam.task8.entity.Car;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class DOMParserUtil {
    private List<Car> cars = new ArrayList<>();
    private Car car;

    public List<Car> parseXML() throws IOException, SAXException {
        DOMParser domParser = new DOMParser();
        domParser.parse("src/by/epam/task8/xml/xmlCars.xml");
        Document document = domParser.getDocument();
        Element element = document.getDocumentElement();

        NodeList carList = element.getElementsByTagName("car");
        System.out.println("--------------Start parsing--------------");

        for(int carCouner = 0; carCouner < carList.getLength(); carCouner++){
            car = new Car();
            Element carElement = (Element) carList.item(carCouner);
            car.setCarType(carElement.getAttribute("type"));
            car.setMark(getChild(carElement, "mark").getTextContent().trim());
            car.setTitle(getChild(carElement, "title").getTextContent().trim());
            car.setNumber(getChild(carElement, "number").getTextContent().trim());
            car.setColor(getChild(carElement, "color").getTextContent().trim());
            car.setPrice(Integer.parseInt(getChild(carElement, "price").getTextContent().trim()));
            cars.add(car);
        }
        return cars;
    }

    public void printCars(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public Element getChild(Element element, String childElement){
        NodeList dishList = element.getElementsByTagName(childElement);
        Element elementChild = (Element)dishList.item(0);
        return elementChild;
    }
}
