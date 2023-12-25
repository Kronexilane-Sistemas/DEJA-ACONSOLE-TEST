package db.entities;

import org.kronexilane.AConsole.datatable.Listable;
import org.kronexilane.AConsole.datatable.ListableField;
import org.kronexilane.DEJA.Annotations.DEJAEntity;
import org.kronexilane.DEJA.Annotations.DEJAPrimaryKey;

import java.util.LinkedHashMap;

@DEJAEntity(name="agenda")
public class AgendaEntity implements Cloneable, Listable {
    @DEJAPrimaryKey(autonumeric = true)
    private Integer idagenda;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Telefono;

    public Integer getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(Integer idagenda) {
        this.idagenda = idagenda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public AgendaEntity clone() {
        try {
            return (AgendaEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "AgendaEntity{" +
                "idagenda=" + idagenda +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", Telefono='" + Telefono + '\'' +
                '}';
    }

    @Override
    public LinkedHashMap<String, Object> getData() {
        ListableField[] campos={
                new ListableField("idagenda",this.idagenda),
                new ListableField("Nombre",this.Nombre),
                new ListableField("Apellido1",this.Apellido1),
                new ListableField("Apellido2",this.Apellido2),
                new ListableField("Telefono",this.Telefono),
        };
        return Listable.AddElements(campos);
    }
}
