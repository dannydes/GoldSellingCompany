package server;

import java.net.*;
import java.io.*;

public class Server {
	private Socket clientSocket;
	private Closeable serverSocket;
	private static Country[] prices = {
		new Country( "Malta", 24.61 ),
		new Country( "UK", 22.15 ),
		new Country( "Swiss", 36.51 ),
		new Country( "CAD", 37.22 ),
		new Country( "AUD", 40.12 ),
		new Country( "JPY", 3251.63 )
	};

	public Server( boolean udp ) {
		try {
			serverSocket = udp ?
					new DatagramSocket( 1046 ) :
					new ServerSocket( 1045 );
		} catch ( Exception e ) {
			System.out.println( "Socket failed! " +
					e.getMessage() + " :(" );
		}
	}
	
	private double getPrice( String countryCode ) throws Exception {
		for ( Country country : prices ) {
			if ( country.getCode().equals( countryCode ) ) {
				return country.getPrice();
			}
		}
		throw new Exception( "Country code not found!" );
	}
	
	public void sendPrice( String countryCode ) throws IOException, Exception {
		BufferedOutputStream stream = new BufferedOutputStream( clientSocket.getOutputStream() );
		OutputStreamWriter writer = new OutputStreamWriter( stream );
		writer.write( ( int ) getPrice( countryCode ) );
	}
	
	public String getCountryCode() throws IOException {
		BufferedInputStream stream = new BufferedInputStream( clientSocket.getInputStream() );
		InputStreamReader reader = new InputStreamReader( stream );
		return Integer.toString( reader.read() );
	}
}
