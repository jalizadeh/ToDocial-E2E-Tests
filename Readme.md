# ToDocial E2E Tests
These set of tests focus on what a user is intended to see on front-end side of the project and mimics a user's behavior on web site. Tests will cover essential parts and pages to make sure everything works and is showed as expected per requirements.

> In order to focus only on E2E (UI) tests, this part of the project is developed in parallel to the project's core

## Framework features
The framework should make test development easy so the developer should only focus on the implementation rather than inventing new solution. Framework should provide all basic features for:
- finding an element
- checking visibility/invisibility
- checking text (equal / contains)
- checking element's focus/status
- clicking (all kind of interactions)
- counting elements
- navigation and redirection
- download/upload management

> In `UIStep` class, the step method name is straight-forward, without pointing to `PageElement`, while the details are implemented and managed in `SeleniumUtils`

> The step method structure follows the step definition, but in `SeleniumUtils`, it always follow `(String page, String element, <other parameters>)`

**Dos and Don'ts**
- Try not to use `JUnit Assertions` directly in the views, instead define a method (that has full access to other low-level methods and assertions) in `SeleniumUtils`. Always think in *repeatability* of your solution


## Tools
For all E2E test that will verify the DOM elements in the browser, Selenium is used

## CI/CD
To set up the CI/CD on Jenkins, after installing the [Cucumber Reports](https://plugins.jenkins.io/cucumber-reports/), follow the basic instructions and how to use.  

It is suggested to create a `Freestyle` job (according to instructions), but also it is possible to set as `Post actions` in a pipeline. `Jenkinsfile` contains the pipeline.

## Environment
All tests are aimed to be executed on **Production** environment. The design and implementation are started on environment **Test** and executed to make sure everything is fine as expected. On successful execution and at the end of project milestone, they are ported on environment **Production**.

> If a test is aimed for a specific environment, it will be mentioned explicitly

## Browser
For now, only Chrome is tested and later (due to missing implementation of Web Driver Manager), Firefox and Edge will be added.

## UI
- General components
    - Top menu
        - Anonymous user
        - Logged in user
            - Menu buttons
            - Search
        - Admin user
    - Footer
- Pages
    - Homepage
    - Todos
        - User's todo
        - Other's todo
    - Gym
        - Homepage
        - Plan
            - New plan
            - Day
        - Shop
            - Homepage
            - Product
            - Cart
    - Settings (Admin user)
- Buttons
- Links
- Forms
- Languages (EN / IT)


## User Registration & Login
1. Verify if a new user can register with valid details
    | #  | Input                      | Output                       | Test data |
    | --- | -------------------------- | ---------------------------- | --------- |
    | [1.1](doc/1.1.md) | Valid user details         | Successful registration      |           |
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
    | [3.1](doc/3.1.md) | ✅ | Valid email/password   | Successful login         | an existing user |
    | [3.2](doc/3.2.md) | ✅ | Invalid email/password | Login failure            |           |  |
    | [3.3](doc/3.3.md) | ❕  | Missing email/password | Login failure            | | |

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

