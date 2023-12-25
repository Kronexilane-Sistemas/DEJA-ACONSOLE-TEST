package cline;

import menu.optDelete;
import menu.optFilter;
import menu.optList;
import menu.optNew;
import org.kronexilane.AConsole.Output;
import org.kronexilane.AConsole.commandline.CLineAction;
import org.kronexilane.AConsole.optionList.OptionList;
import org.kronexilane.AConsole.optionList.OptionListItemEnd;

import java.util.List;

public class agenda extends CLineAction {
    @Override
    public void DoIt(String param,List<String> list) {
        try{
            super.Done();
            String mensaje= """
                Este programa comunica con una base de datos de test situada en\s
                http://www.kronexilane.org límitada a una tabla y pocos permisos\s
                """;
            Output.msgBox(mensaje);
            // Crea el menú de opciones
            OptionList MenuPrincipal= new OptionList("AGENDA DE NOMBRES");
            MenuPrincipal.add(new OptionListItemEnd("0","Salir del programa",true));
            MenuPrincipal.add(new optNew("1","Crear nueva entrada"));
            MenuPrincipal.add(new optDelete("2","Suprimir entrada"));
            MenuPrincipal.add(new optFilter("3","Buscar por contenido en nombre o apellidos"));
            MenuPrincipal.add(new optList("4","Listar Agenda"));
            MenuPrincipal.show();

        }catch(Exception e) {
            Output.msgBox(e.getMessage());
        }
        super.Done();
    }
}
