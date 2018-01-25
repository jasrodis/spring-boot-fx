package cryptosim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	private final static String DB_NAME = "convoy";
	private final static String HOST_NAME = "127.0.0.1";
	private final static Integer PORT = 27017;

	@Override
	protected String getDatabaseName() {
		return DB_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(HOST_NAME, PORT);
	}
}