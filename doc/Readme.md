# Test Scenarios & Cases

## TTS_A) Homepage
1. Verify if anonymous user views default sections on Homepage
    - Top menu items (Home/Login/Signup)
    - Community section
        - at least 1 user
    - Recent activities
        - at least 1 activity (todo)
    - Footer (Copyright/Language)

## TTS_B) User Registration & Login
1. Verify if a new user can register with valid details
    | #  | Input                      | Output                       | Test data |
    | --- | -------------------------- | ---------------------------- | --------- |
    | [1.1](cases/1.1.md) | Valid user details         | Successful registration      |           |
    | 1.2 | Invalid user details       | Registration failure         |           | 
    | 1.3 | Existing user details      | Registration failure         | an existing user |
    | 1.4 | Missing mandatory details  | Registration failure         |           |

2. Verify if the registration form denies submission with incomplete/invalid details
    | #  |  Input                     | Output                                  | Test data |
    | --- |  -------------------------- | --------------------------------------- | --------- |
    | 2.1 | Incomplete user details    | Submission denial (required fields)     |           |
    | 2.2 | Invalid user details       | Submission denial (validation error)    |           | 
    | 2.3 | Valid user details         | Submission accepted                    | |
    | 2.4 | Existing user details      | Submission denial (duplicate account)  | an existing user  |

3. Verify if the user can log in with a valid email and password
    | #  | Status | Input                  | Output                   | Test data |
    | --- | --- | -----------------------| ------------------------ | --------- |
    | [3.1](cases/3.1.md) | ✅ | Valid email/password   | Successful login         | an existing user |
    | [3.2](cases/3.2.md) | ✅ | Invalid email/password | Login failure            |           |  |
    | [3.3](cases/3.3.md) | ❕  | Missing email/password | Login failure            | | |

4. Verify if the login functionality denies access with an invalid email/password
    | Input                  | Output                        |
    | -----------------------| ----------------------------- |
    | Valid email/password   | Access allowed                |
    | Invalid email/password | Access denial (invalid input) |
    | Missing email/password | Access denial (missing input) |

5. Verify if the "Forgot Password" functionality works as expected
    | Input               | Output                              |
    | --------------------| ----------------------------------- |
    | Valid email address | Password reset email sent           |
    | Invalid email       | Error message (invalid email)       |
    | Missing email       | Error message (missing email)       |

6. Verify if the "Remember me" 
    | Input             | Output                       |
    | ------------------| ---------------------------- |
    | Checked "Remember me"  | Session persists on next login |
    | Unchecked "Remember me"| Session doesn't persist        |

7. Verify if the logged in user can successfully log out
    | Input                   | Output                   |
    | ------------------------| ------------------------ |
    | Logged-in user clicks logout | Successful logout   |
    | Logged-out user tries to logout| Logout attempt ignored |

