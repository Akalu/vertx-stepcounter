package verticle;

import io.vertx.reactivex.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import verticle.api.StepApiVerticle;

@Slf4j
public class StepServer {

	public static void main(String[] args) {
		System.setProperty("vertx.log-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory");
		Vertx vertx = Vertx.vertx();
		vertx
		.rxDeployVerticle(new EventsVerticle())
		.flatMap(id -> vertx.rxDeployVerticle(new StepApiVerticle()))
				.subscribe(ok -> log.info("HTTP server started on port {}", StepApiVerticle.HTTP_PORT),
						e -> log.error("Error {}", e.getMessage()));
	}
}
