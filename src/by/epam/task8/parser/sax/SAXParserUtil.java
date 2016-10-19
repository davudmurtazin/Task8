package by.epam.task8.parser.sax;

import by.epam.task8.entity.Car;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class SAXParserUtil extends DefaultHandler {
    private Car car;
    private List<Car> cars = new ArrayList<>();
    private String text;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("--------Parsing started---------");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("--------Parsing ended---------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = qName;
        if(text.equals("car")){
            car = new Car();
            car.setCarType(attributes.getValue("type"));
        }
    }

    @Override
    public void characters(char[] chars, int start, int end) throws SAXException {
        String value = new String(chars, start, end);
        switch (text){
            case "type":
                car.setCarType(value);
                break;
            case "mark":
                car.setMark(value);
                break;
            case "title":
                car.setTitle(value);
                break;
            case "number":
                car.setNumber(value);
                break;
            case "color":
                car.setColor(value);
                break;
            case "price":
                car.setPrice(Integer.parseInt(value));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if (qName.equals("car")) {
            cars.add(car);
        }
        text = "";
    }

    public void getCars(){
        for (Car car: cars) {
            System.out.println(car);
        }
    }

    @Override
    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }
}
