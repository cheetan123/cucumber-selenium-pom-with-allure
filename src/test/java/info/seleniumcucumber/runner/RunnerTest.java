package info.seleniumcucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        glue = {"info.seleniumcucumber.steps","info.seleniumcucumber.hooks"},
        features = {"classpath:features/login.feature"}
)
public class RunnerTest {
}
