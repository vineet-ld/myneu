import junit.framework.Test;
import junit.framework.TestSuite;

public class Full {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Login-Empty Field Validation.class);
    suite.addTestSuite(Login-Invalid Credential.class);
    suite.addTestSuite(Forgot Password.class);
    suite.addTestSuite(Login.class);
    suite.addTestSuite(Dashboard.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
