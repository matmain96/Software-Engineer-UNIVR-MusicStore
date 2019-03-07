package Controller;

import Model.*;
import View.*;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Controller.*;
public class GUIApp {
	public static void main(String[] args){
		Start();
		Main myFrm = new Main();
		System.out.println("Program starts");
	}


	private static  void Start(){
		try {
			
			File xmlFile = new File("C:\\Users\\Matteo Mainenti\\Desktop\\NegozioCD\\src\\CDs.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("CD");
            //now XML is loaded as Document in memory, lets convert it to Object List
            int k;
            for (k = 0; k < nodeList.getLength(); k++) {
            	
            	 Element element = (Element) nodeList.item(k);
            	 NodeList nodeList2 = element.getElementsByTagName("cdname").item(0).getChildNodes();
            	 NodeList nodeList3 = element.getElementsByTagName("code").item(0).getChildNodes();
            	 NodeList nodeList4 = element.getElementsByTagName("tracknames").item(0).getChildNodes();
            	 NodeList nodeList5 = element.getElementsByTagName("price").item(0).getChildNodes();
            	 NodeList nodeList6 = element.getElementsByTagName("path").item(0).getChildNodes();
            	 NodeList nodeList7 = element.getElementsByTagName("info").item(0).getChildNodes();
            	 NodeList nodeList8 = element.getElementsByTagName("release").item(0).getChildNodes();
            	 NodeList nodeList9 = element.getElementsByTagName("band").item(0).getChildNodes();
            	 NodeList nodeList10 = element.getElementsByTagName("genre").item(0).getChildNodes();
            	 NodeList nodeList11 = element.getElementsByTagName("dim").item(0).getChildNodes();
            	 
            	 Node cdname= (Node) nodeList2.item(0);
            	 Node code = (Node) nodeList3.item(0);
            	 Node trackname = (Node) nodeList4.item(0);
            	 Node price = (Node) nodeList5.item(0);
            	 Node path = (Node) nodeList6.item(0);
            	 Node info = (Node) nodeList7.item(0);
            	 Node release = (Node) nodeList8.item(0);
            	 Node band = (Node) nodeList9.item(0);
            	 Node genre = (Node) nodeList10.item(0);
            	 Node dim= (Node)nodeList11.item(0);
            	 
            	 
            	 
            	
            	 CD nuovo = new CD(nodeToString(cdname), Integer.parseInt(nodeToString(code)),nodeToString(trackname),nodeToString(genre), Integer.parseInt(nodeToString(price)), nodeToString(info), nodeToString(release), nodeToString(band), new ImageIcon(nodeToString(path)));
            	 Catalogue.getProducts().put(nuovo, Integer.parseInt(nodeToString(dim)));
            	 Catalogue.getOrder().put(k,nuovo);
            	 
            }
            	 
        		 xmlFile = new File("C:\\Users\\Matteo Mainenti\\Desktop\\NegozioCD\\src\\users.xml");
				 dbFactory = DocumentBuilderFactory.newInstance();
				
					dBuilder = dbFactory.newDocumentBuilder();
					doc = dBuilder.parse(xmlFile);
		            doc.getDocumentElement().normalize();
		            nodeList = doc.getElementsByTagName("utente");
		            //now XML is loaded as Document in memory, lets convert it to Object List
		            ArrayList<Customer> empList = new ArrayList<Customer>();
		            
		        
		            for (k = 0; k < nodeList.getLength(); k++) {
		               Element  element = (Element) nodeList.item(k);
		            	NodeList nodeList2 = element.getElementsByTagName("username").item(0).getChildNodes();
		            	NodeList nodeList3 = element.getElementsByTagName("password").item(0).getChildNodes();
		            	
			            Node usrname = (Node) nodeList2.item(0);
			            Node password = (Node) nodeList3.item(0);
			          
		              
		                	/** creo il customer scelto */
		                	NodeList nodeList4 = element.getElementsByTagName("CF").item(0).getChildNodes();
		                	NodeList nodeList5 = element.getElementsByTagName("name").item(0).getChildNodes();
		                	NodeList nodeList6 = element.getElementsByTagName("surname").item(0).getChildNodes();
		                	NodeList nodeList7 = element.getElementsByTagName("city").item(0).getChildNodes();
		                	NodeList nodeList8 = element.getElementsByTagName("telephone").item(0).getChildNodes();
		                	
		                	Node CF = (Node) nodeList4.item(0);
		                	Node name = (Node) nodeList5.item(0);
		                	Node surname = (Node) nodeList6.item(0);
		                	Node city = (Node) nodeList7.item(0);
		                	Node telephone = (Node) nodeList8.item(0);
		                	
		                	
		                	ArrayCust.getClienti().add( new Customer(nodeToString(CF), nodeToString(usrname), nodeToString(password), nodeToString(name),nodeToString(surname), nodeToString(city),nodeToString(telephone)));
		            }
        
         
          
            	
            } catch(Exception e1){
        	e1.printStackTrace();
        	}
		
		}
  
		
           
		
	
	private static String nodeToString(Node node) throws TransformerException {
	    StringWriter buf = new StringWriter();
	    Transformer xform = TransformerFactory.newInstance().newTransformer();
	    xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    xform.transform(new DOMSource(node), new StreamResult(buf));
	    return(buf.toString());
	}
}