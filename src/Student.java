public class Student extends Person{

    boolean isPresent;

    public Student(){
        setPresent(true);
    }

    public Student(String wholename) {
        setPresent(true);
        String[] namelist = wholename.trim().split("\\s+");
        this.setFirstName(namelist[0]);
        this.setLastName(namelist[1]);
    }

    public Student(boolean present){
        setPresent(present);
    }

    public boolean getPresent(){
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
