package mv.main;

import org.apache.commons.cli.*;

public class MyOptions {
	private final String afileName = "a";
	private final String afileNameLong = "asm";
	private final String inFileName = "i";
	private final String inFileNameLong = "in";
	private final String outFileName = "o";
	private final String outFileNameLong = "out";
	private final String hName = "h";
	private final String hNameLong = "help";
	private final String mode = "m";
	private final String modeLong = "mode";
	private final static String progName = "[-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]";

	private static String a;
	private static String i;
	private static String o;
	private static Boolean h = false;
	private static int m;

	CommandLine cmd;
	static Options options;

	MyOptions(String[] args) throws ParseException {
		options = new Options();
		options.addOption(
				afileName,
				afileNameLong,
				true,
				"Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch");
		options.addOption(hName, hNameLong, false, "Muestra la ayuda");
		options.addOption(inFileName, inFileNameLong, true,
				"Entrada del programa de la maquina-p");
		options.addOption(mode, modeLong, true,
				"Modo de funcionamiento (batch|interactive|window). Por defecto interactive");
		options.addOption(outFileName, outFileNameLong, true,
				"Fichero donde se guarda la salida del programa de la maquina-p");
		CommandLineParser parser = new GnuParser();
		cmd = parser.parse(options, args);

		extractValues();
		validate();
	}

	private void extractValues() {
		if (cmd.hasOption(afileName)) {
			a = cmd.getOptionValue(afileName);
		}
		if (cmd.hasOption(inFileName)) {
			i = cmd.getOptionValue(inFileName);
		}
		if (cmd.hasOption(outFileName)) {
			o = cmd.getOptionValue(outFileName);
		}
		if (cmd.hasOption(hName)) {
			h = true;
		}
		if (cmd.hasOption(mode)) {
			if (cmd.getOptionValue(mode).equalsIgnoreCase("batch"))
				m = 0;
			if (cmd.getOptionValue(mode).equalsIgnoreCase("interactive"))
				m = 1;
			if (cmd.getOptionValue(mode).equalsIgnoreCase("window"))
				m = 2;
		}
	}

	private void validate() throws ParseException {
		if (!h) {
			if (a == null && /* m.equalsIgnoreCase("batch") */(m == 0 || m == 2)) {
				throw new ParseException(
						"Uso incorrecto: Fichero ASM no especificado.\nUse -h | --help para m‡s detalles.");
			}

		}
	}

	public static void usage() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(progName, options);
	}

	public static String getA() {
		return a;
	}

	public static String getI() {
		return i;
	}

	public static String getO() {
		return o;
	}

	public static Boolean getH() {
		return h;
	}

	public static int getM() {
		return m;
	}
}
