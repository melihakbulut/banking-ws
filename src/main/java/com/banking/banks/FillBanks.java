package com.banking.banks;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.banking.pool.PoolConfig;


public class FillBanks {

	public static void main(String[] args) throws SQLException, ParserConfigurationException, SAXException, IOException {
				
		PoolConfig config=new PoolConfig();
		Connection connection=null;
		
		try {
			connection =config.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		ReadExcel r=new ReadExcel();
//		HashMap<Integer, String> banks=new HashMap<Integer, String>();
//		HashMap<Integer, String> cities=new HashMap<Integer, String>();
//		ArrayList<SampleBranch> branches=r.read();
		
		PreparedStatement statement=connection.prepareStatement("select * from banks");
		ResultSet rs=statement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("bank_id") +"-"+rs.getString("name") );
		}
//		
//		statement=connection.prepareStatement("select * from cities");
//		rs=statement.executeQuery();
//		while (rs.next()) {
//			cities.put(rs.getInt("city_id"), rs.getString("name"));
//			
//		}
//		
//		for (SampleBranch s : branches) {
//			if(banks.containsValue(s.getBankname())){
//				int id=getIdFromBankNames(s.getBankname(),banks);
//				s.setBankname(String.valueOf(id));
//			}
//			if(cities.containsValue(s.getCity())){
//				int city=getIdFromBankNames(s.getCity(),cities);
//				s.setCity(String.valueOf(city));
//			}
//					
//		}
//		
//		statement=connection.prepareStatement("insert into branches (bank_id,city_id,name) values(?,?,?)");
//		
//		int counter=0;
//		for (int i = 1; i <= branches.size(); i++) {
//			SampleBranch s=branches.get(i);
//			statement.setInt(1, Integer.parseInt(s.getBankname()));
//			statement.setInt(2, Integer.parseInt(s.getCity()));
//			statement.setString(3, s.getBranch());
//			statement.executeUpdate();
//			counter++;
//			if(counter%250==0)
//				System.out.println(counter);
//		}
//		System.out.println(branches.size());
//		

		
		
		
	}
	
	public static int getIdFromBankNames(String bankname,HashMap<Integer, String> hash){
		int id=0;
		for (int i = 1; i <= hash.size(); i++) {
			if(hash.get(i).equals(bankname))
				id=i;
		}
		return id;
		
	}
	
	
	public static ArrayList<String> readXml() throws ParserConfigurationException, SAXException, IOException{
		ArrayList<String> list=null;
		try {
		URL url=FillBanks.class.getClassLoader().getResource("iller.xml");
		File fXmlFile = new File(url.getPath());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		list=new ArrayList<String>();
		
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("tbl_il");
		
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				
				list.add(eElement.getElementsByTagName("il_ad").item(0).getTextContent());
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return list;
		
	}
}
