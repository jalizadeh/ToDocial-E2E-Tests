# Test Scenarios & Cases

> `X.Y.Z` means `feature.scenario.case`

## TTS_001) Homepage
1. ✅ Verify if anonymous user views default sections on Homepage
    - Top menu items (Home/Login/Signup)
    - Community section
        - at least 1 user
    - Recent activities
        - at least 1 activity (todo)
    - Footer (Copyright/Language)
2. ✅ Verify if logged in user (as `admin`) views default sections on Homepage and all menu items

## TTS_002) User Registration
1. Verify if a new user can register with valid details
    | #  | Input                      | Output                       | Test data |
    | --- | -------------------------- | ---------------------------- | --------- |
    | [2.1.1](cases/1.1.md) | Valid user details         | Successful registration      |           |
    | 2.1.2 | Invalid user details       | Registration failure         |           | 
    | 2.1.3 | Existing user details      | Registration failure         | an existing user |
    | 2.1.4 | Missing mandatory details  | Registration failure         |           |
    | 2.1.5 | Disabled Registration  | Registration of new users is disabled via Settings panel |           |

## TTS_003) User Accesses
1. User login
    | #  | Status | Input                  | Output                   | Test data |
    | --- | --- | -----------------------| ------------------------ | --------- |
    | [3.1.1](cases/3.1.md) | ✅ | Valid email/password | Successful login<br>User has access to more menu items:<ul><li>Home btn</li><li>Me btn</li><li>Todos btn</li><li>Gym btn</li><li>Search bar (complete component)</li><li>Todos (complete component)</li><li>Gym (complete component)</li><li>Diary</li><li>Personal Life Cycle Test</li><li>Calendar</li><li>Experience</li><li>Shop btn</li><li>Account btn (complete component)</li><li>Settings btn</li></ul> | admin user |
    | [3.1.2](cases/3.2.md) | ✅ | Valid email/password   | all 3.1 except:<br><ul><li>Settings btn</li></ul> | a regular (any except admin) user |
    | [3.1.3](cases/3.3.md) | ✅ | Invalid email/password | Login failure            |           |  |
    | [3.1.4](cases/3.4.md) | ❕  | Missing email/password | Login failure            | | |

2. User logout
    | Input                   | Output                   |
    | ------------------------| ------------------------ |
    | [3.2.1] ✅ Logged-in user clicks logout | Successful logout   |
    | [3.2.2] ✅ Logged-out user tries to logout| Logout attempt ignored |

3. Forgot Password
    | Input               | Output                              |
    | --------------------| ----------------------------------- |
    | [3.3.1] ✅ Valid email address | Password reset email sent           |
    | [3.3.2] ✅ Invalid email       | Error message (invalid email)       |
    | [3.3.3] ❕ Missing email       | Error message (missing email)       |

4. Remember me
    | Input             | Output                       |
    | ------------------| ---------------------------- |
    | Checked "Remember me"  | Session persists on next login |
    | Unchecked "Remember me"| Session doesn't persist        |



## TTS_00X) 
- User Permissions
- User's Public Page
- Todos Page
- Gym Page
- Search & Result page
- 
