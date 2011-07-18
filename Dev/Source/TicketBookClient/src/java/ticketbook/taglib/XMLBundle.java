package ticketbook.taglib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class XMLBundle {
	private static ArrayList AUTHORIZE_ROLE;
	public static ArrayList getAuthorizeRole(String path) throws InvalidPropertiesFormatException, FileNotFoundException, ParserConfigurationException, SAXException, IOException{
		if(XMLBundle.AUTHORIZE_ROLE==null)
			XMLBundle.AUTHORIZE_ROLE=new AuthorizeXMLFile(path).getTagPages();
		return XMLBundle.AUTHORIZE_ROLE;
	}
	
}
