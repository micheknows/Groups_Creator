import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Students {
    private static ArrayList<Student> studentObjs = new ArrayList<Student>();

    public ArrayList<String> loadStudents(){
        try{
            ArrayList<String> s = new ArrayList<String>();
            File myObj = new File("students.txt");
            Scanner myReader = new Scanner(myObj);
            studentObjs = new ArrayList<Student>();
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                s.add(data);
                this.studentObjs.add(new Student(data));
            }
            myReader.close();
            return s;
        } catch (FileNotFoundException e){
            return  new ArrayList<String>();
        }
    }

    public void setPresentByWholeName(String wname, boolean isPresent){
        for(Student s: studentObjs){
            if((s.getFirstName() + " " + s.getLastName()).equals(wname)){
                s.isPresent = isPresent;
            }
        }
    }

    private ArrayList<String> getnames() {
        ArrayList<String> s = new ArrayList<String>();
        if (this.studentObjs.size()>0) {
            for (Student student : this.studentObjs) {
                s.add(student.getFirstName() + " " + student.getLastName());
            }
        }
        return s;

    }


    public ArrayList<String> getnames(ArrayList<Student> students) {
        ArrayList<String> s = new ArrayList<String>();
        if (students.size()>0) {
            for (Student student : students) {
                s.add(student.getFirstName() + " " + student.getLastName());
            }
        }
        return s;

    }

    public void saveStudents(){
        try{
            ArrayList<String> tempStudents = this.getnames();
            FileWriter myWriter = new FileWriter("students.txt");
            for (String s : tempStudents){
                myWriter.write(s);
                myWriter.close();
            }
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getPresent(){
        ArrayList<Student> present = new ArrayList<Student>();
        for(Student s : this.studentObjs){
            if(s.isPresent){
                present.add(s);
            }
        }
        return present;
    }

    public void setALl(boolean isPresent){
        for(Student s : this.studentObjs){
            if(isPresent){
                s.isPresent = true;
            } else {
                s.isPresent = false;
            }
        }
    }

    private void setAllAvailable(){
        for(Student s : this.studentObjs){
            s.called = false;
        }
    }

    public ArrayList<Student> getAbsent(){
        ArrayList<Student> absent = new ArrayList<Student>();
        for(Student s : this.studentObjs){
            if(!s.isPresent) {
                absent.add(s);
            }
        }
        return absent;
    }

    public int getNumAbsent(){
        ArrayList<Student> ab = getAbsent();
        return ab.size();
    }

    public int getNumPresent(){
        ArrayList<Student> pre = getPresent();
        return pre.size();
    }

    public String getNextPopsicle(){
        ArrayList<Student> available = new ArrayList<Student>();
        while((available.size()<1) && (this.getPresent().size()>0)){
            for(Student s : this.studentObjs) {
                if (s.isPresent == true) {
                    if (s.called == false) {
                        available.add(s);
                    }
                }
            }
            if(available.size()<1){
                this.setAllAvailable();
            }
        }
        if(available.size()>0){
            Random rand = new Random();
            int index = rand.nextInt(available.size());
            available.get(index).setCalled(true);
            return available.get(index).getWholeName();
        } else {
            return "No students available";
        }
    }
}
