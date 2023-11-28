import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для записи ответов в XML файл
 *
 * @author Ivanova Anastasiya
 */
public class XMLWriter {
    /**
     * Метод для записи результатов для первого задания
     * @param topSalesman результаты
     * @throws FileNotFoundException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void PrintFirst(HashMap<Salesman, Integer> topSalesman) throws FileNotFoundException, ParserConfigurationException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element sellers = document.createElement("Top_sellers");
        document.appendChild(sellers);
        topSalesman.entrySet().stream().sorted(Map.Entry.<Salesman, Integer>comparingByValue().reversed())
                .forEach(k -> {
                    Element element = document.getDocumentElement();
                    NodeList nodeList = element.getChildNodes();
                    if(nodeList.getLength()<5) {//проверка чтобы записалось не больше 5 элементов
                        Element seller = document.createElement("Seller");
                        Element name = document.createElement("Seller_name");
                        Element lastname = document.createElement("Seller_last_name");
                        Element qu = document.createElement("Quantity");
                        Text namet = document.createTextNode(k.getKey().getName());
                        Text lastt = document.createTextNode(k.getKey().getLastName());
                        Text q = document.createTextNode("" + k.getValue());
                        sellers.appendChild(seller);
                        seller.appendChild(name);
                        name.appendChild(namet);
                        seller.appendChild(lastname);
                        lastname.appendChild(lastt);
                        seller.appendChild(qu);
                        qu.appendChild(q);
                    }

                });
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("files/First.xml")));
    }
    /**
     * Метод для записи результатов для второго задания
     * @param topDates результаты
     * @throws FileNotFoundException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void PrintSecond(HashMap<LocalDate,Integer> topDates) throws FileNotFoundException, ParserConfigurationException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element dates = document.createElement("Top_dates");
        document.appendChild(dates);
        topDates.entrySet().stream().sorted(Map.Entry.<LocalDate, Integer>comparingByValue().reversed())
                .forEach(k -> {
                    Element element = document.getDocumentElement();
                    NodeList nodeList = element.getChildNodes();
                    if(nodeList.getLength()<5) {//проверка чтобы записалось не больше 5 элементов
                        Element date = document.createElement("Top_Date");
                        Element name = document.createElement("Date");
                        Element qu = document.createElement("Quantity");
                        Text namet = document.createTextNode(""+k.getKey());
                        Text qt = document.createTextNode("" + k.getValue());
                        dates.appendChild(date);
                        date.appendChild(name);
                        name.appendChild(namet);
                        date.appendChild(qu);
                        qu.appendChild(qt);
                    }

                });
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("files/Second.xml")));
    }

}
