package Negocio;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private String nombre;
    private int deportes;
    private int musica;
    private int espectaculos;
    private int ciencia;
    private static final long serialVersionUID = 1L;

    public Persona (String nombre, int deportes, int musica, int espectaculos, int ciencia) {
    		this.setNombre(nombre);
    		this.setDeportes(deportes);
    		this.setMusica(musica);
    		this.setEspectaculos(espectaculos);
    		this.setCiencia(ciencia);
    }

    @Override
    public boolean equals(Object obj) {
    	if(this.getClass() != obj.getClass()) return false;
    	Persona otro = (Persona) obj;
    	
    	if		(this.getNombre() 		!= otro.getNombre()) 	   return false;
    	else if (this.getCiencia() 		!= otro.getCiencia())      return false;
    	else if (this.getDeportes() 	!= otro.getDeportes())     return false;
    	else if (this.getEspectaculos() != otro.getEspectaculos()) return false;
    	else if (this.getMusica() 		!= otro.getMusica()) 	   return false;
    	else return true;    	
    }
    
    public String toString () {
        return "Nombre: " + getNombre() +
               " [Deporte: " + getDeportes()  +
               " Musica: " + getMusica() +
               " Espectaculo: " + getEspectaculos() +
               " Ciencia: " + getCiencia() 	 + "] \n";
    }
    
    ////////////////////////////////////////////////////////////GETTERS & SETTERS
    //agregar invariante de representacion
    public String getNombre() {return nombre;}
    public void setNombre(String name) {this.nombre=name;}
    public int getDeportes() {return deportes;}
    public void setDeportes(int deporte) {this.deportes=deporte;}
    public int getMusica() {return musica;}
    public void setMusica(int musica) {this.musica=musica;}
    public int getEspectaculos() {return espectaculos;}
    public void setEspectaculos(int espectaculos) {this.espectaculos=espectaculos;}
    public int getCiencia() {return ciencia;}
    public void setCiencia(int ciencia) {this.ciencia=ciencia;}
}