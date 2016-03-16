package mv.command;

public class CommandParser {
	private static Command[] comandos = { new Step(), new Steps(0), new Run(),
			new Quit(), new PushCommando(0), new PopCommando(), new Write(0, 0) };

	public static Command parseComando(String line) {
		for (Command co : comandos) {
			Command comando = co.parseCo(line);
			if (comando != null) {
				return comando;
			}
		}
		return null;
	}
}
