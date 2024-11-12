package Modelos;

public class Excepcion extends Exception {
    /*nombre de la colección, clave y la diferencia entre Z y la cantidad real.*/
    String nombreColeccion;
    String clave;
    Integer diferencia;

    public Excepcion(String nombreColeccion, String clave, Integer diferencia) {
        super("Hay una diferencia de "+ diferencia +" con la cantidad real");
        this.nombreColeccion = nombreColeccion;
        this.clave = clave;
        this.diferencia = diferencia;
    }

    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public Integer getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Integer diferencia) {
        this.diferencia = diferencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
