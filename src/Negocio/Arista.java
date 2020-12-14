package Negocio;

public class Arista {
	private Persona persona1;
    private Persona persona2;
    private Integer peso;

    public Arista (Persona p1, Persona p2){
        this.persona1 = p1;
        this.persona2 = p2;
        this.peso = calcularParecido();
    }
    
    public Integer calcularParecido () {
        int ret;
        ret = 	Math.abs(getPersona1().getDeportes()	 - getPersona2().getDeportes())		+
                Math.abs(getPersona1().getMusica() 	 	 - getPersona2().getMusica()) 		+
                Math.abs(getPersona1().getEspectaculos() - getPersona2().getEspectaculos()) +
                Math.abs(getPersona1().getCiencia() 	 - getPersona2().getCiencia()) 		;
        return ret;
    }
    
    public boolean personaEsta(Persona p) {
    	if(p.equals(this.getPersona1()) || p.equals(this.getPersona2())) return true;
    	return false;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this.getClass() != obj.getClass()) return false;
    	Arista otro = (Arista) obj;
    	
    	if		((this.getPersona1().equals(otro.getPersona1()) && this.getPersona2().equals(otro.getPersona2())) ||
    			 (this.getPersona2().equals(otro.getPersona1()) && this.getPersona1().equals(otro.getPersona2())))
    					return true;
    	else return false;    	
    }
    
    public String toString () {

        return "{Arista Entre: " + getPersona1().getNombre() +
                " y " + getPersona2().getNombre() +
                " = Peso: " + getPeso() + "} \n";
    }
    
    ////////////////////////////////////////////////////////////GETTERS & SETTERS
    
    public Persona getPersona1() {return persona1;}
    public Persona getPersona2() {return persona2;}

    public Integer getPeso() {return peso;} 

}
