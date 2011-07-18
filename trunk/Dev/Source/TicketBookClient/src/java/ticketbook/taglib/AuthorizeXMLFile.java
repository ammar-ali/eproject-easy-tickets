package ticketbook.taglib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AuthorizeXMLFile {
	String path;
	public AuthorizeXMLFile(String path) throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		this.path=path;
	}
	
	public ArrayList getTagPages() throws ParserConfigurationException, SAXException, IOException{
		ArrayList authorizeXMLList=new ArrayList();
		File file = new File(this.path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		NodeList nodeLST=doc.getElementsByTagName("authorize");
		if(nodeLST.getLength()>0){
			Node node=(Node)nodeLST.item(0);
			Element ele=(Element)node;
			
			NodeList sessionRoleNodeLST=(NodeList)ele.getElementsByTagName("session_role");
			NodeList alertNodeLST=(NodeList)ele.getElementsByTagName("alert");
			NodeList errorNodeLST=(NodeList)ele.getElementsByTagName("error");
			
			String sessionName=sessionRoleNodeLST.item(0).getTextContent();
			String errorPage=errorNodeLST.item(0).getTextContent();
			String alert=alertNodeLST.item(0).getTextContent();
			NodeList nodesPage=ele.getElementsByTagName("page");
			
			for(int i=0;i<nodesPage.getLength();i++){
				Node nodePage=(Node)nodesPage.item(i);
				Element elePage=(Element)nodePage;
				AuthorizeXMLBean authorizeXMLModel=new AuthorizeXMLBean();
				authorizeXMLModel.setAlert(alert);
				authorizeXMLModel.setErrorPage(errorPage);
				authorizeXMLModel.setSessionRole(sessionName);
				NodeList pageNameNodes=elePage.getElementsByTagName("page_name");
				authorizeXMLModel.setPageName(pageNameNodes.item(0).getTextContent());
				NodeList itemNodes=elePage.getElementsByTagName("role");
				ArrayList roleList=new ArrayList();
				for(int j=0;j<itemNodes.getLength();j++){
					Element eleRole=(Element)itemNodes.item(j); 
					roleList.add(eleRole.getTextContent());
					authorizeXMLModel.setRoles(roleList);
				}
				authorizeXMLList.add(authorizeXMLModel);
			}
			
		}
		return authorizeXMLList;
	}
}
