package com.example.personlist;

public class People {
    private Person [] people = {
            new Person("Sabin Tab",
                    "11111111",
                    "WGB, UCC, Cork",
                    "sabin.jpg",
                    "http://www.ucc.ie"),
            new Person("Sabina Tabirca",
                    "22222222",
                    "WGB, UCC, Cork",
                    "sabin.jpg",
                    "http://www.ucc.ie"),
            new Person("Saby Taby",
                    "33333333",
                    "WGB, UCC, Cork",
                    "sabin.jpg",
                    "http://www.ucc.ie"),
    };

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