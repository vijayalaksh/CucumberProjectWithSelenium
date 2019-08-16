$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("../CucumberTest/src/test/java/features/Deal.feature");
formatter.feature({
  "line": 1,
  "name": "Login into CRM and Create Deals",
  "description": "",
  "id": "login-into-crm-and-create-deals",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "",
  "description": "",
  "id": "login-into-crm-and-create-deals;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Open the browser and application should be lunched",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User will enter the username and password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 8
    },
    {
      "cells": [
        "neelamvermamsc@gmail.com",
        "12345678"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User should reach on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User should click the deal page and create the new deal",
  "rows": [
    {
      "cells": [
        "title",
        "amount",
        "probability",
        "next_step"
      ],
      "line": 13
    },
    {
      "cells": [
        "T1",
        "2000",
        "10",
        "new values"
      ],
      "line": 14
    },
    {
      "cells": [
        "T3",
        "3000",
        "30",
        "new values"
      ],
      "line": 15
    }
  ],
  "keyword": "Then "
});
});