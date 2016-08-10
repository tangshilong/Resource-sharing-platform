package com.smates.dbc2.mongo;

import java.io.InputStream;
import java.util.Properties;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Component
public class DbHelper {

	private static Morphia morphia = null;
	private static MongoClient mc = null;
	private static Datastore dataStore;

	static {
		try {
			init();
		} catch (Exception e) {
		}
	}

	private static void init() throws Exception {
		InputStream resourceAsStream = DbHelper.class.getClassLoader().getResourceAsStream("mongo.properties");
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		String ip = properties.getProperty("db_ip");
		int port = Integer.parseInt(properties.getProperty("db_port"));
		ServerAddress sa = new ServerAddress(ip, port);
		mc = new MongoClient(sa);

		morphia = new Morphia();
		morphia.mapPackage(properties.getProperty("db_maper_package"));
		dataStore = morphia.createDatastore(mc, properties.getProperty("db_dbname"));
		dataStore.ensureIndexes();
	}

	public Datastore getDs() {
		return dataStore;
	}
}
