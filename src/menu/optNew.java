package menu;

import db.entities.AgendaEntity;
import db.dao.AgendaDAO;
import org.kronexilane.AConsole.Input;
import org.kronexilane.AConsole.Output;
import org.kronexilane.AConsole.optionList.AbstractOptionListItem;
import org.kronexilane.DEJA.DAO.DAOException;
import verificators.StringVerificator;

/**
 * Crea una nueva entrada en la agenda
 */
public class optNew extends AbstractOptionListItem{
    public optNew(String Index, String Title) {
        super(Index, Title);
    }

    @Override
    protected void Action() {
        String nombre;
        String apellido1;
        String apellido2;
        String telefono;
        AgendaEntity entrada=new AgendaEntity();
        AgendaDAO ag=new AgendaDAO();
        Output.msgBox("Crear nueva entrada de AGENDA");
        // Pide los datos
        nombre= (String) Input.fromConsole("Nombre:",new StringVerificator(),true,true);
        apellido1=(String) Input.fromConsole("Apellido 1:",new StringVerificator(),true,true);
        apellido2=(String) Input.fromConsole("Apellido 2:",new StringVerificator(),true,true);
        telefono=(String) Input.fromConsole("Teléfono:",new StringVerificator(),true,true);
        // Establece entrada
        entrada.setNombre(nombre);
        entrada.setApellido1(apellido1);
        entrada.setApellido2(apellido2);
        entrada.setTelefono(telefono);

        Output.msgBox("¡Nueva entrada Creada!");
        // Salva la entrada
        try {
            ag.Save(entrada);
        } catch (DAOException e) {
            Output.msgBox(e.getMessage());
        }
    }
}
