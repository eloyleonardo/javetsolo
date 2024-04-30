import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;

public class JavetlabApplication {

    public static void main(String[] args) throws JavetException {
        System.out.println("init");
        try (V8Runtime v8Runtime = V8Host.getV8Instance().createV8Runtime()) {
            System.out.println(v8Runtime.getExecutor("'Hello Javet'").executeString());
        } catch (JavetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro on say hello: " + e.getMessage(), e);
        }
        System.out.println("finish");
    }

}
