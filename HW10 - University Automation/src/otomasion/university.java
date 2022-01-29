package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class university{
    protected Integer year;
    public university(){
        this.year=0;
    }
    public university(int year){
        this.year=year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "university{" +
                "year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        university that = (university) o;
        return Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
}