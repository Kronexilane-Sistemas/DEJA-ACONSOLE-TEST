import cline.agenda;
import cline.ayuda;
import org.kronexilane.AConsole.commandline.CLineInterpreter;

public class Main {
    public static void main(String[] args) {
        CLineInterpreter.Add("default",new agenda());
        CLineInterpreter.Add("help",new ayuda());
        CLineInterpreter.Interpreter(args,"-");
    }
}