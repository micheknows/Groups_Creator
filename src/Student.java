public class Student extends Person{

    boolean isPresent;
    boolean called;

    public Student(){
        setPresent(true);
        setCalled(false);
    }

    public Student(String wholename) {
        setPresent(true);
        setCalled(false);
        String[] namelist = wholename.trim().split("\\s+");
        this.setFirstName(namelist[0]);
        this.setLastName(namelist[1]);
    }

    public String getWholeName(){
        return this.firstName + " " + this.lastName;
    }

    public Student(boolean present){
        setPresent(present);
    }

    public boolean getPresent(){
        return isPresent;
    }
    public boolean getCalled() { return this.called;}

    public void setPresent(boolean present) {
        isPresent = present;
    }
    public void setCalled(boolean called) {this.called = called;}
}
