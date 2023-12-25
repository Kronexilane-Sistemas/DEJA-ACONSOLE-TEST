package verificators;

import org.kronexilane.AConsole.verificators.Verificator;

public class StringVerificator implements Verificator {
    @Override
    public boolean IsValid(String s) {
        return !s.equalsIgnoreCase("");
    }

    @Override
    public String getInvalidMsg() {
        return "Debe introducir un valor.";
    }

    @Override
    public String getJavaTypeName() {
        return "String";
    }
}
