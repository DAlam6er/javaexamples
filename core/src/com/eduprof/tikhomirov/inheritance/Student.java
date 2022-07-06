package com.eduprof.tikhomirov.inheritance;

public class Student
{
    private String firstName;
    private String lastName;
    private String group;
    private double averageMark;

    public Student() {}

    public Student(String firstName, String lastName,
                   String group, double averageMark)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public double getAverageMark()
    {
        return averageMark;
    }

    public void setAverageMark(double averageMark)
    {
        this.averageMark = averageMark;
    }

    public double getScholarship()
    {
        try {
            if (averageMark == .0) {
                throw new Exception("Average mark for student " +
                    "can not be 0.0!");
            } else {
                return (averageMark == 5.0) ? 100. : 80.;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return .0;
        }
    }
}
