
public abstract class Command {
    private String nombre;

    private String abreviacion;

    public abstract Command parse(String palabras);

    public abstract boolean ejecutar(Game game);

    public Command(String nombre, String abreviacion) {
    }

}
