package com.bidgely;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class AppTest {


  @Test
  public void testPostgreSQLContainer() {
    try (PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
        "postgres:latest")) {
      postgreSQLContainer.start();

      // Access the container's database URL
      String jdbcUrl = postgreSQLContainer.getJdbcUrl();
      System.out.println("JDBC URL: " + jdbcUrl);

      // Your assertions go here, e.g., test DB connectivity

      assertTrue(jdbcUrl.startsWith("jdbc:postgresql://"));
    }
  }
}
