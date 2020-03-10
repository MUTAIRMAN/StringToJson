package MuthuMaven.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class StringtoXML {

	public static void main(String a[]) throws IOException, JAXBException, ParserConfigurationException, TransformerException {
		String st;
		String[] y;
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		 
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("company");
        document.appendChild(root);

        // employee element
        Element employee = document.createElement("employee");

        root.appendChild(employee);

		File file = new File("C:\\Users\\Muthukumar\\Desktop\\SampleFiles\\SampleString.txt");
		File fileNew=new File("C:\\Users\\Muthukumar\\Desktop\\SampleFiles\\pun.txt");

		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		FileWriter bw=new FileWriter(fileNew);

		while ((st = bf.readLine()) != null) {
			y = st.split(":");
			
			Element email = document.createElement(y[0]);
            email.appendChild(document.createTextNode(y[1]));
            employee.appendChild(email);
            
            
            
			
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(fileNew);

        
        transformer.transform(domSource, streamResult);
     
        bw.close();
		
		
	}

}
