$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/php/feature/PHP_Login.feature");
formatter.feature({
  "name": "This feature file has validations related to login page like",
  "description": "checking user ID, password field and other validations.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@LoginPageValidation"
    }
  ]
});
formatter.scenario({
  "name": "User checks if he is able to launch the login page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LoginPageValidation"
    },
    {
      "name": "@TC1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "URL is launched in the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "PHP_LoginValidations_PageNavigations.url_is_launched_in_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Login from the menu options",
  "keyword": "When "
});
formatter.match({
  "location": "PHP_LoginValidations_PageNavigations.user_clicks_on_Login_from_the_menu_options()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks if the page login page is launched properly",
  "keyword": "Then "
});
formatter.match({
  "location": "PHP_LoginValidations_PageNavigations.user_checks_if_the_page_login_page_is_launched_properly()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});