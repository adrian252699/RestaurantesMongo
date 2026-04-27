/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.introduccionmongodb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author LABORATORIOS
 */
public class IntroduccionMongoDB {

    public static void main(String[] args) {
        
        try {
            
            MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = cliente.getDatabase("restaurantesDB");
            MongoCollection<Document> collection = db.getCollection("restaurantes");
            
//            Document doc = new Document();
             //Append es para agregar atributos al documento
//            doc.append("name", "Little Cesear");
//            doc.append("starts", 4.5);
//            
//            List<String> sucursales = new ArrayList<>();
//            sucursales.add("Itson");
//            sucursales.add("Centro");
//            
//            doc.append("sucursales", sucursales);

//            ArrayList<Document> lista = new ArrayList<>();
//            
//            lista.add(
//                    new Document("name","Dogos el Nieves")
//                    .append("stars", 3)
//                    .append("categories", Arrays.asList("Hot dogs"))
//            );
//            
//            lista.add(
//                    new Document("name","Chapo Dogos")
//                    .append("stars", 4.5)
//                    .append("categories", Arrays.asList("Hot dogs"))
//            );
//            
//            lista.add(
//                    new Document("name","Dairy Queen")
//                    .append("stars", 4.5)
//                    .append("categories", Arrays.asList("Nieves"))
//            );
//            
//            collection.insertMany(lista);
            
//            collection.insertOne(doc);
            
            for (Document d : collection.find()) {
                System.out.println(d.toJson());   
            }
            
//            System.out.println("\nRestaurantes 4.5 estrellas");
//            for (Document d : collection.find(Filters.eq("stars", 4.5))) {
//                System.out.println(d.toJson());   
//            }
//            
//            System.out.println("\nRestaurantes con mas de 4 estrellas");
//            for (Document d : collection.find(Filters.gt("stars", 4))) {
//                System.out.println(d.toJson());   
//            }
//            
//            //filtro
//            Bson filtro = Filters.and(Filters.gte("stars", 3),Filters.lte("stars", 4.5));
//            
//            System.out.println("\nRestaurantes con entre 3 estrellas y 4.5 estrellas");
//            for (Document d : collection.find(filtro)) {
//                System.out.println(d.toJson());   
//            }
//            
//            System.out.println("\nRestaurantes que inician con la letra T");
//            for (Document d : collection.find(Filters.regex("name", "^T"))) {
//                System.out.println(d.toJson());   
//            }
//            
//            System.out.println("\nRestaurantes que finalizan con la letra E");
//            for (Document d : collection.find(Filters.regex("name", "e$"))) {
//                System.out.println(d.toJson());   
//            }
//            
//            System.out.println("\nRestaurantes que contengan la letra E");
//            for (Document d : collection.find(Filters.regex("name", "e"))) {
//                System.out.println(d.toJson());   
//            }
            
            //Actualizar
//            collection.updateOne(
//                    Filters.eq("name", "Chapo Dogos"), 
//                    Updates.set("stars", 5)
//            );
//            
//            System.out.println("\nChapo Dogos actualizado");
//            for (Document d : collection.find(Filters.eq("name", "Chapo Dogos"))) {
//                System.out.println(d.toJson());   
//            }

            //Actualizar categorias de hot dogs y aumentar una estrella
//            collection.updateMany(
//                    Filters.in("categories", Arrays.asList("Hot dogs")), 
//                    Updates.inc("stars", 1)
//            );
//
//            collection.updateOne(
//                        Filters.eq("name", "Sushilito"), 
//                        Updates.combine(
//                                Updates.set("phone", "555685149581"),
//                                Updates.set("stars", 5),
//                                Updates.set("opne", true)
//                        )
//            );
        
            System.out.println("\nRestaurantes Actualizados");
            for (Document d : collection.find()) {
                    System.out.println(d.toJson());   
            }
            
//            //Eliminar
//            collection.deleteOne(Filters.eq("name","Dairy Queen"));
//            
//            System.out.println("\nDairy Queen Eliminado");
//            for (Document d : collection.find()) {
//                    System.out.println(d.toJson());   
//            }

            System.out.println("\nBuscar por id");
            for (Document d : collection.find(Filters.eq("_id", new ObjectId("69e9666535ff98b5c31320f4")))) {
                    System.out.println(d.toJson());   
            }
            
        } catch (MongoException e) {
            
            System.out.println("Error: "+e.getMessage());
            
        }
    }
    
}
