package com.headfirstjava.Annex;

public class EnumTest
{
    enum Names
    {
        // "соло-гитара" - аргумент, передаваемый в конструктор перечисления
        JERRY("соло-гитара")
        { // начало тела класса, специфичное для каждой константы
            @Override
            public String sings()
            {
                return "грустно";
            }
        }
        ,
        BOBBY("ритм-гитара")
        {
            @Override
            public String sings()
            {
                return "грубо";
            }
        }
        ,
        PHIL("бас-гитара");

        // Экземпляр перечисления (поле)
        private final String instrument;

        // Конструктор перечисления.
        // Запускается 1 раз для каждого объявленного значения
        // (в данном случае запускается 3 раза)
        Names(String instrument)
        {
            this.instrument = instrument;
        }

        // геттер перечисления
        public String getInstrument()
        {
            return this.instrument;
        }
        
        // общий метод перечисления
        public String sings()
        {
            return "редко";
        }
    }

    public static void main(String[] args)
    {
        // Каждое перечисление содержит встроенный метод values(),
        // который обычно используется в цикле for
        for (Names value : Names.values()) {
            System.out.printf("%s, инструмент: %s, звучит: %s\n",
                value, value.getInstrument(), value.sings());
        }
    }
}
