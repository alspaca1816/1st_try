package modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Admin extends Usuario{
    private LocalDate fechaN;
    private char sexo; // F para mujeres y M para hombres
    private int salario;

    public Admin(LocalDate fechaN, char sexo, int salario, String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.fechaN = fechaN;
        setSexo(sexo);
        this.salario = salario;
    }

    public LocalDate getFechaN() {
        return fechaN;
    }

    public void setFechaN(LocalDate fechaN) {
        this.fechaN = fechaN;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Ha ocurrido un error al agregar un nuevo administrador, intente nuevamente");
        }
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public String Edad() {
        Period primero = Period.between(getFechaN(), LocalDate.now());
        int edad = primero.getYears();
        return ""+edad;
    }
}