package com.eduprof.tikhomirov.inheritance;

public class Graduate extends Student
{
    private String study;

    public Graduate(String study)
    {
        super();
        this.study = study;
    }

    public Graduate(String firstName, String lastName,
                    String group, double averageMark, String study)
    {
        super(firstName, lastName, group, averageMark);
        this.study = study;
    }

    public String getStudy()
    {
        return study;
    }

    public void setStudy(String study)
    {
        this.study = study;
    }

    @Override
    public double getScholarship()
    {
        try {
            if (getAverageMark() == .0) {
                throw new Exception(
                    "Average mark for graduate can not be 0.0!");
            } else {
                return (getAverageMark() == 5.0) ? 200. : 180.;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return .0;
        }
    }
}
