package com.specialist.sedykh.homework.lab2_3_4_5;

public class SimpleParser extends ComLineParserBase
{
    private String inFile, outFile;

    public SimpleParser(String[] keys)
    {
        super(keys);
    }

    public SimpleParser(String[] keys, String[] delimiters)
    {
        super(keys, delimiters);
    }

    public SimpleParser()
    {
        super(new String[]{"?", "r", "w"});
    }

    public String getInFile()
    {
        return inFile;
    }

    public String getOutFile()
    {
        return outFile;
    }

    @Override
    protected void onUsage(String errorKey)
    {
        if (errorKey != null) {
            System.out.println("Command-line switch error: " + errorKey);
        }
        System.out.println(
            "Command line format: programName[-r<input-fileName>][-w<output-fileName>]"
        );
        System.out.println(" -? show Help file");
        System.out.println(" -r specify name of input file");
        System.out.println(" -w implement output into specified file");
    }

    @Override
    protected switchStatus onSwitch(String key, String keyValue)
    {
        switchStatus status = switchStatus.NO_ERROR;
        switch (key) {
            case "?":
                status = switchStatus.SHOW_USAGE;
                break;
            case "r":
                if (keyValue != null) {
                    inFile = keyValue;
                } else {
                    status = switchStatus.ERROR;
                    System.out.println(
                        "Error! Key value for inFile is not specified!");
                }
                break;
            case "w":
                if (keyValue != null) {
                    outFile = keyValue;
                } else {
                    status = switchStatus.ERROR;
                    System.out.println(
                        "Error! Key value for outFile is not specified!");
                }
                break;
            default:
                status = switchStatus.ERROR;
                System.out.println("Error! Unknown key!");
        }
        return status;
    }

    public static void main(String[] args)
    {
//        SimpleParser parser = new SimpleParser(new String[]{"?", "w", "r"});
        SimpleParser parser = new SimpleParser();
        parser.parse(args);
        System.out.println("Input file name: " + parser.getInFile());
        System.out.println("Output file name: " + parser.getOutFile());
    }
}
