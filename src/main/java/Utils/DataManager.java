package Utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Mariusz on 2016-01-30.
 */
public class DataManager {

    public final static String FILEPATH = "data.xml";
    private final static File dbFile = new File(FILEPATH);


    public static DataBase load(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataBase.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (DataBase) jaxbUnmarshaller.unmarshal(dbFile);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static boolean save(DataBase db){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataBase.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(db, dbFile);
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }
}
