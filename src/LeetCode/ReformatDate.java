package LeetCode;
import java.util.HashMap;

public class ReformatDate {
    private HashMap<String, String> monthMap = new HashMap<>();
    public ReformatDate(){
        this.monthMap.put("Jan", "01");
        this.monthMap.put("Feb", "02");
        this.monthMap.put("Mar", "03");
        this.monthMap.put("Apr", "04");
        this.monthMap.put("May", "05");
        this.monthMap.put("Jun", "06");
        this.monthMap.put("Jul", "07");
        this.monthMap.put("Aug", "08");
        this.monthMap.put("Sep", "09");
        this.monthMap.put("Oct", "10");
        this.monthMap.put("Nov", "11");
        this.monthMap.put("Dec", "12");
    }

    public String reformatDate(String date) {
        // transforms date from DD-MM-YYYY to YYYY-MM-DD - assuming valid input
        StringBuilder reformatDateStr = new StringBuilder();
        String [] strArr = date.split(" ");
        reformatDateStr.append(strArr[2] + "-");
        reformatDateStr.append(this.monthMap.get(strArr[1]) + "-");

        StringBuilder dayStr = new StringBuilder(strArr[0]);
        //removing ordinal indicators: 'st', 'nd', 'rd' and 'th'
        dayStr.deleteCharAt(dayStr.length()-1);
        dayStr.deleteCharAt(dayStr.length()-1);
        if(dayStr.length() == 1){ // for dates 1st - 9th
            dayStr.insert(0,'0');
        }

        reformatDateStr.append(dayStr);
        return reformatDateStr.toString();
    }

    public static void main(String[] args) {
        ReformatDate r = new ReformatDate();
        System.out.println(r.reformatDate("20th Oct 2052"));
        System.out.println(r.reformatDate("6th Jun 1933"));
        System.out.println(r.reformatDate("26th May 1960"));
    }
}
