package Constant;

import java.time.LocalDate;

public class Constants {
    public static final int MAX_LENGTH_NAME = 100;

    public static final int MIN_YEAR= 1900;
    public static final int MAX_YEAR= LocalDate.now().getYear();

    public static final int MAX_LENGTH_ADDRESS= 300;

    public static final float  MIN_HEIGHT= 50f;
    public static final float  MAX_HEIGHT= 300f;

    public static final float  MIN_WEIGHT = 5f;
    public static final float  MAX_WEIGHT=1000f;

    public static final float  GPA_WEAK=3.0f;
    public static final float  GPA_AVERAGE=5.0f;
    public static final float  GPA_GOOD=6.5f;
    public static final float  GPA_VERY_GOOD=7.5f;
    public static final float  GPA_EXCELLENT=9.0f;

    public static final int MAX_LENGTH_STUDENTID=10;

    public static final int MAX_LENGTH_SCHOOL=200;

    public static final float MIN_GPA=0f;
    public static final float MAX_GPA=10.0f;

    public static final String FILE_URL="studentManager.txt";

}
