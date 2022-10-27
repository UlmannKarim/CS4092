package com.example.personlist;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//+

public class AirlinesFromXML {
    public Airline [] getAirlines(){
        return airlines;
    }

    private Airline[] airlines;
    private Context context;

    public AirlinesFromXML(Context context ){

        this.context = context;
        // open a stream to the xml file + a DocBuilder + doc
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try{
            stream = this.context.getResources().openRawResource(R.raw.airlines);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);


        }
        catch (Exception e){

        }

            // name,  callSign,  logo,  originCountry,  homeBaseAirport,  url,  ranking


            //Slice xmlDoc to NodeList
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList callSignList = xmlDoc.getElementsByTagName("callSign");
        NodeList logoList = xmlDoc.getElementsByTagName("logo");
        NodeList originCountryList = xmlDoc.getElementsByTagName("originCountry");
        NodeList homeBaseAirportList = xmlDoc.getElementsByTagName("homeBaseAirport");
        NodeList urlList = xmlDoc.getElementsByTagName("url");
        NodeList rankingList = xmlDoc.getElementsByTagName("ranking");

        // make people

        airlines = new Airline[nameList.getLength()];
        for(int i=0; i<airlines.length; i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String callSign = callSignList.item(i).getFirstChild().getNodeValue();
            String logo = logoList.item(i).getFirstChild().getNodeValue();
            String originCountry = originCountryList.item(i).getFirstChild().getNodeValue();
            String homeBaseAirport = homeBaseAirportList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            airlines[i] = new Airline(name, callSign, logo, originCountry, homeBaseAirport, url);
        }
    }

    public int getLength(){return airlines.length;}
    public Airline getAirline(int index){return airlines[index];}
    public String [] getNames(){
        String [] names = new String[getLength()];
        for(int i=0;i<getLength();i++){
            names[i] = getAirline(i).getName();
        }
        return names;
    }
}
