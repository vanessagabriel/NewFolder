package bastanteo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdmBastantear {

	//1ero. defino mi lista de un tipo dado
		List<Bastanteo> MyarrBastanteo;
				
	//2do. En el constructor inicializo
	public AdmBastantear(){
 		MyarrBastanteo = new ArrayList<Bastanteo>();
 	
		}		
		
	
	public void registrarBastanteo(String codCli,     String idGrupoBast,
			                       String tipoInterv, String codPoder, 
			                       String otrGpoBast, String moneda,
			                       Double importe,    String codUser,
			                       Calendar fecReg,   Calendar fecVenc) 
			                       throws PeruBankException {
		
		 //validar datos en blanco	
	     validarDatos(codCli,idGrupoBast, tipoInterv, codPoder, moneda, 
	                  importe);
	     
	     
	   //validar que no exista el mismo poder para el
	   //mismo grupo de bastanteo, tipo de intervencion 
	   //y combinacion grupo bastanteo  
  	     ValidarGrupoBastanteo(codCli, idGrupoBast, codPoder, tipoInterv,otrGpoBast);
         	     
		     
		//Creamos un registro bastanteo
		Bastanteo newbastanteo = new Bastanteo(codCli, idGrupoBast, 
				  tipoInterv, codPoder, otrGpoBast, moneda, importe, codUser, 
				  fecReg, fecVenc);
				
		//a�aden a la lista
		MyarrBastanteo.add(newbastanteo);
			
	}


	private void ValidarGrupoBastanteo(String codCli, String idGrupoBast,
			String codPoder, String tipoInterv, String otrGpoBast)throws PeruBankException {	 {
		
		if(BastanteoExiste(codCli, codPoder, idGrupoBast, tipoInterv,otrGpoBast )) 
        	throw new PeruBankException("Error, Existe coincidencias en el registro");
				
	}
	
	}


	private boolean BastanteoExiste(String codCli, String codPoder,
			String idGrupoBast, String tipoInterv, String otrGpoBast) {
		
           boolean existe = false;
	    
	    //   and &&   , || or
        for(Bastanteo Bastanteo : MyarrBastanteo)
            if (Bastanteo.getCodCli().equals(codCli)          && //Cliente
                Bastanteo.getCodPoder().equals(codPoder)      && //Poderes
                Bastanteo.getIdGrupoBast().equals(idGrupoBast)&& //Gpo Bastanteo	
                Bastanteo.getTipoInterv().equals(tipoInterv)  && //Tipo Intervencion
                Bastanteo.getOtrGpoBast().equals(otrGpoBast))	 //Otro GpoBastanteo  
                existe = true;
		
        return existe;
				
	}

	private void validarDatos(String codCli, String idGrupoBast,
			String tipoInterv, String codPoder, String moneda, Double importe)
					throws PeruBankException{
			 		
		String mensaje = "";
	    if (codCli.equals(""))
	        mensaje += "Codigo cliente no puede ser vacio";
	    if (idGrupoBast.equals(""))
	        mensaje += "\nGrupoBastanteo no puede ser vacio";
	    if (tipoInterv.equals(""))
	    	mensaje += "\nTipo intervencion no puede ser vacio";
	    if (codPoder.equals(""))
	        mensaje += "\nCodigo Poder no puede ser vacio";
	    if (moneda.equals(""))
	        mensaje += "\nTipo de moneda no puede ser vacio";
	    if (importe.equals(0))
	        mensaje += "\nImporte no puede ser cero";
	    	    
	    if (! mensaje.equals(""))
	        throw  new PeruBankException(mensaje);
				
	}


	public Bastanteo buscarBastanteo(String codCli) {
		
		return null;
	}


	public List<Bastanteo> buscalistabastanteo(String codCli) {
		
		return null;
	}


	public Bastanteo buscarCliente(String CodCli, 
			                       String IdGrupoBast, 
			                       String TipoInterv,	
			                       String CodPoder) {
		
		
		for(Bastanteo Bastanteo : MyarrBastanteo)
            if (Bastanteo.getCodCli().equals(CodCli)          && //Cliente
                Bastanteo.getCodPoder().equals(IdGrupoBast)   && //Poderes
                Bastanteo.getIdGrupoBast().equals(TipoInterv) && //Gpo Bastanteo	
                Bastanteo.getTipoInterv().equals(CodPoder))      //Codigo Poder
               
                return Bastanteo;
		
        return null;
				
	}

}
