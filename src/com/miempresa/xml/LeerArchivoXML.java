package com.miempresa.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeerArchivoXML {

  public static void main(String argv[]) {

    try {
	File archivo = new File("C:/Users/Carlos/Desktop/escritura_nomina_xml/empleados.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(archivo);

	doc.getDocumentElement().normalize();

	System.out.println("Elemento raiz :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("empleado");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nElemento actual :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                System.out.println("Cedula : " + eElement.getElementsByTagName("cedula").item(0).getTextContent());
                System.out.println("Numero de cuenta : " + eElement.getElementsByTagName("numeroCuenta").item(0).getTextContent());
                System.out.println("Salario : " + eElement.getElementsByTagName("salario").item(0).getTextContent());
            }
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}