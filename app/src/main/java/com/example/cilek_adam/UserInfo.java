package com.example.cilek_adam;

public class UserInfo {
    public static String name,sex,bmiRateValue;
    public static int years,weight,height, calorie_taken = 0, calorie_burn = 0;
    public static double bmi;

    UserInfo(String n, String s, int y,int w, int h){
        name = n;
        sex = s;
        years = y;
        weight = w;
        height = h;
        bmi = bmiCalculate(h,w);
        bmiRateValue = bmiRate(bmi);
    }
    UserInfo(){}
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public int getYears(){
        return years;
    }
    public String getYearsString(){
        return String.valueOf(years);
    }
    public int getWeight(){
        return weight;
    }
    public String getWeightString(){
        return String.valueOf(weight);
    }
    public int getHeight(){
        return height;
    }
    public String getHeightString(){
        return String.valueOf(height);
    }

    public void addCalorieTaken(int cal) {
        calorie_taken += cal;
    }

    public void addCalorieBurn(int cal) {
        calorie_burn += cal;
    }

    public int getCalorie_taken(){
        return calorie_taken;
    }

    public int getCalorie_burn(){
        return calorie_burn;
    }
    public double getBMI(){return bmi;}
    public String getBmiRate(){return bmiRateValue;}
    public String getBmiRateTR(){
        if(bmi<=18){
            return "Az Kilolu";
        }else if (bmi<=25){
            return "Normal Kilolu";
        } else if(bmi<=35){
            return "Çok Kilolu";
        } else{
            return "bez";
        }
    }
    public String getBMIString(){return String.format("%.0f",bmi);}
    public double bmiCalculate(int h,int w){
        double bm;
        double he = (double) h/100.0;
        bm = ((double) w/(he*he));
        return bm;
    }
    public String bmiRate(double bm){
        if(bm<=18){
            return "Underweight";
        }else if (bm<=25){
            return "Normal Weight";
        } else if(bm<=35){
            return "Overweight";
        } else{
            return "Obesity";
        }
    }
}
