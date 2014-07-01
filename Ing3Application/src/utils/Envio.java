package utils;

public class Envio implements Runnable {

	    private GMailSender sender;
	    private String asunto;
	    private String mensaje;
	    private String to;
	    
	    
	    
	    
	 	public Envio(GMailSender sender, String asunto, String mensaje,
				String to) {
			super();
			this.sender = sender;
			this.asunto = asunto;
			this.mensaje = mensaje;
			this.to = to;
		}

		@Override
	    public void run() {
	        try {
	        	sender.sendMail(asunto,   
	                     mensaje,   
	                     "ingenieria3.2014@gmail.com",   
	                     to);   
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

}
