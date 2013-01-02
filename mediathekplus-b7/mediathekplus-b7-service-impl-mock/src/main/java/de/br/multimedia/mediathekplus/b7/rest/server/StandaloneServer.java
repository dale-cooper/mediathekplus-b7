package de.br.multimedia.mediathekplus.b7.rest.server;

import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public class StandaloneServer {
	
	
	public static void main(String[] args) throws Exception {
		
		String serverUrl = args[0];
		GrizzlyServerFactory.create(serverUrl);
		while(true){}
	}

}
