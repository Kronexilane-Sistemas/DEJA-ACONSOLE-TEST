package menu;

import db.dao.AgendaDAO;
import db.entities.AgendaEntity;
import org.kronexilane.AConsole.Input;
import org.kronexilane.AConsole.Output;
import org.kronexilane.AConsole.datatable.FormattedList;
import org.kronexilane.AConsole.datatable.dtColumnAlignment;
import org.kronexilane.AConsole.datatable.dtColumnFormat;
import org.kronexilane.AConsole.optionList.AbstractOptionListItem;
import org.kronexilane.DEJA.DAO.DAOException;
import verificators.StringVerificator;

import java.util.List;

/**
 * Crea una nueva entrada en la agenda
 */
public class optFilter extends AbstractOptionListItem{
    public optFilter(String Index, String Title) {
        super(Index, Title);
    }

    @Override
    protected void Action() {
        AgendaDAO ag=new AgendaDAO();
        try {
            String filtro=(String) Input.fromConsole("Filtrar por Nombres o apellidos que contengan:", new StringVerificator(),false,false);
            List<AgendaEntity> listado = null;
            if(!filtro.equalsIgnoreCase("")){
                String SQL="Select idagenda,Nombre,apellido1,apellido2,telefono from agenda where Nombre like '%"+filtro+"%' or apellido1 like '%"+filtro+"%' or apellido2 like '%"+filtro+"%'";
                listado= ag.LoadByQuery(SQL);
            }
            if(listado!=null && !listado.isEmpty()) {
                FormattedList<AgendaEntity> lf = new FormattedList<AgendaEntity>();
                lf.addHeader(new dtColumnFormat[]{
                        new dtColumnFormat("idagenda", "Identificador", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Nombre", "Nombre", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Apellido1", "Primer apellido", dtColumnAlignment.Right, dtColumnAlignment.Right),
                        new dtColumnFormat("Apellido2", "Segundo apellido", dtColumnAlignment.Right, dtColumnAlignment.Right, 4),
                        new dtColumnFormat("Telefono", "Teléfono", dtColumnAlignment.Right, dtColumnAlignment.Right),
                });
                lf.addSummary("Nombre", "Total entradas en la agenda", o -> o.length);
                lf.addAll(listado);
                lf.setPageSize(15L);
                lf.toConsole("Listado de entradas de agenda");
            }else{
                Output.msgBox("¡No hay entradas con el criterio seleccionado!");
            }
        } catch (DAOException e) {
            Output.msgBox(e.getMessage());
        }
    }
}
