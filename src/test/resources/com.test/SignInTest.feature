Feature: Sign in
  Scenario:  Valid Login Scenario with username and password
    When I set 'admin' as UserName and I set 'password123' as a password
    Then I signed in