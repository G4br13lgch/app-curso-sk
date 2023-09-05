package mx.smartkode.app.negocio;

public class AppExcepcion extends Exception {

	private static final long serialVersionUID = -5206883934073591630L;

	public AppExcepcion() {
		super();
	}

	public AppExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

	public AppExcepcion(String message) {
		super(message);
	}

	public AppExcepcion(Throwable cause) {
		super(cause);
	}

}
