package com.stepik.javabasecourse;

public class Roles
{
    public static void main(String[] args)
    {
        String [] roles = {
            "Городничий","Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"
        };

        String [] textLines = {
        "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам " +
            "пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. " +
            "И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
        "Артемий Филиппович: Вот не было заботы, так подай!",
        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        Roles r = new Roles();
        System.out.println(r.printTextPerRole(roles, textLines));
    }

    private String printTextPerRole(String[] roles, String[] textLines)
    {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < roles.length; j++) {
            sb.append(roles[j]).append(":\n");
            for (int k = 0; k < textLines.length; k++) {
                if (textLines[k].startsWith(roles[j] + ":")) {
                    sb.append(k+1).append(") ");
                    sb.append(textLines[k].substring(roles[j].length() + 2));
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
