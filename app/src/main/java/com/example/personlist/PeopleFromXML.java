package com.example.personlist;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//=-

public class PeopleFromXML {
    private Person [] people;
    private Context context;

    public PeopleFromXML(Context context ){

        this.context = context;
        // open a stream to the xml file + a DocBuilder + doc
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try{
            stream = this.context.getResources().openRawResource(R.raw.people);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);


        }
        catch (Exception e){

        }

        //Slice xmlDoc to NodeList
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList phoneList = xmlDoc.getElementsByTagName("phone");
        NodeList addressList = xmlDoc.getElementsByTagName("address");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList urlList = xmlDoc.getElementsByTagName("url");

        // make people

        people = new Person[nameList.getLength()];
        for(int i=0; i<people.length; i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String phone = phoneList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            people[i] = new Person(name, phone, address, image, url);
        }
    }

    public int getLength(){return people.length;}
    public Person getPerson(int index){return people[index];}
    public String [] getNames(){
        String [] names = new String[getLength()];
        for(int i=0;i<getLength();i++){
            names[i] = getPerson(i).getName();
        }
        return names;
    }
}
