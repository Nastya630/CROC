import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
/**
 * Класс для чтения информации о продуктах из XML файла
 *
 * @author Ivanova Anastasiya
 */
public class ProductReader {
    /**
     * Метод для чтения данных
     * @param map Куда запишем результат
     * @param file файл для чтения
     * @return метод для чтения содержимого в элементах файла
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static HashMap<Integer, Product> read(HashMap<Integer, Product> map, String file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document =  builder.parse(file);
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        return readInto(nodeList,map);
    }
    /**
     * Метод для чтения содержимого элементов файла
     * @param nodeList элементы файла
     * @param map Куда запишем результат
     * @return HashMap с записанными данными
     */
    public static HashMap<Integer, Product> readInto(NodeList nodeList,HashMap<Integer, Product> map) {
        int id=0;
        String str="";
        for (int i = 0; i< nodeList.getLength();i++){
            if(nodeList.item(i) instanceof Element){
                if (nodeList.item(i).hasChildNodes()){
                    readInto(nodeList.item(i).getChildNodes(),map);
                }
                if(!nodeList.item(i).getTextContent().trim().isEmpty()
                        && !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty()
                        && !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n"))
                {
                    Text text = (Text)nodeList.item(i).getFirstChild();
                    if (i==1) {
                        id=Integer.parseInt(text.getData().trim());
                    }
                    else if (i==3) {
                        str = text.getData().trim();
                    }
                }
            }

        }
        if (!str.equals("")){// проверка на то, что мы ничего не считали
            Product p = new Product(id, str);
            map.put(id,p);
        }
        return map;
    }



}
