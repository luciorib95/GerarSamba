package br.com.logusinfo.consultas;

public class ConnectionException extends Exception {

	private String errMessage;

	public ConnectionException(String errMessage) {
		this.errMessage = errMessage;
	}

}
