package menu;

import db.entities.AgendaEntity;
import db.dao.AgendaDAO;
import org.kronexilane.AConsole.Input;
import org.kronexilane.AConsole.Output;
import org.kronexilane.AConsole.optionList.AbstractOptionListItem;
import org.kronexilane.AConsole.verificators.IntVF;
import org.kronexilane.DEJA.DAO.DAOException;
import verificators.StringVerificator;

import java.util.Optional;

/**
 * Crea una nueva entrada en la agenda
 */
public class optDelete extends AbstractOptionListItem{
    public optDelete(String Index, String Title) {
        super(Index, Title);
    }

    @Override
    protected void Action() {
        int id;
        AgendaEntity entrada=new AgendaEntity();
        AgendaDAO ag=new AgendaDAO();
        Output.msgBox("Borrar entrada de agenda por CLAVE");
        try {
            if(!ag.isEmpty()) {
                // Pide los datos
                optList listado = new optList("", "");
                listado.Action();
                id = Integer.parseInt(Input.fromConsole("IDENTIFICADOR de ENTRADA:", new IntVF("Debe introducir un número entero."), true, true).toString());
                entrada.setIdagenda(id);
                try {
                    boolean x = ag.isEmpty();
                    if (ag.Delete(entrada) != 0) {
                        Output.msgBox("¡Entrada Borrada!");
                        // Pide los datos
                        optList listado2 = new optList("", "");
                        listado2.Action();

                    } else {
                        Output.msgBox("No se encuentra la entrada de id=" + id);
                    }

                } catch (DAOException e) {
                    Output.msgBox(e.getMessage());
                }
            }else{
                System.out.println("¡Agenda vacía!");
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
