package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.SpecLoc;
import models.Wifi;
 
public class MyMain {
	
	
  public static void main(String[] args) {
	  
	  String bCsvFile = "battery.csv";
	  String gCsvFile = "gps.csv";
	  String wCsvFile = "wifi.csv";
	  String sCsvFile = "base_station.csv";
	  BufferedReader br = null;
	  String line = "";
	  String cvsSplitBy = "\t";
	  List<Wifi> points=new ArrayList<Wifi>();
	  List<SpecLoc> aPoLocs=new ArrayList<SpecLoc>();
      String csvFile = null;
//      for(int j=0;j<4;j++){
//    	  if(j==0)
//    		  csvFile = bCsvFile;
//    	  else if(j==1)
//    		  csvFile = gCsvFile;
//    	  else if(j==2)
//    		  csvFile = wCsvFile;
//    	  else if(j==3)
//    		  csvFile = sCsvFile;
//	  
	      try {
	    	  
	  		br = new BufferedReader(new FileReader(wCsvFile));
	  		int i=0;
	  		while ((line = br.readLine()) != null) {
	  			if(i==0)
	  				System.out.println(line);
	  			if(i>0){
	  		        // use comma as separator
		  			String[] field = line.split(cvsSplitBy);
		  			points.add(new Wifi(Integer.parseInt(field[0]),field[1],field[2],field[3],Integer.parseInt(field[4]),Integer.parseInt(field[5]),Double.parseDouble(field[6]),Double.parseDouble(field[7]),Timestamp.valueOf(field[8])));
	   
	  			}
	  			i++;
	  			if(i==50000)
	  				System.out.println(i);
	  		}
	  		System.out.println("done"+points.size());
		  	} catch (FileNotFoundException e) {
		  		e.printStackTrace();
		  	} catch (IOException e) {
		  		e.printStackTrace();
		  	} finally {
		  		if (br != null) {
		  			try {
		  				br.close();
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  		}
		  	}
	      	int j;
	      	int k=0;
	      	for(int i=0;i<points.size();i++){
	      		for(j=0;j<aPoLocs.size();j++)
	      			if(points.get(i).getBssid().equals(aPoLocs.get(j).getBssid())){
	      				k=1;
	      				break;
	      			}
	      		if(k==1){
	      			k=0;
	      			continue;
	      		}
	          	double w=Math.pow(10,points.get(i).getLevel()/10);
	          	double totalweight=w;
	          	double lat=(points.get(i).getLatitude()*3.14159265359/180)*w;
	          	double lon=(points.get(i).getLongitude()*3.14159265359/180)*w;
	      		for(j=points.size()-1;j>i;j--){
	      			if(points.get(i).getBssid().equals(points.get(j).getBssid())){
	      				w=Math.pow(10,points.get(j).getLevel()/10);
	      				totalweight+=w;
	      				lat+=(points.get(j).getLatitude()*3.14159265359/180)*w;
	      				lon+=(points.get(j).getLongitude()*3.14159265359/180)*w;
	      			}
	      			if(j==i+1){
	      				aPoLocs.add(new SpecLoc(points.get(i).getBssid(),lat/totalweight,lon/totalweight));
	      				
	      			}
	      		}
	      	}
    //  }
 
  }
 
}



//if(j==0){
//	query="insert into battery (id,email,level,plugged,temperature,valtage,timestamp) values('"+field[0]+"','"+field[1]+"','"+field[2]+"','"+field[3]+"','"+field[4]+"','"+field[5]+"','"+field[6]+"')";
//	stmnt.executeUpdate(query);
//}
//else if(j==1){
//	query="insert into gps (id,email,latitude,longitude,timestamp) values('"+field[0]+"','"+field[1]+"','"+field[2]+"','"+field[3]+"','"+field[4]+"')";
//	stmnt.executeUpdate(query);
//}
// 	else if(j==2){
//	  	query="insert into wifi (id,email,ssid,bssid,level,frequency,latitude,longitude,timestamp) values('"+field[0]+"','"+field[1]+"','"+field[2]+"','"+field[3]+"','"+field[4]+"','"+field[5]+"','"+field[6]+"','"+field[7]+"','"+field[8]+"')";
//	stmnt.executeUpdate(query);
// 	}
// 	else if(j==3){
//	  	query="insert into battery (id,email,operator,mcc,mnc,cid,lac,latitude,longitude,timestamp) values('"+field[0]+"','"+field[1]+"','"+field[2]+"','"+field[3]+"','"+field[4]+"','"+field[5]+"','"+field[6]+"','"+field[7]+"','"+field[8]+"','"+field[9]+"')";
//	stmnt.executeUpdate(query);
// 	}