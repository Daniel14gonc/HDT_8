/*
 *  Nombre: Daniel Gonzalez Carrillo
 *  Clase: Paciente
 *  Modificacion: 21.04.2021
 *  Descripcion: Clase que permite definir un paciente para utilizarlo en la cola de un hospital.
 *
 */

public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String sintoma;
    private String codigo;

    public Paciente(){
        this(null, null, null);
    }

    public Paciente(String nombre, String sintoma, String codigo){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Paciente paciente) {
        //Post: Compara por codigo de paciente.
        return codigo.compareTo(paciente.getCodigo());
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigo;
    }
}
