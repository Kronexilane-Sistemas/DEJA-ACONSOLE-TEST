package cline;




import org.kronexilane.AConsole.commandline.CLineAction;

import java.util.List;

public class ayuda extends CLineAction {

    @Override
    public void DoIt(String param,List<String> list) {

        String multiline=
            """
                \nDEJA-ACONSOLE TEST Versión 1.00
                Programa de prueba de la libreria DEJA y ACONSOLE
                (Conecta con una base de datos de prueba en www.kronexilane.org)
                \n
                Parámetros:
                    -help:            Muestra este texto de ayuda.
                    (sin parámetros): Muestra el menú de la agenda remota.
            """;
        System.out.println(multiline);
        super.Done();
    }

}
