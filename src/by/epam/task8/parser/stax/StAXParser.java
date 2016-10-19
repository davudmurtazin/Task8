package by.epam.task8.parser.stax;

import by.epam.task8.entity.Car;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class StAXParser {
    List<Car> carList = null;
    Car car = null;
    String tagContent = null;

    public List<Car> parse(XMLStreamReader reader) throws XMLStreamException {
        while(reader.hasNext()){
            int event = reader.next();
            switch(event){
                case XMLStreamConstants.START_ELEMENT:
                    if ("car".equals(reader.getLocalName())){
                        car = new Car();
                        car.setCarType(reader.getAttributeValue(0));
                    }
                    if("cars".equals(reader.getLocalName())){
                        carList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch(reader.getLocalName()){
                        case "car":
                            carList.add(car);
                            break;
                        case "mark":
                            car.setMark(tagContent);
                            break;
                        case "title":
                            car.setTitle(tagContent);
                            break;
                        case "number":
                            car.setNumber(tagContent);
                            break;
                        case "color":
                            car.setColor(tagContent);
                            break;
                        case "price":
                            car.setPrice(Integer.parseInt(tagContent));
                            break;
                    }
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    carList = new ArrayList<>();
                    break;
            }
        }
        return carList;
    }

    public void getCars() {
        for ( Car car : carList){
            System.out.println(car);
        }
    }
}
