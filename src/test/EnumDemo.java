package test;

public class EnumDemo {
    public static void main(String[] args) {
        String report = "MNGRPT";
        if (report.equals(Report.EMPORT.getName()))
            System.out.println("Id: " + Report.EMPORT.getId() + " Name: " + Report.EMPORT.getName());
        if (report.equals(Report.EMPORT))
            System.out.println("Id: " + Report.EMPORT.getId() + " Name: " + Report.EMPORT.getName());
        if (report.equals(Report.MNGRPT.toString()))
            System.out.println("Id: " + Report.EMPORT.getId() + " Name: " + Report.EMPORT.getName());
        if (report.equals(Report.MNGRPT.name))
            System.out.println("Id: " + Report.EMPORT.getId() + " Name: " + Report.EMPORT.getName());
    }

    public enum Report {
        EMPORT(1, "EMPORT_REPORT"), MNGRPT(2, "MANAGER_REPORT");
        private String name;
        private int id;
        Report(int id, String name) {
            this.setName(name);
            this.id = id;
        }
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public int getId() {return this.id;}
    }
}
