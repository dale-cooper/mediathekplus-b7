package de.br.multimedia.mediathekplus.b7.rest.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class StandaloneServer {


	public static void main(String[] args) throws Exception {

		
		ResourceConfig rc = new PackagesResourceConfig(
				"de.br.multimedia.mediathekplus.b7.service.rest.mock");
		GrizzlyServerFactory.createHttpServer(args[0], rc);
		while (true) {
		}
	}

}
