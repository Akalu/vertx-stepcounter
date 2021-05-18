package verticle.config;

import io.vertx.pgclient.PgConnectOptions;

public class PgConfig {

	public static PgConnectOptions pgConnectOpts() {
		return new PgConnectOptions()
				.setHost("localhost")
				.setDatabase("postgres")
				.setUser("postgres")
				.setPassword("postgres");
	}
}
