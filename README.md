## Technical Assessment: Feature Control API
To manage users’ accesses to new features via feature switches

### Endpoints
API Path: ```/api/v1```
1. `GET /feature?email=XXX&featureName=XXX` <br/>
    Request Parameters: *email* (user's email) and *featureName* <br/>
    Return Message:
    ```
    {
      "canAccess": true|false (will be true if the user has accss to the featureName)
    }
    ```

2. `POST /feature`  <br/>
    Receive request in JSON:
    ```
    {
      "featureName": "xxx", (string)
      "email": "xxx", (string)
      "enable": true|false (boolean) (uses true to enable a user's access, false otherwise)
    }
    ```
    Return Status: *HTTP Status OK (200)* or *HTTP Status Not Modifies (304)*


### Database
Login: `http://localhost:8080/h2-console`

