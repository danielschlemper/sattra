package br.com.sattra.exception;

public class CPFValidationException extends Exception {

	private String msg;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CPFValidationException(String msg) {
		super(msg);
		this.msg = msg;		
	}

	public class CPFInvalidoException extends CPFValidationException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CPFInvalidoException() {
			super("CPF invalido");
		}
	}

	public String getMessage() { 
		return msg;
	}
}
