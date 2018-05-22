package pl.bodzio.superproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "pl.bodzio.superproject.service"})
public class TestContext {
}
