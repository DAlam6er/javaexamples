package com.specialist.sedykh.parser;

public abstract class ComLineParserBase
{
    private final String[] keys;
    private final String[] delimiters;

    // options of parsing completion
    protected enum switchStatus
    {
        NO_ERROR, ERROR, SHOW_USAGE
    }

    public ComLineParserBase(String[] keys)
    {
        this(keys, new String[]{"/", "-"}); // замыкаем конструктор
    }

    public ComLineParserBase(String[] keys, String[] delimiters)
    {
        this.keys = keys;
        this.delimiters = delimiters;
    }

    protected abstract void onUsage(String errorKey);


    protected switchStatus onSwitch(String key, String keyValue)
    {
//        System.out.println("name of the key: " + key);
//        System.out.println("key value: " + keyValue);
//        return switchStatus.NO_ERROR;
        return switchStatus.ERROR;
    }

    public final boolean parse(String[] args)
    {
        switchStatus ss = switchStatus.NO_ERROR;
        int argNum;
        for (argNum = 0;
             (ss == switchStatus.NO_ERROR) && (argNum < args.length);
             argNum++)
        {
            // check if correct delimiter presents
            boolean isDelimiter = false;
            for (int n = 0; !isDelimiter && (n < delimiters.length); n++)
            {
                isDelimiter =
                    args[argNum].regionMatches(
                        0, delimiters[n], 0, 1);
            }

            if (isDelimiter) {
                // check if correct key presents
                boolean isKey = false;
                int i;
                for (i = 0; !isKey && (i < keys.length); i++) {
                    isKey =
                        args[argNum].regionMatches(
                            true, 1,
                            keys[i], 0, keys[i].length());
                    if (isKey) break;
                }
                if(!isKey) {
                    ss = switchStatus.ERROR; // wrong key
                    break;
                } else {
                    ss =
                        onSwitch(
                            keys[i].toLowerCase(),
                            args[argNum].substring(1 + keys[i].length())
                        );
                }
            } else {
                ss = switchStatus.ERROR; // wrong delimiter
                break;
            }
        }
        if (ss == switchStatus.SHOW_USAGE) {
            onUsage(null);
        }
        if (ss == switchStatus.ERROR) {
            onUsage((argNum == args.length)? null : args[argNum]);
        }
        return ss == switchStatus.NO_ERROR;
    }

//    public static void main(String[] args)
//    {
//        ComLineParserBase parser = new ComLineParserBase(new String[]{"?", "r", "w"});
//        parser.parse(args);
//    }
}


