import java.io.BufferedReader;
import java.io.FileReader;

public class TestChanger {

    public static void main(String[] args) throws Exception {
        String filePath =
                "/media/work/eclipse_workspace/EasyMock/test/org/easymock/tests2/UsageTest.java";
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String line = null;

        while ((line = in.readLine()) != null) {
            if (line.startsWith("import static")) {
                System.out.println("import junit.framework.TestCase;");
                System.out.println("import org.easymock.EasyMock;");
                continue;
            }

            if (line.startsWith("import org.junit")) {
                continue;
            }

            if (line.startsWith("public class ")) {
                line = line.replaceAll("\\{", "extends TestCase {");
                System.out.println(line);
                continue;
            }

            if (line.indexOf("control.getMock()") != -1) {
                line = line.replaceAll("control.getMock\\(\\)", " (IMethods) control.getMock()");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("<IMethods>") != -1) {
                line = line.replaceAll("\\<IMethods\\>", "");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("replay(") != -1) {
                line = line.replaceAll("replay\\(", "EasyMock.replay(");
                System.out.println(line);
                continue;
            }
            if (line.indexOf("expect(") != -1) {
                line = line.replaceAll("expect\\(", "EasyMock.expect(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("createMock(") != -1) {
                line = line.replaceAll("createMock\\(", "EasyMock.createMock(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("createNiceMock(") != -1) {
                line = line.replaceAll("createNiceMock\\(", "EasyMock.createNiceMock(");
                System.out.println(line);
                continue;
            }
            
            
            if (line.indexOf("verify(") != -1) {
                line = line.replaceAll("verify\\(", "EasyMock.verify(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("createStrictMock(") != -1) {
                line = line.replaceAll("createStrictMock\\(", "EasyMock.createStrictMock(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("expectLastCall(") != -1) {
                line = line.replaceAll("expectLastCall\\(", "EasyMock.expectLastCall(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("getCurrentArguments(") != -1) {
                line = line.replaceAll("getCurrentArguments\\(", "EasyMock.getCurrentArguments(");
                System.out.println(line);
                continue;
            }
            
            if (line.indexOf("notNull(") != -1) {
                line = line.replaceAll("notNull\\(", "EasyMock.notNull(");
                System.out.println(line);
                continue;
            }

            if (line.indexOf("@Before") != -1) {
                line = in.readLine();
                System.out.println(line.replaceAll("setup", "setUp"));
                continue;
            }

            if (line.indexOf("@Test") != -1) {
                line = in.readLine();
                int index = line.indexOf("void ");
                char ch = line.charAt(index + "void ".length());
                System.out.println(line.replaceAll("void " + ch, "void test" + Character.toUpperCase(ch)));
                continue;
            }

            System.out.println(line);

        }
        in.close();
    }

}
