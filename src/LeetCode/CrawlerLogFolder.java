package LeetCode;

public class CrawlerLogFolder {
    private static final String cwd = "./";
    private static final String parentDirectory = "../";
    public static int minOperations(String[] logs) {
        int cout = 0;
        for(String log: logs){
            if(log.equals(cwd)){
                continue;
            }
            else if(log.equals(parentDirectory)){
                if(cout > 0){
                    cout--;
                }
            }
            else{
                cout++;
            }
        }
        return cout;
    }

    public static void main(String[] args) {
        System.out.println(CrawlerLogFolder.minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(CrawlerLogFolder.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(CrawlerLogFolder.minOperations(new String[]{"d1/","../","../","../"}));

    }
}
