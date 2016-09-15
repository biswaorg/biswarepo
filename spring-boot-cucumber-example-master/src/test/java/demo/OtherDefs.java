package demo;

import org.junit.Ignore;

import cucumber.api.java.en.When;

@Ignore
public class OtherDefs extends AbstractDefs
{
    @When("^the client calls /poop$")
    public void the_client_issues_GET_version() throws Throwable
    {
        executeGet("http://localhost:8080/poop");
    }
}
