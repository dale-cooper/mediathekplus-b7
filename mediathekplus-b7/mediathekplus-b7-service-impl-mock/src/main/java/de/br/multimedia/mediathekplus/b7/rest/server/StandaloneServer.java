package de.br.multimedia.mediathekplus.b7.rest.server;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.servlet.GrizzlyWebContainerFactory;

public class StandaloneServer {
	
	
	public static void main(String[] args) throws Exception {
		
		String serverUrl = args[0];
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("com.sun.jersey.config.property.packages", "de.br.multimedia.mediathekplus.b7.service.rest.mock");
		HttpServer server = GrizzlyWebContainerFactory.create("http://localhost:4499/", initParams );
		server.start();
		System.out.println(server.isStarted());
		while(true){}
	}

}
