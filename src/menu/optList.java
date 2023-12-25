package menu;

import db.entities.AgendaEntity;
import db.dao.AgendaDAO;
import org.kronexilane.AConsole.Input;
import org.kronexilane.AConsole.Output;
import org.kronexilane.AConsole.datatable.FormattedList;
import org.kronexilane.AConsole.datatable.dtColumnAlignment;
import org.kronexilane.AConsole.datatable.dtColumnFormat;
import org.kronexilane.AConsole.optionList.AbstractOptionListItem;
import org.kronexilane.DEJA.DAO.DAOException;
import verificators.StringVerificator;

import java.util.Arrays;
import java.util.List;

/**
 * Crea una nueva entrada en la agenda
 */
public class optList extends AbstractOptionListItem{
    public optList(String Index, String Title) {
        super(Index, Title);
    }

    @Override
    protected void Action() {
        AgendaDAO ag=new AgendaDAO();
        try {
            List<AgendaEntity> listado= ag.LoadList();
            if(!listado.isEmpty()) {
                FormattedList<AgendaEntity> lf = new FormattedList<AgendaEntity>();
                lf.addHeader(new dtColumnFormat[]{
                        new dtColumnFormat("idagenda", "Identificador", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Nombre", "Nombre", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Apellido1", "Primer apellido", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Apellido2", "Segundo apellido", dtColumnAlignment.Right, dtColumnAlignment.Right, 4),
                        new dtColumnFormat("Telefono", "Teléfono", dtColumnAlignment.Right, dtColumnAlignment.Right),
                });
                lf.addSummary("Nombre", "Total entradas en la agenda", o -> o.length);
                lf.addSummary("Telefono","Telefonos que contiene 0123",o-> Arrays.stream(o).filter(e->e.toString().contains("0123")).count());
                lf.addAll(listado);
                lf.setPageSize(15L);
                lf.toConsole("Listado de entradas de agenda");
            }else{
                Output.msgBox("¡Agenda vacía!");
            }
        } catch (DAOException e) {
            Output.msgBox(e.getMessage());
        }
    }
}
