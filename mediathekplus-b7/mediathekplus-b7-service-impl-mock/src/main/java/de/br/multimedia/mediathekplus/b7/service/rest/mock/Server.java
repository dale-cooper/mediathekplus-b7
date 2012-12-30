package de.br.multimedia.mediathekplus.b7.service.rest.mock;

import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public class Server {
	
	
	public static void main(String[] args) throws Exception {
		
		String serverUrl = args[0];
		GrizzlyServerFactory.create(serverUrl);
		while(true){}
	}

}
