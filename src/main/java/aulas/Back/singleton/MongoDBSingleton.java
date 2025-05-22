package aulas.Back.singleton;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBSingleton {
    private static MongoDBSingleton instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    // Cambia estos valores si lo necesitas
    private static final String DATABASE_NAME = "aulasdb";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    // Constructor privado
    private MongoDBSingleton() {
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    // Método público para obtener la instancia única
    public static synchronized MongoDBSingleton getInstance() {
        if (instance == null) {
            instance = new MongoDBSingleton();
        }
        return instance;
    }

    // Método para obtener la base de datos
    public MongoDatabase getDatabase() {
        return database;
    }

    // Si necesitas cerrar la conexión
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}